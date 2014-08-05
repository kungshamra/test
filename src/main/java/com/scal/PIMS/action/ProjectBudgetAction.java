/**
 * @(#)ProjectBudget.java
 * 
 *                        Copyright scal.All rights reserved. This software is
 *                        the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月19日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.ProjectBudget;
import com.scal.PIMS.service.ProjectBudgetService;
import com.scal.PIMS.service.impl.ProjectBudgetServiceImpl;
import com.scal.PIMS.util.ShowProjectBudget;

/**
 * Class description goes here.
 * 
 * @author 曾雨桐
 * @since 2013年12月19日
 */
public class ProjectBudgetAction extends ActionSupport {

    private int id;
    private int projectId;
    private String year;
    private String projectName;
    private int projectType;
    private int projectPlatform;
    private int type;
    private double totalInvestment1;
    private double carryOver;
    private double newlyInvestment;
    private double totalInvestment2;
    private String excelPath;
    private String remark1;
    private String remark2;
    private String result;
    private int projectBudgetId;
    private ProjectBudget projectBudget;
    private List<ProjectBudget> list;
    private ProjectBudgetService projectBudgetService = new ProjectBudgetServiceImpl();
    // 构建一个List类来包含预算列表展示所需的字段（从2个表中提取的字段）
    private List<ShowProjectBudget> showlist;
    private String applyYear;
    private double totalInvestment1a;
    private double totalInvestment1b;
    private Date applyTimeStart;
    private Date applyTimeEnd;
    private Date approvalTimeStart;
    private Date approvalTimeEnd;
    // 不区分2个上传文件--------------------
    // 封装文件标题请求参数的属性
    // private String title;
    // // 上传多个文件的集合文本
    // private List<File> file;
    // // 多个上传文件的类型集合
    // private List<String> fileContentType;
    // // 多个上传文件的文件名集合
    // private List<String> fileFileName;
    // private String uploadPath;
    // -------------------------------------

    // 区分2个上传文件---------------------------
    private String title;
    private File file1;
    private File file2;
    private String file1ContentType;
    private String file2ContentType;
    private String file1FileName;
    private String file2FileName;
    private String uploadPath;
    private int page;
    private int totalPage;
    private int flag;

    // -------------------------------------
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getTotalInvestment1() {
        return totalInvestment1;
    }

    public void setTotalInvestment1(double totalInvestment1) {
        this.totalInvestment1 = totalInvestment1;
    }

    public double getCarryOver() {
        return carryOver;
    }

    public void setCarryOver(double carryOver) {
        this.carryOver = carryOver;
    }

    public double getNewlyInvestment() {
        return newlyInvestment;
    }

    public void setNewlyInvestment(double newlyInvestment) {
        this.newlyInvestment = newlyInvestment;
    }

    public double getTotalInvestment2() {
        return totalInvestment2;
    }

