/**
 * @(#)UploadAction.java
 * 
 *                       Copyright scal.All rights reserved. This software is
 *                       the Scal.PIMS system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月20日		  王  超                            Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.scal.PIMS.model.ProjectBudget;

/**
 * Class description goes here.
 * 
 * @author 王超
 * @since 2013年12月20日
 */
public class UploadAction extends ActionSupport {
    // 封装文件标题请求参数的属性
    private String title;
    // // 上传多个文件的集合文本
    // private List<File> file;
    // // 多个上传文件的类型集合
    // private List<String> fileContentType;
    // // 多个上传文件的文件名集合
    // private List<String> fileFileName;
    // 区分上传2个文件
    private File file1;
    private File file2;
    private String file1ContentType;
    private String file2ContentType;
    private String file1FileName;
    private String file2FileName;
    private String uploadPath;

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

    public String getUploadPath() throws Exception {
        // 把上传的文件放到指定的路径下，路径在struts.xml下配置
        return ServletActionContext.getServletContext().getRealPath(uploadPath);
    }

    public void setUploadPath(String value) {
        this.uploadPath = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // 时间戳
    public String timeStamp() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss_");
        Date currentDate = new Date(System.currentTimeMillis());
        String currentTime = formatter.format(currentDate);
        return currentTime;
    }

    public String upload1(ProjectBudget projectBudget) throws Exception {

        // 写到指定的路径中
        File path = new File(getUploadPath());

        // 如果指定的路径没有就创建
        if (!path.exists()) {
            path.mkdirs();
        }
        // try {
        // list集合通过get(i)的方式来获取索引
        // 这里加了时间戳，但是下载的时候根据文件名去取就不好取到这个加了时间戳的文件名，目前想的办法是把这个时间戳和文件名存在数据库里面，
        // 取的话就取这个字段的值作为文件名就可以对应之前上传的文件了
        // FileUtils.copyFile(file.get(i), new File(path, timeStamp()
        // + fileFileName.get(i)));

        // 这里要加一个判断是否选中了上传文件
        // 这里要加一个判断，若之前有上传的文件，则物理删除之前的上传文件，上传新的文件
            try {

                if (projectBudget.getExcelPath() == null
                        && !"".equals(file1FileName)) {
                    String fileName1 = timeStamp() + file1FileName;
                    projectBudget.setExcelPath(fileName1);
                    FileUtils.copyFile(file1, new File(path, fileName1));
                } else if (!"".equals(file1FileName)) {
                    // 先删除原上传文件
                    // File oldDocPath = new
                    // File(getUploadPath()+"\\"+projectBudget.getExcelPath());
                    String oldDocPath = getUploadPath() + "\\"
                            + projectBudget.getExcelPath();
                    File oldFile = new File(oldDocPath);
                    oldFile.delete();
                    // 再上传新文件
                    String fileName1 = timeStamp() + file1FileName;
                    projectBudget.setExcelPath(fileName1);
                    FileUtils.copyFile(file1, new File(path, fileName1));
                }

          else {
                }

                // 打印测试
                System.out.println("文件名:" + timeStamp() + file1FileName);
//                System.out.println("文件名:" + timeStamp() + file2FileName);
                System.out.println("文件路径:" + getUploadPath());

            } catch (Exception e) {
                e.printStackTrace();
                return INPUT;
            }

            return SUCCESS;

        
    }
    public String upload2(ProjectBudget projectBudget) throws Exception {

        // 写到指定的路径中
        File path = new File(getUploadPath());

        // 如果指定的路径没有就创建
        if (!path.exists()) {
            path.mkdirs();
        }
        // try {
        // list集合通过get(i)的方式来获取索引
        // 这里加了时间戳，但是下载的时候根据文件名去取就不好取到这个加了时间戳的文件名，目前想的办法是把这个时间戳和文件名存在数据库里面，
        // 取的话就取这个字段的值作为文件名就可以对应之前上传的文件了
        // FileUtils.copyFile(file.get(i), new File(path, timeStamp()
        // + fileFileName.get(i)));

        // 这里要加一个判断是否选中了上传文件
        // 这里要加一个判断，若之前有上传的文件，则物理删除之前的上传文件，上传新的文件
            try {

                if (projectBudget.getResult() == null
                        && !"".equals(file2FileName)) {
                    String fileName2 = timeStamp() + file2FileName;
                    projectBudget.setResult(fileName2);
                    FileUtils.copyFile(file2, new File(path, fileName2));
                } else if (!"".equals(file2FileName)) {
                    // 先删除原上传文件
                    String oldDocPath = getUploadPath() + "\\"
                            + projectBudget.getResult();
                    File oldFile = new File(oldDocPath);
                    oldFile.delete();
                    // 再上传新文件
                    String fileName2 = timeStamp() + file2FileName;
                    projectBudget.setResult(fileName2);
                    FileUtils.copyFile(file2, new File(path, fileName2));
                } else {
                }

                // 打印测试
//                System.out.println("文件名:" + timeStamp() + file1FileName);
                System.out.println("文件名:" + timeStamp() + file2FileName);
                System.out.println("文件路径:" + getUploadPath());

            } catch (Exception e) {
                e.printStackTrace();
                return INPUT;
            }

            return SUCCESS;

        
    }
}

