/**
 * @(#)ProjectSystemAction.java
 * 
 *                              Copyright scal.All rights reserved. This
 *                              software is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月27日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.BudgetSystem;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.service.BudgetSystemService;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.ProjectSystemService;
import com.scal.PIMS.service.impl.BudgetSystemServiceImpl;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.ProjectSystemServiceImpl;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2013年12月27日
 */
public class ProjectSystemAction extends ActionSupport {
    private int id;
    private int projectId;
    private int budgetId;
    // 对应systemType
    private int projectType;
    // 对应systemPlatform
    private int projectPlatform;
    // 对应systemDevelopType
    private int developType;
    // 分页参数
    private int page;
    private int flag;
    private int totalPage;
    private String projectName;
    private String s;
    private String acceptors;
    private String systemName;
    private int systemType;
    private double systemCarryOver;
    private double systemTotalInvest;
    private double systemNewlyInvest;
    private int systemPlatform;
    private int systemDevelopType;
    private String teamMember;
    private String applyDepartment;
    private Date handoverTime;
    private String userDepartment;
    private String description;
    private String remark;
    private List<ProjectSystem> list;

    private ProjectSystemService projectSystemService = new ProjectSystemServiceImpl();
    BudgetSystemService budgetSystemService = new BudgetSystemServiceImpl();
    OperateLogService operateLogService = new OperateLogServiceImpl();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    public int getProjectPlatform() {
        return projectPlatform;
    }

    public void setProjectPlatform(int projectPlatform) {
        this.projectPlatform = projectPlatform;
    }

    public int getDevelopType() {
        return developType;
    }

