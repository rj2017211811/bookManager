package gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import bean.User;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.MuserDaoImpl;
import service.BookService;
import service.BookServiceImpl;
import service.MuserService;
import service.MuserServiceImpl;

public class MuserPanel extends RefreshPal implements ActionListener{
	private InformationPal bookInfoPal;
	private List<String> lblItemNames;	
	private List<JComponent> cptItems;	
	private List<JButton> btnCommond;
	private MuserService service;
	public JTextField txtOne;
	public JTextField txtTwo;
	public JTextField txtThree;
	public JPasswordField txtFour;
	public JTextField txtFive;
	public MuserPanel()
	{
		 lblItemNames=new ArrayList<String>();
		 lblItemNames.add("id");
		 lblItemNames.add("姓名");
		 lblItemNames.add("用户名");
		 lblItemNames.add("借书数量");	 
		 cptItems=new ArrayList<JComponent>();
		 for(int i = 0; i<4;i++) {
				JTextField t =new JTextField(10);
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}	
		 
		 ((JTextField)cptItems.get(0)).setEditable(false);
		 ((JTextField)cptItems.get(3)).setEditable(false);
		 
		 btnCommond=new ArrayList<JButton>();
		 btnCommond.add(new JButton("查询用户"));
		 btnCommond.add(new JButton("添加用户"));
		 btnCommond.add(new JButton("删除用户"));
		
		 btnCommond.add(new JButton("刷新"));
		 for(int i=0;i<btnCommond.size();i++){
			 btnCommond.get(i).addActionListener(this);
		 }
		 try {
			bookInfoPal=new InformationPal(lblItemNames,cptItems,btnCommond,1,1,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 this.add( bookInfoPal);
		 service=new MuserServiceImpl(new MuserDaoImpl());		 
		 fresh();
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("查询用户")) {
			String userName=((JTextField)cptItems.get(2)).getText();
			String name=((JTextField)cptItems.get(1)).getText();
			if((userName==null||userName.equals(""))&&(name==null||name.equals(""))) {
				JOptionPane.showMessageDialog(null,"请输入用户名或姓名!");
			}else if(userName!=null&&!userName.equals("")) {
				User u=service.SearchLikename(userName);	
				if(u!=null) {
					((JTextField)cptItems.get(0)).setText(String.valueOf(u.getUserId()));
					((JTextField)cptItems.get(1)).setText(u.getName());
					((JTextField)cptItems.get(2)).setText(u.getUserName());
				//	((JTextField)cptItems.get(3)).setText(u.getCode());
					((JTextField)cptItems.get(3)).setText(String.valueOf(u.getBorrowbooks()));
					bookInfoPal.freshTable(service.searchByname2(userName));
				}else {
					JOptionPane.showMessageDialog(null, "该用户不存在，请重新输入!");
					Fresh();
				}
			}else if(name!=null&&!name.equals("")) {
				List<User> u=new ArrayList<User>();
				u=service.searchByName(name);
				//u.addAll(service.searchByName(name));
				
				if(!u.isEmpty()) {
					Fresh();
					bookInfoPal.freshTable(service.searchByName(name));
				}else {
					JOptionPane.showMessageDialog(null, "该用户不存在，请重新输入!");
					Fresh();
				}
			}
	}
		else if(e.getActionCommand().equals("添加用户")) {
			String name=((JTextField)cptItems.get(1)).getText();
			String userName=((JTextField)cptItems.get(2)).getText();
			if(userName!=null&&!userName.equals("")) {
				User u=service.SearchLikename(userName);	
				if(u!=null) {
					JOptionPane.showMessageDialog(null, "该用户已存在,请重新输入!");
					Fresh();
				}else {
					User u1=new User(name,userName,"123456",0);
					service.adduser(u1);
					JOptionPane.showMessageDialog(null, "添加成功!");
					Fresh();
					fresh();
				}
			
		}else {
			JOptionPane.showMessageDialog(null,"请输入用户名!");
		}			
		}
		
		else if(e.getActionCommand().equals("删除用户")) {
			String userName=((JTextField)cptItems.get(2)).getText();
			if(userName!=null&&!userName.equals("")) {
				User u=service.SearchLikename(userName);	
				if(u!=null) {
					if(u.getBorrowbooks()!=0) {
						JOptionPane.showMessageDialog(null, "该用户正在借阅图书，不能删除!");
						Fresh();
					}else {
						service.deleteuByuserName(userName);
						JOptionPane.showMessageDialog(null, "删除成功!");
						Fresh();
						fresh();
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "该用户不存在,请重新输入!");
					Fresh();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "该输入用户名!");
			}
	}
		
		else if(e.getActionCommand().equals("刷新")) {
			fresh();
			Fresh();
		}
	}
	@Override
	//刷新下面的列表
	public void fresh() {
		bookInfoPal.freshTable(service.searchAll());
		
	}
	
	//刷新表格，没完成一次操作都使其为空
	public void Fresh() {
		for(int i=0;i<5;i++) {
			((JTextField)cptItems.get(i)).setText("");
		}
	}
}
