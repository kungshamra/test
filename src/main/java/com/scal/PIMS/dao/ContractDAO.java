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

package com.scal.PIMS.dao;

import java.util.List;

import com.scal.PIMS.model.Contract;

/**
 * Class description goes here.
 * 
 * @author 周波
 * @since 2013年12月17日
 */
public interface ContractDAO {
	public List<Contract> findAll(int projectId) ;
	public void save(Contract contract) ;
	public void update(Contract contract) ;
	public Contract findContractById(int id) ;
}
