package team.javaGroup.bookManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.util.DBtool;



public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> searchAll() throws Exception {
		List<Book> list=new ArrayList<Book>();
		Connection conn=DBtool.getConnection();
		ResultSet  rs;
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from book");

		
		while(rs!=null&&rs.next())
		{
	
			int id=rs.getInt(1);			
			String bookName=rs.getString(2);
			String writer=rs.getString(3);
			double price=rs.getDouble(4);
			int num=rs.getInt(5);
			
		
			Book b=new Book(id,bookName,writer,price,num);
			list.add(b);
			
		}
		rs.close();
		st.close();
		
		
		
		return list;
	}

	@Override
	public int appendBook(Book book) throws Exception {
		int flag=0;
		Connection conn=DBtool.getConnection();
		PreparedStatement pst=null;
		String sql0="select * from  book where bookName='"+book.getBookName()+"' and writer='"+book.getWriter()+"'";
		ResultSet rs=null;
		pst=conn.prepareStatement(sql0);
		rs=pst.executeQuery();
		if(rs.next()==true)
		{
			flag=-1;
			pst.close();
			return flag;
			
		}
		
		
		String sql="insert into book(bookName,writer,price) values(?,?,?)";

    	pst=conn.prepareStatement(sql);

		pst.setString(1, book.getBookName());
		pst.setString(2, book.getWriter());
		pst.setDouble(3,book.getPrice());
		int result=pst.executeUpdate();
		
		if(result==1)
		{
			
			flag=1;
			pst.close();
			
			
		}
		else
		{
			flag=0;
			pst.close();
			return flag;
			
		}
		return flag;
	

	}

	@Override
	public boolean modifyBook(Book book1) throws Exception {
		Connection conn=DBtool.getConnection();
		boolean flag=false;
		PreparedStatement pst=null;

		String sql0="select * from borrowsituation where borrowId="+book1.getBookId()+
				" and state='"+"未还"+"'";
		pst=conn.prepareStatement(sql0);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			
			rs.close();
			pst.close();
			return flag;
			
		}

		String sql="update book set bookName='"+book1.getBookName()+"' ,writer='"+book1.getWriter()
				+"' ,price="+book1.getPrice()+",num="+book1.getNum()
				+" where  id="+book1.getBookId();
		 pst=conn.prepareStatement(sql);
		int result=pst.executeUpdate();
		if(result==1)
		{
			flag=true;
		}
		return flag;
		
		

	}

	@Override
	public boolean deleteBook(int bookId,String name) throws Exception {
		Connection conn=DBtool.getConnection();
		boolean flag=false;
		PreparedStatement pst=null;
		
		String sql0="select * from borrowsituation where borrowId="+bookId+
				" and state='"+"未还"+"'";
		pst=conn.prepareStatement(sql0);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			
			rs.close();
			pst.close();
			return flag;
			
		}
		
		String sql=" delete from book where bookName='"+name+"' and id="+bookId;
		pst=conn.prepareStatement(sql);
		int result=pst.executeUpdate();
		if(result==1)
		{
			flag=true;
			
		}
		rs.close();
		pst.close();
		return flag;
		

	
	}

	@Override
	public boolean searchBook(Book book) throws Exception {
		List<Book> list=new ArrayList<Book>();
		Connection conn=DBtool.getConnection();
		PreparedStatement pst=null;
		
		
		String sql="select * from book where bookName='"+book.getBookName()+"'";
		pst=conn.prepareStatement(sql);
		ResultSet rs=null;
		rs=pst.executeQuery();
		if(rs.next())
		{
			
			return true;
			
		}
		
		return false;
		
		
	}

	@Override
	public List<Book>searchBooks(String bookName) throws Exception {
		List<Book> list=new ArrayList<Book>();
		Connection conn=DBtool.getConnection();
		String sql="select * from book where bookName like ? order by "
				+ "convert(bookName using GBK)";
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=null;
		pst.setString(1, "%"+bookName+"%");
		rs=pst.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt(1);			
			String bookNames=rs.getString(2);
			String writer=rs.getString(3);
			double price=rs.getDouble(4);
			int num=rs.getInt(5);
			
		
			Book b=new Book(id,bookNames,writer,price,num);
			list.add(b);
			
			
		}
		rs.close();
		pst.close();
		return list;
		
		
	}

