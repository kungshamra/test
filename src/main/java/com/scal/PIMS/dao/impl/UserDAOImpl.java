/**
 * @(#)UserDAOImpl.java
 * 
 * Copyright scal.All rights reserved.
 * This software is the XXX system. 
 *
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */ 
 /*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月23日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.UserDAO;
import com.scal.PIMS.model.User;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月23日
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> findUserByCondition(String loginName, String trueName,
            String officeNumber) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        String sql = "select * from t_userinfo where loginName like '%" + loginName 
                + "%' and trueName like '%" + trueName 
                + "%' and officeNumber like '%" + officeNumber 
                + "%' and ( dataMark = 1 or dataMark = 0 ) " ;
        List<User> list = session.createSQLQuery(sql).addEntity(User.class).list() ;
        session.getTransaction().commit() ;
        return list ;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        String sql = "select * from t_userinfo where dataMark = 1 or dataMark = 0 " ;
        List<User> list = session.createSQLQuery(sql).addEntity(User.class).list() ;
    //    List<User> list = session.createCriteria(User.class).add(Restrictions.eq("dataMark", 1)).list() ;
        session.getTransaction().commit() ;
        return list ;
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.save(user) ;
        session.getTransaction().commit() ;
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.update(user) ;
        session.getTransaction().commit() ;
    }

    @Override
    public User findUserById(int memberId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        User user = new User() ;
        String sql = "select * from t_userinfo where memberId = " + memberId + " and ( dataMark = 1 or dataMark = 0 ) " ;
        List<User> list = session.createSQLQuery(sql).addEntity(User.class).list() ;
   //     List<User> list = session.createCriteria(User.class).add(Restrictions.eq("memberId", memberId))
   //             .add(Restrictions.eq("dataMark", 1)).list() ;
        user = list.get(0) ;
        return user ;
    }

    @Override
    public User findUserByLoginName(String loginName) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        User user = null ;
        List<User> list = session.createCriteria(User.class).add(Restrictions.eq("loginName", loginName))
                .add(Restrictions.eq("dataMark", 1)).list() ;
        Iterator<User> iter = list.iterator() ;
        while(iter.hasNext()){
            user = iter.next() ;
        }
        return user ;
    }

}
