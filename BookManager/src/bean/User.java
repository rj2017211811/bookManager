package bean;

import java.util.List;

public class User {
	private String name;
	private String userName;
	
	private String code;
	private int userId;
	private int borrowbooks;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBorrowbooks() {
		return borrowbooks;
	}
	public void setBorrowbooks(int borrowbooks) {
		this.borrowbooks = borrowbooks;
	}
	public User(int userId,String name,String userName, String code, int borrowbooks) {
		super();
		this.name=name;
		this.userName = userName;
		this.code = code;
		this.userId = userId;
		this.borrowbooks = borrowbooks;
	}
	public User(String name,String userName, String code, int borrowbooks) {
		super();
		this.name=name;
		this.userName = userName;
		this.code = code;
		this.borrowbooks = borrowbooks;
	}
	public User(int userId,String name,String userName, String code) {
		super();
		this.name=name;
		this.userName = userName;
		this.code = code;
		this.userId = userId;
		
	}
	public User(int userId,String name,String userName, int borrowbooks) {
		super();
		this.userId = userId;
		this.name=name;
		this.userName = userName;
	
		this.borrowbooks=borrowbooks;
		
	}
	public User(String userName, String code) {
		super();

		this.userName = userName;
		this.code = code;
		
	}
	public User(String userName) {
		super();

		this.userName = userName;
	
		
	}
	
	
	public User(String name,String userName, String code) {
		super();
		this.name=name;

		this.userName = userName;
		this.code = code;
		
	}

	public User()
	{
		
	}
	public String toString()
	{
		return this.getUserId()+","+this.getName()+","+this.getUserName()+","+this.getBorrowbooks();
	}
	

}
