/**
 * @(#)ProjectSystemService.java
 * 
 *                               Copyright scal.All rights reserved. This
 *                               software is the Scal.PIMS system.
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

package com.scal.PIMS.service;

import java.util.List;

import com.scal.PIMS.model.ProjectSystem;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2013年12月27日
 */
public interface ProjectSystemService {

    /**
     * 数据操作
     */
    // 新增
    public void save(ProjectSystem projectSystem);

    // 列表
    public List<ProjectSystem> findAll(int projectId);

    // 根据预算id取项目子系统信息列表
    public List<ProjectSystem> findByBudgetId(int budgetId);

    // 根据id取项目子系统信息
    public ProjectSystem getById(int id);

    // 更新
    public void update(ProjectSystem projectSystem);

    // 详情
    public List<ProjectSystem> detail(int id);

    public List<ProjectSystem> pageListByProjectId(int currPage, int projectId,int flag);

    public int getPageCountByProjectId(int currPage, int projectId,int flag);
    
    public List<ProjectSystem> pageListByBudgetId(int currPage, int budgetId,int flag);

    public int getPageCountByBudgetId(int currPage, int budgetId,int flag);

}
