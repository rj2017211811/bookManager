package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import service.ManagerService;
import service.ManagerServiceImpl;
import service.UserServiceImpl;
import bean.Manager;
import bean.User;
import dao.ManagerDaoImpl;
import dao.UserDaoImpl;
public class ManagerLoginGui extends JFrame {
	private ManagerService service;
	private String userName;
	private String password;
	public ManagerService getService() {
		return service;
	}
	public void setService(ManagerService service) {
		this.service = service;
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
        JLabel title=new JLabel("ͼ�����ϵͳ����Ա��¼");
        title.setFont(new Font("����", Font.PLAIN, 22));
        JPanel titlePanel = new JPanel();
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
				service=new ManagerServiceImpl(new ManagerDaoImpl());
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
						
						
						flag=service.validateLogin(new Manager(userName, password));
						if(flag){
							JOptionPane.showMessageDialog(null,"��¼�ɹ�!");
							setVisible(false);//���õ�¼���ڲ��ɼ�
							new ManagerGui();//�û�����
						}else{
							JOptionPane.showMessageDialog(null,"�˺Ż��������!");
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
