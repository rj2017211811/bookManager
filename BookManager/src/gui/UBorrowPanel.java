package gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bean.BorrowSituation;
import bean.User;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.BorSituationDaoImpl;
import dao.MuserDaoImpl;
import service.BookService;
import service.BookServiceImpl;
import service.BorService;
import service.BorServiceImpl;
import service.MuserService;
import service.MuserServiceImpl;

public class UBorrowPanel extends RefreshPal implements ActionListener{
	private InformationPal bookInfoPal;
	private List<String> lblItemNames;	
	private List<JComponent> cptItems;	
	private List<JButton> btnCommond;
	private BorService service;

	public UBorrowPanel(String userName)
	{
		 lblItemNames=new ArrayList<String>();
		 lblItemNames.add("图书编号");
		 lblItemNames.add("借阅书籍");
		 lblItemNames.add("借阅时间");
		 lblItemNames.add("归还时间");
		 lblItemNames.add("状态");
		 cptItems=new ArrayList<JComponent>();
		  for(int i = 0; i<5;i++) {
				JTextField t =new JTextField(10);
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}	
		 btnCommond=new ArrayList<JButton>();	 
		 try {
			bookInfoPal=new InformationPal(lblItemNames,cptItems,btnCommond,1,0,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 this.add( bookInfoPal);
		 service=new BorServiceImpl(new BorSituationDaoImpl());		 
		 //fresh();
		 bookInfoPal.freshTable(service.searchLikeUId(userName));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fresh() {
		bookInfoPal.freshTable(service.searchAll());
		
	}
	
	
}
