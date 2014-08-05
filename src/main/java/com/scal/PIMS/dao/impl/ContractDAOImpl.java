/**
 * @(#)UserAction.java
 * 
 *                     Copyright scal.All rights reserved. This software is the
 *                     Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*-                 History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日            周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.ContractDAO;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 * 
 * @author 周波
 * @since 2013年12月17日
 */
public class ContractDAOImpl implements ContractDAO {

	@Override
	public List<Contract> findAll(int projectId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ;
		List<Contract> list = session.createCriteria(Contract.class).add(Restrictions.eq("projectId", projectId))
		        .add(Restrictions.eq("dataMark", 1)).list() ;
		session.getTransaction().commit() ;
		return list ;
	}

	@Override
    public Contract findContractById(int id) {
        // TODO Auto-generated method stub
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        Contract contract = null ;
        List<Contract> list = session.createCriteria(Contract.class).add(Restrictions.eq("id", id))
                .add(Restrictions.eq("dataMark", 1)).list() ;
        Iterator<Contract> iter = list.iterator() ;
        while(iter.hasNext()){
            contract = iter.next() ;
        }
        return contract ;
    }

    @Override
	public void save(Contract contract) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ;
		session.save(contract) ;
		session.getTransaction().commit() ;
	}

	@Override
	public void update(Contract contract) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ;
		session.update(contract) ;
		session.getTransaction().commit() ;
	}

}