// --------------------------------------------------------
// @Override
// public String execute() throws Exception {
//
// // 写到指定的路径中
// File path = new File(getUploadPath());
//
// // 如果指定的路径没有就创建
// if (!path.exists()) {
// path.mkdirs();
// }
//
// // 把得到的文件的集合通过循环的方式读取并放在指定的路径下
// for (int i = 0; i < file.size(); i++) {
// try {
// // list集合通过get(i)的方式来获取索引
// // 这里加了时间戳，但是下载的时候根据文件名去取就不好取到这个加了时间戳的文件名，目前想的办法是把这个时间戳和文件名存在数据库里面，
// // 取的话就取这个字段的值作为文件名就可以对应之前上传的文件了
// // FileUtils.copyFile(file.get(i), new File(path, timeStamp()
// // + fileFileName.get(i)));
// String fileName = timeStamp() + fileFileName.get(i);
// FileUtils.copyFile(file.get(i), new File(path, fileName));
// // 打印测试
// System.out.println("文件名:" + timeStamp() + fileFileName.get(i));
// System.out.println("文件路径:" + getUploadPath());
//
// } catch (Exception e) {
// e.printStackTrace();
// return INPUT;
// }
// }
//
// return SUCCESS;
//
// }
// -----------------------------------------------------------
/*
 * 专门针对上传预算信息写的一个方法，缺点是通用性不强
 */
// public String upload(ProjectBudget projectBudget) throws Exception {
//
// // 写到指定的路径中
// File path = new File(getUploadPath());
//
// // 如果指定的路径没有就创建
// if (!path.exists()) {
// path.mkdirs();
// }
// ------------------------------------------------------------------------------------------------
// 把得到的文件的集合通过循环的方式读取并放在指定的路径下，由于想要把2个文件的文件名分别存在2个字段里面，这里就不能用循环了
// for (int i = 0; i < file.size(); i++) {
// try {
// // list集合通过get(i)的方式来获取索引
// // 这里加了时间戳，但是下载的时候根据文件名去取就不好取到这个加了时间戳的文件名，目前想的办法是把这个时间戳和文件名存在数据库里面，
// // 取的话就取这个字段的值作为文件名就可以对应之前上传的文件了
// // FileUtils.copyFile(file.get(i), new File(path, timeStamp()
// // + fileFileName.get(i)));
//
//
// String fileName = timeStamp() + fileFileName.get(i);
// projectBudget.setExcelPath(fileName);
// FileUtils.copyFile(file.get(i), new File(path, fileName));
// // 打印测试
// System.out.println("文件名:" + timeStamp() + fileFileName.get(i));
// System.out.println("文件路径:" + getUploadPath());
//
// } catch (Exception e) {
// e.printStackTrace();
// return INPUT;
// }
// }
// -----------------------------------------------------------------------------------------
// 由于想要把2个文件的文件名分别存在2个字段里面，这里就不能用循环了

// try {
// // list集合通过get(i)的方式来获取索引
// // 这里加了时间戳，但是下载的时候根据文件名去取就不好取到这个加了时间戳的文件名，目前想的办法是把这个时间戳和文件名存在数据库里面，
// // 取的话就取这个字段的值作为文件名就可以对应之前上传的文件了
// // FileUtils.copyFile(file.get(i), new File(path, timeStamp()
// // + fileFileName.get(i)));
//
// // 这里要加一个判断是否选中了上传文件
// // 这里要加一个判断，若之前有上传的文件，则物理删除之前的上传文件，上传新的文件
// if (projectBudget.getExcelPath() == null
// && !"".equals(fileFileName.get(0)) ) {
// String fileName1 = timeStamp() + fileFileName.get(0);
// projectBudget.setExcelPath(fileName1);
// FileUtils.copyFile(file.get(0), new File(path, fileName1));
// } else if (!"".equals(fileFileName.get(0)) ) {
// // 先删除原上传文件
// // File oldDocPath = new
// // File(getUploadPath()+"\\"+projectBudget.getExcelPath());
// String oldDocPath = getUploadPath() + "\\"
// + projectBudget.getExcelPath();
// File oldFile = new File(oldDocPath);
// oldFile.delete();
// // 再上传新文件
// String fileName1 = timeStamp() + fileFileName.get(0);
// projectBudget.setExcelPath(fileName1);
// FileUtils.copyFile(file.get(0), new File(path, fileName1));
// }
//
// if (projectBudget.getResult() == null && !"".equals(fileFileName.get(1)) ) {
// String fileName2 = timeStamp() + fileFileName.get(1);
// projectBudget.setResult(fileName2);
// FileUtils.copyFile(file.get(1), new File(path, fileName2));
// } else if (!"".equals(fileFileName.get(1)) ) {
// // 先删除原上传文件
// String oldDocPath =getUploadPath() + "\\"
// + projectBudget.getResult();
// File oldFile = new File(oldDocPath);
// oldFile.delete();
// // 再上传新文件
// String fileName2 = timeStamp() + fileFileName.get(1);
// projectBudget.setResult(fileName2);
// FileUtils.copyFile(file.get(1), new File(path, fileName2));
// } else {
// }
//
// // 打印测试
// System.out.println("文件名:" + timeStamp() + fileFileName.get(0));
// System.out.println("文件路径:" + getUploadPath());
//
// } catch (Exception e) {
// e.printStackTrace();
// return INPUT;
// }
//
// return SUCCESS;
//
// }
// }
