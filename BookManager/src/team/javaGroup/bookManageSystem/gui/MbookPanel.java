package team.javaGroup.bookManageSystem.gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.BookDao;
import team.javaGroup.bookManageSystem.dao.BookDaoImpl;
import team.javaGroup.bookManageSystem.dao.UserDaoImpl;
import team.javaGroup.bookManageSystem.service.BookService;
import team.javaGroup.bookManageSystem.service.BookServiceImpl;
import team.javaGroup.bookManageSystem.service.UserServiceImpl;

public class MbookPanel extends RefreshPal {
	private InformationPal bookInfoPal;
	private List<String> lblItemNames;	
	private List<JComponent> cptItems;	
	private List<JButton> btnCommond;
	private BookService service;
	private List<Book> bookList;
	private String bookName;
	//private int bookId;
	
	
	public MbookPanel()
	{
		
		 bookList=new ArrayList<Book>();
		 service=new BookServiceImpl(new BookDaoImpl());
		 bookList=service.searchAll();
		 lblItemNames=new ArrayList<String>();
		
		 lblItemNames.add("���");
		 lblItemNames.add("����");	
		 lblItemNames.add("����");
		 lblItemNames.add("�۸�");
		 lblItemNames.add("����");
		
		 cptItems=new ArrayList<JComponent>();
		 for(int i = 0; i<5;i++) {
				JTextField t =new JTextField(20);
				
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}	
		

		 
		 btnCommond=new ArrayList<JButton>();
		 JButton btnAppend=new JButton("����鼮");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnAppend);
		 btnAppend.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				
				String writer=((JTextField)cptItems.get(2)).getText();
			
