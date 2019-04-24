package team.javaGroup.bookManageSystem.gui;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;






import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.UserDaoImpl;
import team.javaGroup.bookManageSystem.service.UserService;
import team.javaGroup.bookManageSystem.service.UserServiceImpl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RetrivePsdGui extends JFrame {
	private UserService service;
	private String userName;
	private String name;
	private int num;
	private JTextField tfdUserName;
	private JTextField tfdName;
	private JTextField tfdNum;
	
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public void  retrivePsd()
	{
		service=new UserServiceImpl(new UserDaoImpl());
		//��Stringʵ����Ϊ���ַ�
		String userName=new String("");
		String name=new String("");
		String strNum=new String("");
		userName=tfdUserName.getText();
		 name=tfdName.getText();
		strNum= tfdNum.getText();
		 

		 if(userName.equals("")||name.equals("")||strNum.equals(""))
		 {
			 JOptionPane.showMessageDialog(null,"��������������Ϣ!");
		 }
		 else
		 {
			 num=Integer.valueOf(strNum).intValue();
			 String psd=service.retrievePassword(new User(name,userName,num));
			 if(psd==null||psd.equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"�����������Ϣ����ȷ��!");
				 
			 }
			 else
			 {
				 
				 JOptionPane.showMessageDialog(null,"�һسɹ�,��������Ϊ"+psd+"!");
				 setVisible(false);
				 
			 }
		 }
	}
	public RetrivePsdGui() {
    	super("�һ�����");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
    	
        this.setBounds(500,300,300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        JLabel title=new JLabel("ͼ�����ϵͳ�û��һ�����");
        title.setFont(new Font("����", Font.PLAIN, 22));
        titlePanel.add(title);
        //�ѱ��������ӵ��������Ϸ�
        con.add(titlePanel,"North");
        
        JLabel userLabel=new JLabel("�û���");
        userLabel.setBounds(60, 20, 50, 20);
        JLabel nameLabel=new JLabel("����");
        nameLabel.setBounds(60, 50, 50, 20);   

        JLabel numLabel=new JLabel("������");
        numLabel.setBounds(60, 80, 50, 20);   
        
        
         tfdUserName=new JTextField(20);
        tfdUserName.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					retrivePsd();
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
				{
					tfdName.grabFocus();
				}
				
			}
        }) ;
        tfdUserName.setBounds(110, 20, 120, 20);        
        tfdName=new JTextField(20);
        
        tfdName.setBounds(110, 50, 120, 20);
        
        tfdName.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					retrivePsd();
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_UP)
				{
					tfdUserName.grabFocus();
				}
			
			}
       	
       }) ;
        tfdNum=new JTextField(20);
        tfdNum.setBounds(110, 80, 120, 20);
    
    
       JPanel fieldPanel = new JPanel();
       fieldPanel.setLayout(null); 
       fieldPanel.add(userLabel);
       fieldPanel.add(nameLabel);
   
       fieldPanel.add(numLabel);
       fieldPanel.add(tfdUserName);
       fieldPanel.add(tfdName);

       fieldPanel.add(tfdNum);
       //�����������ӵ�����������
       con.add(fieldPanel, "Center");
      
  
       
       
       JButton btnRetrivePsd=new JButton("�һ�����");
       
       btnRetrivePsd.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				retrivePsd();
				
			}
				

		});
       btnRetrivePsd.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					retrivePsd();
				}
			
			}
        	
        }) ;
 
        JButton btnReset=new JButton("����");
        btnReset.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				tfdUserName.setText("");
				tfdName.setText("");
			}
				
		});
  

        JPanel  btnPanel = new JPanel();
        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnRetrivePsd);

        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnReset);
        
        btnPanel.add(btnRetrivePsd);
        btnPanel.add(btnReset); 
  
    
                   
      //�ѵ�¼ȡ����ť��ӵ��������·�
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
	
}

