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
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月17日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 项目预算信息实体类
 * 
 * @author 王超
 * @since 2013年12月17日
 */

@Entity
@Table(name = "t_projectbudget")
public class ProjectBudget {

    private int id;
    private Date year;
    private int projectId;
    private int type;
    private double totalInvestment1;
    private double carryOver;
    private double newlyInvestment;
    private double totalInvestment2;
    private String remark1;
    private String remark2;
    private String excelPath;
    private String result;
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getTotalInvestment1() {
        return totalInvestment1;
    }

    public void setTotalInvestment1(double totalInvestment1) {
        this.totalInvestment1 = totalInvestment1;
    }

    public double getCarryOver() {
        return carryOver;
    }

    public void setCarryOver(double carryOver) {
        this.carryOver = carryOver;
    }

    public double getNewlyInvestment() {
        return newlyInvestment;
    }

    public void setNewlyInvestment(double newlyInvestment) {
        this.newlyInvestment = newlyInvestment;
    }

    public double getTotalInvestment2() {
        return totalInvestment2;
    }

    public void setTotalInvestment2(double totalInvestment2) {
        this.totalInvestment2 = totalInvestment2;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
