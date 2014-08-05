/**
 * @(#)ContractService.java
 * 
 *                          Copyright scal.All rights reserved. This software is
 *                          the XXX system.
 * 
 * @Version: 1.0
 * @JDK: jdk jdk1.6.0_10
 * @Module: Scal.PIMS
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2013年12月18日		周波                     Created
 **********************************************
 */

package com.scal.PIMS.service;

import java.util.List;

import com.scal.PIMS.dao.ContractDAO;
import com.scal.PIMS.model.Contract;

/**
 * Class description goes here.
 * 
 * @author ZhouBo
 * @since 2013年12月18日
 */
public interface ContractService {
    public List<Contract> findAll(int projectId);

    public void save(Contract contract);

    public void update(Contract contract);

    public Contract findContractById(int id);

    public List<Contract> pageList(int currPage, int projectId, int flag);

    public int getPageCount(int currPage, int projectId, int flag);
}
