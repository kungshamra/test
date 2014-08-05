/**
 * @(#)AuthoritySupport.java
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
 *  1     2014年1月8日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.util;

import java.util.Iterator;
import java.util.List;

import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;
import com.scal.PIMS.service.UserRoleService;
import com.scal.PIMS.service.UserService;
import com.scal.PIMS.service.impl.UserRoleServiceImpl;
import com.scal.PIMS.service.impl.UserServiceImpl;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2014年1月8日
 */
public class AuthoritySupport {
    public static String findAuthorityByLoginName(String loginName){
        UserService userService = new UserServiceImpl() ;
        UserRoleService userRoleService = new UserRoleServiceImpl() ;
        User user = userService.findUserByLoginName(loginName) ;
        List<Role> list = userRoleService.findRole(user.getMemberId()) ;
        Iterator<Role> iter = list.iterator() ;
        String str = "" ;
        while(iter.hasNext()){
            Role role = iter.next() ;
            str = str + role.getRoleName() ;
        }
        return str ;
    }
}
