/**
 * @(#)OperateLogService.java
 * 
 *                            Copyright scal.All rights reserved. This software
 *                            is the Scal.PIMS system.
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

package com.scal.PIMS.service;

import java.util.Date;
import java.util.List;

import com.scal.PIMS.model.OperateLog;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
public interface OperateLogService {

    /**
     * 数据操作
     */
    // 存储日志
    public void save(OperateLog operateLog);

    public void operate(String loginName, String trueName, String operateType,
            int type, String moduleName, String tableName, String operateInfo);

    // 日志记录
    public void recordOperateLog(int flag, Object object);

    // 列表
    public List<OperateLog> findAll();

    // public List<OperateLog> searchByCondition(String trueName,
    // String moduleName, int operateType, String keyWord, Date startTime,
    // Date endTime, String ipAddress, int currPage, int flag);

    // 条件查询获取分页页数
    public int getConditionPageCount(String trueName, String moduleName,
            int operateType, String keyWord, Date startTime, Date endTime,
            String ipAddress, int currPage, int flag);

    // 条件查询获取各页列表
    public List<OperateLog> searchByConditionPage(String trueName,
            String moduleName, int operateType, String keyWord, Date startTime,
            Date endTime, String ipAddress, int currPage, int flag);

    // 获取各页列表
    public List pageList(int currPage);

    // 获取分页页数
    public int getPageCount();
    
    public List<OperateLog> detail(int id);
}
