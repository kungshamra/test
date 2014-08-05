/**
 * @(#)User.java
 * 
 * Copyright scal.All rights reserved.
 * This software is the XXX system. 
 *
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */ 
 /*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月23日		周波                     Created
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
 * @author ZhouBo
 * @since 2013年12月23日
 */
@Entity
@Table(name="t_userinfo")
public class User {
    private int memberId ;
    private String loginName ;
    private String trueName ;
    private String password ;
    private String department ;
    private String mobile ;
    private String officeNumber ;
    private Date lastLogin ;
    private Date lastChangePwd ;
    private String remarks ;
    private int dataMark ;
    private String email ;
    private int f1 ;
    private String f2 ;
   
    @Id
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    public Date getLastChangePwd() {
        return lastChangePwd;
    }
    public void setLastChangePwd(Date lastChangePwd) {
        this.lastChangePwd = lastChangePwd;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public int getDataMark() {
        return dataMark;
    }
    public void setDataMark(int dataMark) {
        this.dataMark = dataMark;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
