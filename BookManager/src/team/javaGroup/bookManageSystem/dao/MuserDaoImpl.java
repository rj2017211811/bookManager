
package team.javaGroup.bookManageSystem.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.util.DBtool;



public class MuserDaoImpl implements MuserDao {

	@Override
	public List<User> searchAll() throws Exception {
		//显示所有信息
		List<User> user=new ArrayList<User>();
		Connection conn=DBtool.getConnection();
		ResultSet  rs;
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from user");	
		while(rs!=null&&rs.next())
		{
	
			int id=rs.getInt(1);	
			String name=rs.getString(2);
			String userName=rs.getString(3);
			String code=rs.getString(4);
			int num=rs.getInt(5);
			User u=new User(id,name,userName,num);
			user.add(u);
		}
		rs.close();
		st.close();
		return user;
	}
	@Override
	public User searchByname(String userName) throws Exception {
		//按账户查找用户
	
		User u = new User();
		u=null;
		
		Connection conn = DBtool.getConnection();
		ResultSet rs;
		
		String sql="select * from user where userName='"+userName+"'";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			int id=rs.getInt(1);	
			String name=rs.getString(2);
			String n=rs.getString(3);
			String code=rs.getString(4);
			int num=rs.getInt(5);
			u=new User(id,name,userName,num);	
		
		}
		rs.close();
		pst.close();		
		return u;
	}
	@Override
	public boolean deleteByUserName(String userName) throws Exception {
		//按账号删除用户
		boolean flag=false;
		Connection conn = DBtool.getConnection();
		Statement state = conn.createStatement();
		String sql="delete from user where userName="+userName;
		int result = state.executeUpdate(sql);
		if(result == 1) 			
			flag = true;
		state.close();				
		return flag;
	}

	@Override
	public boolean addUser(User u) throws Exception {
		//添加用户
		boolean flag=false;
		Connection coon=DBtool.getConnection();
		String sql="insert into user(name,userName,code,borrowBooks) values(?,?,?,?)";
		PreparedStatement pstmt=coon.prepareStatement(sql);
		pstmt.setString(1, u.getName());
		pstmt.setString(2, u.getUserName());
		pstmt.setString(3, u.getCode());
		pstmt.setInt(4,u.getBorrowbooks());
		int result =pstmt.executeUpdate();
		if(result==1) {
			flag=true;
		}
		pstmt.close();
		return flag;
	}

	@Override
	public boolean JudgeUser(String userName, String code) throws Exception {
		//判断用户账号和密码
		boolean flag = false;
		Connection conn = DBtool.getConnection();
		String sql = "select * from user where userName=? and code=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, code);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			flag = true;
		}
		pstmt.close();
	    return flag;
	}
	@Override
	public List<User> searchByName(String name) throws Exception {
		//按姓名查找用户（模糊查询）
		List<User> user=new ArrayList<User>();
		Connection conn=DBtool.getConnection();
		ResultSet  rs;
		Statement st=conn.createStatement();
		String sql="select * from "
				+ "user where name like '%"+name+"%'";
		rs=st.executeQuery(sql);
			while(rs.next())
			{
				int id=rs.getInt(1);	
				String n=rs.getString(2);
				String userName=rs.getString(3);
				String code=rs.getString(4);
				int num=rs.getInt(5);
				User u=new User(id,n,userName,num);
				//System.out.println(rs);
				//System.out.println(u.toString());
				user.add(u);
			}
			rs.close();
			st.close();
		return user;
	}
	@Override
	public List<User> searchByname2(String userName) throws Exception {
		List<User> user=new ArrayList<User>();

		Connection conn = DBtool.getConnection();
		ResultSet rs;
		
		String sql="select * from user where userName='"+userName+"'";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			int id=rs.getInt(1);	
			String name=rs.getString(2);
			String n=rs.getString(3);
			String code=rs.getString(4);
			int num=rs.getInt(5);
			User u=new User(id,name,userName,num);	
			user.add(u);
		
		}
		rs.close();
		pst.close();		
		return user;
	}
}
