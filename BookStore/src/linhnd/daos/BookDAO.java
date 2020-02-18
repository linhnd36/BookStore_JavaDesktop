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
import linhnd.dtos.BookDTO;
import linhns.conns.Myconnection;

/**
 *
 * @author Duc Linh
 */
public class BookDAO implements Serializable{
        private Connection conn = null;
        private PreparedStatement preStm = null;
        private ResultSet rs = null;
        
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
        
        public List<BookDTO> getAllBook() throws Exception{
            List<BookDTO> listBook = null;
            String bookID, titleBook, author, desBook, price, category,imagerName ;
            BookDTO dto = null;
            try {
                String sql = "SELECT bookID,titleBook,imagerName,descriptionBook,price,author FROM dbo.Books WHERE quantityBook > 0 AND statusBook = 'ready'";
                conn = Myconnection.getMyConnection();
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
                listBook = new ArrayList<>();
                while(rs.next()){
                    bookID = rs.getString("bookID");
                    titleBook = rs.getString("titleBook");
                    imagerName = rs.getString("imagerName");
                    desBook = rs.getString("descriptionBook");
                    price = rs.getString("price");
                    author = rs.getString("author");
                    dto = new BookDTO(bookID, titleBook, author, desBook, imagerName, price);
                    listBook.add(dto);        
                }        
            }finally{
                closeConnection();
            }
            return listBook;
        }
}
