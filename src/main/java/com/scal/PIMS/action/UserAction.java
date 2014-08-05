/**
 * @(#)UserAction.java
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

package com.scal.PIMS.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;
import com.scal.PIMS.model.UserRole;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.RoleAuthorityService;
import com.scal.PIMS.service.RoleService;
import com.scal.PIMS.service.UserRoleService;
import com.scal.PIMS.service.UserService;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.RoleAuthorityServiceImpl;
import com.scal.PIMS.service.impl.RoleServiceImpl;
import com.scal.PIMS.service.impl.UserRoleServiceImpl;
import com.scal.PIMS.service.impl.UserServiceImpl;
import com.scal.PIMS.util.UserAndRole;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月23日
 */
public class UserAction extends ActionSupport {
    
    //Action中用于封装用户请求参数的属性
    private int memberId ;
    private String loginName ;
    private String trueName ;
    private String password ;
    private String department ;
    private String mobile ;
    private String officeNumber ;
    private Date lastLogin ;
    private Date lastChangePwd ;
    private String remarks ;
    private int dataMark ;
    private String email ;
    private String s ;
    private String message ;
    private int page;
    private int totalPage;
    private int flag;
    
    private String roleName ;
    private String authorityName ;
    private List<Role> role ;
    private List<Authority> authority ;
    private List<UserAndRole> userRoleList ;
    private List<User> list ;
    private List leftLabel ;
    private List rightLabel ;
    private List<String> leftList = new ArrayList<String>() ;
    private List<String> rightList = new ArrayList<String>() ;
   
    //声明并实例化Service    
    private UserService userService = new UserServiceImpl() ;
    private UserRoleService userRoleService = new UserRoleServiceImpl() ;
    private RoleService roleService = new RoleServiceImpl() ; 
    private RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
    private OperateLogService operateLogService = new OperateLogServiceImpl();
    
