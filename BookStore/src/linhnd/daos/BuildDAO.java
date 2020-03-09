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
import java.util.ArrayList;
import java.util.List;
import linhnd.conns.Myconnection;
import linhnd.dtos.BuildDTO;

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

    public boolean insertBuild(BuildDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT dbo.Builds\n"
                    + "VALUES  ( ? , \n"
                    + "          ? , \n"
                    + "          ? , \n"
                    + "          ? , \n"
                    + "          ? ,\n"
                    + "          ? , \n"
                    + "          ?,? \n"
                    + "        )";
            conn = Myconnection.getMyConnection();
            preStm =  conn.prepareStatement(sql);
            preStm.setString(1, dto.getBuildId());
            preStm.setString(2, dto.getDateBuild());
            preStm.setString(3, dto.getTotalBuild());
            preStm.setString(4, dto.getPayment());
            preStm.setString(5, dto.getStatusBuild());
            preStm.setString(6, dto.getDesBuild());
            preStm.setString(7, dto.getUserD());
            preStm.setString(8, "done");
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
        public boolean insertBuildPaymentOnline(BuildDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT dbo.Builds\n"
                    + "VALUES  ( ? , \n"
                    + "          ? , \n"
                    + "          ? , \n"
                    + "          ? , \n"
                    + "          ? ,\n"
                    + "          ? , \n"
                    + "          ?,? \n"
                    + "        )";
            conn = Myconnection.getMyConnection();
            preStm =  conn.prepareStatement(sql);
            preStm.setString(1, dto.getBuildId());
            preStm.setString(2, dto.getDateBuild());
            preStm.setString(3, dto.getTotalBuild());
            preStm.setString(4, dto.getPayment());
            preStm.setString(5, dto.getStatusBuild());
            preStm.setString(6, dto.getDesBuild());
            preStm.setString(7, dto.getUserD());
            preStm.setString(8, dto.getPaymentOnlineStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<BuildDTO> getListBuildOnline(String userID) throws Exception {
        List<BuildDTO> result = new ArrayList<>();
        try {
            String sql = " SELECT buildID,paymentOnlineStatus FROM dbo.Builds WHERE userID = ? AND paymentOnlineStatus = ? OR paymentOnlineStatus = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, "checked");
            preStm.setString(3, "checking");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String buildId = rs.getString("buildID");
                String paymentOnlineStatus = rs.getString("paymentOnlineStatus");
                BuildDTO dto = new BuildDTO(buildId, paymentOnlineStatus);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
