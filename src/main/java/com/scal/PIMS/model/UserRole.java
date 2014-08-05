/**
 * @(#)UserRole.java
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
 *  1     2013年12月24日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月24日
 */
@Entity
@Table(name="t_userrolerelationship")
public class UserRole {
    private int id ;
    private int memberId ;
    private int roleId ;
    private int f1 ;
    private String f2 ;
    
    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
