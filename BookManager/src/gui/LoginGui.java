package gui;

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

		super("图书管理系统登录");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		Container c = this.getContentPane();

		Icon img = new ImageIcon(this.getClass().getResource("/img/log.png"));
		this.setBounds(400, 100, img.getIconWidth(), img.getIconHeight() + 90);
		c.add(new JLabel(img), BorderLayout.NORTH);
		// this.setBounds(100, 200, 300,400);
		JButton btnUlogin = new JButton("用户登录");
		// / btnUlogin.setPreferredSize(new Dimension(100,40));//设置大小
		btnUlogin.setBackground(new Color(56, 67, 98));// 设置背景色
		btnUlogin.setForeground(Color.WHITE);// 设置前景色
		btnUlogin.setFont(new java.awt.Font("微软楷体", 1, 20)); // 设置字体样式
		JButton btnMlogin = new JButton("管理员登录");
		btnMlogin.setBackground(new Color(104, 0, 0));// 设置背景色
		btnMlogin.setForeground(Color.WHITE);// 设置前景色
		btnMlogin.setFont(new java.awt.Font("微软楷体", 1, 20)); // 设置字体样式
		JPanel palCmd = new JPanel(new FlowLayout(FlowLayout.CENTER));
		palCmd.add(btnUlogin);
		palCmd.add(btnMlogin);
		btnUlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLoginGui();
				setVisible(false);
			}

		});
		btnMlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerLoginGui();
				setVisible(false);
			}

		});
		c.add(palCmd, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public static void main(String[] argc) {
		new LoginGui();
	}

}
