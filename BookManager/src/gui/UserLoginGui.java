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
    	super("�û���¼");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
    	
        this.setBounds(500,300,300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        JLabel title=new JLabel("ͼ�����ϵͳ�û���¼");
        title.setFont(new Font("����", Font.PLAIN, 22));
        titlePanel.add(title);
        //�ѱ��������ӵ��������Ϸ�
        con.add(titlePanel,"North");
        
        JLabel userLabel=new JLabel("�˺�:");
        userLabel.setBounds(60, 20, 50, 20);
        JLabel passwordLabel=new JLabel("��    ��:");
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
       //�����������ӵ�����������
       con.add(fieldPanel, "Center");
        
       JButton btnLogin=new JButton("��¼");
        btnLogin.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				service=new UserServiceImpl(new UserDaoImpl());
				//��Stringʵ����Ϊ���ַ�
				String userName=new String("");
				String password=new String("");
			
				userName=tfdUserName.getText();
				 password=txtPwd.getText();
				 
				 //�ж��û����������Ƿ�Ϊ��
				 if(userName.equals("")||password.equals(""))
				 {
					 JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��!");
				 }
				 else
				 {
					 boolean flag=false;
						flag=service.judgeUser(userName, password);
						if(flag){
							JOptionPane.showMessageDialog(null,"��¼�ɹ�!");
							setVisible(false);//���õ�¼���ڲ��ɼ�
							new UserGui(userName);//�û�����
						}else{
							JOptionPane.showMessageDialog(null,"�û������������!");
						}
				 }
				
				
			}
				

		});
 
        JButton btnClose=new JButton("ȡ��");
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
                   
      //�ѵ�¼ȡ����ť��ӵ��������·�
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
  
}
