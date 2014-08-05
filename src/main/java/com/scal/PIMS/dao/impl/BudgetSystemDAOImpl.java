/**
 * @(#)BudgetSystemDAOImpl.java
 * 
 *                              Copyright scal.All rights reserved. This
 *                              software is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月6日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.scal.PIMS.dao.BudgetSystemDAO;
import com.scal.PIMS.model.BudgetSystem;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.util.HibernateUtil;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月6日
 */
public class BudgetSystemDAOImpl implements BudgetSystemDAO {

    @Override
    public ProjectBudget getBudgetId(int projectId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProjectBudget projectBudget = null;
        String sql = "select * from t_projectbudget where projectId="
                + projectId + "";
        List<ProjectBudget> list = session.createSQLQuery(sql)
                .addEntity(ProjectBudget.class).list();
        Iterator<ProjectBudget> iter = list.iterator();
        while (iter.hasNext()) {
            projectBudget = iter.next();
        }
        return projectBudget;
    }

    @Override
    public ProjectSystem getSystemId(int projectId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProjectSystem projectSystem = null;
        String sql = "select * from t_projectsysteminfo where projectId="
                + projectId + "";
        List<ProjectSystem> list = session.createSQLQuery(sql)
                .addEntity(ProjectSystem.class).list();
        Iterator<ProjectSystem> iter = list.iterator();
        while (iter.hasNext()) {
            projectSystem = iter.next();
        }
        return projectSystem;
    }

    @Override
    public BudgetSystem getBySystemId(int systemId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        BudgetSystem budgetSystem = null;
        String sql = "select * from t_budgetsystemrelationship where systemId="
                + systemId + "";
        List<BudgetSystem> list = session.createSQLQuery(sql)
                .addEntity(BudgetSystem.class).list();
        Iterator<BudgetSystem> iter = list.iterator();
        while (iter.hasNext()) {
            budgetSystem = iter.next();
        }
        return budgetSystem;
    }
    @Override
    public void saveRelationship(BudgetSystem budgetSystem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(budgetSystem);
        session.getTransaction().commit();
    }

    @Override
    public void deleteRelationship(BudgetSystem budgetSystem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(budgetSystem);
        session.getTransaction().commit();
    }
}
