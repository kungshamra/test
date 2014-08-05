/**
 * @(#)ProjectSystemServiceImpl.java
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
 *  1     2013年12月27日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.service.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.dao.PagingDAO;
import com.scal.PIMS.dao.ProjectSystemDAO;
import com.scal.PIMS.dao.impl.PagingDAOImpl;
import com.scal.PIMS.dao.impl.ProjectSystemDAOImpl;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.service.PagingService;
import com.scal.PIMS.service.ProjectSystemService;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2013年12月27日
 */
public class ProjectSystemServiceImpl implements ProjectSystemService {
    private ProjectSystemDAO projectSystemDAO = new ProjectSystemDAOImpl();

    @Override
    public void save(ProjectSystem projectSystem) {
        projectSystemDAO.save(projectSystem);
    }

    @Override
    public List<ProjectSystem> findAll(int projectId) {
        List<ProjectSystem> list = projectSystemDAO.findAll(projectId);
        return list;
    }

    @Override
    public ProjectSystem getById(int id) {
        ProjectSystem projectSystem = projectSystemDAO.getById(id);
        return projectSystem;
    }

    @Override
    public List<ProjectSystem> findByBudgetId(int budgetId) {
        List<ProjectSystem> list = projectSystemDAO.findByBudgetId(budgetId);
        return list;
    }

    @Override
    public void update(ProjectSystem projectSystem) {
        projectSystemDAO.update(projectSystem);
    }

    @Override
    public List<ProjectSystem> detail(int id) {
        List<ProjectSystem> list = projectSystemDAO.detail(id);
        return list;
    }

    @Override
    public List<ProjectSystem> pageListByProjectId(int currPage, int projectId,
            int flag) {
        ProjectSystem projectSystem = new ProjectSystem();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pId", projectId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("pId");
        int pId = integer.intValue();

        return pagingService.pageListByProjectId(currPage, projectSystem, pId);
    }

    @Override
    public int getPageCountByProjectId(int currPage, int projectId, int flag) {
        ProjectSystem projectSystem = new ProjectSystem();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pId", projectId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("pId");
        int pId = integer.intValue();

        return pagingService.getPageCountByProjectId(projectSystem, pId);
    }

    @Override
    public List<ProjectSystem> pageListByBudgetId(int currPage, int budgetId,
            int flag) {
        ProjectSystem projectSystem = new ProjectSystem();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("bId", budgetId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("bId");
        int bId = integer.intValue();

        return pagingService.pageListByBudgetId(currPage, projectSystem, bId);
    }

    @Override
    public int getPageCountByBudgetId(int currPage, int budgetId, int flag) {
        ProjectSystem projectSystem = new ProjectSystem();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("bId", budgetId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("bId");
        int bId = integer.intValue();

        return pagingService.getPageCountByBudgetId(projectSystem, bId);
    }
}
