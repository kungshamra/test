/**
 * @(#)ProjectInfoAction.java
 * 
 *                            Copyright scal.All rights reserved. This software
 *                            is the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.model.ProjectSystem;
import com.scal.PIMS.service.ContractService;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.ProgressService;
import com.scal.PIMS.service.ProjectBudgetService;
import com.scal.PIMS.service.ProjectInfoService;
import com.scal.PIMS.service.ProjectSystemService;
import com.scal.PIMS.service.impl.ContractServiceImpl;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;
import com.scal.PIMS.service.impl.ProgressServiceImpl;
import com.scal.PIMS.service.impl.ProjectBudgetServiceImpl;
import com.scal.PIMS.service.impl.ProjectInfoServiceImpl;
import com.scal.PIMS.service.impl.ProjectSystemServiceImpl;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月18日
 */
public class ProjectInfoAction extends ActionSupport {

    private int id;
    private String projectName;
    private int projectType;
    private int projectPlatform;
    private String applyDepartment;
    private int projectStatus;
    private Date year;
    private Date budgetApplyTime;
    private Date budgetApprovalTime;
    private int priority;
    private int scheduledPlan;
    // private double totalInvestment2;
    private int developType;
    private String responsibilityDep;
    private String responsibilityLeader;
    private String remark;
    private ProjectInfoService proInfoService = new ProjectInfoServiceImpl();
    private ProjectInfo proInfo;
    private List<ProjectInfo> list;
    // 构建一个List类来包含预算列表展示所需的字段（从2个表中提取的字段）
    private List<ShowProjectBudget> showlist;
    private Date startTime;
    private Date endTime;
    private double totalInvestment2a;
    private double totalInvestment2b;
    private int page;
    private int totalPage;
    private int flag;
    OperateLogService operateLogService = new OperateLogServiceImpl();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getBudgetApplyTime() {
        return budgetApplyTime;
    }

    public void setBudgetApplyTime(Date budgetApplyTime) {
        this.budgetApplyTime = budgetApplyTime;
    }

    public Date getBudgetApprovalTime() {
        return budgetApprovalTime;
    }

