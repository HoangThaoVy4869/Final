/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository.impl;

import com.htv.nttv.pojo.Details;
import com.htv.nttv.pojo.Expense;
import com.htv.nttv.pojo.User;
import com.htv.nttv.respository.ExpenseTeamRepository;
import com.htv.nttv.respository.TeamRespository;
import com.htv.nttv.respository.UserRepository;
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
public class ExpenseTeamRepositoryImpl implements ExpenseTeamRepository{

    @Autowired
    private LocalSessionFactoryBean SessionFactory;

    @Autowired
    private Environment env;
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public List<Object[]> getexpenseTeam(Map<String, String> params, int page) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rD = q.from(Details.class);
        Root rU = q.from(User.class);
        
        q.where(b.equal(rD.get("userId"), rU.get("id")));
        q.multiselect(rD.get("name"), rD.get("expense"), rD.get("date"), rU.get("username"), rD.get("id"));
        q.groupBy(rD.get("id"));
        
        
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
    public boolean addExpenseTeam(Details d, User u) {
        Session session = this.SessionFactory.getObject().getCurrentSession();   
        try {
            d.setUserId(u);
            session.save(d);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD EXPENSE ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Details geExpenseTeamById(int id) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        Details d = session.get(Details.class, id);
        return session.get(Details.class,id);
    }

    @Override
    public boolean updateExpenseTeam(Details d, User u) {
        Session session = this.SessionFactory.getObject().getCurrentSession();   
        try {
            d.setUserId(u);
            session.update(d);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD EXPENSE ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean deleteExpenseTeam(int id) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        try {
            Details d = session.get(Details.class, id);
            session.delete(d);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public List<Object[]> statsExpenseTeam (Date fromDate, Date toDate) {
        Session session = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
      
        Root rootD = q.from(Details.class);
        Root rootU = q.from(User.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootD.get("userId"), rootU.get("id")));
        q.multiselect(rootD.get("id"), rootD.get("name"), rootD.get("expense")
                , rootD.get("date"), rootU.get("username")
                , b.sum(rootD.get("expense")));
        
        q.groupBy(rootD.get("userId"));
        
        if(fromDate != null){
            predicates.add(b.greaterThanOrEqualTo(rootD.get("date"), fromDate));
        }
        
        if(toDate != null){
            predicates.add(b.lessThanOrEqualTo(rootD.get("date"), toDate));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));
       
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
}
