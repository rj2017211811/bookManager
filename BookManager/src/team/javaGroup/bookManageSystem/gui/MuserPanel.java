package team.javaGroup.bookManageSystem.gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.BookDao;
import team.javaGroup.bookManageSystem.dao.BookDaoImpl;
import team.javaGroup.bookManageSystem.dao.MuserDaoImpl;
import team.javaGroup.bookManageSystem.service.BookService;
import team.javaGroup.bookManageSystem.service.BookServiceImpl;
import team.javaGroup.bookManageSystem.service.MuserService;
import team.javaGroup.bookManageSystem.service.MuserServiceImpl;

@SuppressWarnings({ "serial", "unused" })
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
		 lblItemNames.add("����");
		 lblItemNames.add("�û���");
		 lblItemNames.add("��������");	 
		 cptItems=new ArrayList<JComponent>();
		 for(int i = 0; i<4;i++) {
				JTextField t =new JTextField(20);
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}	 
		 btnCommond=new ArrayList<JButton>();
		 JButton btnSearch=new JButton("��ѯ�û�");

		 JButton btnAppend=new JButton("����û�");
		 
		 JButton btnDelete=new JButton("ɾ���û�");
		 
		 JButton btnRefresh=new JButton("ˢ��");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnSearch);
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnAppend);
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnDelete);
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnRefresh);
		 btnCommond.add(btnSearch);
		 btnCommond.add(btnAppend);
		 btnCommond.add(btnDelete);
		 btnCommond.add(btnRefresh);
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
		if(e.getActionCommand().equals("��ѯ�û�")) {
			String userName=((JTextField)cptItems.get(2)).getText();
			String name=((JTextField)cptItems.get(1)).getText();
			if((userName==null||userName.equals(""))&&(name==null||name.equals(""))) {
				JOptionPane.showMessageDialog(null,"�������û���������!","��ʾ",JOptionPane.WARNING_MESSAGE);
			}else if(userName!=null&&!userName.equals("")) {
				User u=service.SearchLikename(userName);	
				if(u!=null) {
					((JTextField)cptItems.get(0)).setText(String.valueOf(u.getUserId()));
					((JTextField)cptItems.get(1)).setText(u.getName());
					((JTextField)cptItems.get(2)).setText(u.getUserName());
					((JTextField)cptItems.get(3)).setText(String.valueOf(u.getBorrowbooks()));
					bookInfoPal.freshTable(service.searchByname2(userName));
				}else {
					JOptionPane.showMessageDialog(null, "���û������ڣ�����������!","��ʾ",JOptionPane.WARNING_MESSAGE);
					
				}
			}else if(name!=null&&!name.equals("")) {
				List<User> u=new ArrayList<User>();
				u=service.searchByName(name);
				//u.addAll(service.searchByName(name));
				
				if(!u.isEmpty()) {
					
					bookInfoPal.freshTable(service.searchByName(name));
				}else {
					JOptionPane.showMessageDialog(null, "���û������ڣ�����������!","��ʾ",JOptionPane.WARNING_MESSAGE);
				
				}
			}
	}
		else if(e.getActionCommand().equals("����û�")) {
			String name=((JTextField)cptItems.get(1)).getText();
			String userName=((JTextField)cptItems.get(2)).getText();
			if(userName!=null&&!userName.equals("")) {
				int length=userName.length();
				
				//��������ʽƥ�京����ĸ���ַ���
				String regex=".*[a-zA-Z]+.*";
				Matcher m=Pattern.compile(regex).matcher(userName);
				
				//���userName�а�����ĸ
				if(m.matches())
				{
					JOptionPane.showMessageDialog(null, "�û������ܰ�����ĸ!","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
				//���userName����201��ͷ
				else if(userName.indexOf("201")!=0)
				{
					JOptionPane.showMessageDialog(null, "�û���������201xxxx��ʽ!","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
				//���userName�ĳ��Ȳ�Ϊ7
				else if(length!=7)
				{
					JOptionPane.showMessageDialog(null, "�û������ȱ���Ϊ7!","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					User u=service.SearchLikename(userName);	
					if(u!=null) {
						JOptionPane.showMessageDialog(null, "���û��Ѵ���,����������!","��ʾ",JOptionPane.WARNING_MESSAGE);
						
					}else {
						User u1=new User(name,userName,"123456",0);
						service.adduser(u1);
						JOptionPane.showMessageDialog(null, "��ӳɹ�!");
						fresh();
					}
				}
				
			
		}else {
			JOptionPane.showMessageDialog(null,"�������û���!","��ʾ",JOptionPane.WARNING_MESSAGE);
		}			
		}
		
		else if(e.getActionCommand().equals("ɾ���û�")) {
			String userName=((JTextField)cptItems.get(2)).getText();
			if(userName!=null&&!userName.equals("")) {
				User u=service.SearchLikename(userName);	
				if(u!=null) {
					if(u.getBorrowbooks()!=0) {
						JOptionPane.showMessageDialog(null, "���û����ڽ���ͼ�飬����ɾ��!","��ʾ",JOptionPane.WARNING_MESSAGE);
						
					}else {
						
						if(service.deleteuByuserName(userName))
						{
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
							
							fresh();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��!","��ʾ",JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "���û�������,����������!","��ʾ",JOptionPane.WARNING_MESSAGE);
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "�������û���!","��ʾ",JOptionPane.WARNING_MESSAGE);
			}
	}
		
		else if(e.getActionCommand().equals("ˢ��")) {
			fresh();
			
		}
	}
	//ˢ��������б�
	public void fresh() {
		bookInfoPal.freshTable(service.searchAll());
	}
}
