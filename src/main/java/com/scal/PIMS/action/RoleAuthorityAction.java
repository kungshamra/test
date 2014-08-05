/**
 * @(#)RoleAuthorityAction.java
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

package com.scal.PIMS.action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.RoleAuthority;
import com.scal.PIMS.service.AuthorityService;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.RoleAuthorityService;
import com.scal.PIMS.service.impl.AuthorityServiceImpl;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.RoleAuthorityServiceImpl;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月31日
 */
public class RoleAuthorityAction extends ActionSupport {
    
    //Action中用于封装用户请求参数的属性    
    private int roleId ;
    private String authorityName ;
    private List rightLabel ;
    //声明并实例化Service    
    private RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
    private AuthorityService authorityService = new AuthorityServiceImpl() ;
    private OperateLogService operateLogService = new OperateLogServiceImpl();

    //Action中属性对应的getter和setter方法    
    public List getRightLabel() {
        return rightLabel;
    }
    public void setRightLabel(List rightLabel) {
        this.rightLabel = rightLabel;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getAuthorityName() {
        return authorityName;
    }
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    
    //对角色授权相应功能
    public String addRoleAuthority(){
        try{
            //根据roleId查询看是否为空，若不为空则删除已有记录
            if(roleAuthorityService.findRoleAuthorityByRoleId(roleId).size()!=0){
                //根据roleId查询RoleAuthority，并新建RoleAuthority对象集合接收
                List<RoleAuthority> list = roleAuthorityService.findRoleAuthorityByRoleId(roleId) ;
                //迭代RoleAuthority对象集合
                Iterator<RoleAuthority> iter = list.iterator() ;
                while(iter.hasNext()){
                    RoleAuthority roleAuthority = iter.next() ;
                    //删除已有记录
                    roleAuthorityService.delete(roleAuthority) ;
                    //记录日志
                    operateLogService.recordOperateLog(94,roleAuthority);
                }
            }
            
            //迭代rightLabel
            Iterator iter = this.rightLabel.iterator() ;
            while(iter.hasNext()){
                String str = (String)iter.next() ;
                RoleAuthority roleAuthority = new RoleAuthority() ;
                //通过str查询Authority对象，并新建对象接收
                Authority authority = authorityService.findAuthority(str) ;
                //设置相应的属性值
                roleAuthority.setRoleId(roleId) ;
                roleAuthority.setAuthorityId(authority.getAuthorityId()) ;
                //保存Authority对象
                roleAuthorityService.save(roleAuthority) ;
                //记录日志
                operateLogService.recordOperateLog(93,roleAuthority);
            }
            
            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace();
            return INPUT ;
        }
    }
}
