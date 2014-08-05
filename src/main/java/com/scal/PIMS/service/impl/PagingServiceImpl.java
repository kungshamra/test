/**
 * @(#)PagingServiceImpl.java
 * 
 *                            Copyright scal.All rights reserved. This software
 *                            is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月17日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.service.impl;

import java.util.Iterator;
import java.util.List;

import com.scal.PIMS.dao.PagingDAO;
import com.scal.PIMS.dao.impl.PagingDAOImpl;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.service.PagingService;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月17日
 */
public class PagingServiceImpl implements PagingService {
    PagingDAO pagingDAO = new PagingDAOImpl();

    @Override
    public List pageList(int currPage, Object object) {
        String hql = "from " + object.getClass().getName()
                + " where dataMark='1' ";
        List list = pagingDAO.pageList(currPage, hql);
        return list;
    }

    @Override
    public List pageListByProjectId(int currPage, Object object, int projectId) {
        String hql = "from " + object.getClass().getName()
                + " where dataMark='1' and projectId='" + projectId + "'";
        List list = pagingDAO.pageList(currPage, hql);
        return list;
    }

    @Override
    public List<ProjectSystem> pageListByBudgetId(int currPage, Object object,
            int budgetId) {
        String hql = "select a from "
                + object.getClass().getName()
                + " a,BudgetSystem b where a.id=b.systemId and dataMark='1' and b.budgetId='"
                + budgetId + "'";
        List<ProjectSystem> list = pagingDAO.pageList(currPage, hql);

        return list;
    }

    @Override
    public int getPageCount(Object object) {
        String hql = "from " + object.getClass().getName()
                + " where dataMark='1' ";
        int count = pagingDAO.getPageCount(hql);
        return count;
    }

    @Override
    public int getPageCountByProjectId(Object object, int projectId) {
        String hql = "from " + object.getClass().getName()
                + " where dataMark='1' and projectId='" + projectId + "'";
        int count = pagingDAO.getPageCount(hql);
        return count;
    }

    @Override
    public int getPageCountByBudgetId(Object object, int budgetId) {
        String hql = "select a from "
                + object.getClass().getName()
                + " a,BudgetSystem b where a.id=b.systemId and dataMark='1' and b.budgetId='"
                + budgetId + "'";
        int count = pagingDAO.getPageCount(hql);
        return count;
    }
}
