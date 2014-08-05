/**
 * @(#)UserServiceImpl.java
 * 
 *                          Copyright scal.All rights reserved. This software is
 *                          the XXX system.
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

package com.scal.PIMS.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.dao.RoleAuthorityDAO;
import com.scal.PIMS.dao.RoleDAO;
import com.scal.PIMS.dao.UserDAO;
import com.scal.PIMS.dao.UserRoleDAO;
import com.scal.PIMS.dao.impl.RoleAuthorityDAOImpl;
import com.scal.PIMS.dao.impl.RoleDAOImpl;
import com.scal.PIMS.dao.impl.UserDAOImpl;
import com.scal.PIMS.dao.impl.UserRoleDAOImpl;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.User;
import com.scal.PIMS.service.UserService;
import com.scal.PIMS.util.HibernateUtil;
import com.scal.PIMS.util.UserAndRole;

/**
 * Class description goes here.
 * 
 * @author ZhouBo
 * @since 2013年12月23日
 */
public class UserServiceImpl implements UserService {
    private RoleDAO roleDao = new RoleDAOImpl();
    private UserDAO userDao = new UserDAOImpl();
    private UserRoleDAO userRoleDao = new UserRoleDAOImpl();
    private RoleAuthorityDAO roleAuthorityDao = new RoleAuthorityDAOImpl();

