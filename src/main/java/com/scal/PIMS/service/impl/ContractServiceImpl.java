/**
 * @(#)ContractServiceImpl.java
 * 
 *                              Copyright scal.All rights reserved. This
 *                              software is the XXX system.
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

package com.scal.PIMS.service.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.scal.PIMS.dao.ContractDAO;
import com.scal.PIMS.dao.impl.ContractDAOImpl;
import com.scal.PIMS.model.Contract;
import com.scal.PIMS.service.ContractService;
import com.scal.PIMS.service.PagingService;

/**
 * Class description goes here.
 * 
 * @author ZhouBo
 * @since 2013年12月18日
 */
public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDao = new ContractDAOImpl();

    @Override
    public Contract findContractById(int id) {
        // TODO Auto-generated method stub
        Contract contract = contractDao.findContractById(id);
        return contract;
    }

    @Override
    public List<Contract> findAll(int projectId) {
        // TODO Auto-generated method stub
        List<Contract> list = contractDao.findAll(projectId);
        return list;
    }

    @Override
    public void save(Contract contract) {
        // TODO Auto-generated method stub
        contractDao.save(contract);
    }

    @Override
    public void update(Contract contract) {
        // TODO Auto-generated method stub
        contractDao.update(contract);
    }

    @Override
    public List<Contract> pageList(int currPage, int projectId, int flag) {
        Contract contract = new Contract();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pId", projectId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("pId");
        int pId = integer.intValue();

        return pagingService.pageListByProjectId(currPage, contract, pId);
    }

    @Override
    public int getPageCount(int currPage, int projectId, int flag) {
        Contract contract = new Contract();
        PagingService pagingService = new PagingServiceImpl();
        if (currPage == 1 && flag == 1) {
            ActionContext.getContext().getSession().put("pId", projectId);
        }
        Integer integer = (Integer) ActionContext.getContext().getSession()
                .get("pId");
        int pId = integer.intValue();

        return pagingService.getPageCountByProjectId(contract, pId);
    }

}
