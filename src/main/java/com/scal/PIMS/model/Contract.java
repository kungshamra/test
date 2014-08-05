/**
 * @(#)ProjectSystem.java
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
 *  1     2013年12月17日		周波                     Created
 **********************************************
 */
package com.scal.PIMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class description goes here.
 * 
 * @author 周波
 * @since 2013年12月17日
 */
@Entity
@Table(name="t_projectcontract")
public class Contract {
	private int id ;
	private int projectId ;
	private int contractType ;
	private String contractName ;
	private Date contractTime ;
	private double contractAmount ;
	private String remarks ;
	private int dataMark ;
	private int f1 ;
	private String f2 ;
	
	@Id
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
	public int getContractType() {
		return contractType;
	}
	public void setContractType(int contractType) {
		this.contractType = contractType;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Date getContractTime() {
		return contractTime;
	}
	public void setContractTime(Date contractTime) {
		this.contractTime = contractTime;
	}
	public double getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(double contractAmount) {
		this.contractAmount = contractAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks ;
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
	public int getDataMark() {
		return dataMark;
	}
	public void setDataMark(int dataMark) {
		this.dataMark = dataMark;
	}
}
