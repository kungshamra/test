/**
 * @(#)AuthorityDAOImpl.java
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
 *  1     2013年12月26日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.AuthorityDAO;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月26日
 */
public class AuthorityDAOImpl implements AuthorityDAO {

    @Override
    public List<Authority> findAll() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
    //    List<Authority> list = session.createCriteria(Authority.class).add(Restrictions.eq("dataMark", 1)).list() ;
        String sql = "select * from t_authority where dataMark = 1 or dataMark = 0 " ;
        List<Authority> list = session.createSQLQuery(sql).addEntity(Authority.class).list() ;
        session.getTransaction().commit() ;
        return list ;
    }

    @Override
    public void save(Authority authority) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.save(authority) ;
        session.getTransaction().commit() ;
    }

    @Override
    public void update(Authority authority) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        session.update(authority) ;
        session.getTransaction().commit() ;
    }

    @Override
    public Authority findAuthorityById(int authorityId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        Authority authority = null ;
        String sql = "select * from t_authority where authorityId = " + authorityId + " and ( dataMark = 1 or dataMark = 0 ) " ;
        List<Authority> list = session.createSQLQuery(sql).addEntity(Authority.class).list() ;
        Iterator<Authority> iter = list.iterator() ;
        while(iter.hasNext()){
            authority = iter.next() ;
        }
        return authority ;
    }
    
    @Override
    public Authority findAuthority(String authorityName) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        Authority authority = null ;
        String sql = "select * from t_authority where authorityName = '" + authorityName + "' and ( dataMark = 1 or dataMark = 0 ) " ;
        List<Authority> list = session.createSQLQuery(sql).addEntity(Authority.class).list() ;
        Iterator<Authority> iter = list.iterator() ;
        while(iter.hasNext()){
            authority = iter.next() ;
        }
        return authority ;
    }

}
