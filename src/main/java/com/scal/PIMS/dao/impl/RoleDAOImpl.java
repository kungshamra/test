/**
 * @(#)RoleDAOImpl.java
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
 *  1     2013年12月25日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.RoleDAO;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月25日
 */
public class RoleDAOImpl implements RoleDAO {

    @Override
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        String sql = "select * from t_roleinfo where dataMark = 1 or dataMark = 0 " ;
        List<Role> list = session.createSQLQuery(sql).addEntity(Role.class).list() ;
//        List<Role> list = session.createCriteria(Role.class).add(Restrictions.eq("dataMark", 1)).list() ;
        session.getTransaction().commit() ;
        return list ;
    }

    @Override
    public void save(Role role) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.save(role) ;
        session.getTransaction().commit() ;
    }

    @Override
    public void update(Role role) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.update(role) ;
        session.getTransaction().commit() ;
    }

    @Override
    public Role findRoleById(int roleId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        Role role = new Role() ;
        String sql = "select * from t_roleinfo where roleId = " + roleId + " and ( dataMark = 1 or dataMark = 0 ) " ;
        List<Role> list = session.createSQLQuery(sql).addEntity(Role.class).list() ;
/*        List<Role> list = session.createCriteria(Role.class).add(Restrictions.eq("roleId", roleId))
                .add(Restrictions.eq("dataMark", 1)).list() ;*/
        role = list.get(0) ;
        return role ;
    }

    @Override
    public Role findRoleByName(String roleName) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        Role role = new Role() ;
        String sql = "select * from t_roleinfo where roleName = '" + roleName + "' and ( dataMark = 1 or dataMark = 0 ) " ;
        List<Role> list = session.createSQLQuery(sql).addEntity(Role.class).list() ;
        role = list.get(0) ;
        return role ;
    }

}
