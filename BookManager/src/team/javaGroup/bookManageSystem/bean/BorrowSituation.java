package team.javaGroup.bookManageSystem.bean;

import java.util.Date;

public class BorrowSituation {
	private int borrowId;
	private String userId;
	private Date borrowDate;
	private Date returnDate;
	private String state;
	private String bookName;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public BorrowSituation(int borrowId, String bookName, String userId, Date borrowDate,
			Date returnDate, String state) {
		super();
		this.borrowId = borrowId;
		this.userId = userId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.state = state;
		this.bookName = bookName;
	}
	public BorrowSituation(int borrowId, String bookName,Date borrowDate,
			Date returnDate, String state) {
		super();
		this.bookName=bookName;
		this.borrowId = borrowId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.state = state;
	}
	public String toString()
	{
		return this.getBorrowId()+","+this.getBookName()+","+this.getBorrowDate()+","
	  +this.getReturnDate()
				+","+this.getState()+","+this.getUserId();
	}

}
