/**
 * @(#)RoleAuthorityDAOImpl.java
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
 *  1     2013年12月31日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.RoleAuthorityDAO;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.RoleAuthority;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月31日
 */
public class RoleAuthorityDAOImpl implements RoleAuthorityDAO {

    @Override
    public void save(RoleAuthority roleAuthority) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.save(roleAuthority) ;
        session.getTransaction().commit() ;
    }

    @Override
    public void update(RoleAuthority roleAuthority) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.update(roleAuthority) ;
        session.getTransaction().commit() ;
    }

    @Override
    public List<RoleAuthority> findRoleAuthorityByRoleId(int roleId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        List<RoleAuthority> list = session.createCriteria(RoleAuthority.class).add(Restrictions.eq("roleId", roleId)).list() ;
        session.getTransaction().commit() ;
        return list ;
    }

    @Override
    public List<RoleAuthority> findRoleAuthorityByAuthorityId(int authorityId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        List<RoleAuthority> list = session.createCriteria(RoleAuthority.class).add(Restrictions.eq("authorityId", authorityId)).list() ;
        session.getTransaction().commit() ;
        return list ;
    }

    @Override
    public List<Authority> findAuthority(int roleId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        String sql = "select * from t_authority as a,t_roleauthorityrelationship as r where a.authorityId = r.authorityId and r.roleId = "
                + roleId + " and (a.dataMark = 1 or a.dataMark = 0) ";
        List<Authority> list = session.createSQLQuery(sql).addEntity(Authority.class).list() ;
        return list ;
    }

    @Override
    public void delete(RoleAuthority roleAuthority) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.delete(roleAuthority);
        session.getTransaction().commit() ;
    }

}
