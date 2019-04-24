package service;

import java.util.List;

import dao.BookDao;
import bean.Book;
import bean.User;

public class BookServiceImpl implements BookService {

	BookDao bookDao;
	public BookServiceImpl(BookDao bookDao)
	{
		this.setBookDao(bookDao);
	}
	
	
	public BookDao getBookDao() {
		return bookDao;
	}


	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}


	public List<Book> searchAll() {
		try {
			return bookDao.searchAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}


	@Override
	public int appendBook(Book book) {
		
	
		try {
			return bookDao.appendBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

		
	}


	@Override
	public boolean modifyBook(Book book1) {
		try {
			return bookDao.modifyBook(book1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteBook(int bookId,String name){

			try {
				return bookDao.deleteBook(bookId,name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
		

	}


	@Override
	public boolean searchBook(Book book) {
		try {
			return bookDao.searchBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}


	@Override
	public List<Book> searchBooks(String bookName) {
		// TODO Auto-generated method stub
		try {
			return bookDao.searchBooks(bookName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public int lendBooks(User user, Book book) {
		
		
			try {
				return bookDao.lendBooks(user, book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		
	}

	@Override
	public boolean returnBooks(User user, Book book) {
		
		try {
			return bookDao.returnBooks(user, book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	

}
