/**
 * @(#)UserDAO.java
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
 *  1     2013年12月23日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.User;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月23日
 */
public interface UserDAO {

    /**
     * 
     */
    public List<User> findAll() ;
    public void save(User user) ;
    public void update(User user) ;
    public User findUserById(int memberId) ;
    public User findUserByLoginName(String loginName) ;
    public List<User> findUserByCondition(String loginName,String trueName,String officeNumber) ;
}
