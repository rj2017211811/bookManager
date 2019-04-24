package team.javaGroup.bookManageSystem.service;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.BorrowSituation;
import team.javaGroup.bookManageSystem.dao.BorSituationDao;

public class BorServiceImpl implements BorService {
	private BorSituationDao borrowSitiationDao;
	

	public BorSituationDao getBorrowSitiationDao() {
		return borrowSitiationDao;
	}


	public void setBorrowSitiationDao(BorSituationDao borrowSitiationDao) {
		this.borrowSitiationDao = borrowSitiationDao;
	}
	


	public BorServiceImpl(BorSituationDao borrowSitiationDao) {
		super();
		this.borrowSitiationDao = borrowSitiationDao;
	}


	@Override
	public List<BorrowSituation> searchAll() {
		try {

			return borrowSitiationDao.searchAll();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}
	
	@Override
	public List<BorrowSituation> searchLikeUId(String userId) {
		try {
			return borrowSitiationDao.searchByUId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}


}
