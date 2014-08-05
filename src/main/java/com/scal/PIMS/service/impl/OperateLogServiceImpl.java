/**
 * @(#)OperateLogServiceImpl.java
 * 
 *                                Copyright scal.All rights reserved. This
 *                                software is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月2日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.common.Tools;
import com.scal.PIMS.dao.OperateLogDAO;
import com.scal.PIMS.dao.PagingDAO;
import com.scal.PIMS.dao.impl.OperateLogDAOImpl;
import com.scal.PIMS.dao.impl.PagingDAOImpl;
import com.scal.PIMS.model.Authority;
import com.scal.PIMS.model.BudgetSystem;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.OperateLog;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.model.Role;
import com.scal.PIMS.model.RoleAuthority;
import com.scal.PIMS.model.User;
import com.scal.PIMS.model.UserRole;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.UserService;
import com.scal.PIMS.util.HibernateUtil;
import com.sun.tools.internal.ws.processor.model.Request;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2014年1月2日
 */
public class OperateLogServiceImpl implements OperateLogService {
    private String add = "新增";
    private String edit = "修改";
    private String delete = "删除";
    Tools tools = new Tools();
    PagingDAO pagingDAO = new PagingDAOImpl();
    OperateLogDAO operateLogDAO = new OperateLogDAOImpl();

    @Override
    public void save(OperateLog operateLog) {
        operateLogDAO.save(operateLog);
    }

    @Override
    public void operate(String loginName, String trueName, String operateType,
            int type, String moduleName, String tableName, String operateInfo) {
        OperateLog operateLog = new OperateLog();
        Tools tools = new Tools();
        Date date = new Date();
        operateLog.setModuleName(moduleName);
        operateLog.setKeyWord("[" + tableName + "]" + operateType + ""
                + operateLog.getModuleName() + "");
        operateLog.setOperateType(type);
        operateLog.setOperateInfo("【" + operateType + ""
                + operateLog.getModuleName() + "：" + operateInfo + "】");
        operateLog.setLoginName(loginName);
        operateLog.setTrueName(trueName);
        operateLog.setOperateTime(date);
        operateLog.setIpAddress(tools.getUserIp());
        operateLog.setDataMark(1);
        save(operateLog);
    }

