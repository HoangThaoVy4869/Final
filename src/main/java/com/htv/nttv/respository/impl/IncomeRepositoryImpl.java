/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository.impl;

import com.htv.nttv.pojo.Income;
import com.htv.nttv.respository.IncomeRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USER
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class IncomeRepositoryImpl implements IncomeRepository{
    @Autowired
    private LocalSessionFactoryBean SessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Income> getIncome(Map<String, String> params, int page, String kw) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Income> q = b.createQuery(Income.class);
        Root root = q.from(Income.class);
        q.select(root);


        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            
//            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }
            
            String cateId = params.get("cateId");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));
        }

        Query query = session.createQuery(q);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();

    }
    
    @Override
    public boolean addIncome(Income in) {
        Session session = this.SessionFactory.getObject().getCurrentSession();   
        try {
            session.save(in);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD INCOME ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int countIncome() {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("SELECT COUNT(*) FROM Income");
        return Integer.parseInt(q.getSingleResult().toString());
       
    }
    
    @Override
    public Income getIncomeById(int id){
        Session session = this.SessionFactory.getObject().getCurrentSession();
        Income in = session.get(Income.class, id);
        return session.get(Income.class,id);
    }

    @Override
    public boolean updateIncome(Income in) {
        Session session = this.SessionFactory.getObject().getCurrentSession();   
        try {
            session.update(in);
            return true;
        } catch (Exception ex) {
            System.err.println("UPDATE INCOME ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteIncome(int id) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        try {
            Income in = session.get(Income.class, id);
            session.delete(in);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object[]> statsIncome(Date fromDate, Date toDate) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
      
        Root root = q.from(Income.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        q.multiselect(root.get("id"), root.get("name"), root.get("amount"), root.get("date"));
        
        q.groupBy(root.get("id"));
        
        if(fromDate != null){
            predicates.add(b.greaterThanOrEqualTo(root.get("date"), fromDate));
        }
        
        if(toDate != null){
            predicates.add(b.lessThanOrEqualTo(root.get("date"), toDate));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));
       
        Query query = session.createQuery(q);
        return query.getResultList();
    }
}