    /*
     * @Override public List<User> findAll() { // TODO Auto-generated method
     * stub List<User> list = userDao.findAll() ; return list ; }
     */

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        userDao.save(user);
    }

    @Override
    public List<UserAndRole> findAllUser() {
        // TODO Auto-generated method stub
        // 新建一个User对象集合接收
        List<User> userList = userDao.findAll();
        Iterator<User> iter = userList.iterator();
        List<UserAndRole> userRoleList = new ArrayList<UserAndRole>();
        while (iter.hasNext()) {
            User user = iter.next();
            UserAndRole ur = new UserAndRole();
            ur.setUser(user);
            ur.setRole(userRoleDao.findRole(user.getMemberId()));
            userRoleList.add(ur);
        }
        return userRoleList;
    }

    @Override
    public List<UserAndRole> pageList(int page) {
        // TODO Auto-generated method stub

        if (findAllUser().size() % 10 != 0
                && page == findAllUser().size() / 10 + 1) {
            List<UserAndRole> userRoleList = findAllUser().subList(
                    (page - 1) * 10, findAllUser().size());
            return userRoleList;
        } else {
            List<UserAndRole> userRoleList = findAllUser().subList(
                    (page - 1) * 10, page * 10);
            return userRoleList;
        }

    }

    @Override
    public int getPageCount() {
        return findAllUser().size() % 10 == 0 ? findAllUser().size() / 10
                : findAllUser().size() / 10 + 1;
    }

    @Override
    public List<UserAndRole> pageListByCondition(String loginName,
            String trueName, String officeNumber, int page, int flag) {
        if (page == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("lName", loginName);
            ActionContext.getContext().getSession().put("tName", trueName);
            ActionContext.getContext().getSession()
                    .put("oNumber", officeNumber);
        }
        String lName = (String) ActionContext.getContext().getSession()
                .get("lName");
        String tName = (String) ActionContext.getContext().getSession()
                .get("tName");
        String oNumber = (String) ActionContext.getContext().getSession()
                .get("oNumber");
        int sumSize = findUserByCondition(lName, tName, oNumber).size();
        if (sumSize % 10 != 0 && page == sumSize / 10 + 1) {
            List<UserAndRole> userRoleList = findUserByCondition(lName, tName,
                    oNumber).subList((page - 1) * 10, sumSize);
            return userRoleList;
        } else {
            List<UserAndRole> userRoleList = findUserByCondition(lName, tName,
                    oNumber).subList((page - 1) * 10, page * 10);
            return userRoleList;
        }

    }

    @Override
    public int getPageCountByCondition(String loginName, String trueName,
            String officeNumber, int page, int flag) {
        if (page == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("lName", loginName);
            ActionContext.getContext().getSession().put("tName", trueName);
            ActionContext.getContext().getSession()
                    .put("oNumber", officeNumber);
        }
        String lName = (String) ActionContext.getContext().getSession()
                .get("lName");
        String tName = (String) ActionContext.getContext().getSession()
                .get("tName");
        String oNumber = (String) ActionContext.getContext().getSession()
                .get("oNumber");
        int sumSize = findUserByCondition(lName, tName, oNumber).size();
        return sumSize % 10 == 0 ? sumSize / 10 : sumSize / 10 + 1;
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        userDao.update(user);
    }

    @Override
    public User findUserById(int memberId) {
        // TODO Auto-generated method stub
        User user = userDao.findUserById(memberId);
        return user;
    }

    @Override
    public List<UserAndRole> findUserByCondition(String loginName,
            String trueName, String officeNumber) {
        // TODO Auto-generated method stub
        // 生命一个User对象集合保存按条件查询到的用户
        List<User> userList = userDao.findUserByCondition(loginName, trueName,
                officeNumber);
        // 迭代User对象集合
        Iterator<User> iter = userList.iterator();
        List<UserAndRole> userRoleList = new ArrayList<UserAndRole>();
        while (iter.hasNext()) {
            User user = iter.next();
            UserAndRole ur = new UserAndRole();
            ur.setUser(user);
            ur.setRole(userRoleDao.findRole(user.getMemberId()));
            userRoleList.add(ur);
        }
        return userRoleList;
    }

    @Override
    public List<List<String>> beforeUpdateUserRole(int memberId) {
        // TODO Auto-generated method stub
        List<List<String>> strings = new ArrayList<List<String>>();
        // 通过用户的ID查询用户的角色
        List<Role> role = userRoleDao.findRole(memberId);
        // 迭代
        Iterator<Role> iter = role.iterator();
        List<String> rightList = new ArrayList<String>();
        while (iter.hasNext()) {
            Role r = iter.next();
            rightList.add(r.getRoleName());
        }
        strings.add(rightList);
        // 查询所有的角色
        List<Role> roleList = roleDao.findAll();
        iter = roleList.iterator();
        List<String> leftList = new ArrayList();
        while (iter.hasNext()) {
            boolean flag = false;
            Role r = iter.next();
            // 如果rightList为空则向leftList中添加数据
            if (rightList.size() == 0) {
                leftList.add(r.getRoleName());
            } else {
                Iterator<String> i = rightList.iterator();
                while (i.hasNext()) {
                    String str = i.next();
                    // 如果str等于r对象的角色名，设置flag为true，继续循环，反之设置flag为false，并跳出循环
                    if (!str.equals(r.getRoleName())) {
                        flag = true;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                // flag为true则向elftList中添加数据
                if (flag) {
                    leftList.add(r.getRoleName());
                }
            }
        }
        strings.add(leftList);
        return strings;
    }

    /*
     * @Override //用户详情中取得用户被授权的功能 public List<Authority> userDetail(int
     * memberId) { // TODO Auto-generated method stub List<Role> roleList =
     * userRoleDao.findRole(memberId) ; Iterator<Role> iter =
     * roleList.iterator() ; List<Authority> authorityList = new
     * ArrayList<Authority>() ; while(iter.hasNext()){ Role role = iter.next() ;
     * //取得用户角色对应的已授权功能 List<Authority> authList =
     * roleAuthorityDao.findAuthority(role.getRoleId()) ; Iterator<Authority>
     * iterator = authList.iterator() ; while(iterator.hasNext()){ Authority
     * authority = iterator.next() ; authorityList.add(authority) ; } } return
     * authorityList ; }
     */

    @Override
    public User findUserByLoginName(String loginName) {
        // TODO Auto-generated method stub
        User user = userDao.findUserByLoginName(loginName);
        return user;
    }

    /*
     * @Override public List<UserAndRole> pageList(int currPage) { Session
     * session = HibernateUtil.getSessionFactory().getCurrentSession();
     * session.beginTransaction(); String hql =
     * "from User where dataMark='1' or dataMark='0'"; List<User> list =
     * session.createQuery(hql).list(); Iterator<User> iterator =
     * list.iterator(); List<UserAndRole> userRoleList = new
     * ArrayList<UserAndRole>() ; while (iterator.hasNext()) { User user =
     * iterator.next(); UserAndRole ur = new UserAndRole() ; ur.setUser(user);
     * String hql1 = "from UserRole where memberId = '" + user.getMemberId() +
     * "'" ; List<Role> list1 = session.createQuery(hql1).list() ;
     * ur.setRole(list1); userRoleList.add(ur) ; }
     * 
     * 
     * List list = pagingDAO.pageList(currPage, hql); return list; }
     */

}
