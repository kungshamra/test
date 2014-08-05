/**
 * @(#)ProjectInfoDAOImpl.java
 * 
 *                             Copyright scal.All rights reserved. This software
 *                             is the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scal.PIMS.dao.ProjectInfoDAO;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.util.HibernateUtil;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月18日
 */
public class ProjectInfoDAOImpl implements ProjectInfoDAO {

    @Override
    public void save(ProjectInfo proInfo) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(proInfo);
        session.getTransaction().commit();
    }

    @Override
    public ProjectInfo getById(int id) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProjectInfo proInfo = (ProjectInfo) session.get(ProjectInfo.class, id);
        session.getTransaction().commit();
        return proInfo;
    }

    @Override
    public void update(ProjectInfo proInfo) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(proInfo);
        session.getTransaction().commit();
    }

    /**
     * 查找出ProjectGeneral表中所有字段的数据
     * */
    @Override
    public List<ProjectInfo> findAll() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProjectInfo> list = session.createCriteria(ProjectInfo.class)
                .add(Restrictions.eq("dataMark", 1)).list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * 查找出ProjectGeneral表中所有字段的数据以及ProjectBudget表中所有字段的数据（
     * 由于预算信息管理里面还要展示budget表中的一个字段数据）
     * */
    @Override
    public void delete(ProjectInfo proInfo) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // 不用物理删除，所以这里是update
        session.update(proInfo);
        session.getTransaction().commit();
    }

    // 查询刚刚新增的projectId，即找出目前id中最大的值就可以
    @Override
    public List<Integer> findProId() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "select id from t_projectgeneral where id=(select max(id) from t_projectgeneral) and dataMark=1"; // 还需要加一个dataMark=1的查询条件
        List<Integer> list = new ArrayList<Integer>();
        list = session.createSQLQuery(sql).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<ShowProjectBudget> showAll() {
        // TODO Auto-generated method stub
        // 可以改写一下构建一个新的list类来返回包含两个表的字段的list
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // String sql =
        // "select pb.*,pg.* from t_projectbudget as pb inner join t_projectgeneral as pg"
        // + " on pb.projectId=pg.id and pg.dataMark=1"; //
        // 要加一个dataMark=1的查询条件where
        // pg.dataMark=1
//        String sql = "select pg.*,pb.*,pp.* from (t_projectgeneral as pg left join t_projectbudget as pb on pg.id=pb.projectId and pg.dataMark=1) left join t_projectprogress as pp on pg.id=pp.projectId and pp.progressType=18 and pp.dataMark=1";
//        String sql = "select pg.*,pb.*,pp.* from t_projectgeneral as pg join t_projectbudget as pb left join t_projectprogress as pp"
//                + " on pg.id=pb.projectId and pg.dataMark=1 and pg.id=pp.projectId and pp.progressType=18 and pp.dataMark=1";
        String sql = "select pg.*,pb.* from t_projectgeneral as pg inner join t_projectbudget as pb"
                + " on pg.id=pb.projectId and pg.dataMark=1";
        
        // 可以改写一下构建一个新的list类来返回包含两个表的字段两个实体类的list,现在的问题是如果下面2个类有相同的字段的话，list里面添加的2个对象相同的字段都会只取第一个添加进去的值。
//        List list = session.createSQLQuery(sql)
//                .addEntity("pg", ProjectInfo.class)
//                .addEntity("pb", ProjectBudget.class)
//                .addEntity("pp", ProjectProgress.class).list();
        List list = session.createSQLQuery(sql)
                .addEntity("pg", ProjectInfo.class)
                .addEntity("pb", ProjectBudget.class).list();
//                .addEntity("pp", ProjectProgress.class).list();

        List<ShowProjectBudget> showList = new ArrayList<ShowProjectBudget>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            // 每个集合元素都是ProjectBudget、ProjectInfo所组成的数组
            Object[] objects = (Object[]) iterator.next();
            ProjectBudget proBudget = (ProjectBudget) objects[1];
            ProjectInfo proInfo = (ProjectInfo) objects[0];
            ProjectProgress p = new ProjectProgress() ;
            int projectId = proInfo.getId() ;
            String sql2 = "select * from t_projectprogress where projectId = " + projectId + " and dataMark = 1 and progressType = 9 " ;
            List list1 = session.createSQLQuery(sql2).addEntity(ProjectProgress.class).list();
            if(list1.size()!=0){
                p = (ProjectProgress)list1.get(0);
                //同时把项目进度里面取到的实际完成时间存入项目信息表的year字段以便于查询
                //由于查询条件是针对年月的，所以不需要精确到日，若精确到日会造成错误的查询结果，例如系统默认是查9月1到9月1，若是9月2号完成时间的就查不出来
                //这里对取出的实际完成时间做下转换后存入general表的year字段中。
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM"+"-01");
                String ymString=simpleDateFormat.format((p.getEndTime()));
                try {
                    Date yearMonth=simpleDateFormat.parse(ymString);
                    proInfo.setYear(yearMonth);
                    session.update(proInfo);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
//                proInfo.setYear(p.getEndTime());
//                session.update(proInfo);
            }
//            ProjectProgress proProgress = (ProjectProgress) objects[2];
            ShowProjectBudget showBudget = new ShowProjectBudget();
            showBudget.setProBudget(proBudget);
            showBudget.setProInfo(proInfo);
            showBudget.setProProgress(p);
            showList.add(showBudget);
            System.out.println("projectBudget_id=" + proBudget.getId()
                    + "project_id=" + proInfo.getId() + "project_budget="
                    + proBudget.getTotalInvestment2() + " projectInfo_type="
                    + proInfo.getProjectType() + " projectInfo_platform="
                    + proInfo.getProjectPlatform());

        }
        session.getTransaction().commit();
        return showList;
    }

    /**
     * 按搜索条件查询项目信息管理页面所展示的信息列表
     * */
    @Override
    public List<ShowProjectBudget> searchProInfo(String projectName,
            int projectType, int developType, int projectPlatform,
            Date startTime, Date endTime, int projectStatus, int priority,
            int scheduledPlan, double totalInvestment2a,
            double totalInvestment2b) {
        // TODO Auto-generated method stub

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // String sql =
        // "select pg.*,pb.* from t_projectgeneral as pg inner join t_projectbudget as pb"
        // + " on pg.id=pb.projectId and pg.dataMark=1"
        // + " and pg.projectName like '%"
        // + projectName
        // + "%' and pg.projectType like '%"
        // + projectType
        // + "%' and pg.developType like '%" + developType + "%'";

        // String sql = "";
        // if (projectType == 0 && developType == 0 && projectPlatform == 0) {
        // sql =
        // "select pg.*,pb.* from t_projectgeneral as pg inner join t_projectbudget as pb"
        // + " on pg.id=pb.projectId and pg.dataMark=1"
        // + " and pg.projectName like '%" + projectName + "%'";
        // } else if(projectType != 0 || developType != 0 || projectPlatform !=
        // 0){
        // sql =
        // "select pg.*,pb.* from t_projectgeneral as pg inner join t_projectbudget as pb"
        // + " on pg.id=pb.projectId and pg.dataMark=1"
        // + " and pg.projectName like '%"
        // + projectName
        // + "%' and pg.projectType like '%"
        // + projectType
        // + "%'and pg.developType like '%"
        // + developType
        // + "%'and pg.projectPlatform like '%"
        // + projectPlatform
        // + "%'";
        // }

        StringBuffer multiSql = new StringBuffer();
        multiSql.append("select pg.*,pb.* from t_projectgeneral as pg inner join t_projectbudget as pb on pg.id=pb.projectId and pg.dataMark=1");
        if (projectName != "") {
            multiSql.append(" and pg.projectName like '%" + projectName + "%'");
        }
        if (projectType != 0) {
            multiSql.append(" and pg.projectType like '%" + projectType + "%'");
        }
        if (developType != 0) {
            multiSql.append(" and pg.developType like '%" + developType + "%'");
        }
        if (projectPlatform != 0) {
            multiSql.append(" and pg.projectPlatform like '%" + projectPlatform
                    + "%'");
        }
        // if((startTime !=null) && (endTime!=null)){
        // java.sql.Date start = new java.sql.Date(startTime.getTime());
        // java.sql.Date end = new java.sql.Date(endTime.getTime());
        // multiSql.append(" and pg.year between '"+ start
        // + " 00:00:00' and '" + end
        // + " 23:59:59'");}
        if ((startTime != null) && (endTime != null)) {
            java.sql.Date start = new java.sql.Date(startTime.getTime());
            java.sql.Date end = new java.sql.Date(endTime.getTime());
            multiSql.append(" and pg.year between '" + start
                    + " 00:00:00' and '" + end + " 23:59:59'");
        }
        if (projectStatus != 0) {
            multiSql.append(" and pg.projectStatus like '%" + projectStatus
                    + "%'");
        }
        if (priority != 0) {
            multiSql.append(" and pg.priority like '%" + priority + "%'");
        }
        if (scheduledPlan != 0) {
            multiSql.append(" and pg.scheduledPlan like '%" + scheduledPlan
                    + "%'");
        }
        if ((totalInvestment2a != 0) && (totalInvestment2b != 0)) {
            multiSql.append(" and pb.totalInvestment2 between "
                    + totalInvestment2a + " and " + totalInvestment2b);
        }

        // else{multiSql.append("select pg.*,pb.* from t_projectgeneral as pg inner join t_projectbudget as pb"
        // + " on pg.id=pb.projectId and pg.dataMark=1");}
        String sql = multiSql.toString();
        List list = session.createSQLQuery(sql)
                .addEntity("pg", ProjectInfo.class)
                .addEntity("pb", ProjectBudget.class).list();
        List<ShowProjectBudget> showList = new ArrayList<ShowProjectBudget>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            // 每个集合元素都是ProjectBudget、ProjectInfo所组成的数组
            Object[] objects = (Object[]) iterator.next();
            ProjectBudget proBudget = (ProjectBudget) objects[1];
            ProjectInfo proInfo = (ProjectInfo) objects[0];
            ProjectProgress p = new ProjectProgress() ;
            int projectId = proInfo.getId() ;
            String sql2 = "select * from t_projectprogress where projectId = " + projectId + " and dataMark = 1 and progressType = 9 " ;
            List list1 = session.createSQLQuery(sql2).addEntity(ProjectProgress.class).list();
            if(list1.size()!=0){
                p = (ProjectProgress)list1.get(0);
                //同时把项目进度里面取到的实际完成时间存入项目信息表的year字段以便于查询
//                proInfo.setYear(p.getEndTime());
//                session.update(proInfo);
            }
            ShowProjectBudget showBudget = new ShowProjectBudget();
            showBudget.setProBudget(proBudget);
            showBudget.setProInfo(proInfo);
            showBudget.setProProgress(p);
            showList.add(showBudget);
            System.out.println("projectBudget_id=" + proBudget.getId()
                    + "project_id=" + proInfo.getId() + "project_budget="
                    + proBudget.getTotalInvestment2() + " projectInfo_type="
                    + proInfo.getProjectType() + " projectInfo_platform="
                    + proInfo.getProjectPlatform());

        }
        session.getTransaction().commit();
        return showList;
    }
}
