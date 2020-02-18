/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Duc Linh
 */
public class BookDTO implements Serializable{
    private String bookId,titleBook,author,desBook,imagerName,price,quantity,category;

    public BookDTO() {
    }

    public BookDTO(String bookId, String titleBook, String author, String desBook, String imagerName, String price) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.author = author;
        this.desBook = desBook;
        this.imagerName = imagerName;
        this.price = price;
    }

    
    public Vector toVectorBookView(){
        Vector v = new Vector();
        v.add(bookId);
        v.add(titleBook);
        v.add(imagerName);
        v.add(desBook);
        v.add(price);
        v.add(author);
        return v;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesBook() {
        return desBook;
    }

    public String getImagerName() {
        return imagerName;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDesBook(String desBook) {
        this.desBook = desBook;
    }

    public void setImagerName(String imagerName) {
        this.imagerName = imagerName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
