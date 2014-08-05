/**
 * @(#)Log.java
 * 
 *              Copyright scal.All rights reserved. This software is the
 *              Scal.PIMS system.
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

package com.scal.PIMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
@Entity
@Table(name = "t_operatelog")
public class OperateLog {
    private int id;
    private String loginName;
    private String trueName;
    private String moduleName;
    private String keyWord;
    private int operateType;
    private String operateInfo;
    private Date operateTime;
    private String ipAddress;
    private int dataMark;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public String getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getDataMark() {
        return dataMark;
    }

    public void setDataMark(int dataMark) {
        this.dataMark = dataMark;
    }

}
