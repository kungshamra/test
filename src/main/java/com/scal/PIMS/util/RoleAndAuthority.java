/**
 * @(#)RoleAndAuthority.java
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
 *  1     2014年1月2日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.util;

import java.util.List;

import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.Role;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2014年1月2日
 */
public class RoleAndAuthority {
    private Role role ;
    private List<Authority> authority ;
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public List<Authority> getAuthority() {
        return authority;
    }
    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }
    
}
