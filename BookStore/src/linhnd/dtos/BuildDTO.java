/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;

/**
 *
 * @author Duc Linh
 */
public class BuildDTO implements Serializable{
    private String buildId,dateBuild,totalBuild,payment,statusBuild,desBuild,userD;

    public BuildDTO(String buildId, String dateBuild, String totalBuild, String payment, String statusBuild, String desBuild, String userD) {
        this.buildId = buildId;
        this.dateBuild = dateBuild;
        this.totalBuild = totalBuild;
        this.payment = payment;
        this.statusBuild = statusBuild;
        this.desBuild = desBuild;
        this.userD = userD;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public void setDateBuild(String dateBuild) {
        this.dateBuild = dateBuild;
    }

    public void setTotalBuild(String totalBuild) {
        this.totalBuild = totalBuild;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setStatusBuild(String statusBuild) {
        this.statusBuild = statusBuild;
    }

    public void setDesBuild(String desBuild) {
        this.desBuild = desBuild;
    }

    public void setUserD(String userD) {
        this.userD = userD;
    }

    public String getBuildId() {
        return buildId;
    }

    public String getDateBuild() {
        return dateBuild;
    }

    public String getTotalBuild() {
        return totalBuild;
    }

    public String getPayment() {
        return payment;
    }

    public String getStatusBuild() {
        return statusBuild;
    }

    public String getDesBuild() {
        return desBuild;
    }

    public String getUserD() {
        return userD;
    }
    
    
    
}
