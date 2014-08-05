/**
 * @(#)AuthorityAction.java
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
 *  1     2013年12月26日		 周波                    Created
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
 * @since 2013年12月26日
 */
public class AuthorityAction extends ActionSupport {
    
    //Action中用于封装用户请求参数的属性
    private int authorityId ;
    private String authorityGroup ;
    private String authorityName ;
    private int dataMark ;
    private String remarks ;
    private String s ;
    private Authority authority ;
    private List<Authority> list ;
    
    //声明并实例化Service
    private AuthorityService authorityService = new AuthorityServiceImpl() ;
    private OperateLogService operateLogService = new OperateLogServiceImpl();
    
    //Action中属性对应的getter和setter方法
    public int getAuthorityId() {
        return authorityId;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }
    public String getAuthorityGroup() {
        return authorityGroup;
    }
    public void setAuthorityGroup(String authorityGroup) {
        this.authorityGroup = authorityGroup;
    }
    public String getAuthorityName() {
        return authorityName;
    }
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    public int getDataMark() {
        return dataMark;
    }
    public void setDataMark(int dataMark) {
        this.dataMark = dataMark;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public List<Authority> getList() {
        return list;
    }
    public void setList(List<Authority> list) {
        this.list = list;
    }
    public Authority getAuthority() {
        return authority;
    }
    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
    
    //查询所有的系统功能
    public String findAuthority() {
        try{
            this.list = authorityService.findAll() ;
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //新增加一个系统功能
    public String addAuthority() {
        try{
            Authority authority = new Authority() ;
            
            authority.setAuthorityGroup(authorityGroup) ;
            authority.setAuthorityName(authorityName) ;
            authority.setDataMark(dataMark) ;
            authority.setRemarks(remarks) ;
            
            //保存新建的authority对象
            authorityService.save(authority) ;
            //记录日志
            operateLogService.recordOperateLog(81,authority);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //编辑系统功能
    public String updateAuthority() {
        try{
            Authority authority = authorityService.findAuthorityById(authorityId) ;
            
            authority.setAuthorityGroup(authorityGroup) ;
            authority.setAuthorityName(authorityName) ;
            authority.setDataMark(dataMark) ;
            authority.setRemarks(remarks) ;
            
            //调用update方法实现更新
            authorityService.update(authority) ;
            //记录日志
            operateLogService.recordOperateLog(83,authority);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //更新前的操作
    public String beforeUpdateAuthority(){
        try{
            //取出原有的值
            Authority authority = authorityService.findAuthorityById(authorityId) ;

            this.setAuthorityGroup(authority.getAuthorityGroup()) ;
            this.setAuthorityName(authority.getAuthorityName()) ;
            this.setDataMark(authority.getDataMark()) ;
            this.setRemarks(authority.getRemarks()) ;
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //删除系统功能
/*    public String deleteAuthority() {
        try{
            //根据ID取得相应功能
            Authority authority = authorityService.findAuthorityById(authorityId) ;
            
            //设置标志位为-1，并非物理删除
            authority.setDataMark(-1) ;
            authorityService.update(authority) ;
            RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
            List<RoleAuthority> list = roleAuthorityService.findRoleAuthorityByAuthorityId(authorityId) ;
            Iterator<RoleAuthority> iter = list.iterator() ;
            while(iter.hasNext()){
                RoleAuthority roleAuthority = iter.next() ;
                roleAuthorityService.delete(roleAuthority) ;
            }
            //记录日志
            operateLogService.recordOperateLog(82,authority);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }*/
    
    //批量删除功能
    public String deleteAnyAuthority() {
        try{
        //    System.out.print(s);
        //    System.out.print(projectId);
            String[] string = s.substring(0, s.length()-2).split("A") ;
            for(int i=0;i<string.length;i++){
                Authority authority = authorityService.findAuthorityById(Integer.parseInt(string[i])) ;
                authority.setDataMark(-1) ;
                authorityService.update(authority) ;
                //级联删除角色功能关系表中的数据
                RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
                List<RoleAuthority> list = roleAuthorityService.findRoleAuthorityByAuthorityId(authorityId) ;
                Iterator<RoleAuthority> iter = list.iterator() ;
                while(iter.hasNext()){
                    RoleAuthority roleAuthority = iter.next() ;
                    roleAuthorityService.delete(roleAuthority) ;
                }
                //记录日志
                operateLogService.recordOperateLog(82,authority);
            }
            
            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace() ;
            return INPUT ;
        } 
    }
}
