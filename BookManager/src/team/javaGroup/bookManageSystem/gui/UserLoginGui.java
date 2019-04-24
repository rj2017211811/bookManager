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

public class UserLoginGui extends JFrame {
	private UserService service;
	private String userName;
	private String password;
	private JTextField tfdUserName;
	private JPasswordField txtPwd;
	
	
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public void  validateLogin()
	{
		service=new UserServiceImpl(new UserDaoImpl());
		//给String实例化为空字符
		String userName=new String("");
		String password=new String("");
	
		userName=tfdUserName.getText();
		 password=txtPwd.getText();
		 
		 //判断用户名或密码是否为空
		 if(userName.equals("")||password.equals(""))
		 {
			 JOptionPane.showMessageDialog(null,"用户名或密码不能为空!","提示",JOptionPane.WARNING_MESSAGE);
		 }
		 else
		 {
			 boolean flag=false;
				flag=service.judgeUser(userName, password);
				if(flag){
					JOptionPane.showMessageDialog(null,"登录成功!");
					setVisible(false);//设置登录窗口不可见
					new UserGui(userName);//用户界面
				}else{
					JOptionPane.showMessageDialog(null,"用户名或密码错误!","提示",JOptionPane.WARNING_MESSAGE);
				}
		 }
	}
	public UserLoginGui() {
    	super("用户登录");

    	
        this.setBounds(500,300,300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        JLabel title=new JLabel("图书管理系统用户登录");
        title.setFont(new Font("隶书", Font.PLAIN,26));
        titlePanel.add(title);
        //把标题面板添加到容器的上方
        con.add(titlePanel,"North");
        
        JLabel userLabel=new JLabel("账号");
        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setLabelStyle(userLabel);
        userLabel.setBounds(60, 20, 50, 20);

        JLabel passwordLabel=new JLabel("密码");
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
       //把输入面板添加到容器的中央
       con.add(fieldPanel, "Center");
       JButton btnRetrivePsd=new JButton("找回密码");
       team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnRetrivePsd);
       btnRetrivePsd.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				new RetrivePsdGui();
				
			}
				

		});
  
       
       
       JButton btnLogin=new JButton("登录");
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
 
        JButton btnClose=new JButton("重置");
        team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnClose);
        btnClose.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				tfdUserName.setText("");
				txtPwd.setText("");
			}
				
		});
  

        JPanel  btnPanel = new JPanel();
  
        
        btnPanel.add(btnLogin);
        btnPanel.add(btnClose); 
        btnPanel.add(btnRetrivePsd);
    
                   
      //把登录取消按钮添加到容器的下方
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
	
}

