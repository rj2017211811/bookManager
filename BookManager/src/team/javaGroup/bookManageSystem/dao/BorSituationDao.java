package team.javaGroup.bookManageSystem.dao;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.BorrowSituation;

public interface BorSituationDao {
	List<BorrowSituation> searchAll() throws Exception;
	//���û��˺Ų���ͼ����Ϣ����Ҫ���û���ѯ������Ϣ�ã�
	List<BorrowSituation> searchByUId(String userId) throws Exception;
	
}
