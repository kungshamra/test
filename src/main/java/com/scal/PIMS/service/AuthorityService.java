/**
 * @(#)AuthorityService.java
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

package com.scal.PIMS.service;

import java.util.List;

import com.scal.PIMS.model.Authority;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月26日
 */
public interface AuthorityService {

    /**
     * 
     */
    public List<Authority> findAll() ;
    public void save(Authority authority) ;
    public void update(Authority authority) ;
    public Authority findAuthorityById(int authorityId) ;
    public Authority findAuthority(String authorityName) ;
}
