package service;

import java.util.List;

import bean.User;



public interface UserService {
	//  boolean validateLogin(User user);
	  boolean modifyPassword(String userName1,String password1,String password2);
	  boolean judgeUser(String userName,String code);
}