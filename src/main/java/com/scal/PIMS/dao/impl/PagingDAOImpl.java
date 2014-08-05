/**
 * @(#)PagingDAOImpl.java
 * 
 *                        Copyright scal.All rights reserved. This software is
 *                        the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月17日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.scal.PIMS.dao.PagingDAO;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月17日
 */
public class PagingDAOImpl implements PagingDAO {

    @Override
    public List pageList(int currPage, String hql) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setFirstResult((currPage - 1) * 10);
        query.setMaxResults(10);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public int getPageCount(String hql) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        int count = query.list().size();
        session.getTransaction().commit();
        return count % 10 == 0 ? count / 10 : count / 10 + 1;
    }

}