    @Override
    public void recordOperateLog(int flag, Object object) {
        ProjectInfo exProjectInfo = null;
        ProjectSystem exProjectSystem = null;
        ProjectProgress exProjectProgress = null;
        ProjectBudget exProjectBudget = null;
        Contract exContract = null;
        User exUser = null;
        Role exRole = null;
        Authority exAuthority = null;
        BudgetSystem exBudgetSystem = null;
        UserRole exUserRole = null;
        RoleAuthority exRoleAuthority = null;
        String operateInfo = null;
        String loginName = (String) ActionContext.getContext().getSession()
                .get("loginName");
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByLoginName(loginName);
        String trueName = user.getTrueName();

        switch (flag) {
        case 11:
            exProjectInfo = (ProjectInfo) object;
            operate(loginName, trueName, add, 1, "基本信息", "t_projectgeneral",
                    exProjectInfo.getProjectName());
            break;
        case 12:
            exProjectInfo = (ProjectInfo) object;
            operate(loginName, trueName, delete, 2, "基本信息", "t_projectgeneral",
                    exProjectInfo.getProjectName());
            break;
        case 13:
            exProjectInfo = (ProjectInfo) object;
            String budgetApplyTime = "";
            String budgetApprovalTime = "";
            if (exProjectInfo.getBudgetApplyTime() != null) {
                budgetApplyTime = tools.dateFormat(exProjectInfo
                        .getBudgetApplyTime());
            } else if (exProjectInfo.getBudgetApprovalTime() != null) {
                budgetApprovalTime = tools.dateFormat(exProjectInfo
                        .getBudgetApprovalTime());
            }
            operateInfo = "[编号：" + exProjectInfo.getId() + "][项目名称："
                    + exProjectInfo.getProjectName() + "][平台："
                    + exProjectInfo.getProjectPlatform() + "][类别："
                    + exProjectInfo.getProjectType() + "][项目状态："
                    + exProjectInfo.getProjectStatus() + "][预算申报时间："
                    + budgetApplyTime + "][预算批准时间：" + budgetApprovalTime
                    + "][优先级：" + exProjectInfo.getPriority() + "][是否计划外项目："
                    + exProjectInfo.getScheduledPlan() + "][开发类别："
                    + exProjectInfo.getDevelopType() + "][申报部门："
                    + exProjectInfo.getApplyDepartment() + "][分管领导："
                    + exProjectInfo.getResponsibilityLeader() + "][责任科室："
                    + exProjectInfo.getResponsibilityDep() + "]";
            operate(loginName, trueName, edit, 3, "基本信息", "t_projectgeneral",
                    operateInfo);
            break;
        case 21:
            exProjectSystem = (ProjectSystem) object;
            operate(loginName, trueName, add, 1, "子系统", "t_projectsysteminfo",
                    exProjectSystem.getSystemName());

            break;
        case 22:
            exProjectSystem = (ProjectSystem) object;
            operate(loginName, trueName, delete, 2, "子系统",
                    "t_projectsysteminfo", exProjectSystem.getSystemName());

            break;
        case 23:
            exProjectSystem = (ProjectSystem) object;
            String handoverTime = "";
            if (exProjectSystem.getHandoverTime() != null) {
                handoverTime = tools.dateFormat(exProjectSystem
                        .getHandoverTime());
            }
            operateInfo = "[编号：" + exProjectSystem.getId() + "][子系统名："
                    + exProjectSystem.getSystemName() + "][类别："
                    + exProjectSystem.getSystemType() + "][平台："
                    + exProjectSystem.getSystemPlatform() + "][性质："
                    + exProjectSystem.getSystemDevelopType() + "][总投资额："
                    + exProjectSystem.getSystemTotalInvest() + "][结转："
                    + exProjectSystem.getSystemCarryOver() + "][新增投资额："
                    + exProjectSystem.getSystemNewlyInvest() + "][验收评委："
                    + exProjectSystem.getAcceptors() + "][项目组人员："
                    + exProjectSystem.getTeamMember() + "][运维交接时间："
                    + handoverTime + "][使用部门："
                    + exProjectSystem.getUserDepartment() + "]";
            operate(loginName, trueName, edit, 3, "子系统", "t_projectsysteminfo",
                    operateInfo);

            break;

        case 31:
            exProjectProgress = (ProjectProgress) object;
            operate(loginName, trueName, add, 1, "进度信息", "t_projectprogress",
                    "" + exProjectProgress.getId() + "");
            break;
        case 32:
            exProjectProgress = (ProjectProgress) object;
            operate(loginName, trueName, delete, 2, "进度信息",
                    "t_projectprogress", "" + exProjectProgress.getId() + "");
            break;
        case 33:
            exProjectProgress = (ProjectProgress) object;
            String planStartTime = "";
            String planEndTime = "";
            String startTime = "";
            String endTime = "";
            if (exProjectProgress.getPlanStartTime() != null) {
                planStartTime = tools.dateFormat(exProjectProgress
                        .getPlanStartTime());
            } else if (exProjectProgress.getPlanEndTime() != null) {
                planEndTime = tools.dateFormat(exProjectProgress
                        .getPlanEndTime());
            } else if (exProjectProgress.getStartTime() != null) {
                startTime = tools.dateFormat(exProjectProgress.getStartTime());
            } else if (exProjectProgress.getEndTime() != null) {
                endTime = tools.dateFormat(exProjectProgress.getEndTime());
            }
            operateInfo = "[编号：" + exProjectProgress.getId() + "][项目进度："
                    + exProjectProgress.getProgressType() + "][状态："
                    + exProjectProgress.getStatus() + "][计划启动时间："
                    + planStartTime + "][计划完成时间：" + planEndTime + "][实际启动时间："
                    + startTime + "][实际完成时间：" + endTime + "][是否延误："
                    + exProjectProgress.getIsDelay() + "][延误时间："
                    + exProjectProgress.getDelayTime() + "]";
            operate(loginName, trueName, edit, 3, "进度信息", "t_projectprogress",
                    operateInfo);
            break;
        case 41:
            exProjectBudget = (ProjectBudget) object;
            operate(loginName, trueName, add, 1, "预算信息", "t_projectbudget", ""
                    + exProjectBudget.getId() + "");
            break;
        case 42:
            exProjectBudget = (ProjectBudget) object;
            operate(loginName, trueName, delete, 2, "预算信息", "t_projectbudget",
                    "" + exProjectBudget.getId() + "");
            break;
        case 43:
            exProjectBudget = (ProjectBudget) object;
            operateInfo = "[编号：" + exProjectBudget.getId() + "][项目申报年份："
                    + exProjectBudget.getYear() + "][性质："
                    + exProjectBudget.getType() + "][总投资额："
                    + exProjectBudget.getTotalInvestment1() + "][结转："
                    + exProjectBudget.getCarryOver() + "][新增投资额："
                    + exProjectBudget.getNewlyInvestment() + "][总投资："
                    + exProjectBudget.getTotalInvestment2() + "][上传路径："
                    + exProjectBudget.getExcelPath() + "][上传结果："
                    + exProjectBudget.getResult() + "]";
            operate(loginName, trueName, edit, 3, "预算信息", "t_projectbudget",
                    operateInfo);
            break;
        case 51:
            exContract = (Contract) object;
            operate(loginName, trueName, add, 1, "合同信息", "t_projectcontract",
                    exContract.getContractName());
            break;
        case 52:
            exContract = (Contract) object;
            operate(loginName, trueName, delete, 2, "合同信息",
                    "t_projectcontract", exContract.getContractName());
            break;
        case 53:
            exContract = (Contract) object;
            String s = "";
            if (exContract.getContractTime() != null) {
                s = tools.dateFormat(exContract.getContractTime());
            }
            operateInfo = "[编号：" + exContract.getId() + "][合同名称："
                    + exContract.getContractName() + "][合同类型："
                    + exContract.getContractType() + "][合同金额："
                    + exContract.getContractAmount() + "][签订时间：" + s + "]";
            operate(loginName, trueName, edit, 3, "合同信息", "t_projectcontract",
                    operateInfo);
            break;
        case 61:
            exUser = (User) object;
            operate(loginName, trueName, add, 1, "用户管理", "t_userinfo",
                    exUser.getLoginName());
            break;
        case 62:
            exUser = (User) object;
            operateInfo = "[编号：" + exUser.getMemberId() + "][登录名："
                    + exUser.getLoginName() + "]";
            operate(loginName, trueName, delete, 2, "用户管理", "t_userinfo",
                    operateInfo);
            break;
        case 63:
            exUser = (User) object;
            operateInfo = "[编号：" + exUser.getMemberId() + "][登录名："
                    + exUser.getLoginName() + "][真实姓名：" + exUser.getTrueName()
                    + "][部门：" + exUser.getDepartment() + "][手机："
                    + exUser.getMobile() + "][座机：" + exUser.getOfficeNumber()
                    + "][邮箱：" + exUser.getEmail() + "]";
            operate(loginName, trueName, edit, 3, "用户管理", "t_userinfo",
                    operateInfo);
            break;
        case 71:
            exRole = (Role) object;
            operate(loginName, trueName, add, 1, "角色维护", "t_roleinfo",
                    exRole.getRoleName());
            break;
        case 72:
            exRole = (Role) object;
            operateInfo = "[编号：" + exRole.getRoleId() + "][角色名称："
                    + exRole.getRoleName() + "]";
            operate(loginName, trueName, delete, 2, "角色维护", "t_roleinfo",
                    exRole.getRoleName());
            break;
        case 73:
            exRole = (Role) object;
            operateInfo = "[编号：" + exRole.getRoleId() + "][角色名称："
                    + exRole.getRoleName() + "]";
            operate(loginName, trueName, edit, 3, "角色维护", "t_roleinfo",
                    operateInfo);
            break;
        case 81:
            exAuthority = (Authority) object;
            operate(loginName, trueName, add, 1, "功能维护", "t_authority",
                    exAuthority.getAuthorityName());
            break;
        case 82:
            exAuthority = (Authority) object;
            operateInfo = "[编号：" + exAuthority.getAuthorityId() + "][功能名称："
                    + exAuthority.getAuthorityName() + "]";
            operate(loginName, trueName, delete, 2, "功能维护", "t_authority",
                    exAuthority.getAuthorityName());
            break;
        case 83:
            exAuthority = (Authority) object;
            operateInfo = "[编号：" + exAuthority.getAuthorityId() + "][功能名称："
                    + exAuthority.getAuthorityName() + "]";
            operate(loginName, trueName, edit, 3, "功能维护", "t_authority",
                    operateInfo);
            break;
        case 91:
            exUserRole = (UserRole) object;
            operateInfo = "[用户编号：" + exUserRole.getMemberId() + "][角色编号："
                    + exUserRole.getRoleId() + "]关系";
            operate(loginName, trueName, add, 1, "用户角色关系",
                    "t_userrolerelationship", operateInfo);
            break;
        case 92:
            exUserRole = (UserRole) object;
            operateInfo = "[用户编号：" + exUserRole.getMemberId() + "][角色编号："
                    + exUserRole.getRoleId() + "]关系";
            operate(loginName, trueName, delete, 2, "用户角色关系",
                    "t_userrolerelationship", operateInfo);
            break;
        case 93:
            exRoleAuthority = (RoleAuthority) object;
            operateInfo = "[角色编号：" + exRoleAuthority.getRoleId() + "][功能编号："
                    + exRoleAuthority.getAuthorityId() + "]关系";
            operate(loginName, trueName, add, 1, "角色功能关系",
                    "t_roleauthorityrelationship", operateInfo);
            break;
        case 94:
            exRoleAuthority = (RoleAuthority) object;
            operateInfo = "[角色编号：" + exRoleAuthority.getRoleId() + "][功能编号："
                    + exRoleAuthority.getAuthorityId() + "]关系";
            operate(loginName, trueName, delete, 2, "角色功能关系",
                    "t_roleauthorityrelationship", operateInfo);
            break;
        case 95:
            exBudgetSystem = (BudgetSystem) object;
            operateInfo = "[预算编号：" + exBudgetSystem.getBudgetId() + "][子系统编号："
                    + exBudgetSystem.getSystemId() + "]关系";
            operate(loginName, trueName, add, 1, "预算子系统关系",
                    "t_budgetsystemrelationship", operateInfo);
            break;
        case 96:
            exBudgetSystem = (BudgetSystem) object;
            operateInfo = "[预算编号：" + exBudgetSystem.getBudgetId() + "][子系统编号："
                    + exBudgetSystem.getSystemId() + "]关系";
            operate(loginName, trueName, delete, 2, "预算子系统关系",
                    "t_budgetsystemrelationship", operateInfo);
            break;
        default:
            break;
        }

    }

