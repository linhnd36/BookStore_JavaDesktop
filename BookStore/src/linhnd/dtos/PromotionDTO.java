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
public class PromotionDTO implements Serializable{
    private String codeDis, desDis,disID;

    public PromotionDTO(String codeDis, String desDis, String disID) {
        this.codeDis = codeDis;
        this.desDis = desDis;
        this.disID = disID;
    }

    public PromotionDTO(String codeDis, String desDis) {
        this.codeDis = codeDis;
        this.desDis = desDis;
    }
    

    public String getCodeDis() {
        return codeDis;
    }

    public String getDesDis() {
        return desDis;
    }

    public String getDisID() {
        return disID;
    }

    public void setCodeDis(String codeDis) {
        this.codeDis = codeDis;
    }

    public void setDesDis(String desDis) {
        this.desDis = desDis;
    }

    public void setDisID(String disID) {
        this.disID = disID;
    }
    
}
