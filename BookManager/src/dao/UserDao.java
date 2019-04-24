package dao;

import bean.User;

public interface UserDao {
//	boolean validateLogin(User user) throws Exception;//检验用户登录
	boolean modifyPassword(String userName1,String password1,String password2) throws Exception;//用户修改密码
	boolean judgeUser(String userName,String code)throws Exception;//判断用户输入的账号密码是否正确
}