    public void setDevelopType(int developType) {
        this.developType = developType;
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

    public String getProjectName() throws UnsupportedEncodingException {
        return new String(projectName.getBytes("ISO-8859-1"), "UTF-8");
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getAcceptors() {
        return acceptors;
    }

    public void setAcceptors(String acceptors) {
        this.acceptors = acceptors;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public int getSystemType() {
        return systemType;
    }

    public void setSystemType(int systemType) {
        this.systemType = systemType;
    }

    public double getSystemCarryOver() {
        return systemCarryOver;
    }

    public void setSystemCarryOver(double systemCarryOver) {
        this.systemCarryOver = systemCarryOver;
    }

    public double getSystemTotalInvest() {
        return systemTotalInvest;
    }

    public void setSystemTotalInvest(double systemTotalInvest) {
        this.systemTotalInvest = systemTotalInvest;
    }

    public double getSystemNewlyInvest() {
        return systemNewlyInvest;
    }

    public void setSystemNewlyInvest(double systemNewlyInvest) {
        this.systemNewlyInvest = systemNewlyInvest;
    }

    public int getSystemPlatform() {
        return systemPlatform;
    }

    public void setSystemPlatform(int systemPlatform) {
        this.systemPlatform = systemPlatform;
    }

    public int getSystemDevelopType() {
        return systemDevelopType;
    }

    public void setSystemDevelopType(int systemDevelopType) {
        this.systemDevelopType = systemDevelopType;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }

    public Date getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(Date handoverTime) {
        this.handoverTime = handoverTime;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ProjectSystem> getList() {
        return list;
    }

    public void setList(List<ProjectSystem> list) {
        this.list = list;
    }

    public String addProjectSystem() {
        try {
            Integer pId = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            Integer pType = (Integer) ActionContext.getContext().getSession()
                    .get("pType");
            Integer pPlatform = (Integer) ActionContext.getContext()
                    .getSession().get("pPlatform");
            Integer dType = (Integer) ActionContext.getContext().getSession()
                    .get("dType");
            String pName = (String) ActionContext.getContext().getSession()
                    .get("pName");
            this.setProjectId(pId.intValue());
            this.setProjectType(pType.intValue());
            this.setProjectPlatform(pPlatform.intValue());
            this.setDevelopType(dType.intValue());
            this.setProjectName(pName);
            // 添加子系统信息
            ProjectSystem projectSystem = new ProjectSystem();
            projectSystem.setProjectId(projectId);
            projectSystem.setAcceptors(acceptors);
            projectSystem.setSystemName(systemName);
            projectSystem.setSystemType(projectType);
            projectSystem.setSystemTotalInvest(systemTotalInvest);
            projectSystem.setSystemCarryOver(systemCarryOver);
            projectSystem.setSystemNewlyInvest(systemNewlyInvest);
            projectSystem.setSystemPlatform(projectPlatform);
            projectSystem.setSystemDevelopType(developType);
            projectSystem.setTeamMember(teamMember);
            // projectSystem.setApplyDepartment(applyDepartment);
            projectSystem.setHandoverTime(handoverTime);
            projectSystem.setUserDepartment(userDepartment);
            projectSystem.setDescription(description);
            projectSystem.setRemark(remark);
            projectSystem.setDataMark(1);
            projectSystemService.save(projectSystem);

            // 添加预算和子系统关系映射
            BudgetSystem budgetSystem = new BudgetSystem();
            BudgetSystemService budgetSystemService = new BudgetSystemServiceImpl();
            int budgetId = budgetSystemService.getBudgetId(projectId).getId();
            int systemId = budgetSystemService.getSystemId(projectId).getId();
            budgetSystem.setSystemId(systemId);
            budgetSystem.setBudgetId(budgetId);
            budgetSystemService.saveRelationship(budgetSystem);

            // 记录操作日志
            operateLogService.recordOperateLog(21, projectSystem);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String beforeAdd() {
        try {
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }

    }

    public String beforeEdit() {
        try {

            ProjectSystem projectSystem = projectSystemService.getById(id);
            this.setAcceptors(projectSystem.getAcceptors());
            this.setSystemName(projectSystem.getSystemName());
            this.setSystemType(projectSystem.getSystemType());
            this.setSystemTotalInvest(projectSystem.getSystemTotalInvest());
            this.setSystemCarryOver(projectSystem.getSystemCarryOver());
            this.setSystemNewlyInvest(projectSystem.getSystemNewlyInvest());
            this.setSystemPlatform(projectSystem.getSystemPlatform());
            this.setSystemDevelopType(projectSystem.getSystemDevelopType());
            this.setTeamMember(projectSystem.getTeamMember());
            // this.setApplyDepartment(projectSystem.getApplyDepartment());
            this.setHandoverTime(projectSystem.getHandoverTime());
            this.setUserDepartment(projectSystem.getUserDepartment());
            this.setDescription(projectSystem.getDescription());
            this.setRemark(projectSystem.getRemark());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }

    }

    public String editProjectSystem() {
        try {
            Integer pId = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            Integer pType = (Integer) ActionContext.getContext().getSession()
                    .get("pType");
            Integer pPlatform = (Integer) ActionContext.getContext()
                    .getSession().get("pPlatform");
            Integer dType = (Integer) ActionContext.getContext().getSession()
                    .get("dType");
            String pName = (String) ActionContext.getContext().getSession()
                    .get("pName");
            this.setProjectId(pId.intValue());
            this.setProjectType(pType.intValue());
            this.setProjectPlatform(pPlatform.intValue());
            this.setDevelopType(dType.intValue());
            this.setProjectName(pName);
            ProjectSystem projectSystem = projectSystemService.getById(id);
            ProjectSystem exProjectSystem = (ProjectSystem) projectSystem
                    .clone();
            this.projectId = projectSystem.getProjectId();
            // String exAcceptors = projectSystem.getAcceptors();
            // String exSystemName = projectSystem.getSystemName();
            // int exSystemType=projectSystem.getSystemType();
            // int exSystemPlatform=projectSystem.getSystemPlatform();
            // String exTeamMember = projectSystem.getTeamMember();
            // Date exHandoverTime = projectSystem.getHandoverTime();
            // String exUserDepartment = projectSystem.getUserDepartment();
            // Double exToltalInvest = projectSystem.getSystemTotalInvest();
            // Double exCarryOver = projectSystem.getSystemCarryOver();
            // Double exNewlyInvest = projectSystem.getSystemNewlyInvest();
            projectSystem.setAcceptors(acceptors);
            projectSystem.setSystemName(systemName);
            projectSystem.setSystemType(systemType);
            projectSystem.setSystemTotalInvest(systemTotalInvest);
            projectSystem.setSystemCarryOver(systemCarryOver);
            projectSystem.setSystemNewlyInvest(systemNewlyInvest);
            projectSystem.setSystemPlatform(systemPlatform);
            projectSystem.setSystemDevelopType(systemDevelopType);
            projectSystem.setTeamMember(teamMember);
            // projectSystem.setApplyDepartment(applyDepartment);
            projectSystem.setHandoverTime(handoverTime);
            projectSystem.setUserDepartment(userDepartment);
            projectSystem.setDescription(description);
            projectSystem.setRemark(remark);
            projectSystemService.update(projectSystem);
            // 记录操作日志
            operateLogService.recordOperateLog(23, exProjectSystem);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String editSystemBudget() {
        try {
            Integer bId = (Integer) ActionContext.getContext().getSession()
                    .get("bId");
            String pName = (String) ActionContext.getContext().getSession()
                    .get("pName");
            this.setBudgetId(bId.intValue());
            this.setProjectName(pName);
            this.setPage(getPage());
            ProjectSystem projectSystem = projectSystemService.getById(id);
            ProjectSystem exProjectSystem = (ProjectSystem) projectSystem
                    .clone();
            // Double exToltalInvest = projectSystem.getSystemTotalInvest();
            // Double exCarryOver = projectSystem.getSystemCarryOver();
            // Double exNewlyInvest = projectSystem.getSystemNewlyInvest();
            projectSystem.setSystemTotalInvest(systemTotalInvest);
            projectSystem.setSystemCarryOver(systemCarryOver);
            projectSystem.setSystemNewlyInvest(systemNewlyInvest);
            projectSystemService.update(projectSystem);
            // 记录操作日志
            operateLogService.recordOperateLog(23, exProjectSystem);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String findAllProjectSystem() {
        try {
            // 分页
            if (page == 1 && flag == 1) {
                ActionContext.getContext().getSession().put("pId", projectId);
                ActionContext.getContext().getSession()
                        .put("pType", projectType);
                ActionContext.getContext().getSession()
                        .put("pPlatform", projectPlatform);
                ActionContext.getContext().getSession()
                        .put("dType", developType);
                ActionContext.getContext().getSession()
                        .put("pName", projectName);
            }
            Integer pId = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            Integer pType = (Integer) ActionContext.getContext().getSession()
                    .get("pType");
            Integer pPlatform = (Integer) ActionContext.getContext()
                    .getSession().get("pPlatform");
            Integer dType = (Integer) ActionContext.getContext().getSession()
                    .get("dType");
            String pName = (String) ActionContext.getContext().getSession()
                    .get("pName");
            this.setProjectId(pId.intValue());
            this.setProjectType(pType.intValue());
            this.setProjectPlatform(pPlatform.intValue());
            this.setDevelopType(dType.intValue());
            this.setProjectName(pName);
            this.setTotalPage(projectSystemService.getPageCountByProjectId(
                    page, projectId, flag));
            this.list = projectSystemService.pageListByProjectId(page,
                    projectId, flag);
            // this.list=projectSystemService.findAll(projectId);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String findSystemBudget() {
        try {
            if (page == 1 && flag == 1) {
                ActionContext.getContext().getSession().put("pId", projectId);
                ActionContext.getContext().getSession()
                        .put("pType", projectType);
                ActionContext.getContext().getSession()
                        .put("pPlatform", projectPlatform);
                ActionContext.getContext().getSession()
                        .put("dType", developType);
                ActionContext.getContext().getSession()
                        .put("pName", projectName);
            }
            Integer pId = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            Integer pType = (Integer) ActionContext.getContext().getSession()
                    .get("pType");
            Integer pPlatform = (Integer) ActionContext.getContext()
                    .getSession().get("pPlatform");
            Integer dType = (Integer) ActionContext.getContext().getSession()
                    .get("dType");
            String pName = (String) ActionContext.getContext().getSession()
                    .get("pName");
            this.setProjectId(pId.intValue());
            this.setProjectType(pType.intValue());
            this.setProjectPlatform(pPlatform.intValue());
            this.setDevelopType(dType.intValue());
            this.setProjectName(pName);
            this.setTotalPage(projectSystemService.getPageCountByBudgetId(page,
                    budgetId, flag));
            this.list = projectSystemService.pageListByBudgetId(page, budgetId,
                    flag);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String deleteProjectSystem() {
        try {
            ProjectSystem projectSystem = projectSystemService.getById(id);
            BudgetSystem budgetSystem = budgetSystemService.getBySystemId(id);
            this.projectId = projectSystem.getProjectId();
            projectSystem.setDataMark(-1);
            projectSystemService.update(projectSystem);
            budgetSystemService.deleteRelationship(budgetSystem);
            // 记录操作日志
            operateLogService.recordOperateLog(22, projectSystem);
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    // 批量删除
    public String deleteAnyProjectSystem() {
        try {
            String[] string = s.substring(0, s.length() - 2).split("A");
            Integer pId = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            Integer pType = (Integer) ActionContext.getContext().getSession()
                    .get("pType");
            Integer pPlatform = (Integer) ActionContext.getContext()
                    .getSession().get("pPlatform");
            Integer dType = (Integer) ActionContext.getContext().getSession()
                    .get("dType");
            String pName = (String) ActionContext.getContext().getSession()
                    .get("pName");
            if (ActionContext.getContext().getSession().get("pId") != null) {
                setProjectId(pId.intValue());
                setProjectType(pType.intValue());
                setProjectPlatform(pPlatform.intValue());
                setDevelopType(dType.intValue());
                setProjectName(pName);
            }
            for (int i = 0; i < string.length; i++) {

                ProjectSystem projectSystem = projectSystemService
                        .getById(Integer.parseInt(string[i]));
                BudgetSystem budgetSystem = budgetSystemService
                        .getBySystemId(Integer.parseInt(string[i]));
                projectSystem.setDataMark(-1);
                projectSystemService.update(projectSystem);
                budgetSystemService.deleteRelationship(budgetSystem);
                // 记录操作日志
                operateLogService.recordOperateLog(22, projectSystem);
            }

            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String projectSystemDetail() {
        try {
            ProjectSystem projectSystem = projectSystemService.getById(id);
            this.setSystemName(projectSystem.getSystemName());
            this.setSystemType(projectSystem.getSystemType());
            this.setSystemPlatform(projectSystem.getSystemPlatform());
            this.setSystemDevelopType(projectSystem.getSystemDevelopType());
            this.setSystemTotalInvest(projectSystem.getSystemTotalInvest());
            this.setSystemCarryOver(projectSystem.getSystemCarryOver());
            this.setSystemNewlyInvest(projectSystem.getSystemNewlyInvest());
            this.setTeamMember(projectSystem.getTeamMember());
            this.setAcceptors(projectSystem.getAcceptors());
            this.setHandoverTime(projectSystem.getHandoverTime());
            this.setUserDepartment(projectSystem.getUserDepartment());
            this.setDescription(projectSystem.getDescription());
            this.setRemark(projectSystem.getRemark());

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // 数字类型格式化
    public String formatDouble(double s) {
        // DecimalFormat fmt = new DecimalFormat("\u00A4##0.00");
        DecimalFormat fmt = new DecimalFormat("##0.00");
        return fmt.format(s);
    }
}
