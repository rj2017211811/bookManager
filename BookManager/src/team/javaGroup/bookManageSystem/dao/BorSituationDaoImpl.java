package team.javaGroup.bookManageSystem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import team.javaGroup.bookManageSystem.bean.BorrowSituation;
import team.javaGroup.bookManageSystem.util.DBtool;

public class BorSituationDaoImpl implements BorSituationDao {

	@Override
	public List<BorrowSituation> searchAll() throws Exception {
		Connection conn=DBtool.getConnection();
		ResultSet rs=null;
		List<BorrowSituation> borrowList=new ArrayList<BorrowSituation>();
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from BorrowSituation");
		while(rs.next())
		{
			int id=rs.getInt(1);
			int borrowId=rs.getInt(2);
			String bookName=rs.getString(3);
			String userId=rs.getString(4);
			Date borrowDate=rs.getDate(5);
			Date returnDate=rs.getDate(6);
			String statue=rs.getString(7);
			BorrowSituation bs=new BorrowSituation(borrowId,bookName,userId,borrowDate,returnDate,statue);
			borrowList.add(bs);
			
		}
		rs.close();
		st.close();
				
		return borrowList;
	}

	@Override
	public List<BorrowSituation> searchByUId(String userId) throws Exception {
		List<BorrowSituation> list =new ArrayList<BorrowSituation>();
		Connection conn=DBtool.getConnection();
		ResultSet  rs;
		Statement pst=conn.createStatement();
		String sql="select * from borrowsituation where userId="+userId;
		//PreparedStatement pst=conn.prepareStatement(sql);
		rs = pst.executeQuery(sql);
		while (rs.next())
		{
			int id=rs.getInt(1);
			int borrowId=rs.getInt(2);
			String bookName=rs.getString(3);
			//String u=rs.getString(4);
			Date borrowDate=rs.getDate(5);
			Date returnDate=rs.getDate(6);
			String statue=rs.getString(7);
			BorrowSituation bs=new BorrowSituation(borrowId,bookName, borrowDate,returnDate,statue);
			//System.out.println(bs.toString());
			list.add(bs);
		}
		rs.close();
		pst.close();				
		return list;
	}


}
