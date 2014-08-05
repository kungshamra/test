/**
 * @(#)ProjectSystemDAOImpl.java
 * 
 *                               Copyright scal.All rights reserved. This
 *                               software is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月27日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.ProjectSystemDAO;

import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 * 
 * @author Andy
 * @since 2013年12月27日
 */
public class ProjectSystemDAOImpl implements ProjectSystemDAO {

    @Override
    public void save(ProjectSystem projectSystem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(projectSystem);
        session.getTransaction().commit();
    }

    @Override
    public List<ProjectSystem> findAll(int projectId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProjectSystem> list = session.createCriteria(ProjectSystem.class)
                .add(Restrictions.eq("projectId", projectId))
                .add(Restrictions.eq("dataMark", 1)).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public ProjectSystem getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProjectSystem projectSystem = (ProjectSystem) session.get(
                ProjectSystem.class, id);
        session.getTransaction().commit();
        return projectSystem;
    }

    @Override
    public List<ProjectSystem> findByBudgetId(int budgetId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "select * from t_projectsysteminfo as system,t_budgetsystemrelationship as relationship where system.id = relationship.systemId and relationship.budgetId = "
                + budgetId + "";
        List<ProjectSystem> list = session.createSQLQuery(sql)
                .addEntity(ProjectSystem.class).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public void update(ProjectSystem projectSystem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(projectSystem);
        session.getTransaction().commit();
    }

    @Override
    public List<ProjectSystem> detail(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProjectSystem> list = session.createCriteria(ProjectSystem.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("dataMark", 1)).list();
        session.getTransaction().commit();
        return list;
    }

}
