/**
 * @(#)PagingDAO.java
 * 
 *                    Copyright scal.All rights reserved. This software is the
 *                    Scal.PIMS system.
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

package com.scal.PIMS.dao;

import java.util.List;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月17日
 */
public interface PagingDAO {

    /**
     * 
     */
    // 分页结果
    public List pageList(int currPage, String hql);

    // 分页页数
    public int getPageCount(String hql);
}
