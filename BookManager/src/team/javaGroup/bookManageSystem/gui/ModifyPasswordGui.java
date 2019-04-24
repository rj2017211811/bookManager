package team.javaGroup.bookManageSystem.gui;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import team.javaGroup.bookManageSystem.bean.Manager;
import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.ManagerDaoImpl;
import team.javaGroup.bookManageSystem.dao.UserDao;
import team.javaGroup.bookManageSystem.dao.UserDaoImpl;
import team.javaGroup.bookManageSystem.service.ManagerServiceImpl;
import team.javaGroup.bookManageSystem.service.UserService;
import team.javaGroup.bookManageSystem.service.UserServiceImpl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ModifyPasswordGui extends JFrame {
	private UserService service;

	private String password,password2;
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public ModifyPasswordGui(String userName) {
    	super("修改密码");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		   	
        this.setBounds(500,300,300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        JLabel title=new JLabel("图书管理系统修改密码");
        title.setFont(new Font("隶书", Font.PLAIN, 22));
        titlePanel.add(title);
        //把标题面板添加到容器的上方
        con.add(titlePanel,"North");
                
        JLabel passwordLabel=new JLabel("旧密码:");
        passwordLabel.setBounds(60, 20, 50, 20);
        JLabel passwordLabel2=new JLabel("新密码:");
        passwordLabel2.setBounds(60, 50, 50, 20);
     
        JPasswordField txtPwd=new JPasswordField(20);
        txtPwd.setBounds(110, 20, 120, 20);
        JPasswordField txtPwd2=new JPasswordField(20);
        txtPwd2.setBounds(110, 50, 120, 20);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);  
        fieldPanel.add(passwordLabel);
        fieldPanel.add(passwordLabel2);      
        fieldPanel.add(txtPwd);
        fieldPanel.add(txtPwd2);
        //把输入面板添加到容器的中央
        con.add(fieldPanel, "Center");
       
        JButton btnModify=new JButton("修改密码");
        btnModify.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				password=new String(txtPwd.getText());
				password2=new String(txtPwd2.getText());
				if(password.equals(password2))
				{
					JOptionPane.showMessageDialog(null,"新密码不能与旧密码相同!","提示",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					service=new UserServiceImpl(new UserDaoImpl());
					boolean  flag=service.modifyPassword(userName, password, password2);
					
					if(flag)
					{
						JOptionPane.showMessageDialog(null,"修改成功!");
						setVisible(false);
					}
					else 
						
					{
						JOptionPane.showMessageDialog(null,"请输入正确的密码!","提示",JOptionPane.WARNING_MESSAGE);
					}
				}				
				
			}		
	
		});

        JButton btnClose=new JButton("取消");
        btnClose.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				txtPwd.setText("");
				txtPwd2.setText("");
			}				

		});
       
        JPanel  btnPanel = new JPanel();
        btnPanel.add(btnModify);
        btnPanel.add(btnClose);
                
      //把按钮添加到容器的下方
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
       // new ModifyPasswordGui();
   
    }
}
