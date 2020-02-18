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
import linhns.conns.Myconnection;

/**
 *
 * @author Duc Linh
 */
public class UserDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public UserDAO() {
    }
    
    private void closeConnection() throws Exception{
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
    public String checkLoginUser(String userId, String password) throws Exception{
        String role = "";
        try {
            String sql = "SELECT roleUser FROM dbo.Users WHERE userID = ? AND pass = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userId);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("roleUser");
            }
        }finally{
            closeConnection();
        }
        return role;
    }
    
}
