/**
 * @(#)UserAction.java
 * 
 *                     Copyright scal.All rights reserved. This software is the
 *                     Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*-                 History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日            周波                     Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.service.ContractService;
import com.scal.PIMS.service.OperateLogService;
import com.scal.PIMS.service.impl.ContractServiceImpl;
import com.scal.PIMS.service.impl.OperateLogServiceImpl;

/**
 * Class description goes here.
 * 
 * @author 周波
 * @since 2013年12月18日
 */
public class ContractAction extends ActionSupport {

    // Action中用于封装用户请求参数的属性
    private int id;
    private String contractName;
    private int projectId;
    private String projectName;
    private int contractType;
    private double contractAmount;
    private Date contractTime;
    private String remarks;
    private List<Contract> list;
    private int page;
    private int totalPage;
    private int flag;
    private String s;

    // 声明并实例化Service
    private ContractService contractService = new ContractServiceImpl();
    private OperateLogService operateLogService = new OperateLogServiceImpl();

    // Action中属性对应的getter和setter方法
    public String getS() {
        return s;
    }

    public String getProjectName() throws Exception {
        return new String(this.projectName.getBytes("iso-8859-1"),"utf-8") ;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getContractType() {
        return contractType;
    }

    public void setContractType(int contractType) {
        this.contractType = contractType;
    }

    public double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    public List<Contract> getList() {
        return list;
    }

    public void setList(List<Contract> list) {
        this.list = list;
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

    // 根据项目ID查询该项目的所有合同
    public String findContract() {
        try {
            if (page == 1 && flag == 1) {
                ActionContext.getContext().getSession().put("pId", projectId);
                ActionContext.getContext().getSession()
                        .put("pName", projectName);
            }
            Integer a = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            this.setProjectId(a.intValue());
            this.setProjectName((String) ActionContext.getContext()
                    .getSession().get("pName"));
            this.setTotalPage(contractService.getPageCount(page, projectId,
                    flag));
            this.list = contractService.pageList(page, projectId, flag);
            // this.list = contractService.findAll(projectId);
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    // 新增合同前的操作，不进行任何操作，只用于传项目ID参数
    public String beforeAddContract() {
        try {
            /*String s = (String)ActionContext.getContext().getSession().get("pName");
            this.setProjectName(s);
            Integer in = (Integer)ActionContext.getContext().getSession().get("pId");
            this.setProjectId(in.intValue());*/
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    // 新增合同
    public String addContract() {
        try {
            String s = (String)ActionContext.getContext().getSession().get("pName");
            this.setProjectName(s);
            // 新建合同对象
            Contract contract = new Contract();

            // 给对象赋值
            contract.setProjectId(projectId);
            contract.setContractAmount(contractAmount);
            contract.setContractName(contractName);
            contract.setContractTime(contractTime);
            contract.setContractType(contractType);
            contract.setRemarks(remarks);
            contract.setDataMark(1);

            // 保存合同对象
            contractService.save(contract);
            // 记录日志
            operateLogService.recordOperateLog(51, contract);

            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    // 更新合同
    public String updateContract() {
        try {
            String s = (String)ActionContext.getContext().getSession().get("pName");
            this.setProjectName(s);
            // 通过ID取得要修改的合同
            Contract contract = contractService.findContractById(id);

            contract.setContractAmount(contractAmount);
            contract.setContractName(contractName);
            contract.setContractTime(contractTime);
            contract.setContractType(contractType);
            contract.setRemarks(remarks);
            contract.setDataMark(1);

            // 更新合同操作
            contractService.update(contract);
            // 记录日志
            operateLogService.recordOperateLog(53, contract);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    // 更新前的操作
    public String beforeUpdate() {
        try {
            // 通过ID取得要修改的合同
            Contract contract = contractService.findContractById(id);

            // 取得修改前合同的数据
            this.setProjectId(contract.getProjectId());
            this.setContractType(contract.getContractType());
            this.setContractName(contract.getContractName());
            this.setContractTime(contract.getContractTime());
            this.setContractAmount(contract.getContractAmount());
            this.setRemarks(contract.getRemarks());

            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    // 删除合同
    /*
     * public String deleteContract() { 
     * try { 
     *     // 根据ID查询相应合同 
     *     Contract contract = contractService.findContractById(id); 
     *     this.projectId = contract.getProjectId(); 
     *     // 设置标志位为-1，不做物理删除
     *     contract.setDataMark(-1);
     *     //执行更新操作
     *     contractService.update(contract); 
     *     // 记录日志
     *     operateLogService.recordOperateLog(52, contract);
     * 
     *     return SUCCESS; 
     *     } catch (Exception e) { 
     *         return INPUT; 
     *     } 
     * }
     */

    // 批量删除合同
    public String deleteAnyContract() {
        try {
            String[] string = s.substring(0, s.length() - 2).split("A");
            Integer a = (Integer) ActionContext.getContext().getSession()
                    .get("pId");
            setProjectName((String) ActionContext.getContext().getSession()
                    .get("pName"));
            if (ActionContext.getContext().getSession().get("pId") != null) {
                setProjectId(a.intValue());
            }
            for (int i = 0; i < string.length; i++) {
                Contract contract = contractService.findContractById(Integer
                        .parseInt(string[i]));
                contract.setDataMark(-1);
                contractService.update(contract);
                // 记录日志
                operateLogService.recordOperateLog(52, contract);
            }

            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    //
    public String contractDetail() {
        try {
            Contract contract = contractService.findContractById(id);
            this.setProjectId(contract.getProjectId());
            this.setContractType(contract.getContractType());
            this.setContractName(contract.getContractName());
            this.setContractTime(contract.getContractTime());
            this.setContractAmount(contract.getContractAmount());
            this.setRemarks(contract.getRemarks());

            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }
}
