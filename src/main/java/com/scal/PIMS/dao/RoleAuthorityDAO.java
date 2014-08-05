/**
 * @(#)RoleAuthorityDAO.java
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

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.RoleAuthority;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月31日
 */
public interface RoleAuthorityDAO {

    /**
     * 
     */
    public void save(RoleAuthority roleAuthority) ;
    public void update(RoleAuthority roleAuthority) ;
    public List<RoleAuthority> findRoleAuthorityByRoleId(int roleId) ;
    public List<RoleAuthority> findRoleAuthorityByAuthorityId(int authorityId) ;
    public List<Authority> findAuthority(int roleId) ;
    public void delete(RoleAuthority roleAuthority) ;
}
