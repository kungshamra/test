/**
 * @(#)UserRoleDAO.java
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
 *  1     2013年12月27日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.UserRole;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月27日
 */
public interface UserRoleDAO {
    public void save(UserRole userRole) ;
    public void update(UserRole userRole) ;
    public void delete(UserRole userRole) ;
    public List<UserRole> findUserRoleByMemberId(int memberId) ;
    public List<UserRole> findUserRoleByRoleId(int roleId) ;
    public List<Role> findRole(int memberId) ;
}
