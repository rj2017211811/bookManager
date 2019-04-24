package team.javaGroup.bookManageSystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class BorrowGui extends JFrame{
	public BorrowGui()
	{
		
		BorrowPanel bPanel=new BorrowPanel();
		
		
	
		
		JTabbedPane table=new JTabbedPane();
		this.getContentPane().add(table);
		table.add("½èÔÄÇé¿ö",bPanel);

		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(400, 100, 800, 600);
		this.setVisible(true);
	
	}
		
	public static void main(String[] args)
	{
		new BorrowGui();
	}

}
