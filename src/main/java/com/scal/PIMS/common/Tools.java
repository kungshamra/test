/**
 * @(#)GetUserIp.java
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
 *  1     2014年1月2日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
public class Tools {
    public String getUserIp() {
        String ip = ServletActionContext.getRequest().getRemoteAddr();
        return ip;
    }
    public String dateFormat(Date date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate=format.format(date);
        return formatDate;
    }

}
