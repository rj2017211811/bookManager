package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class UBorrowGui extends JFrame{
	public UBorrowGui(String userName)
	{
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		UBorrowPanel ubPanel=new UBorrowPanel(userName);	
		JTabbedPane table=new JTabbedPane();
		this.getContentPane().add(table);
		table.add("个人借阅情况",ubPanel);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(400, 100, 800, 600);
		this.setVisible(true);
	
	}
		
	/*public static void main(String[] args)
	{
		new UBorrowGui("34324");
	}*/

}