public int lendBooks(User user,Book book)throws Exception {
		
		Connection conn=DBtool.getConnection();
		int flag=0;
		PreparedStatement pst;
		 int result;
		 ResultSet st=null;
		String sql0="select * from borrowsituation where bookName='"+book.getBookName()
				+"'  and  borrowId="+book.getBookId()+" and userId='"+user.getUserName()
				+"'  and state='"+"未还"+"'";
		pst=conn.prepareStatement(sql0);
	    st=pst.executeQuery();
		if(st.next())
		{
			flag=-1;
			return flag;
		}
		else
		{
			flag=1;
			
			
		}
		String sql1="update book set num=num-1 where bookName='"+book.getBookName()+"' and id="+book.getBookId()+" and num>=1";
	    pst=conn.prepareStatement(sql1);
	    result=pst.executeUpdate();
		if(result==1)
		{
			flag=1;
		}
		else
		{
			flag=0;
			return flag;
			
		}
		String sql2="update user set borrowBooks=borrowBooks+1 where userName='"+user.getUserName()+"'";
		pst=conn.prepareStatement(sql2);
		 result=pst.executeUpdate();
		 if(result==1)
			{
				flag=1;
			}
			else
			{
				flag=0;
				return flag;
			}
		
		String sql3="insert into  borrowsituation(borrowId,bookName,userId,borrowDate, returnDate, state) values(?,?,?,?,?,?) ";
		
		pst=conn.prepareStatement(sql3);
	//	pst.setInt(1,book.getBookId());
		
		pst.setInt(1, book.getBookId());
		pst.setString(2, book.getBookName());
		pst.setString(3, user.getUserName());
	
		java.sql.Date sqlDate=new java.sql.Date(new java.util.Date().getTime());
		pst.setDate(4,  sqlDate);
		
		pst.setDate(5, null);
		pst.setString(6, new String("未还"));
		
		result=pst.executeUpdate();
		 if(result==1)
			{
				flag=1;
			}
			else
			{
				flag=0;
				return flag;
			}
		 return flag;
	}

	@Override
	public boolean returnBooks(User user, Book book) throws Exception {
		
		Connection conn=DBtool.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(new java.util.Date().getTime());
		boolean flag=false;
		PreparedStatement pst;
		int result;
		String sql0="update   borrowsituation set state='"+"已还"+"',returnDate='"+sqlDate+"' where borrowId="+book.getBookId()
				+" and bookName='"+book.getBookName()
				+"'  and  userId='"+user.getUserName()+"' and state='"+"未还"+"'";
		pst=conn.prepareStatement(sql0);
		
		 result=pst.executeUpdate();
		if(result==1)
		{
			flag=true;
		}
		else
		{
			flag=false;
			return flag;
		
		}
		String sql1="update book set num=num+1 where bookName='"+
		book.getBookName()+"' and id='"+book.getBookId()+"'";
		
	    pst=conn.prepareStatement(sql1);
	    result=pst.executeUpdate();
		if(result==1)
		{
			flag=true;
		}
		else
		{
			flag=false;
			return flag;
			
		}
		String sql2="update user set borrowBooks=borrowBooks-1 where userName='"+user.getUserName()+"'";
		pst=conn.prepareStatement(sql2);
		 result=pst.executeUpdate();
		 if(result==1)
			{
				flag=true;
			}
			else
			{
				flag=false;
				return flag;
			}
		
		 return flag;
	}

	@Override
	public List<Book> searchBookById(Book book) throws Exception {
	
		Connection conn=DBtool.getConnection();
		List<Book> bookList=new ArrayList<Book>();
		String sql="select * from book where id="+book.getBookId();
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=null;
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			
			int id=rs.getInt(1);			
			String bookNames=rs.getString(2);
			String writer=rs.getString(3);
			double price=rs.getDouble(4);
			int num=rs.getInt(5);
			
		
			Book b=new Book(id,bookNames,writer,price,num);
			bookList.add(b);
			
		}
		rs.close();
		pst.close();
		return bookList;
	}
}


