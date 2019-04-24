package team.javaGroup.bookManageSystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class LoginGui extends JFrame {
	public LoginGui() {

		super("ͼ�����ϵͳ��¼");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		Container c = this.getContentPane();

		Icon img = new ImageIcon(this.getClass().getResource("/img/bg7.jpg"));
		this.setBounds(400, 100, img.getIconWidth(), img.getIconHeight() + 90);
		c.add(new JLabel(img), BorderLayout.NORTH);
		// this.setBounds(100, 200, 300,400);
		JButton btnUlogin = new JButton("�û���¼(U)");
		
		// / btnUlogin.setPreferredSize(new Dimension(100,40));//���ô�С
		btnUlogin.setBackground(new Color(56, 67, 98));// ���ñ���ɫ
		btnUlogin.setForeground(Color.WHITE);// ����ǰ��ɫ
		btnUlogin.setFont(new java.awt.Font("΢����", 1, 20)); // ����������ʽ
		JButton btnMlogin = new JButton("����Ա��¼(M)");
		btnMlogin.setBackground(new Color(104, 0, 0));// ���ñ���ɫ
		btnMlogin.setForeground(Color.WHITE);// ����ǰ��ɫ
		btnMlogin.setFont(new java.awt.Font("΢����", 1, 20)); // ����������ʽ
		JPanel palCmd = new JPanel(new FlowLayout(FlowLayout.CENTER));
		palCmd.add(btnUlogin);
		palCmd.add(btnMlogin);
		btnUlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLoginGui();
				setVisible(false);
			}

		});
		btnUlogin.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_U)
				{
					new UserLoginGui();
					setVisible(false);
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_M)
				{
					new ManagerLoginGui();
					setVisible(false);
				}
			}
        }) ;
		
		btnMlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerLoginGui();
				setVisible(false);
			}

		});
		btnMlogin.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_M)
				{
					new UserLoginGui();
					setVisible(false);
				}
			}
        }) ;
		c.add(palCmd, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public static void main(String[] argc) {
		new LoginGui();
	}

}
