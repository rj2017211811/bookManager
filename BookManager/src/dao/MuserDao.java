package dao;

import java.util.List;

import bean.User;

public interface MuserDao {
	
	List<User> searchAll() throws Exception;//��ʾ�û���Ϣ
	List<User> searchByName(String name) throws Exception;//�����������û�
	public User searchByname(String userName) throws Exception;//���˻������û���Ϣ(��Ҫ�������ɾ���û�)
	public List<User> searchByname2(String userName) throws Exception;//���˻������û���Ϣ(��Ҫ�������ɾ���û�)
	boolean deleteByUserName(String userName) throws Exception;//���˻�ɾ���û���Ϣ
	boolean addUser(User u) throws Exception;//����û�
	/*boolean updateUser(User u)throws Exception;//�޸��û���Ϣ(�û����˵Ĺ���)*/
	boolean JudgeUser(String userName,String code)throws Exception;//�ж��û�������˺������Ƿ���ȷ
}
