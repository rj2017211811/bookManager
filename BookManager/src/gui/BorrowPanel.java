package gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.BookDao;
import dao.BookDaoImpl;
import dao.BorSituationDaoImpl;
import dao.UserDaoImpl;
import service.BookService;
import service.BookServiceImpl;
import service.BorService;
import service.BorServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class BorrowPanel extends RefreshPal {
	private InformationPal bookInfoPal;
	private List<String> lblItemNames;	
	private List<JComponent> cptItems;	
	private List<JButton> btnCommond;
	private BorService service;
	public BorrowPanel()
	{
		 lblItemNames=new ArrayList<String>();
		 lblItemNames.add("图书编号");
		 lblItemNames.add("借阅书籍");
		 lblItemNames.add("借阅时间");		
		 lblItemNames.add("归还时间");
		 
		 lblItemNames.add("状态");
		 lblItemNames.add("借阅者id");

		 cptItems=new ArrayList<JComponent>();
		 for(int i = 0; i<6;i++) {
				JTextField t =new JTextField(10);
			  t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}	
			
		 btnCommond=new ArrayList<JButton>();
		 JTable tblInfo=new JTable();
		 try {
			bookInfoPal=new InformationPal(lblItemNames,cptItems,btnCommond,1,0,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.add( bookInfoPal);
		 service=new BorServiceImpl(new BorSituationDaoImpl());	 
		fresh();
	}


	@Override
	public void fresh() {
		bookInfoPal.freshTable(service.searchAll());

	}

}
