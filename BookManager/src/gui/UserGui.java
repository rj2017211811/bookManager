package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class UserGui extends JFrame{
	
	public UserGui(String userName)
	{
		
		super("ͼ�����ϵͳ�û���");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		UserPanel bPanel=new UserPanel(userName);
		
		
		JTabbedPane table=new JTabbedPane();
	
		
		this.getContentPane().add(table);
		table.add("ͼ�����ϵͳ�û���",bPanel);
		JButton btnReLogin=new JButton("���µ�¼");
		 btnReLogin.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					setVisible(false);
				
					new LoginGui();

					
				}
	         });
		 JButton btnExit=new JButton("�˳�");
		 btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//�����˳�����
					System.exit(0);
				}
	         });
		 bPanel.add(btnReLogin);
		 bPanel.add(btnExit);

	
	
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(400, 100, 800, 600);
		this.setVisible(true);
		
	
		
		
	}
		
	public static void main(String[] args)
	{
		//new UserGui();
	}

}
