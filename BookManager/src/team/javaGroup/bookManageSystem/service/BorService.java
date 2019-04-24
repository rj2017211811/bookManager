package team.javaGroup.bookManageSystem.service;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.BorrowSituation;

public interface BorService {
	 List<BorrowSituation> searchAll();
	 List<BorrowSituation> searchLikeUId(String userId);//用户查询自己的借阅情况

}
