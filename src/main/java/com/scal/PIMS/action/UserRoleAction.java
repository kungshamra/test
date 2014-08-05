/**
 * @(#)RoleUserAction.java
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
 *  1     2013年12月27日	           周波                    Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.UserRole;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.RoleService;
import com.scal.PIMS.service.UserRoleService;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.RoleServiceImpl;
import com.scal.PIMS.service.impl.UserRoleServiceImpl;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月27日
 */
public class UserRoleAction extends ActionSupport {
    
    //Action中用于封装用户请求参数的属性
    private String roleName ;
    private int memberId ;
    private List rightLabel ;
    //声明并实例化Service
    private UserRoleService userRoleService = new UserRoleServiceImpl() ;
    private RoleService roleService = new RoleServiceImpl() ;
    private OperateLogService operateLogService = new OperateLogServiceImpl();
    
    //Action中属性对应的getter和setter方法
    public List getRightLabel() {
        return rightLabel;
    }

    public void setRightLabel(List rightLabel) {
        this.rightLabel = rightLabel;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    //为用户分配角色
    public String addUserRole() {
        try{
            //根据memberId查询看是否为空，若不为空，删除已有记录
            if(userRoleService.findUserRoleByMemberId(memberId).size()!=0){
                List<UserRole> list = userRoleService.findUserRoleByMemberId(memberId) ;
                Iterator<UserRole> iter = list.iterator() ;
                while(iter.hasNext()){
                    UserRole userRole = iter.next() ;
                    userRoleService.delete(userRole) ;
                    //记录日志
                    operateLogService.recordOperateLog(92,userRole);
                }
            }
            
            //迭代rightList，保存UserRole对象
            Iterator iter = this.rightLabel.iterator() ;
            while(iter.hasNext()){
                String str = (String)iter.next() ;
                UserRole userRole = new UserRole() ;
                userRole.setMemberId(memberId) ;
                Role role = roleService.findRoleByName(str) ;
                userRole.setRoleId(role.getRoleId()) ;
                userRoleService.save(userRole) ;
                //记录日志
                operateLogService.recordOperateLog(91,userRole);
            }

            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace() ;
            return INPUT ;
        }
    }
}
