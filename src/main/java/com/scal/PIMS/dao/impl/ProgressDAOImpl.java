/**
 * @(#)ProgressDAOImpl.java
 * 
 *                          Copyright scal.All rights reserved. This software is
 *                          the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月23日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.ProgressDAO;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月23日
 */
public class ProgressDAOImpl implements ProgressDAO {

    @Override
    public void save(ProjectProgress proProgress) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(proProgress);
        session.getTransaction().commit();
    }

    @Override
    public ProjectProgress getById(int id) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProjectProgress proProgress = (ProjectProgress) session.get(
                ProjectProgress.class, id);
        session.getTransaction().commit();
        return proProgress;
    }

    @Override
    public void update(ProjectProgress proProgress) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(proProgress);
        session.getTransaction().commit();
    }

    @Override
    public void delete(ProjectProgress proProgress) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // 不用物理删除，所以这里是update
        session.update(proProgress);
        session.getTransaction().commit();
    }

    @Override
    public List<ProjectProgress> findAll(int projectId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProjectProgress> list = session
                .createCriteria(ProjectProgress.class)
                .add(Restrictions.eq("dataMark", 1))
                .add(Restrictions.eq("projectId", projectId)).list();
        session.getTransaction().commit();
        return list;
    }

}
