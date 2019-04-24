package service;

import java.util.List;

import bean.Book;
import bean.User;

public interface BookService {
	 List<Book> searchAll();
	 int appendBook( Book book);
	 public boolean modifyBook(Book book1);
	 public boolean searchBook(Book book);
	 List<Book> searchBooks(String bookName) ;
	boolean  deleteBook(int bookId,String name);
	int lendBooks(User user,Book book);
	boolean returnBooks(User user,Book book);

}
