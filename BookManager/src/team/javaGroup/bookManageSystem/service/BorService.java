package team.javaGroup.bookManageSystem.service;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.BorrowSituation;

public interface BorService {
	 List<BorrowSituation> searchAll();
	 List<BorrowSituation> searchLikeUId(String userId);//�û���ѯ�Լ��Ľ������

}
