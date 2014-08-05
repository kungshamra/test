/**
 * @(#)UserAndRole.java
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
 *  1     2013年12月30日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.util;

import java.util.Date;
import java.util.List;

import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月30日
 */
public class UserAndRole {
    private User user ;
    private List<Role> role ;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Role> getRole() {
        return role;
    }
    public void setRole(List<Role> role) {
        this.role = role;
    }
  
}
