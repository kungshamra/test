/**
 * @(#)ProgressService.java
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
 *  1     2013年12月23日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.service;

import java.util.List;

import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.ProjectProgress;

/**
 * Class description goes here.
 *
 * @author jonathan
 * @since 2013年12月23日
 */
public interface ProgressService {

    /**
     * 
     */
    //保存对象
    public void save(ProjectProgress proProgress); 
    //根据id取项目进度的对象
    public ProjectProgress getById(int id);
    //更新对象
    public void update(ProjectProgress proProgress) ;
    //在每条信息后面进行删除操作
    public void delete(ProjectProgress proProgress) ;
    //取出所有项目进度信息数据到列表(这个方法需改成更加id取出这个id相关联的所有项目进度信息)
    public List<ProjectProgress> findAll(int projectId) ;
    //分页相关方法
    public List<ProjectProgress> pageList(int currPage, int projectId, int flag);

    public int getPageCount(int currPage, int projectId, int flag);
}
