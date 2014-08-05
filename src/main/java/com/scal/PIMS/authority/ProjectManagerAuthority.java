/**
 * @(#)ProjectManagerAuthority.java
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

package com.scal.PIMS.authority;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;
import com.scal.PIMS.service.UserRoleService;
import com.scal.PIMS.service.UserService;
import com.scal.PIMS.service.impl.UserRoleServiceImpl;
import com.scal.PIMS.service.impl.UserServiceImpl;
import com.scal.PIMS.util.AuthoritySupport;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2014年1月8日
 */
public class ProjectManagerAuthority extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
     // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext() ;
        Map session = ctx.getSession() ;
        //取出名为loginName的session属性
        String loginName = (String)session.get("loginName") ;
    
        //如果没有登陆，或者登陆用户不是项目管理员，则不能访问相应资源
        if(loginName!=null&&(!"".equals(loginName))){
            String str = AuthoritySupport.findAuthorityByLoginName(loginName) ;
            if(str.contains("项目管理员")){
                return invocation.invoke() ; 
            }else{
                ctx.put("tip","您没有相应的权限");     
                return Action.ERROR;
            }
        }else{
            ctx.put("tip","您还没有登录，请登陆系统");     
            return Action.LOGIN;
        }
    }

}
