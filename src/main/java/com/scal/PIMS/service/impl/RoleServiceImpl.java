/**
 * @(#)RoleServiceImpl.java
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
 *  1     2013年12月25日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scal.PIMS.dao.RoleDAO;
import com.scal.PIMS.dao.impl.RoleDAOImpl;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.service.AuthorityService;
import com.scal.PIMS.service.RoleAuthorityService;
import com.scal.PIMS.service.RoleService;
import com.scal.PIMS.util.RoleAndAuthority;

/**
 * Class description goes here.
 *
 * @author ZhouBo
 * @since 2013年12月25日
 */
public class RoleServiceImpl implements RoleService {
    
    private RoleDAO roleDao = new RoleDAOImpl() ;
    private AuthorityService authorityService = new AuthorityServiceImpl() ;
    private RoleAuthorityService roleAuthorityService = new RoleAuthorityServiceImpl() ;
    
    @Override
    public List<RoleAndAuthority> findAll() {
        // TODO Auto-generated method stub     
        //取得所有的角色，保存在一个角色对象的集合中
        List<Role> roleList = roleDao.findAll() ;
        //通过Iterator迭代
        Iterator<Role> iter = roleList.iterator() ;
        //新建一个角色和功能的对象集合
        List<RoleAndAuthority> roleAuthorityList = new ArrayList<RoleAndAuthority>() ;
        while(iter.hasNext()){
            Role role = iter.next() ;
            //新建一个角色和功能对象
            RoleAndAuthority ra = new RoleAndAuthority() ;
            ra.setAuthority(roleAuthorityService.findAuthority(role.getRoleId())) ;
            ra.setRole(role) ;
            //加入到集合中
            roleAuthorityList.add(ra) ;
        }
        
        return roleAuthorityList ;
    }

/*    @Override
    public List<Role> findAllRole() {
        // TODO Auto-generated method stub
        List<Role> list = roleDao.findAll() ;
        return list ;
    }*/

    @Override
    public List<List<String>> beforeUpdateRoleAuthority(int roleId) {
        // TODO Auto-generated method stub
        List<List<String>> strings = new ArrayList<List<String>>() ;
        
        //通过角色ID查询功能，并新建一个功能对象集合保存
        List<Authority> auth = roleAuthorityService.findAuthority(roleId) ;
        //通过Iterator迭代
        Iterator<Authority> iterator = auth.iterator() ;
        List<String> rightList = new ArrayList<String>() ;
        while(iterator.hasNext()){
            //新建一个Authority对象保存
            Authority au = iterator.next() ;
            //添加到rightList中
            rightList.add(au.getAuthorityName()) ;
        }
        strings.add(rightList) ;
      //查询所有的功能
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
        }
        strings.add(leftList) ;
        return strings ;
    }

    @Override
    public void save(Role role) {
        // TODO Auto-generated method stub
        roleDao.save(role) ;
    }

    @Override
    public void update(Role role) {
        // TODO Auto-generated method stub
        roleDao.update(role) ;
    }

    @Override
    public Role findRoleById(int roleId) {
        // TODO Auto-generated method stub
        Role role = roleDao.findRoleById(roleId) ;
        return role ;
    }

    @Override
    public Role findRoleByName(String roleName) {
        // TODO Auto-generated method stub
        Role role = roleDao.findRoleByName(roleName) ;
        return role ;
    }

}