    @Override
    public List<OperateLog> findAll() {
        List<OperateLog> list = operateLogDAO.findAll();
        return list;
    }

    @Override
    public int getConditionPageCount(String trueName, String moduleName,
            int operateType, String keyWord, Date startTime, Date endTime,
            String ipAddress, int currPage, int flag) {
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("tName", trueName);
            ActionContext.getContext().getSession().put("mName", moduleName);
            ActionContext.getContext().getSession().put("oType", operateType);
            ActionContext.getContext().getSession().put("kWord", keyWord);
            ActionContext.getContext().getSession().put("sTime", startTime);
            ActionContext.getContext().getSession().put("eTime", endTime);
            ActionContext.getContext().getSession().put("ip", ipAddress);
        }

        String tName = (String) ActionContext.getContext().getSession()
                .get("tName");
        String mName = (String) ActionContext.getContext().getSession()
                .get("mName");
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("oType");
        int oType = integer.intValue();
        String kWord = (String) ActionContext.getContext().getSession()
                .get("kWord");
        Date sTime = (Date) ActionContext.getContext().getSession()
                .get("sTime");
        Date eTime = (Date) ActionContext.getContext().getSession()
                .get("eTime");
        String ip = (String) ActionContext.getContext().getSession().get("ip");
        List<OperateLog> list = operateLogDAO.searchByCondition(tName, mName,
                oType, kWord, sTime, eTime, ip);
        return list.size() % 10 == 0 ? list.size() / 10 : list.size() / 10 + 1;
    }

    /*
     * @Override public List<OperateLog> searchByCondition(String trueName,
     * String moduleName, int operateType, String keyWord, Date startTime, Date
     * endTime, String ipAddress, int currPage, int flag) { OperateLogDAO
     * operateLogDAO = new OperateLogDAOImpl(); if (currPage == 1 && flag == 1)
     * { ActionContext.getContext().getSession().put("tName", trueName);
     * ActionContext.getContext().getSession().put("mName", moduleName);
     * ActionContext.getContext().getSession().put("oType", operateType);
     * ActionContext.getContext().getSession().put("kWord", keyWord);
     * ActionContext.getContext().getSession().put("sTime", startTime);
     * ActionContext.getContext().getSession().put("eTime", endTime);
     * ActionContext.getContext().getSession().put("ip", ipAddress); }
     * 
     * String tName = (String) ActionContext.getContext().getSession()
     * .get("tName"); String mName = (String)
     * ActionContext.getContext().getSession() .get("mName"); Integer integer =
     * (Integer) ActionContext.getContext().getSession() .get("oType"); int
     * oType = integer.intValue(); // int oType =
     * Integer.parseInt(ActionContext.getContext() //
     * .getSession().get("oType")); String kWord = (String)
     * ActionContext.getContext().getSession() .get("kWord"); Date sTime =
     * (Date) ActionContext.getContext().getSession() .get("sTime"); Date eTime
     * = (Date) ActionContext.getContext().getSession() .get("eTime"); String ip
     * = (String) ActionContext.getContext().getSession().get("ip");
     * List<OperateLog> list = operateLogDAO.searchByCondition(tName, mName,
     * oType, kWord, sTime, eTime, ip); return list; }
     */

    @Override
    public List<OperateLog> searchByConditionPage(String trueName,
            String moduleName, int operateType, String keyWord, Date startTime,
            Date endTime, String ipAddress, int currPage, int flag) {
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("tName", trueName);
            ActionContext.getContext().getSession().put("mName", moduleName);
            ActionContext.getContext().getSession().put("oType", operateType);
            ActionContext.getContext().getSession().put("kWord", keyWord);
            ActionContext.getContext().getSession().put("sTime", startTime);
            ActionContext.getContext().getSession().put("eTime", endTime);
            ActionContext.getContext().getSession().put("ip", ipAddress);

        }
        String tName = (String) ActionContext.getContext().getSession()
                .get("tName");
        String mName = (String) ActionContext.getContext().getSession()
                .get("mName");
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("oType");
        int oType = integer.intValue();
        // int oType = Integer.parseInt(ActionContext.getContext()
        // .getSession().get("oType"));
        String kWord = (String) ActionContext.getContext().getSession()
                .get("kWord");
        Date sTime = (Date) ActionContext.getContext().getSession()
                .get("sTime");
        Date eTime = (Date) ActionContext.getContext().getSession()
                .get("eTime");
        String ip = (String) ActionContext.getContext().getSession().get("ip");
        List<OperateLog> list = operateLogDAO.searchByConditionPage(tName,
                mName, oType, kWord, sTime, eTime, ip, currPage);
        return list;
    }

    @Override
    public List pageList(int currPage) {
        String hql = "from OperateLog where dataMark='1' order by operateTime desc";
        List list = pagingDAO.pageList(currPage, hql);
        return list;
    }

    @Override
    public int getPageCount() {
        String hql = "from OperateLog where dataMark='1' ";
        int count = pagingDAO.getPageCount(hql);
        return count;
    }

    @Override
    public List<OperateLog> detail(int id) {
        List<OperateLog> list = operateLogDAO.detail(id);
        return list;
    }
}
