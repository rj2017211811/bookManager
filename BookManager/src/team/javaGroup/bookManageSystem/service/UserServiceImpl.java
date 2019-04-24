package team.javaGroup.bookManageSystem.service;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.UserDao;

public class UserServiceImpl implements UserService {
	UserDao userdao;
	

	public UserDao getUserdao() {
		return userdao;
	}


	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	


	public UserServiceImpl(UserDao userdao) {
		super();
		this.userdao = userdao;
	}

	/*@Override
	public boolean validateLogin(User user) {
		try {
			return userdao.validateLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override*/
	public boolean modifyPassword(String userName1, String password1, String password2) {
	
		try {
			return userdao.modifyPassword(userName1, password1, password2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean judgeUser(String userName, String code) {
		try {
			return userdao.judgeUser(userName, code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public String retrievePassword(User user) {
		String str=new String("");
		try {
			str = userdao.retrievePassword( user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
			
	
		
	}

}
