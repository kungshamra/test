/**
 * @(#)OperateLogAction.java
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
 *  1     2014年1月2日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.dao.OperateLogDAO;
import com.scal.PIMS.dao.impl.OperateLogDAOImpl;
import com.scal.PIMS.model.OperateLog;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.PagingService;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.PagingServiceImpl;
import com.sun.tools.internal.ws.processor.model.Request;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
public class OperateLogAction extends ActionSupport {
    private int id;
    private String loginName;
    private String trueName;
    private String moduleName;
    private String keyWord;
    private int operateType;
    private String operateInfo;
    private Date operateTime;
    private Date startTime;
    private Date endTime;
    private String ipAddress;
    private int dataMark;
    private int page;
    private int totalPage;
    private int flag;
    private List<OperateLog> list;
    private OperateLogService operateLogService = new OperateLogServiceImpl();
    PagingService pagingService = new PagingServiceImpl();
    OperateLog operateLog = new OperateLog();

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<OperateLog> getList() {
        return list;
    }

    public void setList(List<OperateLog> list) {
        this.list = list;
    }

    public OperateLogService getOperateLogService() {
        return operateLogService;
    }

    public void setOperateLogService(OperateLogService operateLogService) {
        this.operateLogService = operateLogService;
    }

    public String showLog() {
        try {
            this.setTotalPage(operateLogService.getPageCount());
            this.list = operateLogService.pageList(page);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String searchLog() {
        try {
            this.setTotalPage(operateLogService.getConditionPageCount(trueName,
                    moduleName, operateType, keyWord, startTime, endTime,
                    ipAddress, page, flag));
            this.list = operateLogService.searchByConditionPage(trueName,
                    moduleName, operateType, keyWord, startTime, endTime,
                    ipAddress, page, flag);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String logDetail() {
        try {
            this.list = operateLogService.detail(id);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
}
