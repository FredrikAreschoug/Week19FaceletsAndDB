/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week19.controls;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import week19.beans.Book;

/**
 *
 * @author fredrik_the_grym
 */
@Named("bookController")
@RequestScoped
public class BookController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Book book;
	
	@PersistenceUnit(unitName="booktablesPU")
	private EntityManagerFactory emf;
	
	@Resource
	private UserTransaction ut;
	
	public String saveBook(){
            
		System.out.println(book.getTitle());
		String reurnStmt = "";
		
		EntityManager em = emf.createEntityManager();
		
		Book tmpBook = new Book();
		
                tmpBook.setBookId(15);
		tmpBook.setTitle(book.getTitle());
		tmpBook.setAuthor(book.getAuthor());
		tmpBook.setPrice(book.getPrice());
		
		try {
			ut.begin();
			em.persist(tmpBook);
			ut.commit();
		} catch (Exception e) {
			e.printStackTrace();
			reurnStmt = "error";
		}
		
		System.out.println(reurnStmt);
		
		return "list";
	}
	
	public List<Book> getBookList(){
		System.out.println("list");
		List<Book> books;
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Book s");
	    books = query.getResultList();
		
		return books;         
	}
	

}