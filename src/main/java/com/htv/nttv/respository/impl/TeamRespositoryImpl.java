/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository.impl;


import com.htv.nttv.pojo.Expense;
import com.htv.nttv.pojo.Team;
import com.htv.nttv.pojo.UserTeam;
import com.htv.nttv.respository.TeamRespository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USER
 */
@Repository
@Transactional
public class TeamRespositoryImpl implements TeamRespository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Team> getTeam(Map<String, String> params, int page){
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Team> q = b.createQuery(Team.class);
        Root root = q.from(Team.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
    @Override
    public boolean addTeam(Team t) {
        Session session = this.sessionFactory.getObject().getCurrentSession();   
        try {
            session.save(t);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD GROUP ERROR!!!!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

//    @Override
//    public boolean joinTeam(UserTeam ut) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();   
//        try {
//            session.save(ut);
//            return true;
//        } catch (Exception ex) {
//            System.err.println("JOIN TO TEAM ERROR!!!!" + ex.getMessage());
//            ex.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public Team getTeamById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Team t = session.get(Team.class, id);
        return session.get(Team.class,id);
//        org.hibernate.query.Query q = session.createQuery("SELECT id FROM Team ORDER BY id DESC").setMaxResults(1);
//        return (Team) (q.getSingleResult());
    }
}
