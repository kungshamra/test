/**
 * @(#)Relationship.java
 * 
 *                       Copyright scal.All rights reserved. This software is
 *                       the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月2日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
@Entity
@Table(name = "t_budgetsystemrelationship")
public class BudgetSystem {
    private int id;
    private int budgetId;
    private int systemId;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

}
