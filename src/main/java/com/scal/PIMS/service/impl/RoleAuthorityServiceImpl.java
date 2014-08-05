/**
 * @(#)RoleAuthorityServiceImpl.java
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
 *  1     2013年12月31日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.service.impl;

import java.util.List;

import com.scal.PIMS.dao.RoleAuthorityDAO;
import com.scal.PIMS.dao.impl.RoleAuthorityDAOImpl;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.RoleAuthority;
import com.scal.PIMS.service.RoleAuthorityService;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月31日
 */
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
    
    private RoleAuthorityDAO roleAuthorityDao = new RoleAuthorityDAOImpl() ;
    
    @Override
    public void save(RoleAuthority roleAuthority) {
        // TODO Auto-generated method stub
        roleAuthorityDao.save(roleAuthority) ;
    }

    @Override
    public void update(RoleAuthority roleAuthority) {
        // TODO Auto-generated method stub
        roleAuthorityDao.update(roleAuthority) ;
    }

    @Override
    public List<RoleAuthority> findRoleAuthorityByRoleId(int roleId) {
        // TODO Auto-generated method stub
        List<RoleAuthority> roleAuthority = roleAuthorityDao.findRoleAuthorityByRoleId(roleId) ;
        return roleAuthority ;
    }

    @Override
    public List<RoleAuthority> findRoleAuthorityByAuthorityId(int authorityId) {
        // TODO Auto-generated method stub
        List<RoleAuthority> roleAuthority = roleAuthorityDao.findRoleAuthorityByAuthorityId(authorityId) ;
        return roleAuthority ;
    }

    @Override
    public List<Authority> findAuthority(int roleId) {
        // TODO Auto-generated method stub
        List<Authority> authority = roleAuthorityDao.findAuthority(roleId) ;
        return authority ;
    }

    @Override
    public void delete(RoleAuthority roleAuthority) {
        // TODO Auto-generated method stub
        roleAuthorityDao.delete(roleAuthority) ;
    }
    
}
