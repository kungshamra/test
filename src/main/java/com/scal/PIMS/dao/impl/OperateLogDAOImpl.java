/**
 * @(#)OperateLogDAOImpl.java
 * 
 *                            Copyright scal.All rights reserved. This software
 *                            is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月2日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.OperateLogDAO;
import com.scal.PIMS.model.OperateLog;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
public class OperateLogDAOImpl implements OperateLogDAO {

    @Override
    public void save(OperateLog operateLog) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(operateLog);
        session.getTransaction().commit();
    }

    @Override
    public List<OperateLog> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<OperateLog> list = session.createCriteria(OperateLog.class)
                .add(Restrictions.eq("dataMark", 1))
                .addOrder(Order.desc("operateTime")).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<OperateLog> searchByCondition(String trueName,
            String moduleName, int operateType, String keyWord, Date startTime,
            Date endTime, String ipAddress) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = null;
        if ((startTime == null || endTime == null) && operateType == 0) {
            hql = "from OperateLog l where l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";

        } else if ((startTime == null || endTime == null) && operateType != 0) {
            hql = "from OperateLog l where l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.operateType ='" + operateType
                    + "' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";
        } else if (startTime != null && endTime != null && operateType != 0) {
            java.sql.Date start = new java.sql.Date(startTime.getTime());
            java.sql.Date end = new java.sql.Date(endTime.getTime());
            hql = "from OperateLog l where l.operateTime between '" + start
                    + " 00:00:00' and '" + end
                    + " 23:59:59' and l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.operateType ='" + operateType
                    + "' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";
        } else {
            java.sql.Date start = new java.sql.Date(startTime.getTime());
            java.sql.Date end = new java.sql.Date(endTime.getTime());
            hql = "from OperateLog l where l.operateTime between '" + start
                    + " 00:00:00' and '" + end
                    + " 23:59:59' and l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";
        }
        Query query = session.createQuery(hql);
        List<OperateLog> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public List<OperateLog> searchByConditionPage(String trueName,
            String moduleName, int operateType, String keyWord, Date startTime,
            Date endTime, String ipAddress, int currPage) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = null;
        if ((startTime == null || endTime == null) && operateType == 0) {
            hql = "from OperateLog l where l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";

        } else if ((startTime == null || endTime == null) && operateType != 0) {
            hql = "from OperateLog l where l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.operateType ='" + operateType
                    + "' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";
        } else if (startTime != null && endTime != null && operateType != 0) {
            java.sql.Date start = new java.sql.Date(startTime.getTime());
            java.sql.Date end = new java.sql.Date(endTime.getTime());
            hql = "from OperateLog l where l.operateTime between '" + start
                    + " 00:00:00' and '" + end
                    + " 23:59:59' and l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.operateType ='" + operateType
                    + "' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";
        } else {
            java.sql.Date start = new java.sql.Date(startTime.getTime());
            java.sql.Date end = new java.sql.Date(endTime.getTime());
            hql = "from OperateLog l where l.operateTime between '" + start
                    + " 00:00:00' and '" + end
                    + " 23:59:59' and l.keyWord like '%" + keyWord
                    + "%' and  l.moduleName like '%" + moduleName
                    + "%' and l.trueName like '%" + trueName
                    + "%' and l.ipAddress like '%" + ipAddress
                    + "%' and l.dataMark='1' order by l.id desc";
        }
        Query query = session.createQuery(hql);
        query.setFirstResult((currPage - 1) * 10);
        query.setMaxResults(10);
        List<OperateLog> list = query.list();
        session.getTransaction().commit();
        return list;
    }
    
    public List<OperateLog> detail(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<OperateLog> list = session.createCriteria(OperateLog.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("dataMark", 1)).list();
        session.getTransaction().commit();
        return list;
    }
}
