package service;

import java.util.List;

import bean.BorrowSituation;

public interface BorService {
	 List<BorrowSituation> searchAll();
	 List<BorrowSituation> searchLikeUId(String userId);//�û���ѯ�Լ��Ľ������

}
