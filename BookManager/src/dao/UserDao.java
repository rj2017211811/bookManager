package dao;

import bean.User;

public interface UserDao {
//	boolean validateLogin(User user) throws Exception;//�����û���¼
	boolean modifyPassword(String userName1,String password1,String password2) throws Exception;//�û��޸�����
	boolean judgeUser(String userName,String code)throws Exception;//�ж��û�������˺������Ƿ���ȷ
}
