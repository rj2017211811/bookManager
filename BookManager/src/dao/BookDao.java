package dao;

import java.util.List;

import bean.Book;
import bean.BorrowSituation;
import bean.User;

public interface BookDao {
	List<Book> searchAll() throws Exception;
	int appendBook( Book book) throws Exception;
	boolean modifyBook(Book book) throws Exception;
	boolean  deleteBook(int bookId,String name) throws Exception;
	boolean searchBook( Book book) throws Exception;
	List<Book> searchBooks(String bookName) throws Exception;	
	int  lendBooks(User user,Book book)throws Exception;
	boolean returnBooks(User user,Book book)throws Exception;


}
