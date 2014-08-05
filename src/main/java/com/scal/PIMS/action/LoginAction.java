/**
 * @(#)UserAction.java
 * 
 *                     Copyright scal.All rights reserved. This software is the
 *                     Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.User;
import com.scal.PIMS.service.UserService;
import com.scal.PIMS.service.impl.UserServiceImpl;

/**
 * Class description goes here.
 * 
 * @author Andy
 * @since 2013年12月18日
 */
public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {

        ActionContext ctx = ActionContext.getContext();
        if (getUsername()!=null) {
            ctx.getSession().put("loginName", this.getUsername());
            Date date = new Date() ;
            UserService userService = new UserServiceImpl() ;
            User user = userService.findUserByLoginName(username) ;
            user.setLastLogin(date) ;
            userService.save(user) ;
            
            return SUCCESS;
        } else {
            return INPUT;
        }

    }

}
