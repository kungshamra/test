/**
 * @(#)ProjectProgressHistoryService.java
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

package com.scal.PIMS.service;

import java.util.Date;
import java.util.List;

import com.scal.PIMS.model.ProjectProgressHistory;
import com.scal.PIMS.util.ShowProgressHistory;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 *
 * @author jonathan
 * @since 2014年1月27日
 */
public interface ProjectProgressHistoryService {
    // 更新对象
    public void save(ProjectProgressHistory pph);
    //更新对象
    public void update(ProjectProgressHistory pph);   
    //找出记录中id最大的一条
    public List<Integer> findMaxId();
    //找出id最大的一条记录给并返回对象给action调用
    public ProjectProgressHistory getByMaxId(int id);
    //查找出项目进度信息及进度信息历史表两个表的数据并返回一个list供前台展示
    public List<ShowProgressHistory> showHistory();
    // 分页相关方法
    public List<ShowProgressHistory> pageList(int page);

    public int getPageCount();
}
