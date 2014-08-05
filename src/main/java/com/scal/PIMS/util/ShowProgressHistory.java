/**
 * @(#)ShowProgressHistory.java
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
 *  1     2014年1月28日		 jonathan       Created
 **********************************************
 */

package com.scal.PIMS.util;

import com.scal.PIMS.model.ProjectInfo;
import com.scal.PIMS.model.ProjectProgress;
import com.scal.PIMS.model.ProjectProgressHistory;

/**
 * Class description goes here.
 * 
 * @author jonathan
 * @since 2014年1月28日
 */
public class ShowProgressHistory {
    private ProjectProgress proProgress;
    private ProjectProgressHistory ppHistory;
    private ProjectInfo proInfo;

    public ProjectProgress getProProgress() {
        return proProgress;
    }

    public void setProProgress(ProjectProgress proProgress) {
        this.proProgress = proProgress;
    }

    public ProjectProgressHistory getPpHistory() {
        return ppHistory;
    }

    public void setPpHistory(ProjectProgressHistory ppHistory) {
        this.ppHistory = ppHistory;
    }

    public ProjectInfo getProInfo() {
        return proInfo;
    }

    public void setProInfo(ProjectInfo proInfo) {
        this.proInfo = proInfo;
    }

}
