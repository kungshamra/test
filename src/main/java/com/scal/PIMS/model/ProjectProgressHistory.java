/**
 * @(#)ProjectProgressHistory.java
 * 
 *                                 Copyright scal.All rights reserved. This
 *                                 software is the XXX system.
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

package com.scal.PIMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2014年1月27日
 */
@Entity
@Table(name = "t_projectprogresshistory")
public class ProjectProgressHistory {
    private int id;
    private int projectProgressId;
    private Date changedPlanST;
    private Date changedPlanET;
    private String editor;
    private Date editTime;
    private String remark;
    private int dataMark;
    private int f1;
    private String f2;
    
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectProgressId() {
        return projectProgressId;
    }

    public void setProjectProgressId(int projectProgressId) {
        this.projectProgressId = projectProgressId;
    }

    public Date getChangedPlanST() {
        return changedPlanST;
    }

    public void setChangedPlanST(Date changedPlanST) {
        this.changedPlanST = changedPlanST;
    }

    public Date getChangedPlanET() {
        return changedPlanET;
    }

    public void setChangedPlanET(Date changedPlanET) {
        this.changedPlanET = changedPlanET;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDataMark() {
        return dataMark;
    }

    public void setDataMark(int dataMark) {
        this.dataMark = dataMark;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

}
