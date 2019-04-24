package team.javaGroup.bookManageSystem.service;

import java.util.ArrayList;
import java.util.List;

import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.MuserDao;

public class MuserServiceImpl implements MuserService {
	MuserDao userdao;
	public MuserDao getUserdao() {
		return userdao;
	}


	public void setUserdao(MuserDao userdao) {
		this.userdao = userdao;
	}
	


	public MuserServiceImpl(MuserDao userdao) {
		super();
		this.userdao = userdao;
	}
	


	@Override
	public List<User> searchAll() {
		
		try {
			return userdao.searchAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

	@Override
	public boolean deleteuByuserName(String userName) {
		try {
			return userdao.deleteByUserName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean adduser(User u) {
		try {
			return userdao.addUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<User> searchByName(String name) {
		try {
			return userdao.searchByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public User SearchLikename(String userName) {
	
		try {
			return userdao.searchByname(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<User> searchByname2(String userName) {
	
		try {
			return userdao.searchByname2(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/*@Override
	public boolean updateuser(User updatedUser) {
		try {
			return userdao.updateUser(updatedUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/


}
