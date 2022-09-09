/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository.impl;

import com.htv.nttv.pojo.Expense;
import java.util.ArrayList;
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
import com.htv.nttv.respository.ExpenseRespository;
import java.util.Date;

/**
 *
 * @author USER
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class ExpenseRespositoryImpl implements ExpenseRespository {
    @Autowired
    private LocalSessionFactoryBean SessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Expense> getExpense(Map<String, String> params, int page, String kw) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Expense> q = b.createQuery(Expense.class);
        Root root = q.from(Expense.class);
        q.select(root);


        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            
//            String kw = params.get("kw");
            
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                
//                q = q.where(p);
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
    public boolean addExpense(Expense em) {
        Session session = this.SessionFactory.getObject().getCurrentSession();   
        try {
            session.save(em);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD EXPENSE ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int countExpense() {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("SELECT COUNT(*) FROM Expense");
        return Integer.parseInt(q.getSingleResult().toString());
       
    }
    
    @Override
    public Expense geExpenseById(int id){
        Session session = this.SessionFactory.getObject().getCurrentSession();
        Expense em = session.get(Expense.class, id);
        return session.get(Expense.class,id);
    }

    @Override
    public boolean updateExpense(Expense em) {
        Session session = this.SessionFactory.getObject().getCurrentSession();   
        try {
            
            session.update(em);
            return true;
        } catch (Exception ex) {
            System.err.println("UPDATE EXPENSE ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteExpense(int id) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        try {
            Expense em = session.get(Expense.class, id);
            session.delete(em);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object[]> statsExpense(Date fromDate, Date toDate) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
      
        Root root = q.from(Expense.class);
        
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
    
    public List<Object> ListExpense(Date fromDate) {
        
        return null;
    }

    @Override
    public List<Object[]> statsExpenseMonth(Date fromDate) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
      
        Root root = q.from(Expense.class);
//        int d = fromDate.getMonth();
        
        List<Predicate> predicates = new ArrayList<>();
        
        
        
        q.multiselect(b.function("MONTH", Integer.class, root.get("date")),
                b.function("YEAR", Integer.class, root.get("date")),
                root.get("name"),
                b.sum(root.get("amount")));
        
        q.groupBy(b.function("MONTH", Integer.class, root.get("date")),
                b.function("YEAR", Integer.class, root.get("date")));
//        Predicate p = b.equal(b.function("MONTH", Integer.class, root.get("date")), d);
//                predicates.add(p);
        
//        if(fromDate != null){
//            predicates.add(b.greaterThanOrEqualTo(root.get("date"), fromDate));
//        }
        
//        if(toDate != null){
//            predicates.add(b.lessThanOrEqualTo(root.get("date"), toDate));
//        }
        
        q.where(predicates.toArray(new Predicate[]{}));
       
        Query query = session.createQuery(q);
        return query.getResultList();    
    }
}
