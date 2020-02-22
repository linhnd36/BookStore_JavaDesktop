/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Duc Linh
 */
public class BookInBuildDTO implements Serializable {

    private String bookID,buildID,quantity;

    public BookInBuildDTO(String bookID, String buildID, String quantity) {
        this.bookID = bookID;
        this.buildID = buildID;
        this.quantity = quantity;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBuildID() {
        return buildID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBuildID(String buildID) {
        this.buildID = buildID;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
}