    //Action中属性对应的getter和setter方法
    public int getMemberId() {
        return memberId;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getTrueName() {
        return trueName;
    }
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    public Date getLastChangePwd() {
        return lastChangePwd;
    }
    public void setLastChangePwd(Date lastChangePwd) {
        this.lastChangePwd = lastChangePwd;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public int getDataMark() {
        return dataMark;
    }
    public void setDataMark(int dataMark) {
        this.dataMark = dataMark;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public String getAuthorityName() {
        return authorityName;
    }
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public List<Role> getRole() {
        return role;
    }
    public void setRole(List<Role> role) {
        this.role = role;
    }
    public List<Authority> getAuthority() {
        return authority;
    }
    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }
    public List<User> getList() {
        return list;
    }
    public void setList(List<User> list) {
        this.list = list;
    }    
    public List<UserAndRole> getUserRoleList() {
        return userRoleList;
    }
    public void setUserRoleList(List<UserAndRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
    
    //查询所有的用户
    public String findUser() {
        try{
/*            //新建一个User对象集合接收
            List<User> userList = userService.findAll() ;
            Iterator<User> iter = userList.iterator() ;
            List<UserAndRole> userRoleList = new ArrayList<UserAndRole>() ;
            while(iter.hasNext()){
                User user  = iter.next() ;
                UserAndRole ur = new UserAndRole() ;
                ur.setUser(user) ;
                ur.setRole(userRoleService.findRole(user.getMemberId()));
                userRoleList.add(ur) ;
            }*/
            this.setTotalPage(userService.getPageCount());
            this.userRoleList = userService.pageList(page);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //按条件查询用户
    public String findUserByCondition(){
        try{
/*            //生命一个User对象集合保存按条件查询到的用户
            List<User> userList = userService.findUserByCondition(loginName, trueName, officeNumber) ;
            //迭代User对象集合
            Iterator<User> iter = userList.iterator() ;
            List<UserAndRole> userRoleList = new ArrayList<UserAndRole>() ;
            while(iter.hasNext()){
                User user  = iter.next() ;
                UserAndRole ur = new UserAndRole() ;
                ur.setUser(user) ;
                ur.setRole(userRoleService.findRole(user.getMemberId()));
                userRoleList.add(ur) ;
            }*/
            this.setTotalPage(userService.getPageCountByCondition(loginName,
                    trueName, officeNumber, page, flag));
            this.userRoleList = userService.pageListByCondition(loginName,
                    trueName, officeNumber, page, flag);

            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    public String beforeAddUser(){
        try{
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //新增用户
    public String addUser() {
        try{
            User user = new User() ;
            
            //设置相应属性值
            user.setLoginName(loginName) ;
            user.setTrueName(trueName) ;
            user.setPassword("123456a") ;
            user.setDepartment(department) ;
            user.setMobile(mobile) ;
            user.setOfficeNumber(officeNumber) ;
            user.setRemarks(remarks) ;
            user.setEmail(email) ;
            user.setDataMark(dataMark) ;
            
            userService.save(user) ;
            this.setMessage("新增用户" + user.getLoginName() + "成功！");
            //记录日志
            operateLogService.recordOperateLog(61,user);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //更新用户
    public String updateUser() {
        try{
            User user = userService.findUserById(memberId) ;
            
            user.setLoginName(loginName) ;
            user.setTrueName(trueName) ;
            user.setDepartment(department) ;
            user.setMobile(mobile) ;
            user.setOfficeNumber(officeNumber) ;
            user.setRemarks(remarks) ;
            user.setDataMark(dataMark) ;
            user.setEmail(email) ;
            user.setDataMark(dataMark) ;
            
            userService.update(user) ;
            
            this.setMessage("用户信息修改成功！");
            //记录日志
            operateLogService.recordOperateLog(63,user);
            
            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace() ;
            return INPUT ;
        }
    }
    
    //更新用户前操作
    public String beforeUpdateUser(){
        try{
            //通过用户ID取得相应的User对象
            User user = userService.findUserById(memberId) ;

            //取得相应的属性值，通过setter方法传到页面
            this.setLoginName(user.getLoginName()) ;
            this.setTrueName(user.getTrueName()) ;
            this.setDepartment(user.getDepartment()) ;
            this.setMobile(user.getMobile()) ;
            this.setOfficeNumber(user.getOfficeNumber()) ;
            this.setRemarks(user.getRemarks()) ;
            this.setEmail(user.getEmail()) ;
            this.setDataMark(user.getDataMark()) ;
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //为用户分配角色前的操作
    public String beforeUpdateUserRole(){
        try{
   /*         //通过用户ID查询到用户
            User user = userService.findUserById(memberId) ;
            
            this.setLoginName(user.getLoginName()) ;
            this.setTrueName(user.getTrueName()) ;
            this.setOfficeNumber(user.getOfficeNumber()) ;
            
            //通过用户的ID查询用户的角色
            List<Role> role = userRoleService.findRole(memberId) ;
            //迭代
            Iterator<Role> iter = role.iterator() ;
            List<String> rightList = new ArrayList() ;
            while(iter.hasNext()){
                Role r = iter.next() ;
                rightList.add(r.getRoleName()) ;
            }
            this.setRightList(rightList) ;
            
            //查询所有的角色
            List<Role> roleList = roleService.findAllRole() ;
            iter = roleList.iterator() ;
            while(iter.hasNext()){
                boolean flag = false ;
                Role r = iter.next() ;
                //如果rightList为空则向leftList中添加数据
                if(rightList.size()==0){
                    leftList.add(r.getRoleName()) ;
                }else{
                    Iterator<String> i = rightList.iterator() ;
                    while(i.hasNext()){
                        String str = i.next() ;
                        //如果str等于r对象的角色名，设置flag为true，继续循环，反之设置flag为false，并跳出循环
                        if(!str.equals(r.getRoleName())){
                            flag = true ;
                            continue ;
                        }else{
                            flag = false ;
                            break ;
                        }
                    }
                    //flag为true则向elftList中添加数据
                    if(flag){
                        leftList.add(r.getRoleName()) ;
                    }
                }
            }*/
            //通过用户ID查询到用户
            User user = userService.findUserById(memberId) ;
            
            this.setLoginName(user.getLoginName()) ;
            this.setTrueName(user.getTrueName()) ;
            this.setOfficeNumber(user.getOfficeNumber()) ;
            
            List<List<String>> strings = userService.beforeUpdateUserRole(memberId) ;
            
            this.setRightList(strings.get(0)) ;
            this.setLeftList(strings.get(1)) ;
            
            return SUCCESS ;
        }catch(Exception e){
            e.printStackTrace() ;
            return INPUT ;
        }
    }
    
    //删除用户
/*    public String deleteUser() {
        try{
            User user = userService.findUserById(memberId) ;
            //不作物理删除，设置标志位为-1
            user.setDataMark(-1) ;
            userService.update(user) ;
            List<UserRole> list = userRoleService.findUserRoleByMemberId(memberId) ;
            Iterator<UserRole> iter = list.iterator() ;
            while(iter.hasNext()){
                UserRole userRole = iter.next() ;
                userRoleService.delete(userRole) ;
            }
            //记录日志
            operateLogService.recordOperateLog(62,user);
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }*/
    
    //批量删除用户
    public String deleteAnyUser() {
        try{
            System.out.print(s);
            String[] string = s.substring(0, s.length()-2).split("A") ;
            for(int i=0;i<string.length;i++){
                User user = userService.findUserById(Integer.parseInt(string[i])) ;
                user.setDataMark(-1) ;
                userService.update(user) ;
                //级联删除用户角色关系表中数据
                List<UserRole> list = userRoleService.findUserRoleByMemberId(memberId) ;
                Iterator<UserRole> iter = list.iterator() ;
                while(iter.hasNext()){
                    UserRole userRole = iter.next() ;
                    userRoleService.delete(userRole) ;
                }
                //记录日志
                operateLogService.recordOperateLog(62,user);
            }
            this.setMessage("删除用户成功！");
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    //重置密码
    public String resetPassword() {
        try{
            User user = userService.findUserById(memberId) ;
            user.setPassword("123456a") ;
            userService.update(user) ;
            
            return SUCCESS ;
        }catch(Exception e){
            return INPUT ;
        }
    }
    
    //用户详情
    public String userDetail() {
         try{
             User user = userService.findUserById(memberId) ;
             
             //设置用户的各属性
             this.setLoginName(user.getLoginName()) ;
             this.setTrueName(user.getTrueName()) ;
             this.setPassword(user.getPassword()) ;
             this.setDepartment(user.getDepartment()) ;
             this.setMobile(user.getMobile()) ;
             this.setOfficeNumber(user.getOfficeNumber()) ;
             this.setLastLogin(user.getLastLogin()) ;
             this.setLastChangePwd(user.getLastChangePwd()) ;
             this.setRemarks(user.getRemarks()) ;
             this.setDataMark(user.getDataMark()) ;
             this.setEmail(user.getEmail()) ;
             
             /*//取得用户的角色
             List<Role> roleList = userRoleService.findRole(memberId) ;
             this.setRole(roleList) ;
             Iterator<Role> iter = roleList.iterator() ;
             List<Authority> authorityList = new ArrayList<Authority>() ;
             while(iter.hasNext()){
                 Role role = iter.next() ;
                 //取得用户角色对应的已授权功能
                 List<Authority> authList = roleAuthorityService.findAuthority(role.getRoleId()) ;
                 Iterator<Authority> iterator = authList.iterator() ;
                 while(iterator.hasNext()){
                     Authority authority = iterator.next() ;
                     authorityList.add(authority) ;
                 }
             }*/
             //取得用户的角色
             List<Role> roleList = userRoleService.findRole(memberId) ;
             this.setRole(roleList) ;
             //取得用户被授权的功能
//             List<Authority> authorityList = userService.userDetail(memberId) ;
//             this.setAuthority(authorityList) ;
             
             return SUCCESS ;
         }catch(Exception e){
             return INPUT ;
         }
     }
}
