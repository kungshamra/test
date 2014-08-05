/**
 * @(#)FileDownloadAction.java
 * 
 *                             Copyright scal.All rights reserved. This software
 *                             is the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*-                 History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2014年1月21日         jonathan       Created
 **********************************************
 */

package com.scal.PIMS.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Class description goes here. 折腾了2天的乱码问题终于解决了，可能是我机器浏览器的问题，其他人机器上都可以显示中文
 * 
 * @author jonathan
 * @since 2014年1月21日
 */
public class FileDownloadAction extends ActionSupport {
    // 该属性可以在配置文件中动态指定该属性值
    private String inputPath;

    // 依赖注入该属性值的setter方法
    public void setInputPath(String value) {
        this.inputPath = value;
    }

    public String getInputPath() {
        return inputPath;
    }

    private String basePath;
    // private String basePath = ServletActionContext.getServletContext()
    // .getRealPath(inputPath);

    // private String basePath =
    // "D:\\apache-tomcat-6.0.35\\wtpwebapps\\Scal.PIMS\\Uploads\\";
    // public String getBasePath() throws Exception {
    // // 把上传的文件放到指定的路径下，路径在struts.xml下配置
    // return ServletActionContext.getServletContext().getRealPath(inputPath);
    // }

    private String fileName;

    public String getBasePath() {
        return ServletActionContext.getServletContext().getRealPath(inputPath);
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    // 网上解决办法http://xiaolongfeixiang.iteye.com/blog/662479
    // 现在是用下面这个方法主要是解决下载英文名的文件没问题，下载中文的文件就会出错的问题，getBytes里面是待转换的编码，后面是转换为什么的编码
    // 这个方法可以决定下载文件另存为时的文件名（通过struts配置文件来取这个名字），这里把其从utf-8转换为ISO8859-1显示出来就没有乱码了。
    //<param name="contentDisposition">attachment;filename="${fileName}"</param> filename就是取这里getFileName的返回值
    public String getFileName() {
        // return fileName;
        try {
            // return new String(fileName.getBytes("ISO8859-1"), "utf-8");
            // return new String(fileName.getBytes("ISO8859-1"), "GBK");
            this.fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
            // fileName=new String(fileName.getBytes("ISO8859-1"), "utf-8");
            return this.fileName;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ERROR;
        }
    }

    // public String getFileName() {
    // return fileName;
    // }
    public void setFileName(String fileName) {
        // this.fileName = fileName;
        try {
            this.fileName = new String(fileName.getBytes("ISO8859-1"), "utf-8");
            System.out.println("执行setFileName()后打印fileName" + fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // 网上解决办法http://xiaolongfeixiang.iteye.com/blog/662479
    // public void setFilename(String filename) {
    // try {
    // this.filename = new String(filename.getBytes("ISO8859-1"),"GBK");
    // } catch (UnsupportedEncodingException e) {
    // }
    // }

    /*
     * 定义返回一个InputStream方法 该方法将作为被下载文件的入口， 且需要配置stream类型结果时指定inputName参数，
     * inputName参数的值就是方法去掉get前缀】首字母小写的字符串
     */
    public InputStream getInputStream() throws FileNotFoundException {
        // ServletContext提供getResourceAsStream()方法
        // 返回指定文件对应的输入流
        // return
        // ServletActionContext.getServletContext().getResourceAsStream(inputPath);
        // return new
        // FileInputStream("D:\\apache-tomcat-6.0.35\\wtpwebapps\\Scal.PIMS\\Uploads\\GettingThingsDone.pdf");
        System.out.println(getBasePath());
        System.out.println(getFileName());
        // String convertFileName=getFileName();
        // 把从控件接受到的编码为ISO8859-1的文件名转换为utf-8去找路径名相符的文件
        this.setFileName(fileName);

        return new FileInputStream(new File(getBasePath() + "\\"
                + this.fileName));
        // return new FileInputStream(new File(getBasePath() + "\\"
        // + getFileName()));
        // return new FileInputStream(getBasePath()+"\\"+fileName);
    }
}
