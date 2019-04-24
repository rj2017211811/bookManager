package dao;

import java.util.List;

import bean.BorrowSituation;

public interface BorSituationDao {
	List<BorrowSituation> searchAll() throws Exception;
	//按用户账号查找图书信息（主要是用户查询个人信息用）
	List<BorrowSituation> searchByUId(String userId) throws Exception;
	
}
