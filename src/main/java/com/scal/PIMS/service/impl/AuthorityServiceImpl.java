/**
 * @(#)AuthorityServiceImpl.java
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
 *  1     2013年12月26日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.service.impl;

import java.util.List;

import com.scal.PIMS.dao.AuthorityDAO;
import com.scal.PIMS.dao.impl.AuthorityDAOImpl;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.service.AuthorityService;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月26日
 */
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityDAO authorityDao = new AuthorityDAOImpl() ;
    
    @Override
    public List<Authority> findAll() {
        // TODO Auto-generated method stub
        List<Authority> list = authorityDao.findAll() ;
        return list ;
    }

    @Override
    public void save(Authority authority) {
        // TODO Auto-generated method stub
        authorityDao.save(authority) ;
    }

    @Override
    public void update(Authority authority) {
        // TODO Auto-generated method stub
        authorityDao.update(authority) ;
    }

    
    @Override
    public Authority findAuthorityById(int authorityId) {
        // TODO Auto-generated method stub
        Authority authority = authorityDao.findAuthorityById(authorityId) ;
        return authority ;
    }

    @Override
    public Authority findAuthority(String authorityName) {
        // TODO Auto-generated method stub
        Authority authority = authorityDao.findAuthority(authorityName) ;
        return authority ;
    }

}
