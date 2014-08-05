/**
 * @(#)UserRoleServiceImpl.java
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

package com.scal.PIMS.service.impl;

import java.util.List;

import com.scal.PIMS.dao.UserRoleDAO;
import com.scal.PIMS.dao.impl.UserRoleDAOImpl;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;
import com.scal.PIMS.model.UserRole;
import com.scal.PIMS.service.UserRoleService;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月27日
 */
public class UserRoleServiceImpl implements UserRoleService {
       
    private UserRoleDAO userRoleDao = new UserRoleDAOImpl() ;
    
    @Override
    public void save(UserRole userRole) {
        // TODO Auto-generated method stub
        userRoleDao.save(userRole) ;
    }

    @Override
    public void update(UserRole userRole) {
        // TODO Auto-generated method stub
        userRoleDao.update(userRole) ;
    }

    @Override
    public void delete(UserRole userRole) {
        // TODO Auto-generated method stub
        userRoleDao.delete(userRole) ;
    }

    @Override
    public List<UserRole> findUserRoleByMemberId(int memberId) {
        // TODO Auto-generated method stub
        List<UserRole> userRole = userRoleDao.findUserRoleByMemberId(memberId) ;
        return userRole ;
    }

    @Override
    public List<UserRole> findUserRoleByRoleId(int roleId) {
        // TODO Auto-generated method stub
        List<UserRole> userRole = userRoleDao.findUserRoleByRoleId(roleId) ;
        return userRole ;
    }

    @Override
    public List<Role> findRole(int memberId) {
        // TODO Auto-generated method stub
        List<Role> role = userRoleDao.findRole(memberId) ;
        return role ;
    }

}
