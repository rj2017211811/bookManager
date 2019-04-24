package gui;


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

import bean.Book;
import bean.User;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.UserDaoImpl;
import service.BookService;
import service.BookServiceImpl;
import service.UserServiceImpl;

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
		
		 lblItemNames.add("编号");
		 lblItemNames.add("书名");	
		 lblItemNames.add("作者");
		 lblItemNames.add("价格");
		 lblItemNames.add("数量");
		
		 cptItems=new ArrayList<JComponent>();
		 for(int i = 0; i<6;i++) {
				JTextField t =new JTextField(20);
				t.addFocusListener(new FocusListener() {
					public void focusGained(FocusEvent e) {
						
						
					}
					public void focusLost(FocusEvent e) {
						bookName=new String(t.getText());
						System.out.println(bookName);
			
						
					}
					
				});
				
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
				 
				/* ((JTextField)cptItems.get(2)).setEditable(false);
				 ((JTextField)cptItems.get(3)).setEditable(false);*/
			}	
		
		 
			/*DefaultListModel<String> model = new DefaultListModel<String>();
			JList<String> listPhone = new JList<String>(model);		
			
			cptItems.add(new JScrollPane(listPhone) {
				@Override
			      public Dimension getPreferredSize() {
			        return new Dimension(200, 60);
			      }
			});	*/
		 
		 btnCommond=new ArrayList<JButton>();
		 JButton btnAppend=new JButton("添加书籍");
		 btnAppend.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				
				String writer=((JTextField)cptItems.get(2)).getText();
			
				String bookName=((JTextField)cptItems.get(1)).getText();	
			    String strPrice=((JTextField)cptItems.get(3)).getText();	
				if(bookName.equals("")|| writer.equals("")||strPrice.equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入完整的书籍信息(书名,作者,价格)!","提示",JOptionPane.WARNING_MESSAGE);
				}
				
				else 
				{
					Double price=Double.parseDouble(strPrice);
					int n=service.appendBook(new Book(bookName,writer,price));
					 if(n==-1)
					 {
						 JOptionPane.showMessageDialog(null, "添加失败,同一作者不能出版相同名字的书!","提示",JOptionPane.WARNING_MESSAGE);
					 }
					 else if(n==1)
					{
						JOptionPane.showMessageDialog(null, "添加成功!");
						bookList=new ArrayList<Book>();
						service=new BookServiceImpl(new BookDaoImpl());
						bookList=service.searchAll();
						fresh();
						
					}
					else if(n==0)	 
					{
						 JOptionPane.showMessageDialog(null, "添加失败，该书籍id不存在!","提示",JOptionPane.WARNING_MESSAGE);
					}
					 ((JTextField)cptItems.get(0)).setEditable(true);
						
					 ((JTextField)cptItems.get(4)).setEditable(true);
					
				}
				
				
	
				
			}

			 
		 });
		 JButton btnModify=new JButton("修改书籍");
		 btnModify.addMouseListener(new MouseAdapter(){

			 
				@Override
				public void mouseClicked(MouseEvent arg0) {
					 
				
					 String strId=((JTextField)cptItems.get(0)).getText();
					 String strNum=((JTextField)cptItems.get(4)).getText();
		             String strPrice=((JTextField)cptItems.get(3)).getText();			
					String bookName=((JTextField)cptItems.get(1)).getText();
					
					String writer=((JTextField)cptItems.get(2)).getText();
					//判断文本域是否输入完整信息
					if(strId.equals("")||strNum.equals("")||strPrice.equals("")||bookName.equals("")||writer.equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入完整信息,编号必须为书的编号!","提示",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						 int id=Integer.valueOf(strId).intValue();
							Double price=Double.parseDouble(strPrice);
						
						
							
							int num=Integer.valueOf(((JTextField)cptItems.get(4)).getText()).intValue();
							
							
							if(service.modifyBook(new Book(id,bookName,writer,price,num)))
							{
								JOptionPane.showMessageDialog(null, "修改成功!");
								bookList=new ArrayList<Book>();
								 service=new BookServiceImpl(new BookDaoImpl());
								 bookList=service.searchAll();
								 fresh();
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "修改失败，该书籍正在借阅中,请不要修改书籍信息!","提示",JOptionPane.WARNING_MESSAGE);
							}
							
					}
					
					
				}

				 
			 });
		 JButton btnDelete=new JButton("删除书籍");
		 btnDelete.addMouseListener(new MouseAdapter(){
			 

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					 
					String strId=((JTextField)cptItems.get(0)).getText();
					
					String bookName=((JTextField)cptItems.get(1)).getText();
					if(bookName.equals("")||strId.equals("") )
					{
						JOptionPane.showMessageDialog(null, "请输入书籍的编号和书名!","提示",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						int bookId=Integer.valueOf(strId).intValue();
						boolean flag=service.deleteBook(bookId,bookName);
						if(flag)
						{
							
							JOptionPane.showMessageDialog(null, "删除成功!","消息",JOptionPane.PLAIN_MESSAGE);
							bookList=new ArrayList<Book>();
							 service=new BookServiceImpl(new BookDaoImpl());
							 bookList=service.searchAll();
							 fresh();
							
						}
						else if(!flag)
						{
							JOptionPane.showMessageDialog(null, "删除失败，该书籍正在借阅中!","提示",JOptionPane.WARNING_MESSAGE);
						}
						
					}
				
					
				}

				 
			 });
		 JButton  btnSearch=new JButton("查询书籍");
		 btnSearch.addMouseListener(new MouseAdapter(){
			 
			 
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					
					String bookName=new String("");
					bookName=((JTextField)cptItems.get(1)).getText();
					if(bookName.equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入您要查询的书名","提示",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						bookList=new ArrayList<Book>();
						service=new BookServiceImpl(new BookDaoImpl());
						bookList=service.searchBooks(bookName);
						fresh();
						
					}
					
					
						
					
				}

				 
			 });
		JButton  btnBorrowSituation=new JButton("借阅情况");
		
		btnBorrowSituation.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				BorrowGui borrowGui=new BorrowGui();
			}
			
		});	
		JButton btnExit=new JButton("安全退出");
		 btnExit.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					//正常退出程序
					System.exit(0);	
				}
	         });
		 JButton btnRefresh=new JButton("刷新");
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
		 btnCommond.add(btnSearch);
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
