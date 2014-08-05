/**
 * @(#)ProgressServiceImpl.java
 * 
 *                              Copyright scal.All rights reserved. This
 *                              software is the XXX system.
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

package com.scal.PIMS.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.dao.ProgressDAO;
import com.scal.PIMS.dao.ProjectInfoDAO;
import com.scal.PIMS.dao.impl.ProgressDAOImpl;
import com.scal.PIMS.dao.impl.ProjectInfoDAOImpl;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.service.PagingService;
import com.scal.PIMS.service.ProgressService;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月23日
 */
public class ProgressServiceImpl implements ProgressService {

    @Override
    public void save(ProjectProgress proProgress) {
        // TODO Auto-generated method stub
        ProgressDAO proProgressDAO = new ProgressDAOImpl();
        proProgressDAO.save(proProgress);
    }

    @Override
    public ProjectProgress getById(int id) {
        // TODO Auto-generated method stub
        ProgressDAO proProgressDAO = new ProgressDAOImpl();
        ProjectProgress proProgress = proProgressDAO.getById(id);
        return proProgress;
    }

    @Override
    public void update(ProjectProgress proProgress) {
        // TODO Auto-generated method stub
        ProgressDAO proProgressDAO = new ProgressDAOImpl();
        proProgressDAO.update(proProgress);
    }

    @Override
    public void delete(ProjectProgress proProgress) {
        // TODO Auto-generated method stub
        ProgressDAO proProgressDAO = new ProgressDAOImpl();
        proProgressDAO.delete(proProgress);
    }

    @Override
    public List<ProjectProgress> findAll(int projectId) {
        // TODO Auto-generated method stub
        ProgressDAO proProgressDAO = new ProgressDAOImpl();
        List<ProjectProgress> list = proProgressDAO.findAll(projectId);
        for (Iterator<ProjectProgress> iterator = list.iterator(); iterator
                .hasNext();) {
            ProjectProgress proProgress = iterator.next();
            if (proProgress.getEndTime() != null
                    && (proProgress.getEndTime().after(proProgress
                            .getPlanEndTime()))) {
                proProgress.setIsDelay(2);// IsDelay字段：0代表空，1代表否，2代表是；
                Date actualTime = proProgress.getEndTime();
                Date planTime = proProgress.getPlanEndTime();
                long delayTime = (actualTime.getTime() - planTime.getTime())
                        / (1000 * 60 * 60 * 24);
                int dTime = (int) delayTime;
                proProgress.setDelayTime(dTime);
            } else {
                proProgress.setIsDelay(1);
                proProgress.setDelayTime(0);
            }
            proProgressDAO.update(proProgress);
        }
        return list;
    }

    @Override
    public List<ProjectProgress> pageList(int currPage, int projectId, int flag) {
        // TODO Auto-generated method stub
        ProjectProgress proProgress = new ProjectProgress();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pId", projectId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("pId");
        int pId = integer.intValue();

        return pagingService.pageListByProjectId(currPage, proProgress, pId);
    }

    @Override
    public int getPageCount(int currPage, int projectId, int flag) {
        // TODO Auto-generated method stub
        ProjectProgress proProgress = new ProjectProgress();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pId", projectId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("pId");
        int pId = integer.intValue();

        return pagingService.getPageCountByProjectId(proProgress, pId);
    }

}
