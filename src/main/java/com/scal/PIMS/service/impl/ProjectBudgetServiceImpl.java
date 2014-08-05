/**
 * @(#)ProjectBudgetServiceImpl.java
 * 
 *                                   Copyright scal.All rights reserved. This
 *                                   software is the Scal.PIMS system.
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

package com.scal.PIMS.service.impl;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.dao.ProjectBudgetDAO;
import com.scal.PIMS.dao.ProjectInfoDAO;
import com.scal.PIMS.dao.impl.ProjectBudgetDAOImpl;
import com.scal.PIMS.dao.impl.ProjectInfoDAOImpl;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.service.ProjectBudgetService;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author 曾雨桐
 * @since 2013年12月18日
 */
public class ProjectBudgetServiceImpl implements ProjectBudgetService {

    // 这个方法没用了，只是针对单表的
    @Override
    public List<ProjectBudget> listAll() {
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        List<ProjectBudget> list = projectBudgetDAO.listAll();
        return list;
    }

    @Override
    public ProjectBudget getById(int id) {
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        ProjectBudget projectBudget = projectBudgetDAO.getById(id);
        return projectBudget;
    }

    @Override
    public void save(ProjectBudget projectBudget) {
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        projectBudgetDAO.save(projectBudget);
    }

    @Override
    public void update(ProjectBudget projectBudget) {
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        projectBudgetDAO.update(projectBudget);
    }

    @Override
    public List<ShowProjectBudget> multiEntityQuery() {
        // TODO Auto-generated method stub
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        List<ShowProjectBudget> showList = projectBudgetDAO.multiEntityQuery();
        return showList;
    }

    @Override
    public ProjectBudget getByProjectId(int projectId) {
        // TODO Auto-generated method stub
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        ProjectBudget projectBudget = projectBudgetDAO
                .getByProjectId(projectId);
        return projectBudget;
    }

    @Override
    public List<ShowProjectBudget> searchBudgetInfo(String projectName,
            int projectType, int type, int projectPlatform, Date applyYear,
            double totalInvestment1a, double totalInvestment1b,
            Date applyTimeStart, Date applyTimeEnd, Date approvalTimeStart,
            Date approvalTimeEnd) {
        // TODO Auto-generated method stub
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        List<ShowProjectBudget> showList = projectBudgetDAO.searchBudgetInfo(
                projectName, projectType, type, projectPlatform, applyYear,
                totalInvestment1a, totalInvestment1b, applyTimeStart,
                applyTimeEnd, approvalTimeStart, approvalTimeEnd);
        return showList;
    }

    @Override
    public List<ShowProjectBudget> pageList(int page) {
        // TODO Auto-generated method stub
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();

        if (multiEntityQuery().size() % 10 != 0
                && page == multiEntityQuery().size() / 10 + 1) {
            List<ShowProjectBudget> showList = projectBudgetDAO
                    .multiEntityQuery().subList((page - 1) * 10,
                            multiEntityQuery().size());
            return showList;
        } else {
            List<ShowProjectBudget> showList = projectBudgetDAO
                    .multiEntityQuery().subList((page - 1) * 10, page * 10);
            return showList;
        }
    }

    @Override
    public int getPageCount() {
        // TODO Auto-generated method stub
        return multiEntityQuery().size() % 10 == 0 ? multiEntityQuery().size() / 10
                : multiEntityQuery().size() / 10 + 1;
    }

