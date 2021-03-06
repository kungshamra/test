/**
 * @(#)ProjectInfoDAO.java
 * 
 *                         Copyright scal.All rights reserved. This software is
 *                         the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.dao;

import java.util.Date;
import java.util.List;

import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月18日
 */
public interface ProjectInfoDAO {
    // 保存对象
    public void save(ProjectInfo proInfo);

    // 根据id取项目信息的对象
    public ProjectInfo getById(int id);

    // 取出所有项目信息数据到列表
    public List<ProjectInfo> findAll();

    // 更新对象
    public void update(ProjectInfo proInfo);

    // 在每条信息后面进行删除操作
    public void delete(ProjectInfo proInfo);

    // 查找刚刚新增项目的id
    public List<Integer> findProId();

    // 查找出ProjectGeneral表中所有字段的数据以及ProjectBudget表中所有字段的数据
    // （由于预算信息管理里面还要展示budget表中的一个字段数据）
    public List<ShowProjectBudget> showAll();

    // 按搜索条件查询并返回结果
    public List<ShowProjectBudget> searchProInfo(String projectName,
            int projectType, int developType, int projectPlatform,
            Date startTime, Date endTime, int projectStatus, int priority,
            int scheduledPlan, double totalInvestment2a,
            double totalInvestment2b);
}