    public void setBudgetApprovalTime(Date budgetApprovalTime) {
        this.budgetApprovalTime = budgetApprovalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getScheduledPlan() {
        return scheduledPlan;
    }

    public void setScheduledPlan(int scheduledPlan) {
        this.scheduledPlan = scheduledPlan;
    }

    // public double getTotalInvestment2() {
    // return totalInvestment2;
    // }
    //
    // public void setTotalInvestment2(double totalInvestment2) {
    // this.totalInvestment2 = totalInvestment2;
    // }

    public int getDevelopType() {
        return developType;
    }

    public void setDevelopType(int developType) {
        this.developType = developType;
    }

    public String getResponsibilityDep() {
        return responsibilityDep;
    }

    public void setResponsibilityDep(String responsibilityDep) {
        this.responsibilityDep = responsibilityDep;
    }

    public String getResponsibilityLeader() {
        return responsibilityLeader;
    }

    public void setResponsibilityLeader(String responsibilityLeader) {
        this.responsibilityLeader = responsibilityLeader;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ProjectInfoService getProInfoService() {
        return proInfoService;
    }

    public void setProInfoService(ProjectInfoService proInfoService) {
        this.proInfoService = proInfoService;
    }

    public ProjectInfo getProInfo() {
        return proInfo;
    }

    public void setProInfo(ProjectInfo proInfo) {
        this.proInfo = proInfo;
    }

    public List<ProjectInfo> getList() {
        return list;
    }

    public void setList(List<ProjectInfo> list) {
        this.list = list;
    }

    public List<ShowProjectBudget> getShowlist() {
        return showlist;
    }

    public void setShowlist(List<ShowProjectBudget> showlist) {
        this.showlist = showlist;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getTotalInvestment2a() {
        return totalInvestment2a;
    }

    public void setTotalInvestment2a(double totalInvestment2a) {
        this.totalInvestment2a = totalInvestment2a;
    }

    public double getTotalInvestment2b() {
        return totalInvestment2b;
    }

    public void setTotalInvestment2b(double totalInvestment2b) {
        this.totalInvestment2b = totalInvestment2b;
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

    /**
     * 展示项目信息管理页面
     * */
    public String findAllProjectInfo() {
        try {
            // 这个只是找出ProjectGeneral表里面的所有字段
            // this.list = proInfoService.findAll();
            // 这里需要显示ProjectGeneral表里面的所有字段以及ProjectBudget表中的一个字段
            // this.showlist = proInfoService.showAll();
            this.setTotalPage(proInfoService.getPageCount());
            this.showlist = proInfoService.pageList(page);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    /**
     * 按搜索条件查询结果展示
     * */
    public String searchProInfo() {
        try {
            // this.showlist = proInfoService.searchProInfo(projectName,
            // projectType, developType, projectPlatform, startTime,
            // endTime, projectStatus, priority, scheduledPlan,
            // totalInvestment2a, totalInvestment2b);
            this.setTotalPage(proInfoService.getPageCountByCondition(
                    projectName, projectType, developType, projectPlatform,
                    startTime, endTime, projectStatus, priority, scheduledPlan,
                    totalInvestment2a, totalInvestment2b, page, flag));
            this.showlist = proInfoService.pageListByCondition(projectName,
                    projectType, developType, projectPlatform, startTime,
                    endTime, projectStatus, priority, scheduledPlan,
                    totalInvestment2a, totalInvestment2b, page, flag);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return INPUT;
        }
    }

    public String addProjectInfo() {
        try {
            ProjectInfo proInfo = new ProjectInfo();
            proInfo.setProjectName(projectName);
            proInfo.setProjectPlatform(projectPlatform);
            proInfo.setProjectType(projectType);
            proInfo.setProjectStatus(projectStatus);
            // 在建年份自动提取项目进度信息里面最新的一个日期，在未完成项目进度信息前先付一个固定时间
            // proInfo.setYear(2013-12-12);
            proInfo.setBudgetApplyTime(budgetApplyTime);
            proInfo.setBudgetApprovalTime(budgetApprovalTime);
            proInfo.setPriority(priority);
            proInfo.setScheduledPlan(scheduledPlan);
            proInfo.setDevelopType(developType);
            proInfo.setApplyDepartment(applyDepartment);
            proInfo.setResponsibilityLeader(responsibilityLeader);
            proInfo.setResponsibilityDep(responsibilityDep);
            proInfo.setRemark(remark);
            // DataMark默认设置为1
            proInfo.setDataMark(1);
            // ProjectInfoService proInfoService=new ProjectInfoServiceImpl();
            proInfoService.save(proInfo);
            // 实例化一个新的预算信息对象
            ProjectBudget proBudget = new ProjectBudget();
            // 这里调用findProId()是取出项目id里面最大的一个也就是刚刚添加的最新的一个项目id，并把这个值存入预算表中以便于关联，
            // 同时创建一个关联此项目id的预算对象
            List<Integer> list = proInfoService.findProId();
            int projectId = list.get(0).intValue();
            proBudget.setProjectId(projectId);
            proBudget.setDataMark(1);
            proInfoService.addBudget(proBudget);
            // 记录操作日志,添加一条项目基本信息
            operateLogService.recordOperateLog(11, proInfo);
            // 记录操作日志,添加一条项目预算信息
            operateLogService.recordOperateLog(41, proBudget);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }

    }

    public String beforeEdit() {
        try {
            proInfo = proInfoService.getById(id);

            this.setProjectName(proInfo.getProjectName());
            this.setProjectPlatform(proInfo.getProjectPlatform());
            this.setProjectType(proInfo.getProjectType());
            this.setProjectStatus(proInfo.getProjectStatus());
            this.setBudgetApplyTime(proInfo.getBudgetApplyTime());
            this.setBudgetApprovalTime(proInfo.getBudgetApprovalTime());
            this.setPriority(proInfo.getPriority());
            this.setScheduledPlan(proInfo.getScheduledPlan());
            this.setDevelopType(proInfo.getDevelopType());
            this.setApplyDepartment(proInfo.getApplyDepartment());
            this.setResponsibilityDep(proInfo.getResponsibilityDep());
            this.setResponsibilityLeader(proInfo.getResponsibilityLeader());
            this.setRemark(proInfo.getRemark());
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }

    }

    public String editProjectInfo() {
        try {
            // ProjectInfoService proInfoService=new ProjectInfoServiceImpl();
            ProjectInfo proInfo = proInfoService.getById(id);

            proInfo.setProjectName(projectName);
            proInfo.setProjectPlatform(projectPlatform);
            proInfo.setProjectType(projectType);
            proInfo.setProjectStatus(projectStatus);
            proInfo.setBudgetApplyTime(budgetApplyTime);
            proInfo.setBudgetApprovalTime(budgetApprovalTime);
            proInfo.setPriority(priority);
            proInfo.setScheduledPlan(scheduledPlan);
            proInfo.setDevelopType(developType);
            proInfo.setApplyDepartment(applyDepartment);
            proInfo.setResponsibilityLeader(responsibilityLeader);
            proInfo.setResponsibilityDep(responsibilityDep);
            proInfo.setRemark(remark);

            proInfoService.update(proInfo);
            // 记录操作日志,修改一条项目基本信息
            operateLogService.recordOperateLog(13, proInfo);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }

    }

    // 在每条信息后面进行删除操作,实际是更改DataMark为-1，展示查询的时候不展示就行，而不是物理删除
    public String deleteProjectInfo() {
        try {
            ProjectInfo proInfo = proInfoService.getById(id);
            // 删除只是设置DataMark为-1，查询展示列表时只查DataMark=1的即可。
            proInfo.setDataMark(-1);
            System.out.println(proInfo.getId());
            // 在删除项目信息的同时要把对应的项目预算信息设置DataMark=-1
            ProjectBudgetService projectBudgetService = new ProjectBudgetServiceImpl();
            ProjectBudget projectBudget = projectBudgetService
                    .getByProjectId(proInfo.getId());
            projectBudget.setDataMark(-1);
            projectBudgetService.update(projectBudget);
            // 在删除项目信息的同时要把对应的项目子系统信息设置DataMark=-1,可能会有多个所以取出来是一个list的对象
            ProjectSystemService projectSystemService = new ProjectSystemServiceImpl();
            List<ProjectSystem> projectSystem = projectSystemService
                    .findAll(proInfo.getId());
            for (Iterator<ProjectSystem> iterator = projectSystem.iterator(); iterator
                    .hasNext();) {
                ProjectSystem proSystem = iterator.next();
                proSystem.setDataMark(-1);
                projectSystemService.update(proSystem);
            }

            // 同上在删除项目信息的同时要把对应的项目进度信息设置DataMark=-1
            ProgressService progressService = new ProgressServiceImpl();
            List<ProjectProgress> projectProgress = progressService
                    .findAll(proInfo.getId());
            for (Iterator<ProjectProgress> iterator = projectProgress
                    .iterator(); iterator.hasNext();) {
                ProjectProgress proProgress = iterator.next();
                proProgress.setDataMark(-1);
                progressService.update(proProgress);
            }
            // 同上在删除项目信息的同时要把对应的项目合同信息设置DataMark=-1
            ContractService contractService = new ContractServiceImpl();
            List<Contract> contract = contractService.findAll(proInfo.getId());
            for (Iterator<Contract> iterator = contract.iterator(); iterator
                    .hasNext();) {
                Contract c = iterator.next();
                c.setDataMark(-1);
                contractService.update(c);
            }
            proInfoService.delete(proInfo);
         // 记录操作日志,删除一条项目基本信息
            operateLogService.recordOperateLog(12, proInfo);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return INPUT;
        }
    }
}