				String bookName=((JTextField)cptItems.get(1)).getText();	
			    String strPrice=((JTextField)cptItems.get(3)).getText();	
				if(bookName.equals("")|| writer.equals("")||strPrice.equals(""))
				{
					JOptionPane.showMessageDialog(null, "�������������鼮��Ϣ(����,����,�۸�)!","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
				
				else 
				{
					Double price=Double.parseDouble(strPrice);
					int n=service.appendBook(new Book(bookName,writer,price));
					 if(n==-1)
					 {
						 JOptionPane.showMessageDialog(null, "���ʧ��,ͬһ���߲��ܳ�����ͬ���ֵ���!","��ʾ",JOptionPane.WARNING_MESSAGE);
					 }
					 else if(n==1)
					{
						JOptionPane.showMessageDialog(null, "��ӳɹ�!");
						bookList=new ArrayList<Book>();
						service=new BookServiceImpl(new BookDaoImpl());
						bookList=service.searchAll();
						fresh();
						
					}
					else if(n==0)	 
					{
						 JOptionPane.showMessageDialog(null, "���ʧ�ܣ����鼮id������!","��ʾ",JOptionPane.WARNING_MESSAGE);
					}
					 ((JTextField)cptItems.get(0)).setEditable(true);
						
					 ((JTextField)cptItems.get(4)).setEditable(true);
					
				}
				
				
	
				
			}

			 
		 });
		 JButton btnModify=new JButton("�޸��鼮");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnModify);
		 btnModify.addMouseListener(new MouseAdapter(){

			 
				@Override
				public void mouseClicked(MouseEvent arg0) {
					 
				
					 String strId=((JTextField)cptItems.get(0)).getText();
					 String strNum=((JTextField)cptItems.get(4)).getText();
		             String strPrice=((JTextField)cptItems.get(3)).getText();			
					String bookName=((JTextField)cptItems.get(1)).getText();
					
					String writer=((JTextField)cptItems.get(2)).getText();
					//�ж��ı����Ƿ�����������Ϣ
					if(strId.equals("")||strNum.equals("")||strPrice.equals("")||bookName.equals("")||writer.equals(""))
					{
						JOptionPane.showMessageDialog(null, "������������Ϣ,��ű���Ϊ��ı��!","��ʾ",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						 int id=Integer.valueOf(strId).intValue();
							Double price=Double.parseDouble(strPrice);
						
						
							
							int num=Integer.valueOf(((JTextField)cptItems.get(4)).getText()).intValue();
							
							
							if(service.modifyBook(new Book(id,bookName,writer,price,num)))
							{
								JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
								bookList=new ArrayList<Book>();
								 service=new BookServiceImpl(new BookDaoImpl());
								 bookList=service.searchAll();
								 fresh();
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ����鼮���ڽ�����,�벻Ҫ�޸��鼮��Ϣ!","��ʾ",JOptionPane.WARNING_MESSAGE);
							}
							
					}
					
					
				}

				 
			 });
		 JButton btnDelete=new JButton("ɾ���鼮");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnDelete);
		 btnDelete.addMouseListener(new MouseAdapter(){
			 

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					 
					String strId=((JTextField)cptItems.get(0)).getText();
					
					String bookName=((JTextField)cptItems.get(1)).getText();
					if(bookName.equals("")||strId.equals("") )
					{
						JOptionPane.showMessageDialog(null, "�������鼮�ı�ź�����!","��ʾ",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						int bookId=Integer.valueOf(strId).intValue();
						boolean flag=service.deleteBook(bookId,bookName);
						if(flag)
						{
							
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�!","��Ϣ",JOptionPane.PLAIN_MESSAGE);
							bookList=new ArrayList<Book>();
							 service=new BookServiceImpl(new BookDaoImpl());
							 bookList=service.searchAll();
							 fresh();
							
						}
						else if(!flag)
						{
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ����鼮���ڽ�����!","��ʾ",JOptionPane.WARNING_MESSAGE);
						}
						
					}
				
					
				}

				 
			 });
		 JButton  btnSearch1=new JButton("���ؼ��ֲ�ѯ�鼮");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnSearch1);
		 btnSearch1.addMouseListener(new MouseAdapter(){
			 
			 
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					
					String bookName=new String("");
					bookName=((JTextField)cptItems.get(1)).getText();
					
					if(bookName.equals(""))
					{
						JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ������","��ʾ",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						bookList=new ArrayList<Book>();
						service=new BookServiceImpl(new BookDaoImpl());
						bookList=service.searchBooks(bookName);
						if(bookList.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "δ��ѯ��������鼮��Ϣ","��ʾ",JOptionPane.WARNING_MESSAGE);
							
						}
						else
						{
							fresh();
							
						}
						
						
					}
					
					
						
					
				}

				 
			 });
		 JButton  btnSearch2=new JButton("����Ų�ѯ�鼮");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnSearch2);
		 btnSearch2.addMouseListener(new MouseAdapter(){
			 
			 
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					
					String strId=new String("");
					strId=((JTextField)cptItems.get(0)).getText();
					
					
					if(strId.equals(""))
					{
						JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�鼮�ı��","��ʾ",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						int id=Integer.valueOf(((JTextField)cptItems.get(0)).getText());
						
						bookList=new ArrayList<Book>();
						service=new BookServiceImpl(new BookDaoImpl());
						bookList=service.searchBookById(new Book(id));
						if(bookList.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "δ��ѯ�����鼮��Ϣ","��ʾ",JOptionPane.WARNING_MESSAGE);
							
						}
						else
						{
							fresh();
							
						}
						
						
					}
					
					
						
					
				}

				 
			 });
		JButton  btnBorrowSituation=new JButton("�������");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnBorrowSituation);
		
		btnBorrowSituation.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				BorrowGui borrowGui=new BorrowGui();
			}
			
		});	
		JButton btnExit=new JButton("��ȫ�˳�");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnExit);
		 btnExit.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					//�����˳�����
					System.exit(0);	
				}
	         });
		 JButton btnRefresh=new JButton("ˢ��");
		 team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnRefresh);
		 btnRefresh.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
			
					 bookList=new ArrayList<Book>();
					 service=new BookServiceImpl(new BookDaoImpl());
					 bookList=service.searchAll();
					 fresh();
				}
	         });
         btnCommond.add(btnAppend);
         btnCommond.add(btnDelete);
		 btnCommond.add(btnModify);
		 btnCommond.add(btnSearch1);
		 btnCommond.add(btnSearch2);
		 btnCommond.add(btnBorrowSituation);
		 btnCommond.add(btnExit);
		 btnCommond.add(btnRefresh);
		 try {
			bookInfoPal=new InformationPal(lblItemNames,cptItems,btnCommond,1,1,1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.add( bookInfoPal);
		fresh();
	}
	@Override
	public void fresh() {
		bookInfoPal.freshTable(bookList);
	}
}
