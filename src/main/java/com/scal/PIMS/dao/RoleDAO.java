/**
 * @(#)RoleDAO.java
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

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.Role;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月25日
 */
public interface RoleDAO {

    /**
     * 
     */
    public List<Role> findAll() ;
    public void save(Role role) ;
    public void update(Role role) ;
    public Role findRoleById(int roleId) ;
    public Role findRoleByName(String roleName) ;
}
