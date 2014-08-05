/**
 * @(#)ProjectInfoServiceImpl.java
 * 
 *                                 Copyright scal.All rights reserved. This
 *                                 software is the XXX system.
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

package com.scal.PIMS.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.dao.ProjectBudgetDAO;
import com.scal.PIMS.dao.ProjectInfoDAO;
import com.scal.PIMS.dao.impl.ProjectBudgetDAOImpl;
import com.scal.PIMS.dao.impl.ProjectInfoDAOImpl;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.service.ProjectInfoService;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月18日
 */
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Override
    public void save(ProjectInfo proInfo) {
        // TODO Auto-generated method stub
        ProjectInfoDAO proInfoDAO = new ProjectInfoDAOImpl();
        proInfoDAO.save(proInfo);
    }

    @Override
    public ProjectInfo getById(int id) {
        // TODO Auto-generated method stub
        ProjectInfoDAO proInfoDAO = new ProjectInfoDAOImpl();
        ProjectInfo proInfo = proInfoDAO.getById(id);
        return proInfo;
    }

    @Override
    public void update(ProjectInfo proInfo) {
        // TODO Auto-generated method stub
        ProjectInfoDAO proInfoDAO = new ProjectInfoDAOImpl();
        proInfoDAO.update(proInfo);
    }

    @Override
    public List<ProjectInfo> findAll() {
        // TODO Auto-generated method stub
        ProjectInfoDAO proInfoDAO = new ProjectInfoDAOImpl();
        List<ProjectInfo> list = proInfoDAO.findAll();
        return list;
    }

    @Override
    public void delete(ProjectInfo proInfo) {
        // TODO Auto-generated method stub
        ProjectInfoDAO proInfoDAO = new ProjectInfoDAOImpl();
        proInfoDAO.delete(proInfo);
    }

    @Override
    public void addBudget(ProjectBudget proBudget) {
        // TODO Auto-generated method stub
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        projectBudgetDAO.save(proBudget);
    }

    @Override
    public List findProId() {
        // TODO Auto-generated method stub
        ProjectInfoDAO proInfoDAO = new ProjectInfoDAOImpl();
        List list = proInfoDAO.findProId();
        return list;
    }

    @Override
    public List<ShowProjectBudget> showAll() {
        // TODO Auto-generated method stub
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAOImpl();
        List<ShowProjectBudget> showList = projectInfoDAO.showAll();
        return showList;
    }

    @Override
    public List<ShowProjectBudget> pageList(int page) {
        // TODO Auto-generated method stub
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAOImpl();
        if (showAll().size() % 10 != 0 && page == showAll().size() / 10 + 1) {
            List<ShowProjectBudget> showList = projectInfoDAO.showAll()
                    .subList((page - 1) * 10, showAll().size());
            return showList;
        } else {
            List<ShowProjectBudget> showList = projectInfoDAO.showAll()
                    .subList((page - 1) * 10, page * 10);
            return showList;
        }

    }

    @Override
    public int getPageCount() {
        return showAll().size() % 10 == 0 ? showAll().size() / 10 : showAll()
                .size() / 10 + 1;
    }

    @Override
    public List<ShowProjectBudget> searchProInfo(String projectName,
            int projectType, int developType, int projectPlatform,
            Date startTime, Date endTime, int projectStatus, int priority,
            int scheduledPlan, double totalInvestment2a,
            double totalInvestment2b) {
        // TODO Auto-generated method stub
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAOImpl();
        List<ShowProjectBudget> showList = projectInfoDAO.searchProInfo(
                projectName, projectType, developType, projectPlatform,
                startTime, endTime, projectStatus, priority, scheduledPlan,
                totalInvestment2a, totalInvestment2b);
        return showList;
    }

    @Override
    public List<ShowProjectBudget> pageListByCondition(String projectName,
            int projectType, int developType, int projectPlatform,
            Date startTime, Date endTime, int projectStatus, int priority,
            int scheduledPlan, double totalInvestment2a,
            double totalInvestment2b, int page, int flag) {
        // TODO Auto-generated method stub
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAOImpl();
        if (page == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pName", projectName);
            ActionContext.getContext().getSession().put("pType", projectType);
            ActionContext.getContext().getSession().put("dType", developType);
            ActionContext.getContext().getSession()
                    .put("pPlatform", projectPlatform);
            ActionContext.getContext().getSession().put("sTime", startTime);
            ActionContext.getContext().getSession().put("eTime", endTime);
            ActionContext.getContext().getSession()
                    .put("pStatus", projectStatus);
            ActionContext.getContext().getSession().put("prior", priority);
            ActionContext.getContext().getSession().put("sPlan", scheduledPlan);
            ActionContext.getContext().getSession()
                    .put("tInvestment2a", totalInvestment2a);
            ActionContext.getContext().getSession()
                    .put("tInvestment2b", totalInvestment2b);
        }
        String pName = (String) ActionContext.getContext().getSession()
                .get("pName");
        Integer integer1 = (Integer) ActionContext.getContext().getSession()
                .get("pType");
        int pType = integer1.intValue();
        Integer integer2 = (Integer) ActionContext.getContext().getSession()
                .get("dType");
        int dType = integer2.intValue();
        Integer integer3 = (Integer) ActionContext.getContext().getSession()
                .get("pPlatform");
        int pPlatform = integer3.intValue();
        Integer integer4 = (Integer) ActionContext.getContext().getSession()
                .get("pStatus");
        int pStatus = integer4.intValue();
        Integer integer5 = (Integer) ActionContext.getContext().getSession()
                .get("prior");
        int prior = integer5.intValue();
        Integer integer6 = (Integer) ActionContext.getContext().getSession()
                .get("sPlan");
        int sPlan = integer6.intValue();
        Date sTime = (Date) ActionContext.getContext().getSession()
                .get("sTime");
        Date eTime = (Date) ActionContext.getContext().getSession()
                .get("eTime");
        Double tInvestment2a = (Double) ActionContext.getContext().getSession()
                .get("tInvestment2a");
        Double tInvestment2b = (Double) ActionContext.getContext().getSession()
                .get("tInvestment2b");
        int sumSize = searchProInfo(pName, pType, dType, pPlatform,
                sTime, eTime, pStatus, prior, sPlan, tInvestment2a,
                tInvestment2b).size();
        if (sumSize % 10 != 0 && page == sumSize/10+1) {
            List<ShowProjectBudget> showList = projectInfoDAO.searchProInfo(
                    pName, pType, dType, pPlatform, sTime, eTime, pStatus,
                    prior, sPlan, tInvestment2a, tInvestment2b).subList(
                    (page - 1) * 10, sumSize);
            return showList;
        } else {
            List<ShowProjectBudget> showList = projectInfoDAO.searchProInfo(
                    pName, pType, dType, pPlatform, sTime, eTime, pStatus,
                    prior, sPlan, tInvestment2a, tInvestment2b).subList(
                    (page - 1) * 10, page * 10);
            return showList;
        }

    }

    @Override
    public int getPageCountByCondition(String projectName, int projectType,
            int developType, int projectPlatform, Date startTime, Date endTime,
            int projectStatus, int priority, int scheduledPlan,
            double totalInvestment2a, double totalInvestment2b, int page,
            int flag) {
        if (page == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pName", projectName);
            ActionContext.getContext().getSession().put("pType", projectType);
            ActionContext.getContext().getSession().put("dType", developType);
            ActionContext.getContext().getSession()
                    .put("pPlatform", projectPlatform);
            ActionContext.getContext().getSession().put("sTime", startTime);
            ActionContext.getContext().getSession().put("eTime", endTime);
            ActionContext.getContext().getSession()
                    .put("pStatus", projectStatus);
            ActionContext.getContext().getSession().put("prior", priority);
            ActionContext.getContext().getSession().put("sPlan", scheduledPlan);
            ActionContext.getContext().getSession()
                    .put("tInvestment2a", totalInvestment2a);
            ActionContext.getContext().getSession()
                    .put("tInvestment2b", totalInvestment2b);
        }
        String pName = (String) ActionContext.getContext().getSession()
                .get("pName");
        Integer integer1 = (Integer) ActionContext.getContext().getSession()
                .get("pType");
        int pType = integer1.intValue();
        Integer integer2 = (Integer) ActionContext.getContext().getSession()
                .get("dType");
        int dType = integer2.intValue();
        Integer integer3 = (Integer) ActionContext.getContext().getSession()
                .get("pPlatform");
        int pPlatform = integer3.intValue();
        Integer integer4 = (Integer) ActionContext.getContext().getSession()
                .get("pStatus");
        int pStatus = integer4.intValue();
        Integer integer5 = (Integer) ActionContext.getContext().getSession()
                .get("prior");
        int prior = integer5.intValue();
        Integer integer6 = (Integer) ActionContext.getContext().getSession()
                .get("sPlan");
        int sPlan = integer6.intValue();
        Date sTime = (Date) ActionContext.getContext().getSession()
                .get("sTime");
        Date eTime = (Date) ActionContext.getContext().getSession()
                .get("eTime");
        Double tInvestment2a = (Double) ActionContext.getContext().getSession()
                .get("tInvestment2a");
        Double tInvestment2b = (Double) ActionContext.getContext().getSession()
                .get("tInvestment2b");
        int sumSize = searchProInfo(pName, pType, dType, pPlatform, sTime,
                eTime, pStatus, prior, sPlan, tInvestment2a, tInvestment2b)
                .size();
        return sumSize % 10 == 0 ? sumSize / 10 : sumSize / 10 + 1;
    }

}