    @Override
    public List<ShowProjectBudget> pageListByCondition(String projectName,
            int projectType, int type, int projectPlatform, Date applyYear,
            double totalInvestment1a, double totalInvestment1b,
            Date applyTimeStart, Date applyTimeEnd, Date approvalTimeStart,
            Date approvalTimeEnd, int page, int flag) {
        // TODO Auto-generated method stub
        ProjectBudgetDAO projectBudgetDAO = new ProjectBudgetDAOImpl();
        if (page == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pName", projectName);
            ActionContext.getContext().getSession().put("pType", projectType);
            ActionContext.getContext().getSession().put("ptype", type);
            ActionContext.getContext().getSession()
                    .put("pPlatform", projectPlatform);
            ActionContext.getContext().getSession().put("aYear", applyYear);
            ActionContext.getContext().getSession()
                    .put("tInvestment1a", totalInvestment1a);
            ActionContext.getContext().getSession()
                    .put("tInvestment1b", totalInvestment1b);
            ActionContext.getContext().getSession()
                    .put("aTimeStart", applyTimeStart);
            ActionContext.getContext().getSession()
                    .put("applyTimeEnd", applyTimeEnd);
            ActionContext.getContext().getSession()
                    .put("approvalTimeStart", approvalTimeStart);
            ActionContext.getContext().getSession()
                    .put("approvalTimeEnd", approvalTimeEnd);
        }
        String pName = (String) ActionContext.getContext().getSession()
                .get("pName");
        Integer integer1 = (Integer) ActionContext.getContext().getSession()
                .get("pType");
        int pType = integer1.intValue();
        Integer integer2 = (Integer) ActionContext.getContext().getSession()
                .get("type");
        int ttype = integer2.intValue();
        Integer integer3 = (Integer) ActionContext.getContext().getSession()
                .get("pPlatform");
        int pPlatform = integer3.intValue();
        Date aYear = (Date) ActionContext.getContext().getSession()
                .get("aYear");
        Double tInvestment1a = (Double) ActionContext.getContext().getSession()
                .get("tInvestment1a");

        Double tInvestment1b = (Double) ActionContext.getContext().getSession()
                .get("tInvestment1b");

        Date aTimeStart = (Date) ActionContext.getContext().getSession()
                .get("aTimeStart");
        Date aTimeEnd = (Date) ActionContext.getContext().getSession()
                .get("applyTimeEnd");
        Date aprovalTimeStart = (Date) ActionContext.getContext().getSession()
                .get("approvalTimeStart");
        Date aprovalTimeEnd = (Date) ActionContext.getContext().getSession()
                .get("approvalTimeEnd");
        int sumSize = searchBudgetInfo(pName, pType, ttype, pPlatform, aYear,
                tInvestment1a, tInvestment1b, aTimeStart, aTimeEnd,
                aprovalTimeStart, aprovalTimeEnd).size();
        if (sumSize % 10 != 0 && page == sumSize / 10 + 1) {
            List<ShowProjectBudget> showList = projectBudgetDAO
                    .searchBudgetInfo(pName, pType, ttype, pPlatform, aYear,
                            tInvestment1a, tInvestment1b, aTimeStart, aTimeEnd,
                            aprovalTimeStart, aprovalTimeEnd).subList((page - 1) * 10, sumSize);
            return showList;
        } else {
            List<ShowProjectBudget> showList = projectBudgetDAO
                    .searchBudgetInfo(pName, pType, ttype, pPlatform, aYear,
                            tInvestment1a, tInvestment1b, aTimeStart, aTimeEnd,
                            aprovalTimeStart, aprovalTimeEnd).subList((page - 1) * 10, page * 10);
            return showList;
        }
    }

    @Override
    public int getPageCountByCondition(String projectName, int projectType,
            int type, int projectPlatform, Date applyYear,
            double totalInvestment1a, double totalInvestment1b,
            Date applyTimeStart, Date applyTimeEnd, Date approvalTimeStart,
            Date approvalTimeEnd, int page, int flag) {
        // TODO Auto-generated method stub
        if (page == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pName", projectName);
            ActionContext.getContext().getSession().put("pType", projectType);
            ActionContext.getContext().getSession().put("ptype", type);
            ActionContext.getContext().getSession()
                    .put("pPlatform", projectPlatform);
            ActionContext.getContext().getSession().put("aYear", applyYear);
            ActionContext.getContext().getSession()
                    .put("tInvestment1a", totalInvestment1a);
            ActionContext.getContext().getSession()
                    .put("tInvestment1b", totalInvestment1b);
            ActionContext.getContext().getSession()
                    .put("aTimeStart", applyTimeStart);
            ActionContext.getContext().getSession()
                    .put("applyTimeEnd", applyTimeEnd);
            ActionContext.getContext().getSession()
                    .put("approvalTimeStart", approvalTimeStart);
            ActionContext.getContext().getSession()
                    .put("approvalTimeEnd", approvalTimeEnd);
        }
        String pName = (String) ActionContext.getContext().getSession()
                .get("pName");
        Integer integer1 = (Integer) ActionContext.getContext().getSession()
                .get("pType");
        int pType = integer1.intValue();
        Integer integer2 = (Integer) ActionContext.getContext().getSession()
                .get("type");
        int ttype = integer2.intValue();
        Integer integer3 = (Integer) ActionContext.getContext().getSession()
                .get("pPlatform");
        int pPlatform = integer3.intValue();
        Date aYear = (Date) ActionContext.getContext().getSession()
                .get("aYear");
        Double tInvestment1a = (Double) ActionContext.getContext().getSession()
                .get("tInvestment1a");

        Double tInvestment1b = (Double) ActionContext.getContext().getSession()
                .get("tInvestment1b");

        Date aTimeStart = (Date) ActionContext.getContext().getSession()
                .get("aTimeStart");
        Date aTimeEnd = (Date) ActionContext.getContext().getSession()
                .get("applyTimeEnd");
        Date aprovalTimeStart = (Date) ActionContext.getContext().getSession()
                .get("approvalTimeStart");
        Date aprovalTimeEnd = (Date) ActionContext.getContext().getSession()
                .get("approvalTimeEnd");
        int sumSize = searchBudgetInfo(pName, pType, ttype, pPlatform, aYear,
                tInvestment1a, tInvestment1b, aTimeStart, aTimeEnd,
                aprovalTimeStart, aprovalTimeEnd).size();
        return sumSize % 10 == 0 ? sumSize / 10 : sumSize / 10 + 1;
    }

}
