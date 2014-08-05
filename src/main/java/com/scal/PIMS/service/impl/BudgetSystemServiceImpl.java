/**
 * @(#)BudgetSystemServiceImpl.java
 * 
 *                                  Copyright scal.All rights reserved. This
 *                                  software is the Scal.PIMS system.
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

package com.scal.PIMS.service.impl;

import com.scal.PIMS.dao.BudgetSystemDAO;
import com.scal.PIMS.dao.impl.BudgetSystemDAOImpl;
import com.scal.PIMS.model.BudgetSystem;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.service.BudgetSystemService;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月6日
 */
public class BudgetSystemServiceImpl implements BudgetSystemService {

    private BudgetSystemDAO budgetSystemDAO = new BudgetSystemDAOImpl();

    @Override
    public ProjectBudget getBudgetId(int projectId) {
        ProjectBudget projectBudget = budgetSystemDAO.getBudgetId(projectId);
        return projectBudget;
    }

    @Override
    public ProjectSystem getSystemId(int projectId) {
        ProjectSystem projectSystem = budgetSystemDAO.getSystemId(projectId);
        return projectSystem;
    }
    @Override
    public BudgetSystem getBySystemId(int systemId){
        BudgetSystem budgetSystem=budgetSystemDAO.getBySystemId(systemId);
        return budgetSystem;
    }
    @Override
    public void saveRelationship(BudgetSystem budgetSystem) {
        budgetSystemDAO.saveRelationship(budgetSystem);
    }

    @Override
    public void deleteRelationship(BudgetSystem budgetSystem) {
        budgetSystemDAO.deleteRelationship(budgetSystem);
    }
}
