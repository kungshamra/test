/**
 * @(#)ProjectProgressHistoryServiceImpl.java
 * 
 * Copyright scal.All rights reserved.
 * This software is the XXX system. 
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

package com.scal.PIMS.service.impl;

import java.util.List;

import com.scal.PIMS.dao.ProProgressHistoryDAO;
import com.scal.PIMS.dao.ProjectBudgetDAO;
import com.scal.PIMS.dao.impl.ProjectBudgetDAOImpl;
import com.scal.PIMS.dao.impl.ProjectProgressHistoryDAOImpl;
import com.scal.PIMS.model.ProjectProgressHistory;
import com.scal.PIMS.service.ProjectProgressHistoryService;
import com.scal.PIMS.util.ShowProgressHistory;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 *
 * @author jonathan
 * @since 2014年1月27日
 */
public class ProjectProgressHistoryServiceImpl implements ProjectProgressHistoryService{

    @Override
    public void save(ProjectProgressHistory pph) {
        // TODO Auto-generated method stub
        ProProgressHistoryDAO pphDAO= new  ProjectProgressHistoryDAOImpl();
        pphDAO.save(pph);
    }

    @Override
    public ProjectProgressHistory getByMaxId(int id) {
        // TODO Auto-generated method stub
        ProProgressHistoryDAO pphDAO= new  ProjectProgressHistoryDAOImpl();
        return pphDAO.getByMaxId(id);
    }

    @Override
    public void update(ProjectProgressHistory pph) {
        // TODO Auto-generated method stub
        ProProgressHistoryDAO pphDAO= new  ProjectProgressHistoryDAOImpl();
        pphDAO.update(pph);
    }

    @Override
    public List<Integer> findMaxId() {
        // TODO Auto-generated method stub
        ProProgressHistoryDAO pphDAO= new  ProjectProgressHistoryDAOImpl();
        List<Integer> maxIdList = pphDAO.findMaxId();
        return maxIdList;
    }

    @Override
    public List<ShowProgressHistory> showHistory() {
        // TODO Auto-generated method stub
        ProProgressHistoryDAO pphDAO= new  ProjectProgressHistoryDAOImpl();
        return pphDAO.showHistory();       
    }

    @Override
    public List<ShowProgressHistory> pageList(int page) {
        // TODO Auto-generated method stub
        ProProgressHistoryDAO pphDAO= new  ProjectProgressHistoryDAOImpl();

        if (showHistory().size() % 10 != 0
                && page == showHistory().size() / 10 + 1) {
            List<ShowProgressHistory> showList = pphDAO
                    .showHistory().subList((page - 1) * 10,
                            showHistory().size());
            return showList;
        } else {
            List<ShowProgressHistory> showList = pphDAO
                    .showHistory().subList((page - 1) * 10, page * 10);
            return showList;
        }
    }

    @Override
    public int getPageCount() {
        // TODO Auto-generated method stub
        return showHistory().size() % 10 == 0 ? showHistory().size() / 10
                : showHistory().size() / 10 + 1;
    }

}
