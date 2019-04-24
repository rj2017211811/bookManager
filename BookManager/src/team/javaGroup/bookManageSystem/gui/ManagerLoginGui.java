package team.javaGroup.bookManageSystem.gui;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;













import team.javaGroup.bookManageSystem.bean.Manager;
import team.javaGroup.bookManageSystem.dao.ManagerDaoImpl;
import team.javaGroup.bookManageSystem.dao.UserDaoImpl;
import team.javaGroup.bookManageSystem.service.ManagerService;
import team.javaGroup.bookManageSystem.service.ManagerServiceImpl;
import team.javaGroup.bookManageSystem.service.UserService;
import team.javaGroup.bookManageSystem.service.UserServiceImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ManagerLoginGui extends JFrame {
	private ManagerService service;
	private String userName;
	private String password;
	private JTextField tfdUserName;
	private JPasswordField txtPwd;
	
	public ManagerService getService() {
		return service;
	}
	public void setService(ManagerService service) {
		this.service = service;
	}
	
	public void  validateLogin()
	{
		service=new ManagerServiceImpl(new ManagerDaoImpl());
		
		//��Stringʵ����Ϊ���ַ�
		String userName=new String("");
		String password=new String("");
	
		userName=tfdUserName.getText();
		 password=txtPwd.getText();
		 
		 //�ж��û����������Ƿ�Ϊ��
		 if(userName.equals("")||password.equals(""))
		 {
			 JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��!","��ʾ",JOptionPane.WARNING_MESSAGE);
		 }
		 else
		 {
			 boolean flag=false;
				flag=service.validateLogin(new Manager(userName, password));
				if(flag){
					JOptionPane.showMessageDialog(null,"��¼�ɹ�!");
					setVisible(false);//���õ�¼���ڲ��ɼ�
					new ManagerGui();
				}else{
					JOptionPane.showMessageDialog(null,"�û������������!","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
		 }
	}
	public ManagerLoginGui() {
    	super("����Ա��¼");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
    	
        this.setBounds(500,300,300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        
        JLabel title=new JLabel("ͼ�����ϵͳ����Ա��¼");
        title.setFont(new Font("����", Font.PLAIN,26));
        titlePanel.add(title);
        //�ѱ��������ӵ��������Ϸ�
        con.add(titlePanel,"North");
        
        JLabel userLabel=new JLabel("�˺�");
        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setLabelStyle(userLabel);
        userLabel.setBounds(60, 20, 50, 20);
        JLabel passwordLabel=new JLabel("����");
        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setLabelStyle(passwordLabel);
        passwordLabel.setBounds(60, 50, 50, 20);        
        
         tfdUserName=new JTextField(20);
        tfdUserName.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					validateLogin();
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
				{
					txtPwd.grabFocus();
				}
				
			}
        }) ;
        tfdUserName.setBounds(110, 20, 120, 20);        
        txtPwd=new JPasswordField(20);
       txtPwd.setBounds(110, 50, 120, 20);
       txtPwd.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					validateLogin();
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_UP)
				{
					tfdUserName.grabFocus();
				}
			
			}
       	
       }) ;
       JPanel fieldPanel = new JPanel();
       fieldPanel.setLayout(null); 
       fieldPanel.add(userLabel);
       fieldPanel.add(passwordLabel);
       fieldPanel.add(tfdUserName);
       fieldPanel.add(txtPwd);
       //�����������ӵ�����������
       con.add(fieldPanel, "Center");
        
       JButton btnLogin=new JButton("��¼");
     
       team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnLogin);
       
       
        btnLogin.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				validateLogin();
				
			}
				

		});
        btnLogin.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					validateLogin();
				}
				
			}
        	
        }) ;
 
        JButton btnReset=new JButton("����");
        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnReset);
        btnReset.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				tfdUserName.setText("");
				txtPwd.setText("");
			}
				
		});

        JPanel  btnPanel = new JPanel();        
        btnPanel.add(btnLogin);
        btnPanel.add(btnReset); 
    
                   
      //�ѵ�¼ȡ����ť��ӵ��������·�
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
	
	
}

