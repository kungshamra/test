/**
 * @(#)PagingService.java
 * 
 *                        Copyright scal.All rights reserved. This software is
 *                        the Scal.PIMS system.
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

package com.scal.PIMS.service;

import java.util.List;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月17日
 */
public interface PagingService {

    /**
     * 
     */
    // 根据对象和页数获取分页结果
    public List pageList(int currPage, Object object);

    public List pageListByProjectId(int currPage, Object object, int projectId);

    public List pageListByBudgetId(int currPage, Object object, int budgetId);

    // 根据对象获取分页页数
    public int getPageCount(Object object);

    public int getPageCountByProjectId(Object object, int projectId);

    public int getPageCountByBudgetId(Object object, int budgetId);
}
