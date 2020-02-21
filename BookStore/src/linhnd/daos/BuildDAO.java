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

/**
 *
 * @author Duc Linh
 */
public class BuildDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public BuildDAO() {
    }
    
    private void closeConnection() throws Exception{
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
}
