package team.javaGroup.bookManageSystem.bean;

public class Book {
	private String bookName;
	private String writer;
	private double price;
	private int bookId;
	
	private int num;
	

	

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Book(	String bookName)
	{
		
		this.bookName=bookName;
	}

	public Book(int bookId,String bookName, String writer, double price, 
			int num) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.price = price;
		this.bookId = bookId;
		this.num = num;
	}
	public Book(int bookId,String bookName) {
		super();
		this.bookName = bookName;

		this.bookId = bookId;

	}
	public Book(int bookId) {
		super();


		this.bookId = bookId;

	}
	
	public Book(String bookName, String writer, double price) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.price = price;

	}
	public Book(){
		
	}

	public String toString()
	{
		return this.getBookId()+","+this.getBookName()+","+this.getWriter()+","+this.getPrice()+","+this.getNum();
		
	}

}
