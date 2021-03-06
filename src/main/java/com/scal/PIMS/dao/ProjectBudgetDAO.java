/**
 * @(#)ProjectBudgetDAO.java
 * 
 *                           Copyright scal.All rights reserved. This software
 *                           is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日		  曾雨桐                            Created
 **********************************************
 */

package com.scal.PIMS.dao;

import java.util.Date;
import java.util.List;

import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author 曾雨桐
 * @since 2013年12月18日
 */
public interface ProjectBudgetDAO {
    public List<ProjectBudget> listAll();

    public ProjectBudget getById(int id);

    public void save(ProjectBudget projectBudget);

    public void update(ProjectBudget projectBudget);

    public List<ShowProjectBudget> multiEntityQuery();

    // 根据projectId找出ProjectBudget对象并把该对象的dataMark设置为-1（该方法是删除项目信息的同时执行的）
    public ProjectBudget getByProjectId(int projectId);

    // 按搜索条件查询并返回结果
    public List<ShowProjectBudget> searchBudgetInfo(String projectName,
            int projectType, int type, int projectPlatform, Date applyYear,
            double totalInvestment1a, double totalInvestment1b,
            Date applyTimeStart, Date applyTimeEnd, Date approvalTimeStart,
            Date approvalTimeEnd);
}
