/**
 * @(#)ProjectProgressHistoryDAOImpl.java
 * 
 *                                        Copyright scal.All rights reserved.
 *                                        This software is the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月27日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.scal.PIMS.dao.ProProgressHistoryDAO;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.model.ProjectProgressHistory;
import com.scal.PIMS.util.HibernateUtil;
import com.scal.PIMS.util.ShowProgressHistory;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2014年1月27日
 */
public class ProjectProgressHistoryDAOImpl implements ProProgressHistoryDAO {

    @Override
    public void save(ProjectProgressHistory pph) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(pph);
        session.getTransaction().commit();
    }

    @Override
    public ProjectProgressHistory getByMaxId(int id) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        ProjectProgressHistory pph = (ProjectProgressHistory) session.get(
                ProjectProgressHistory.class, id);
        session.getTransaction().commit();
        return pph;
    }

    @Override
    public void update(ProjectProgressHistory pph) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(pph);
        session.getTransaction().commit();
    }

    @Override
    public List<Integer> findMaxId() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "select id from t_projectprogresshistory where id=(select max(id) from t_projectprogresshistory) and dataMark=1"; // 还需要加一个dataMark=1的查询条件
        List<Integer> maxIdList = session.createSQLQuery(sql).list();
        session.getTransaction().commit();
        return maxIdList;
    }

    @Override
    public List<ShowProgressHistory> showHistory() {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "select pph.*,pp.* from  t_projectprogresshistory as pph inner join  t_projectprogress as pp"
                + " on pp.id=pph.projectProgressId and pp.dataMark=1 and pph.dataMark=1";
        // 这里添加的先后顺序还是会对结果造成影响，根本原因是这2个表的主键都叫id，如果像下面这种展示的结果是正确的，唯独id都是第一个的，不过这个不影响给用户的展示效果
        List list = session.createSQLQuery(sql)
                .addEntity("pph", ProjectProgressHistory.class)
                .addEntity("pp", ProjectProgress.class).list();
        List<ShowProgressHistory> showList = new ArrayList<ShowProgressHistory>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {

            // 每个集合元素都是ProjectProgress、ProjectProgressHistory所组成的数组
            Object[] objects = (Object[]) iterator.next();
            ProjectProgress progress = (ProjectProgress) objects[1];
            ProjectProgressHistory progressHistory = (ProjectProgressHistory) objects[0];
            ShowProgressHistory showHistory = new ShowProgressHistory();

            int projectId = progress.getProjectId();
            String sqlProjectInfo = "select * from t_projectgeneral where id = "
                    + projectId + " and dataMark = 1";
            ProjectInfo proInfo=new ProjectInfo();
            List listProjectInfo = session.createSQLQuery(sqlProjectInfo).addEntity(ProjectInfo.class).list();
            proInfo=(ProjectInfo) listProjectInfo.get(0);
            showHistory.setProProgress(progress);
            showHistory.setPpHistory(progressHistory);
            showHistory.setProInfo(proInfo);
            showList.add(showHistory);
        }
        session.getTransaction().commit();
        return showList;
    }
}
