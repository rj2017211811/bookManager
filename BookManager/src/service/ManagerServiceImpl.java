package service;

import java.util.List;

import dao.ManagerDao;
import dao.UserDao;
import bean.Manager;
import bean.User;

public class ManagerServiceImpl implements ManagerService {
	ManagerDao managerdao;
	
	



	public ManagerDao getUserdao() {
		return managerdao;
	}


	public void setUserdao(ManagerDao managerdao) {
		this.managerdao = managerdao;
	}
	




	public ManagerServiceImpl(ManagerDao managerdao) {
		super();
		this.managerdao = managerdao;
	}


	@Override
	public boolean validateLogin(Manager manager) {
		try {
			return managerdao.validateLogin(manager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	
}
