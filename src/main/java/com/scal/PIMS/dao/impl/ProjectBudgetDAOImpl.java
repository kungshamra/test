/**
 * @(#)ProjectBudgetDAOImpl.java
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
 *  1     2013年12月18日		  曾雨桐                            Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javassist.expr.NewArray;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.ProjectBudgetDAO;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.util.HibernateUtil;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author 曾雨桐
 * @since 2013年12月18日
 */

// 多表查询
public class ProjectBudgetDAOImpl implements ProjectBudgetDAO {

    @Override
    public List<ShowProjectBudget> multiEntityQuery() {
        // 可以改写一下构建一个新的list类来返回包含两个表的字段的list
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "select pb.*,pg.* from t_projectbudget as pb inner join t_projectgeneral as pg"
                + " on pb.projectId=pg.id and pg.dataMark=1"; // 还需要加一个dataMark=1的查询条件
        // 可以改写一下构建一个新的list类来返回包含两个表的字段两个实体类的list
        //这里添加的先后顺序还是会对结果造成影响，根本原因是这2个表的主键都叫id，如果像下面这种展示的结果是正确的，唯独id都是第一个的，不过这个不影响给用户的展示效果
        List list = session.createSQLQuery(sql)
                .addEntity("pb", ProjectBudget.class)
                .addEntity("pg", ProjectInfo.class).list();
        List<ShowProjectBudget> showList = new ArrayList<ShowProjectBudget>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            // 每个集合元素都是ProjectBudget、ProjectInfo所组成的数组
            Object[] objects = (Object[]) iterator.next();
            ProjectBudget proBudget = (ProjectBudget) objects[0];
            ProjectInfo proInfo = (ProjectInfo) objects[1];
            ShowProjectBudget showBudget = new ShowProjectBudget();
            showBudget.setProBudget(proBudget);
            showBudget.setProInfo(proInfo);
            showList.add(showBudget);
            System.out.println("projectBudget_id=" + proBudget.getId()
                    + "project_id=" + proBudget.getProjectId()
                    + " projectInfo_type=" + proInfo.getProjectType()
                    + " projectInfo_platform=" + proInfo.getProjectPlatform());

        }
        session.getTransaction().commit();
        return showList;
    }

    @Override
    public List<ProjectBudget> listAll() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProjectBudget> list = session.createCriteria(ProjectBudget.class)
                .add(Restrictions.eq("dataMark", 1)).list();
        session.getTransaction().commit();
        return list;

    }

    @Override
    public ProjectBudget getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ProjectBudget projectBudget = (ProjectBudget) session.get(
                ProjectBudget.class, id);
        session.close();
        return projectBudget;
    }

    @Override
    public void save(ProjectBudget projectBudget) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(projectBudget);
        session.getTransaction().commit();

    }

    @Override
    public void update(ProjectBudget projectBudget) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(projectBudget);
        session.getTransaction().commit();

    }

    // 根据projectId找出ProjectBudget对象并把该对象的dataMark设置为-1（该方法是删除项目信息的同时执行的）
    @Override
    public ProjectBudget getByProjectId(int projectId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().openSession();
        // 下面session.get（）方法不能成功是因为这个方法只能根据主键取对象，用其他的列的值取对象取不出来。。。
        // ProjectBudget projectBudget = (ProjectBudget) session.get(
        // ProjectBudget.class, projectId);
        session.beginTransaction();
        String sql = "select * from t_projectbudget where projectId="
                + projectId + " and dataMark=1"; // 还需要加一个dataMark=1的查询条件
        List<ProjectBudget> list = session.createSQLQuery(sql)
                .addEntity(ProjectBudget.class).list();
        Iterator<ProjectBudget> iterator = list.iterator();
        ProjectBudget proBudget = null;
        while (iterator.hasNext()) {
            proBudget = iterator.next();
        }
        session.getTransaction().commit();
        session.close();
        return proBudget;

    }

    @Override
    public List<ShowProjectBudget> searchBudgetInfo(String projectName,
            int projectType, int type, int projectPlatform, Date applyYear,
            double totalInvestment1a, double totalInvestment1b,
            Date applyTimeStart, Date applyTimeEnd, Date approvalTimeStart,
            Date approvalTimeEnd) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        StringBuffer multiSql = new StringBuffer();
        multiSql.append("select pb.*,pg.* from t_projectbudget as pb inner join t_projectgeneral as pg"
                + " on pb.projectId=pg.id and pg.dataMark=1");
        if (projectName != "") {
            multiSql.append(" and pg.projectName like '%" + projectName + "%'");
        }
        if (projectType != 0) {
            multiSql.append(" and pg.projectType like '%" + projectType + "%'");
        }
        if (projectPlatform != 0) {
            multiSql.append(" and pg.projectPlatform like '%" + projectPlatform
                    + "%'");
        }
        if (type != 0) {
            multiSql.append(" and pb.type like '%" + type + "%'");
        }
        if (applyYear != null) {
            java.sql.Date year = new java.sql.Date(applyYear.getTime());
            multiSql.append(" and pb.year= '" + year + " 00:00:00'");
        }
        if ((totalInvestment1a != 0) && (totalInvestment1b != 0)) {
            multiSql.append(" and pb.totalInvestment1 between "
                    + totalInvestment1a + " and " + totalInvestment1b);
        }
        if ((applyTimeStart != null) && (applyTimeEnd != null)) {
            java.sql.Date start = new java.sql.Date(applyTimeStart.getTime());
            java.sql.Date end = new java.sql.Date(applyTimeEnd.getTime());
            multiSql.append(" and pg.budgetApplyTime between '" + start
                    + " 00:00:00' and '" + end + " 23:59:59'");
        }
        if ((approvalTimeStart != null) && (approvalTimeEnd != null)) {
            java.sql.Date start = new java.sql.Date(approvalTimeStart.getTime());
            java.sql.Date end = new java.sql.Date(approvalTimeEnd.getTime());
            multiSql.append(" and pg.budgetApprovalTime between '" + start
                    + "00:00:00' and '" + end + "23:59:59'");
        }
        // 可以改写一下构建一个新的list类来返回包含两个表的字段两个实体类的list
        String sql = multiSql.toString();
        List list = session.createSQLQuery(sql)
                .addEntity("pb", ProjectBudget.class)
                .addEntity("pg", ProjectInfo.class).list();
        List<ShowProjectBudget> showList = new ArrayList<ShowProjectBudget>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            // 每个集合元素都是ProjectBudget、ProjectInfo所组成的数组
            Object[] objects = (Object[]) iterator.next();
            ProjectBudget proBudget = (ProjectBudget) objects[0];
            ProjectInfo proInfo = (ProjectInfo) objects[1];
            ShowProjectBudget showBudget = new ShowProjectBudget();
            showBudget.setProBudget(proBudget);
            showBudget.setProInfo(proInfo);
            showList.add(showBudget);
            System.out.println("projectBudget_id=" + proBudget.getId()
                    + "project_id=" + proBudget.getProjectId()
                    + " projectInfo_type=" + proInfo.getProjectType()
                    + " projectInfo_platform=" + proInfo.getProjectPlatform());

        }
        session.getTransaction().commit();
        return showList;

    }

}
