
package team.javaGroup.bookManageSystem.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.Manager;
import team.javaGroup.bookManageSystem.util.DBtool;




public class ManagerDaoImpl implements ManagerDao {


	@Override
	public boolean validateLogin(Manager manager) throws Exception {
		boolean flag=false;
		Connection conn=DBtool.getConnection();
		ResultSet  rs;
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from manager where managerName='"+manager.getManagerName()+"' and managerPassword='"+manager.getManagerPassword()+"' ");
		
		if(rs.next())
		{
			flag=true;
			
		}
		
		return flag;
	}

}
