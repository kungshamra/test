/**
 * @(#)OperateLogDAO.java
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
 *  1     2014年1月2日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.dao;

import java.util.Date;
import java.util.List;

import com.scal.PIMS.model.OperateLog;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
public interface OperateLogDAO {

    /**
     * 
     */
    // 存储日志
    public void save(OperateLog operateLog);

    // 列表
    public List<OperateLog> findAll();

    // 条件查询
    public List<OperateLog> searchByCondition(String trueName,
            String moduleName, int operateType, String keyWord, Date startTime,
            Date endTime, String ipAddress);

    // 分页条件查询
    public List<OperateLog> searchByConditionPage(String trueName,
            String moduleName, int operateType, String keyWord, Date startTime,
            Date endTime, String ipAddress, int currPage);

    public List<OperateLog> detail(int id);
}
