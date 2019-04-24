package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class ManagerGui extends JFrame{
	

	public ManagerGui()
	{
		MbookPanel bPanel=new MbookPanel();
		MuserPanel uPanel=new MuserPanel();
		JTabbedPane table=new JTabbedPane();
		this.getContentPane().add(table);
		table.add("图书管理",bPanel);
		table.add("用户管理",uPanel);
		JButton btnReLogin=new JButton("重新登录");
		 btnReLogin.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					new LoginGui();
				}
	         });
		 uPanel.add(btnReLogin) ;
		
		 JButton btnExit=new JButton("退出");
		 btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//正常退出程序
					System.exit(0);
				}
	         });
		 uPanel.add(btnReLogin);
		 uPanel.add(btnExit);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 100, 800, 600);
		this.setVisible(true);
	
	}
		

}

