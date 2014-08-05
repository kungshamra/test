/**
 * @(#)ProjectBudget.java
 * 
 *                        Copyright scal.All rights reserved. This software is
 *                        the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*-                 History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日         曾雨桐                            Created
 **********************************************
 */
package com.scal.PIMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 项目信息管理列表.
 * 
 * @author 曾雨桐
 * @since 2013年12月18日
 */
@Entity
@Table(name = "t_projectgeneral")
public class ProjectInfo {
    private int id;
    private String projectName;
    private int projectType;
    private int projectPlatform;
    private String applyDepartment;
    private int projectStatus;
    private Date year;
    private Date budgetApplyTime;
    private Date budgetApprovalTime;
    private int priority;
    private int scheduledPlan;
//    private double totalInvestment2;
    private int developType;
    private String responsibilityDep;
    private String responsibilityLeader;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    public int getProjectPlatform() {
        return projectPlatform;
    }

    public void setProjectPlatform(int projectPlatform) {
        this.projectPlatform = projectPlatform;
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getBudgetApplyTime() {
        return budgetApplyTime;
    }

    public void setBudgetApplyTime(Date budgetApplyTime) {
        this.budgetApplyTime = budgetApplyTime;
    }

    public Date getBudgetApprovalTime() {
        return budgetApprovalTime;
    }

    public void setBudgetApprovalTime(Date budgetApprovalTime) {
        this.budgetApprovalTime = budgetApprovalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getScheduledPlan() {
        return scheduledPlan;
    }

//    public double getTotalInvestment2() {
//        return totalInvestment2;
//    }
//
//    public void setTotalInvestment2(double totalInvestment2) {
//        this.totalInvestment2 = totalInvestment2;
//    }

    public void setScheduledPlan(int scheduledPlan) {
        this.scheduledPlan = scheduledPlan;
    }

    public int getDevelopType() {
        return developType;
    }

    public void setDevelopType(int developType) {
        this.developType = developType;
    }

    public String getResponsibilityDep() {
        return responsibilityDep;
    }

    public void setResponsibilityDep(String responsibilityDep) {
        this.responsibilityDep = responsibilityDep;
    }

    public String getResponsibilityLeader() {
        return responsibilityLeader;
    }

    public void setResponsibilityLeader(String responsibilityLeader) {
        this.responsibilityLeader = responsibilityLeader;
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
