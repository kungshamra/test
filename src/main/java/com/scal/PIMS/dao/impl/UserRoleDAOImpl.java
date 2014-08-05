/**
 * @(#)UserRoleDAOImpl.java
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
 *  1     2013年12月27日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.UserRoleDAO;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.UserRole;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月27日
 */
public class UserRoleDAOImpl implements UserRoleDAO {

    @Override
    public void save(UserRole userRole) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.save(userRole) ;
        session.getTransaction().commit() ;
    }

    @Override
    public void update(UserRole userRole) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.update(userRole) ;
        session.getTransaction().commit() ;
    }

    @Override
    public void delete(UserRole userRole) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.delete(userRole) ;
        session.getTransaction().commit() ;
    }

    @Override
    public List<UserRole> findUserRoleByMemberId(int memberId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        List<UserRole> list = session.createCriteria(UserRole.class).add(Restrictions.eq("memberId", memberId)).list() ;
        return list ;
    }

    @Override
    public List<UserRole> findUserRoleByRoleId(int roleId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        List<UserRole> list = session.createCriteria(UserRole.class).add(Restrictions.eq("roleId", roleId)).list() ;
        return list ;
    }

    @Override
    public List<Role> findRole(int memberId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        String sql = "select * from t_roleinfo as r,t_userrolerelationship as u where r.roleId = u.roleId and u.memberId = "
                + memberId + " and (r.dataMark = 1 or r.dataMark = 0) ";
        List<Role> list = session.createSQLQuery(sql).addEntity(Role.class).list() ;
        return list ;
    }

}
