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
public class UserHaveDiscountDTO implements Serializable{
    private String discountID,userID;

    public UserHaveDiscountDTO(String discountID, String userID) {
        this.discountID = discountID;
        this.userID = userID;
    }

    public String getDiscountID() {
        return discountID;
    }

    public String getUserID() {
        return userID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
}
