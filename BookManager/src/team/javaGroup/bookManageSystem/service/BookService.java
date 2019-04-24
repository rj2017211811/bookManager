package team.javaGroup.bookManageSystem.service;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.User;

public interface BookService {
	 List<Book> searchAll();
	 int appendBook( Book book);
	 public boolean modifyBook(Book book1);
	 public boolean searchBook(Book book);
	 List<Book> searchBooks(String bookName) ;
	boolean  deleteBook(int bookId,String name);
	int lendBooks(User user,Book book);
	boolean returnBooks(User user,Book book);
	public List<Book> searchBookById(Book book);

}
