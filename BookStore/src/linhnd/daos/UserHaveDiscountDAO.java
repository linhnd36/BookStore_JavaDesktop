/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import linhnd.conns.Myconnection;
import linhnd.dtos.UserHaveDiscountDTO;

/**
 *
 * @author Duc Linh
 */
public class UserHaveDiscountDAO implements Serializable{
     private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public boolean deleteDiscountOfTheUser(UserHaveDiscountDTO dto ) throws Exception  {
        boolean check = false;
        try {
            String  sql = "DELETE dbo.UserHaveDiscount WHERE userID = ? AND discountID = ?";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserID());
            preStm.setString(2, dto.getDiscountID());
            check = preStm.executeUpdate() > 0;
        }finally{
            closeConnection();
        }
        return check;
    }
}
