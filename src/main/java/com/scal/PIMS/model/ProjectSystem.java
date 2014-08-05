/**
 * @(#)ProjectSystem.java
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
 *  1  2013年12月17日	       王  超               Created
 **********************************************
 */

package com.scal.PIMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 项目子系统信息实体类
 * 
 * @author 王超
 * @since 2013年12月17日
 */

@Entity
@Table(name = "t_projectsysteminfo")
public class ProjectSystem implements Cloneable {

    private int id;
    private int projectId;
    private String acceptors;
    private String systemName;
    private int systemType;
    private double systemTotalInvest;
    private double systemCarryOver;
    private double systemNewlyInvest;
    private int systemPlatform;
    private int systemDevelopType;
    private String teamMember;
    private String applyDepartment;
    private Date handoverTime;
    private String userDepartment;
    private String description;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getAcceptors() {
        return acceptors;
    }

    public void setAcceptors(String acceptors) {
        this.acceptors = acceptors;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public int getSystemType() {
        return systemType;
    }

    public void setSystemType(int systemType) {
        this.systemType = systemType;
    }

    public double getSystemTotalInvest() {
        return systemTotalInvest;
    }

    public void setSystemTotalInvest(double systemTotalInvest) {
        this.systemTotalInvest = systemTotalInvest;
    }

    public double getSystemCarryOver() {
        return systemCarryOver;
    }

    public void setSystemCarryOver(double systemCarryOver) {
        this.systemCarryOver = systemCarryOver;
    }

    public double getSystemNewlyInvest() {
        return systemNewlyInvest;
    }

    public void setSystemNewlyInvest(double systemNewlyInvest) {
        this.systemNewlyInvest = systemNewlyInvest;
    }

    public int getSystemPlatform() {
        return systemPlatform;
    }

    public void setSystemPlatform(int systemPlatform) {
        this.systemPlatform = systemPlatform;
    }

    public int getSystemDevelopType() {
        return systemDevelopType;
    }

    public void setSystemDevelopType(int systemDevelopType) {
        this.systemDevelopType = systemDevelopType;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }

    public Date getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(Date handoverTime) {
        this.handoverTime = handoverTime;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Object clone() {
        try {
            return super.clone();

        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
