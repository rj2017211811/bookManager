package team.javaGroup.bookManageSystem.gui.style;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComponentStyle {
	public static void setButtonStyle(JButton btn)
	{
		btn.setBackground(new Color(56, 67, 98));// ���ñ���ɫ
		btn.setForeground(Color.WHITE);// ����ǰ��ɫ
		btn.setFont(new java.awt.Font("΢����", 1, 15)); // ����������ʽ
	}
	public static void setButtonStyle2(JButton btn)
	{
		btn.setBackground(new Color(56, 67, 98));// ���ñ���ɫ
		btn.setForeground(Color.WHITE);// ����ǰ��ɫ
		btn.setFont(new java.awt.Font("΢����", 1, 12)); // ����������ʽ
	}
	public static void setLabelStyle(JLabel jl)
	{
		jl.setBackground(new Color(56, 67, 98));// ���ñ���ɫ
		jl.setForeground(Color.BLACK);// ����ǰ��ɫ
		jl.setFont(new java.awt.Font("΢����", 1, 15)); // ����������ʽ
	}




}
