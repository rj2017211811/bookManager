package service;

import java.util.List;

import bean.User;

public interface MuserService {
	 List<User> searchAll();
	 List<User> searchByName(String name);//����ģ����ѯ
   User SearchLikename(String userName);//�˺�
    boolean deleteuByuserName(String userName);
 	boolean adduser(User u);
 	public List<User> searchByname2(String userName);
 	//boolean updateuser(User updatedUser);
}