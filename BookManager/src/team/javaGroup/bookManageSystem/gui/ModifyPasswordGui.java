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
    	super("�޸�����");
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
        JLabel title=new JLabel("ͼ�����ϵͳ�޸�����");
        title.setFont(new Font("����", Font.PLAIN, 22));
        titlePanel.add(title);
        //�ѱ��������ӵ��������Ϸ�
        con.add(titlePanel,"North");
                
        JLabel passwordLabel=new JLabel("������:");
        passwordLabel.setBounds(60, 20, 50, 20);
        JLabel passwordLabel2=new JLabel("������:");
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
        //�����������ӵ�����������
        con.add(fieldPanel, "Center");
       
        JButton btnModify=new JButton("�޸�����");
        btnModify.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				password=new String(txtPwd.getText());
				password2=new String(txtPwd2.getText());
				if(password.equals(password2))
				{
					JOptionPane.showMessageDialog(null,"�����벻�����������ͬ!","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					service=new UserServiceImpl(new UserDaoImpl());
					boolean  flag=service.modifyPassword(userName, password, password2);
					
					if(flag)
					{
						JOptionPane.showMessageDialog(null,"�޸ĳɹ�!");
						setVisible(false);
					}
					else 
						
					{
						JOptionPane.showMessageDialog(null,"��������ȷ������!","��ʾ",JOptionPane.WARNING_MESSAGE);
					}
				}				
				
			}		
	
		});

        JButton btnClose=new JButton("ȡ��");
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
                
      //�Ѱ�ť��ӵ��������·�
        con.add(btnPanel, "South");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
       // new ModifyPasswordGui();
   
    }
}
