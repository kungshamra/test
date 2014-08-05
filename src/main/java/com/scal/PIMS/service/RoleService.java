/**
 * @(#)RoleService.java
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
 *  1     2013年12月25日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.service;

import java.util.List;

import com.scal.PIMS.model.Role;
import com.scal.PIMS.util.RoleAndAuthority;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月25日
 */
public interface RoleService {

    /**
     * 
     */
    public List<RoleAndAuthority> findAll() ;
//    public List<Role> findAllRole() ;
    public void save(Role role) ;
    public void update(Role role) ;
    public Role findRoleById(int roleId) ;
    public Role findRoleByName(String roleName) ;
    public List<List<String>> beforeUpdateRoleAuthority(int roleId) ;
}
