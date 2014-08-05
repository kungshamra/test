/**
 * @(#)UserService.java
 * 
 *                      Copyright scal.All rights reserved. This software is the
 *                      XXX system.
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

package com.scal.PIMS.service;

import java.util.List;

import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.User;
import com.scal.PIMS.util.UserAndRole;

/**
 * Class description goes here.
 * 
 * @author ZhouBo
 * @since 2013年12月23日
 */
public interface UserService {

    /**
     * 
     */
    // public List<User> findAll() ;
    public List<UserAndRole> findAllUser();

    public List<UserAndRole> pageList(int page);

    public int getPageCount();

    public List<UserAndRole> pageListByCondition(String loginName,
            String trueName, String officeNumber, int page, int flag);

    public int getPageCountByCondition(String loginName, String trueName,
            String officeNumber, int page, int flag);

    public void save(User user);

    public void update(User user);

    public User findUserById(int memberId);

    public User findUserByLoginName(String loginName);

    // public List<Authority> userDetail(int memberId) ;
    public List<List<String>> beforeUpdateUserRole(int memberId);

    public List<UserAndRole> findUserByCondition(String loginName,
            String trueName, String officeNumber);
    /*
     * public List<UserAndRole> pageList(int currPage); public int
     * getPageCount();
     */
}
