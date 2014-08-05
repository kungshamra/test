/**
 * @(#)ProjectSubsystemDAO.java
 * 
 *                              Copyright scal.All rights reserved. This
 *                              software is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1   2013年12月25日	       王  超              Created
 **********************************************
 */

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.ProjectSystem;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2013年12月25日
 */
public interface ProjectSystemDAO {
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

}
