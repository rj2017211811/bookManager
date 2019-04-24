package team.javaGroup.bookManageSystem.service;

import java.util.List;

import team.javaGroup.bookManageSystem.bean.User;



public interface UserService {
	//  boolean validateLogin(User user);
	  boolean modifyPassword(String userName1,String password1,String password2);
	  boolean judgeUser(String userName,String code);
	  String retrievePassword(User user);
}