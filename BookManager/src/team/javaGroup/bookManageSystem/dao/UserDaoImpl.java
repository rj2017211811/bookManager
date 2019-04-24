
package team.javaGroup.bookManageSystem.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.util.DBtool;



public class UserDaoImpl implements UserDao {
	public boolean modifyPassword(String userName1, String password1, String password2) throws Exception {
		Connection conn=DBtool.getConnection();
		boolean flag=false;		
		String sql="update user set code='"+password2+"' where userName='"+userName1+"' and code='"+password1+"'";			
		PreparedStatement pst=conn.prepareStatement(sql);
		int result=pst.executeUpdate();		
		if(result==1)
		{
			flag=true;
		}
		pst.close();
		conn.close();
		
		return flag;
		
	}
	@Override
	public boolean judgeUser(String userName, String code) throws Exception {
		//≈–∂œ”√ªß’À∫≈∫Õ√‹¬Î
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
	public String retrievePassword(User user) throws Exception {
		Connection conn=DBtool.getConnection();
		String password=new String("");
		String sql="select * from user where   name='"+user.getName()+"' and userName='"+user.getUserName()
				+"' and  borrowBooks="+user.getBorrowbooks();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			password=rs.getString(4);
			
			
		}
		rs.close();
		st.close();
		
		return password;
	}

}
