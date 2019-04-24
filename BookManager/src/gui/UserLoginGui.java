package gui;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bean.Manager;
import bean.User;
import dao.ManagerDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import service.ManagerServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class UserLoginGui extends JFrame {
	private UserService service;
	private String userName;
	private String password;
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public UserLoginGui() {
    	super("用户登录");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
    	
        this.setBounds(500,300,300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        JLabel title=new JLabel("图书管理系统用户登录");
        title.setFont(new Font("隶书", Font.PLAIN, 22));
        titlePanel.add(title);
        //把标题面板添加到容器的上方
        con.add(titlePanel,"North");
        
        JLabel userLabel=new JLabel("账号:");
        userLabel.setBounds(60, 20, 50, 20);
        JLabel passwordLabel=new JLabel("密    码:");
        passwordLabel.setBounds(60, 50, 50, 20);        
        
        JTextField tfdUserName=new JTextField(20);
        tfdUserName.setBounds(110, 20, 120, 20);        
       JPasswordField txtPwd=new JPasswordField(20);
       txtPwd.setBounds(110, 50, 120, 20);
       
       JPanel fieldPanel = new JPanel();
       fieldPanel.setLayout(null); 
       fieldPanel.add(userLabel);
       fieldPanel.add(passwordLabel);
       fieldPanel.add(tfdUserName);
       fieldPanel.add(txtPwd);
       //把输入面板添加到容器的中央
       con.add(fieldPanel, "Center");
        
       JButton btnLogin=new JButton("登录");
        btnLogin.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				service=new UserServiceImpl(new UserDaoImpl());
				//给String实例化为空字符
				String userName=new String("");
				String password=new String("");
			
				userName=tfdUserName.getText();
				 password=txtPwd.getText();
				 
				 //判断用户名或密码是否为空
				 if(userName.equals("")||password.equals(""))
				 {
					 JOptionPane.showMessageDialog(null,"用户名或密码不能为空!");
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
							JOptionPane.showMessageDialog(null,"用户名或密码错误!");
						}
				 }
				
				
			}
				

		});
 
        JButton btnClose=new JButton("取消");
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
                   
      //把登录取消按钮添加到容器的下方
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
  
}
