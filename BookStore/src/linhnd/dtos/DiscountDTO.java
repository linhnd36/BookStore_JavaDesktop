/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Duc Linh
 */
public class DiscountDTO implements Serializable{
    private String codeDis, desDis,disID,dateDis;

    public DiscountDTO(String codeDis, String desDis, String disID) {
        this.codeDis = codeDis;
        this.desDis = desDis;
        this.disID = disID;
    }

    public DiscountDTO(String codeDis, String desDis, String disID, String dateDis) {
        this.codeDis = codeDis;
        this.desDis = desDis;
        this.disID = disID;
        this.dateDis = dateDis;
    }
    public Vector toVectorDiscount(){
        Vector v = new Vector();
        v.add(disID);
        v.add(desDis);
        v.add(codeDis);
        v.add(dateDis);
        return  v;
    }

    public String getDateDis() {
        return dateDis;
    }

    public void setDateDis(String dateDis) {
        this.dateDis = dateDis;
    }
    

    public DiscountDTO(String codeDis, String desDis) {
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
