
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DBtool;
import bean.Book;
import bean.User;



public class UserDaoImpl implements UserDao {

	@Override
	/*public boolean validateLogin(User user) throws Exception {
		boolean flag=false;
		Connection conn=DBtool.getConnection();
		ResultSet  rs;
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from user where userName='"+user.getUserName()+"' and code='"+user.getCode()+"' ");
		if(rs.next())
		{
			flag=true;
			
		}
		
		return flag;
	

	@Override*/
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

}
