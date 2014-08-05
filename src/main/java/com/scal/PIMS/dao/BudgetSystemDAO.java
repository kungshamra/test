/**
 * @(#)BudgetSystemDAO.java
 * 
 *                          Copyright scal.All rights reserved. This software is
 *                          the Scal.PIMS system.
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

package com.scal.PIMS.dao;

import com.scal.PIMS.model.BudgetSystem;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectSystem;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月6日
 */
public interface BudgetSystemDAO {
    public ProjectBudget getBudgetId(int projectId);

    public ProjectSystem getSystemId(int projectId);
    public BudgetSystem getBySystemId(int systemId);
    public void saveRelationship(BudgetSystem budgetSystem);
    public void deleteRelationship(BudgetSystem budgetSystem);
}
