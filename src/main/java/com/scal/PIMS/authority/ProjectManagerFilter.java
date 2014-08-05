/**
 * @(#)ProjectManagerFilter.java
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
 *  1     2014年1月9日		 ZhouBo       Created
 **********************************************
 */

package com.scal.PIMS.authority;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.scal.PIMS.util.AuthoritySupport;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2014年1月9日
 */
public class ProjectManagerFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request ;
        HttpSession session = req.getSession() ;
        String loginName = (String)session.getAttribute("loginName") ;
        if(loginName!=null){
            String str = AuthoritySupport.findAuthorityByLoginName(loginName) ;
            if(str.contains("项目管理员")){
                chain.doFilter(request, response) ;
            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response) ;
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
