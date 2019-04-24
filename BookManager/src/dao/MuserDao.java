package dao;

import java.util.List;

import bean.User;

public interface MuserDao {
	
	List<User> searchAll() throws Exception;//显示用户信息
	List<User> searchByName(String name) throws Exception;//按姓名查找用户
	public User searchByname(String userName) throws Exception;//按账户查找用户信息(主要用于添加删除用户)
	public List<User> searchByname2(String userName) throws Exception;//按账户查找用户信息(主要用于添加删除用户)
	boolean deleteByUserName(String userName) throws Exception;//按账户删除用户信息
	boolean addUser(User u) throws Exception;//添加用户
	/*boolean updateUser(User u)throws Exception;//修改用户信息(用户个人的功能)*/
	boolean JudgeUser(String userName,String code)throws Exception;//判断用户输入的账号密码是否正确
}
