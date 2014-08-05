/**
 * @(#)ProProgressHistoryDAO.java
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

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.ProjectProgressHistory;
import com.scal.PIMS.util.ShowProgressHistory;


/**
 * Class description goes here.
 *
 * @author jonathan
 * @since 2014年1月27日
 */
public interface ProProgressHistoryDAO {
    // 保存对象
    public void save(ProjectProgressHistory pph);
    //找出记录中id最大的一条
    public List<Integer> findMaxId();
    //找出id最大的一条记录给并返回对象给action调用
    public ProjectProgressHistory getByMaxId(int id);
    //更新对象
    public void update(ProjectProgressHistory pph);
    //查找出项目进度信息及进度信息历史表两个表的数据并返回一个list供前台展示
    public List<ShowProgressHistory> showHistory();
}
