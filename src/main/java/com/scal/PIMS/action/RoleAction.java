/**
 * @(#)RoleAction.java
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
 *  1     2013年12月25日		 周波                    Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.RoleAuthority;
import com.scal.PIMS.model.UserRole;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.RoleAuthorityService;
import com.scal.PIMS.service.RoleService;
import com.scal.PIMS.service.UserRoleService;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.RoleAuthorityServiceImpl;
import com.scal.PIMS.service.impl.RoleServiceImpl;
import com.scal.PIMS.service.impl.UserRoleServiceImpl;
import com.scal.PIMS.util.RoleAndAuthority;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月25日
 */
public class RoleAction extends ActionSupport {
    
    //Action中用于封装用户请求参数的属性
    private int roleId ;
    private String roleName ;
    private int dataMark ;
    private String remarks ;
    private String s ;
    private String authorityName ;
    private String authorityGroup ;
    private List<Role> list ;
    private List leftLabel ;
    private List rightLabel ;
    private List<String> leftList = new ArrayList<String>() ;
    private List<String> rightList = new ArrayList<String>() ;
    //声明并实例化Service
    private RoleService roleService = new RoleServiceImpl() ;
    private OperateLogService operateLogService = new OperateLogServiceImpl();
    
    //Action中属性对应的getter和setter方法
    public String getAuthorityGroup() {
        return authorityGroup;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public void setAuthorityGroup(String authorityGroup) {
        this.authorityGroup = authorityGroup;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public String getAuthorityName() {
        return authorityName;
    }
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    public List<Role> getList() {
        return list;
    }
    public void setList(List<Role> list) {
        this.list = list;
    }
    private List<RoleAndAuthority> raList ;
    
    public RoleService getRoleService() {
        return roleService;
    }
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    public List<RoleAndAuthority> getRaList() {
        return raList;
    }
    public void setRaList(List<RoleAndAuthority> raList) {
        this.raList = raList;
    }  
    public List getLeftLabel() {
        return leftLabel;
    }
    public void setLeftLabel(List leftLabel) {
        this.leftLabel = leftLabel;
    }
    public List getRightLabel() {
        return rightLabel;
    }
    public void setRightLabel(List rightLabel) {
        this.rightLabel = rightLabel;
    }
    public List<String> getLeftList() {
        return leftList;
    }
    public void setLeftList(List<String> leftList) {
        this.leftList = leftList;
    }
    public List<String> getRightList() {
        return rightList;
    }
    public void setRightList(List<String> rightList) {
        this.rightList = rightList;
    }
    
    //查询所有的角色，以及该角色对应的功能模块
    public String findRole() {
        try{
            List<RoleAndAuthority> roleAuthorityList = roleService.findAll() ;
            this.raList = roleAuthorityList ;
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //新增角色
    public String addRole() {
        try{
            //新建一个角色对象
            Role role = new Role() ;
            
            //设置相应的值
            role.setRoleName(roleName) ;
            role.setRemarks(remarks) ;
            role.setDataMark(dataMark) ;
            
            //保存角色对象
            roleService.save(role) ;
            //记录日志
            operateLogService.recordOperateLog(71,role);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //更新角色
    public String updateRole() {
        try{
            //通过ID查找相应角色
            Role role = roleService.findRoleById(roleId) ;
            
            //设置修改后的值
            role.setRoleName(roleName) ;
            role.setRemarks(remarks) ;
            role.setDataMark(dataMark) ;
            
            //更新角色操作
            roleService.update(role) ;
            //记录日志
            operateLogService.recordOperateLog(73,role);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //更新前操作
    public String beforeUpdateRole(){
        try{
            //通过ID查找相应角色
            Role role = roleService.findRoleById(roleId) ;

            ///取得之前的值，并通过设置属性传到页面
            this.setRoleName(role.getRoleName()) ;
            this.setRemarks(role.getRemarks()) ;
            this.setDataMark(role.getDataMark()) ;
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //删除角色
/*    public String deleteRole() {
        try{
            //通过ID查找相应角色
            Role role = roleService.findRoleById(roleId) ;
            //设置标志位为-1，不进行物理删除
            role.setDataMark(-1) ;
            //实际上执行更新操作
            roleService.update(role) ;
            
            UserRoleService userRoleService = new UserRoleServiceImpl() ;
            List<UserRole> list = userRoleService.findUserRoleByRoleId(roleId) ;
            Iterator<UserRole> iter = list.iterator() ;
            while(iter.hasNext()){
                UserRole userRole = iter.next() ;
                userRoleService.delete(userRole) ;
            }
            
            RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
            List<RoleAuthority> listra = roleAuthorityService.findRoleAuthorityByRoleId(roleId) ;
            Iterator<RoleAuthority> iterator = listra.iterator() ;
            while(iterator.hasNext()){
                RoleAuthority roleAuthority = iterator.next() ;
                roleAuthorityService.delete(roleAuthority) ;
            }
            //记录日志
            operateLogService.recordOperateLog(72,role);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }*/
    
    //批量删除角色
    public String deleteAnyRole() {
        try{
            System.out.print(s);
            String[] string = s.substring(0, s.length()-2).split("A") ;
            for(int i=0;i<string.length;i++){
                Role role = roleService.findRoleById(Integer.parseInt(string[i])) ;
                role.setDataMark(-1) ;
                roleService.update(role) ;
                //级联删除用户角色、角色功能关系表中的数据
                UserRoleService userRoleService = new UserRoleServiceImpl() ;
                List<UserRole> list = userRoleService.findUserRoleByRoleId(roleId) ;
                Iterator<UserRole> iter = list.iterator() ;
                while(iter.hasNext()){
                    UserRole userRole = iter.next() ;
                    userRoleService.delete(userRole) ;
                }
                
                RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
                List<RoleAuthority> listra = roleAuthorityService.findRoleAuthorityByRoleId(roleId) ;
                Iterator<RoleAuthority> iterator = listra.iterator() ;
                while(iterator.hasNext()){
                    RoleAuthority roleAuthority = iterator.next() ;
                    roleAuthorityService.delete(roleAuthority) ;
                }
                //记录日志
                operateLogService.recordOperateLog(72,role);
            }
            
            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace() ;
            return INPUT ;
        } 
    }
    
    //给角色授权相应功能前的操作
    public String beforeUpdateRoleAuthority(){
        try{
            //通过ID查找相应角色
            Role role = roleService.findRoleById(roleId) ;
            this.setRoleName(role.getRoleName()) ;
            
       /*     //通过角色ID查询功能，并新建一个功能对象集合保存
            List<Authority> auth = roleAuthorityService.findAuthority(role.getRoleId()) ;
            //通过Iterator迭代
            Iterator<Authority> iterator = auth.iterator() ;
            List<String> rightList = new ArrayList<String>() ;
            while(iterator.hasNext()){
                //新建一个Authority对象保存
                Authority au = iterator.next() ;
                //添加到rightList中
                rightList.add(au.getAuthorityName()) ;
            }*/
            
            List<List<String>> strings = roleService.beforeUpdateRoleAuthority(roleId) ;
            //通过设置属性传值到页面
            this.setRightList(strings.get(0)) ;
            this.setLeftList(strings.get(1)) ;
            
/*            //查询所有的功能
            List<Authority> authority = authorityService.findAll() ;
            //通过Iterator迭代
            Iterator<Authority> iter = authority.iterator() ;
            List<String> leftList = new ArrayList<String>() ;
            while(iter.hasNext()){
                //生命一个布尔型变量
                boolean flag = false ;
                //新建一个Authority接收
                Authority au = iter.next() ;
                //如果rightList集合为空，则将Authority对象添加到leftList集合中
                if(rightList.size()==0){
                    leftList.add(au.getAuthorityName()) ;
                }else{
                    //迭代rightList集合
                    Iterator<String> i = rightList.iterator() ;
                    while(i.hasNext()){
                        String str = i.next() ;
                        //如果str与Authority对象的authorityName相等，设置flag为true，反之设置为false并跳出循环
                        if(!str.equals(au.getAuthorityName())){
                            flag = true ;
                            continue ;
                        }else{
                            flag = false ;
                            break ;
                        }
                    }
                    //flag为true，向leftList中添加Authority对象的authorityName
                    if(flag){
                        leftList.add(au.getAuthorityName()) ;
                    }
                }
            }*/         
            
            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace();
            return INPUT ;
        }
    }
}
