/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week19.beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fredrik_the_grym
 */
@Named("book")
@RequestScoped
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {
	
	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int bookId;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "PRICE")
	private int price;
	
	public Book(){
        
    }
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

