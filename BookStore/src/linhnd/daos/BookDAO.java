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
public class BookDAO implements Serializable {

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

    public List<BookDTO> getAllBook() throws Exception {
        List<BookDTO> listBook = null;
        String bookID, titleBook, author, desBook, price, category, imagerName;
        BookDTO dto = null;
        try {
            String sql = "SELECT bookID,titleBook,imagerName,descriptionBook,price,author,category FROM dbo.Books WHERE quantityBook > 0 AND statusBook = 'ready'";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            listBook = new ArrayList<>();
            while (rs.next()) {
                bookID = rs.getString("bookID");
                titleBook = rs.getString("titleBook");
                imagerName = rs.getString("imagerName");
                desBook = rs.getString("descriptionBook");
                price = rs.getString("price");
                author = rs.getString("author");
                category = rs.getString("category");
                dto = new BookDTO(bookID, titleBook, author, desBook, imagerName, price, category);
                listBook.add(dto);
            }
        } finally {
            closeConnection();
        }
        return listBook;
    }

    public List<BookDTO> searchBookByUser(String textSearch) throws Exception {
        List<BookDTO> result = null;
        BookDTO dto = null;
        String bookID, titleBook, author, desBook, price, category, imagerName;
        try {
            String sql = "SELECT bookID,titleBook,imagerName,descriptionBook,price,author,category "
                    + "FROM dbo.Books WHERE quantityBook > 0 AND statusBook = 'ready' AND (titleBook LIKE ? OR category LIKE ? )";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + textSearch + "%");
            preStm.setString(2, "%" + textSearch + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                bookID = rs.getString("bookID");
                titleBook = rs.getString("titleBook");
                imagerName = rs.getString("imagerName");
                desBook = rs.getString("descriptionBook");
                price = rs.getString("price");
                author = rs.getString("author");
                category = rs.getString("category");
                dto = new BookDTO(bookID, titleBook, author, desBook, imagerName, price, category);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
