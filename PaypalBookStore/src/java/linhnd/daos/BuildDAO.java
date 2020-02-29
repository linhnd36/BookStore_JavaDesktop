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
import linhnd.conn.Myconnection;

/**
 *
 * @author Duc Linh
 */
public class BuildDAO implements Serializable {

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
    public boolean updateStatusBuildOnline(String buildID) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE dbo.Builds SET paymentOnlineStatus = ? WHERE buildID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "checked");
            preStm.setString(2, buildID);
            check = preStm.executeUpdate() > 0;
        }finally{
            closeConnection();
        }
        return check;
    }
}
