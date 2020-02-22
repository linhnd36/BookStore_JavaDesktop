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
import linhnd.dtos.BookInBuildDTO;

/**
 *
 * @author Duc Linh
 */
public class BookInBuildDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public BookInBuildDAO() {
    }
    
    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public boolean insertBookInBuild(BookInBuildDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT dbo.BookinBuild\n"
                    + "VALUES  ( ?, \n"
                    + "          ?, \n"
                    + "          ?  \n"
                    + "          )";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getBookID() );
            preStm.setString(2, dto.getBuildID());
            preStm.setString(3, dto.getQuantity());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
