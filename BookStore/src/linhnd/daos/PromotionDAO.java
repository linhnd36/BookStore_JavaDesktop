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
import linhnd.dtos.PromotionDTO;
import linhns.conns.Myconnection;

/**
 *
 * @author Duc Linh
 */
public class PromotionDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public PromotionDAO() {
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
    
    public PromotionDTO getDiscountPro(String codePro) throws Exception{
        String desDis,codeDis;
        PromotionDTO dto = null;
        try {
            String sql = "SELECT descriptionDiscount,codeDiscount FROM dbo.Discount WHERE discountID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, codePro);
            rs = preStm.executeQuery();
            if (rs.next()) {
                desDis = rs.getString("descriptionDiscount");
                codeDis = rs.getString("codeDiscount");
                dto = new PromotionDTO(codeDis, desDis);
            }   
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean checkDiscount(String userID,String codeDis) throws Exception{
        boolean check = false;
        try {
            String sql = "SELECT userID FROM dbo.UserHaveDiscount WHERE userID = ? AND discountID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, codeDis);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        }finally{
            closeConnection();
        }
        return check;
    }
    
    
}
