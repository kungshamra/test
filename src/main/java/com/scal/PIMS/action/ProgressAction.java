/**
 * @(#)ProgressAction.java
 * 
 *                         Copyright scal.All rights reserved. This software is
 *                         the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月23日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.model.ProjectProgressHistory;
import com.scal.PIMS.service.ProgressService;
import com.scal.PIMS.service.ProjectProgressHistoryService;
import com.scal.PIMS.service.impl.ProgressServiceImpl;
import com.scal.PIMS.service.impl.ProjectProgressHistoryServiceImpl;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2013年12月23日
 */
public class ProgressAction extends ActionSupport {
    private int id;
    private int projectId;
    private int progressType;
    private int status;
    private Date planStartTime;
    private Date planEndTime;
    private Date startTime;
    private Date endTime;
    private int isDelay;
    private int delayTime;
    private String remark;
    private int dataMark;
    private int f1;
    private String f2;
    private List<ProjectProgress> list;
    private ProgressService progressService = new ProgressServiceImpl();
    private String projectName;
    private int page;
    private int totalPage;
    private int flag;
    
    public String getProjectName() throws UnsupportedEncodingException {
        return new String(projectName.getBytes("ISO-8859-1"), "UTF-8");
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

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

    public int getProgressType() {
        return progressType;
    }

    public void setProgressType(int progressType) {
        this.progressType = progressType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
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

    public int getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(int isDelay) {
        this.isDelay = isDelay;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDataMark() {
        return dataMark;
    }

    public void setDataMark(int dataMark) {
        this.dataMark = dataMark;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public List<ProjectProgress> getList() {
        return list;
    }

    public void setList(List<ProjectProgress> list) {
        this.list = list;
    }

    public ProgressService getProgressService() {
        return progressService;
    }

    public void setProgressService(ProgressService progressService) {
        this.progressService = progressService;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String findAllProgressInfo() {
        try {
//            this.setProjectName(projectName);
//            this.list = progressService.findAll(projectId);
            //添加分页后的方法
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
            this.setTotalPage(progressService.getPageCount(page, projectId,
                    flag));
            this.list = progressService.pageList(page, projectId, flag);
            
 
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    // 在新增项目进度信息前获取相对应的项目id
    public String beforeAdd() {
        try {
            // ProjectProgress proProgress=progressService.getById(projectId);
            // this.setProjectId(proProgress.getProjectId());
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }
    }

    public String addProgressInfo() {
        try {
            ProjectProgress proProgress = new ProjectProgress();
            proProgress.setProjectId(projectId);
            proProgress.setProgressType(progressType);
            proProgress.setStatus(status);
            proProgress.setPlanStartTime(planStartTime);
            proProgress.setPlanEndTime(planEndTime);
            proProgress.setStartTime(startTime);
            proProgress.setEndTime(endTime);
            proProgress.setIsDelay(isDelay);
            // proProgress.setDelayTime(delayTime);
            proProgress.setRemark(remark);
            proProgress.setDataMark(1);
            progressService.save(proProgress);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }
    }

    public String beforeEditProgressInfo() {
        try {
            // id是页面跳action的传值
            // 下面这个方法中的id是取的url：beforeEditProgressInfo?id=<s:property
            // value="id"/>中传过来的id以及传过来的projectName=<s:property
            // value="projectName"/>
            this.setProjectName(projectName);
            ProjectProgress proProgress = progressService.getById(id);
            // 下面是从action跳页面的传值
            // 由于执行了下面的赋值操作后跳转是有对应字段的页面，所以页面上会显示出这些赋的值
            this.setProjectId(proProgress.getProjectId());
            this.setProgressType(proProgress.getProgressType());
            this.setStatus(proProgress.getStatus());
            this.setPlanStartTime(proProgress.getPlanStartTime());
            this.setPlanEndTime(proProgress.getPlanEndTime());
            this.setStartTime(proProgress.getStartTime());
            this.setEndTime(proProgress.getEndTime());
            // this.setIsDelay(proProgress.getIsDelay());
            this.setRemark(proProgress.getRemark());
            // this.setDataMark(proProgress.getDataMark());
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }
    }

    public String editProgressInfo() {
        try {

            // 这个方法和取s标签中文本框的值是一样的，只要id有getter和setter方法就可以从页面取是值传入action中
            // 下面getById方法要取到id的前提是编辑的这个页面要有一个对应的字段才行！！！<s:textfield name="id"
            // label="项目进度id：" />必须有这个下面才能取到id
            ProjectProgress proProgress = progressService.getById(id);
            // 从beforeEditProgressInfo方法跳过来后，括号里面的值就是上个方法赋值，但是如果更改页面对应字段文本框里面的值，那么会覆盖之前赋值为更改的值。
            proProgress.setProjectId(projectId);
            proProgress.setProgressType(progressType);
            proProgress.setStatus(status);

            // 由于取出来的planStartTime及planEndTime格式不对，所以和数据库比较的话始终是不一样的，
            // 这里进行判断的时候要对其格式进行转换统一成数据库中的格式才行: Date类学习总结(Calendar Date 字符串 相互转换
            // 格式化)
            // http://www.blogjava.net/jerry-zhaoj/archive/2008/10/08/233228.html
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd 00:00:00");
            // String PST=simpleDateFormat.format(planStartTime);
            // Date convertPST=simpleDateFormat.parse(PST);
            Date convertPST = simpleDateFormat.parse(simpleDateFormat
                    .format(planStartTime));
            Date convertPET = simpleDateFormat.parse(simpleDateFormat
                    .format(planEndTime));

            // 判断若只修改了计划启动时间，则把修改前的计划启动时间存入进度修改进度表中
            // if (convertPST != proProgress.getPlanStartTime()) {
            // 这样比较是不能成功了，下面用getTime（）方法转换为long类型的才比较成功了
            if (convertPST.getTime() != proProgress.getPlanStartTime()
                    .getTime()
                    && convertPET.getTime() == proProgress.getPlanEndTime()
                            .getTime()) {
                ProjectProgressHistory pph = new ProjectProgressHistory();
                pph.setProjectProgressId(id);
                pph.setChangedPlanST(proProgress.getPlanStartTime());
                System.out.println("从用户输入框里面取得的计划启动时间：" + planStartTime);
                pph.setEditor("取登录人姓名");
                // 取当前时间
                pph.setEditTime(new Date(System.currentTimeMillis()));
                pph.setDataMark(1);
                ProjectProgressHistoryService pphService = new ProjectProgressHistoryServiceImpl();
                // 别忘了若只改了第一条但第二条不改，则第二条原计划启动时间还是要给一个值，即没有改变的那个值，不然是空值界面展示看起来会误导用户。
                pph.setChangedPlanET(planEndTime);
                pphService.save(pph);
            }

            // 判断若同时修改2条记录，则把修改前的计划启动时间和计划完成时间存入进度修改进度表中，
            
            if (convertPST.getTime() != proProgress.getPlanStartTime()
                    .getTime()
                    && convertPET.getTime() != proProgress.getPlanEndTime()
                            .getTime()) {
                ProjectProgressHistoryService pphService = new ProjectProgressHistoryServiceImpl();
                // 需要找出刚刚添加的那条项目启动时间修改记录，这里可以通过找出id最大的一条来确认
//                int id = pphService.findMaxId().get(0).intValue();
//                ProjectProgressHistory pph = pphService.getByMaxId(id);
                ProjectProgressHistory pph = new ProjectProgressHistory();
                pph.setProjectProgressId(id);
                pph.setChangedPlanST(proProgress.getPlanStartTime());
                pph.setChangedPlanET(proProgress.getPlanEndTime());
                pph.setEditor("取登录人姓名");
                // 取当前时间
                pph.setEditTime(new Date(System.currentTimeMillis()));
                pph.setDataMark(1);
                pphService.save(pph);
            }
            // 若只改第二条不改第一条则要新增一条数据
            if (convertPET.getTime() != proProgress.getPlanEndTime().getTime()
                    && convertPST.getTime() == proProgress.getPlanStartTime()
                            .getTime()) {
                ProjectProgressHistory pph = new ProjectProgressHistory();
                pph.setProjectProgressId(id);
                pph.setChangedPlanET(proProgress.getPlanEndTime());
                pph.setEditor("取登录人姓名");
                // 取当前时间作为修改时间
                pph.setEditTime(new Date(System.currentTimeMillis()));
                pph.setDataMark(1);
                ProjectProgressHistoryService pphService = new ProjectProgressHistoryServiceImpl();
                // 别忘了第一条原计划启动时间还是要给一个值，即没有改变的那个值，不然是空值界面展示看起来会误导用户。
                pph.setChangedPlanST(planStartTime);
                pphService.save(pph);
            }

            proProgress.setPlanStartTime(planStartTime);
            proProgress.setPlanEndTime(planEndTime);
            proProgress.setStartTime(startTime);
            proProgress.setEndTime(endTime);
            // proProgress.setIsDelay(isDelay);
            proProgress.setRemark(remark);
            // proProgress.setDataMark(dataMark);
            progressService.update(proProgress);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return INPUT;
        }
    }

    public String deleteProgressInfo() {
        try {
            // 下面这个方法中的id是取的url中传过来的id
            ProjectProgress proProgress = progressService.getById(id);
            // 这里必须把projectId赋值给私有变量，然后再跳转到findAllProgressInfo（）时那边的projectId才能被取到
            this.setProjectId(proProgress.getProjectId());
            // 删除只是设置DataMark为-1，查询展示列表时只查DataMark=1的即可。
            proProgress.setDataMark(-1);
            progressService.delete(proProgress);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return INPUT;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