    public void setTotalInvestment2(double totalInvestment2) {
        this.totalInvestment2 = totalInvestment2;
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public int getProjectBudgetId() {
        return projectBudgetId;
    }

    public void setProjectBudgetId(int projectBudgetId) {
        this.projectBudgetId = projectBudgetId;
    }

    public ProjectBudget getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(ProjectBudget projectBudget) {
        this.projectBudget = projectBudget;
    }

    public List<ProjectBudget> getList() {
        return list;
    }

    public void setList(List<ProjectBudget> list) {
        this.list = list;
    }

    public List<ShowProjectBudget> getShowlist() {
        return showlist;
    }

    public void setShowlist(List<ShowProjectBudget> showlist) {
        this.showlist = showlist;
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

    public String getProjectName() throws UnsupportedEncodingException {
        return new String(projectName.getBytes("ISO-8859-1"), "UTF-8");
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    public double getTotalInvestment1a() {
        return totalInvestment1a;
    }

    public void setTotalInvestment1a(double totalInvestment1a) {
        this.totalInvestment1a = totalInvestment1a;
    }

    public double getTotalInvestment1b() {
        return totalInvestment1b;
    }

    public void setTotalInvestment1b(double totalInvestment1b) {
        this.totalInvestment1b = totalInvestment1b;
    }

    public Date getApplyTimeStart() {
        return applyTimeStart;
    }

    public void setApplyTimeStart(Date applyTimeStart) {
        this.applyTimeStart = applyTimeStart;
    }

    public Date getApplyTimeEnd() {
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(Date applyTimeEnd) {
        this.applyTimeEnd = applyTimeEnd;
    }

    public Date getApprovalTimeStart() {
        return approvalTimeStart;
    }

    public void setApprovalTimeStart(Date approvalTimeStart) {
        this.approvalTimeStart = approvalTimeStart;
    }

    public Date getApprovalTimeEnd() {
        return approvalTimeEnd;
    }

    public void setApprovalTimeEnd(Date approvalTimeEnd) {
        this.approvalTimeEnd = approvalTimeEnd;
    }

    // 不区分2个上传文件--------------------------------------------------
    // public List<File> getFile() {
    // return file;
    // }
    //
    // public void setFile(List<File> file) {
    // this.file = file;
    // }
    //
    // public List<String> getFileContentType() {
    // return fileContentType;
    // }
    //
    // public void setFileContentType(List<String> fileContentType) {
    // this.fileContentType = fileContentType;
    // }
    //
    // public List<String> getFileFileName() {
    // return fileFileName;
    // }
    //
    // public void setFileFileName(List<String> fileFileName) {
    // this.fileFileName = fileFileName;
    // }
    // 不区分2个上传文件--------------------------------------------------

    // 要区分2个上传文件----------------------------------------------------
    public String getUploadPath() {
        return uploadPath;
    }

    public File getFile1() {
        return file1;
    }

    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        this.file2 = file2;
    }

    public String getFile1ContentType() {
        return file1ContentType;
    }

    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    public String getFile2ContentType() {
        return file2ContentType;
    }

    public void setFile2ContentType(String file2ContentType) {
        this.file2ContentType = file2ContentType;
    }

    public String getFile1FileName() {
        return file1FileName;
    }

    public void setFile1FileName(String file1FileName) {
        this.file1FileName = file1FileName;
    }

    public String getFile2FileName() {
        return file2FileName;
    }

    public void setFile2FileName(String file2FileName) {
        this.file2FileName = file2FileName;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    // ------------------------------------------------------------
    public String beforeAddProjectBudget() {
        try {
            ProjectBudget projectBudget = projectBudgetService.getById(id);
            this.setProjectId(projectBudget.getProjectId());
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return ERROR;
        }
    }

    // public String addProjectBudget() {
    // try {
    // ProjectBudget projectBudget = projectBudgetService.getById(id);
    // projectBudget.setYear(year);
    // projectBudget.setProjectId(projectId);
    // projectBudget.setType(type);
    // projectBudget.setTotalInvestment1(totalInvestment1);
    // projectBudget.setCarryOver(carryOver);
    // projectBudget.setNewlyInvestment(newlyInvestment);
    // projectBudget.setTotalInvestment2(totalInvestment2);
    // projectBudget.setRemark1(remark1);
    // projectBudget.setRemark2(remark2);
    // projectBudget.setExcelPath(excelPath);
    // projectBudget.setResult("上传文件至" + projectBudget.getExcelPath());
    // projectBudget.setDataMark(1);
    //
    // projectBudgetService.update(projectBudget);
    // return SUCCESS;
    //
    // } catch (Exception e) {
    //
    // return ERROR;
    //
    // }
    // }

    public String beforeEdit() {
        try {
            projectBudget = projectBudgetService.getById(id);
            this.setProjectId(projectBudget.getProjectId());
            // 由于存的类型是date类型，这里需要输入String类型，所以要把取出来的date转换为String,只取年
            String stringYear = "";
            if (projectBudget.getYear() != null) {
                stringYear = (projectBudget.getYear()).toString().substring(0,
                        4);
            } else {
                stringYear = "";
            }
            this.setYear(stringYear);
            this.setType(projectBudget.getType());
            this.setTotalInvestment1(projectBudget.getTotalInvestment1());
            this.setCarryOver(projectBudget.getCarryOver());
            this.setNewlyInvestment(projectBudget.getNewlyInvestment());
            this.setTotalInvestment2(projectBudget.getTotalInvestment2());
            this.setRemark1(projectBudget.getRemark1());
            this.setRemark2(projectBudget.getRemark2());
            this.setExcelPath(projectBudget.getExcelPath());
            this.setResult(projectBudget.getResult());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String editProjectBudget() {
        try {
            ProjectBudget projectBudget = projectBudgetService.getById(id);
            // 这里对输入的年作格式转换后存入budget表的year字段中。
            // SimpleDateFormat simpleDateFormat=new
            // SimpleDateFormat("yyyy"+"-01-01");
            // String yearString=simpleDateFormat.format(year);

            // 即使yearString已经填了"-01-01"格式了，simpleDateFormat仍然要拼后面的格式"yyyy"+"-01-01"，
            // 不然转换为Date类型会报错

            // 要先验证一下手动输入year的地方是否为空，如果是就不能执行下面的转换，但这里如果写if (year != null &&
            // year != "")是不能排除year为空的情况，要换成下面的写法！！！！！！！
            if (!"".equals(year)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy"
                        + "-01-01");
                String yearString = year + "-01-01";
                try {
                    Date applyYear = simpleDateFormat.parse(yearString);
                    projectBudget.setYear(applyYear);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // else {
            // SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            // Date applyYear = simpleDateFormat.parse(year);
            // projectBudget.setYear(applyYear);
            // }

            projectBudget.setProjectId(projectId);
            projectBudget.setType(type);
            projectBudget.setTotalInvestment1(totalInvestment1);
            projectBudget.setCarryOver(carryOver);
            projectBudget.setNewlyInvestment(newlyInvestment);
            projectBudget.setTotalInvestment2(totalInvestment2);
            projectBudget.setRemark1(remark1);
            projectBudget.setRemark2(remark2);
            // projectBudget.setExcelPath(uploadPath);
            // projectBudget.setResult("上传文件至" + projectBudget.getExcelPath());
            // projectBudget.setResult("上传文件至" + projectBudget.getExcelPath());
            // 不区分2个上传文件-------------------------------------------------------------------
            // if ((this.getFile() != null) && (this.getFileContentType() !=
            // null)
            // && (this.getFileFileName() != null)) {
            // UploadAction upload = new UploadAction();
            // // upload.setTitle(this.getTitle());
            // upload.setFile(this.getFile());
            // upload.setFileContentType(this.getFileContentType());
            // upload.setFileFileName(this.getFileFileName());
            // upload.setUploadPath(uploadPath);
            // // upload.execute();
            // upload.upload(projectBudget);
            // }
            // --------------------------------------------------------------------

            // 区分2个上传文件----------------------------------------------------------
            if ((this.getFile1() != null)
                    && (this.getFile1ContentType() != null)
                    && (this.getFile1FileName() != null)) {
                UploadAction upload = new UploadAction();
                // upload.setTitle(this.getTitle());
                upload.setFile1(this.getFile1());
                upload.setFile1ContentType(this.getFile1ContentType());
                upload.setFile1FileName(this.getFile1FileName());
                upload.setUploadPath(uploadPath);
                // upload.execute();
                upload.upload1(projectBudget);
            }
            if ((this.getFile2() != null)
                    && (this.getFile2ContentType() != null)
                    && (this.getFile2FileName() != null)) {
                UploadAction upload = new UploadAction();
                // upload.setTitle(this.getTitle());
                upload.setFile2(this.getFile2());
                upload.setFile2ContentType(this.getFile2ContentType());
                upload.setFile2FileName(this.getFile2FileName());
                upload.setUploadPath(uploadPath);
                // upload.execute();
                upload.upload2(projectBudget);
            }
            // --------------------------------------------------------------------
            projectBudgetService.update(projectBudget);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;

        }
    }

    // public String deleteProjectBudget(){
    // try {
    // return SUCCESS;
    // } catch (Exception e) {
    // // TODO: handle exception
    // return ERROR;
    // }
    // }
    // 这个方法没用了！！！！！！！！！！！！！！！
    public String listProjectBudget() {
        try {
            this.list = projectBudgetService.listAll();
            return SUCCESS;

        } catch (Exception e) {

            return ERROR;

        }
    }

    public String multiEntityQuery() {

        try {
            // 可以构建一个新的类来包含展示列表所需的所有字段，然后返回前台就能获取到
            // 添加分页前 this.showlist = projectBudgetService.multiEntityQuery();
            // 添加分页后
            this.setTotalPage(projectBudgetService.getPageCount());
            this.showlist = projectBudgetService.pageList(page);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 按搜索条件查询结果展示
     * */
    public String searchBudgetInfo() {
        try {
            // 要把查询输入的项目申报年份(String)类型转换为Date类型去数据库里面去查
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy"
                    + "-01-01");
            String yearString = applyYear + "-01-01";
            Date appYear = null;
            try {
                // 将转换为Date类型的appYear传入searchBudgetInfo()方法中去数据库查询
                appYear = simpleDateFormat.parse(yearString);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.showlist = projectBudgetService.searchBudgetInfo(projectName,
                    projectType, type, projectPlatform, appYear,
                    totalInvestment1a, totalInvestment1b, applyTimeStart,
                    applyTimeEnd, approvalTimeStart, approvalTimeEnd);
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return INPUT;
        }
    }

}
