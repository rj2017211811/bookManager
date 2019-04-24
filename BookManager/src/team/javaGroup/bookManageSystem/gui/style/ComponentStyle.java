package team.javaGroup.bookManageSystem.gui.style;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComponentStyle {
	public static void setButtonStyle(JButton btn)
	{
		btn.setBackground(new Color(56, 67, 98));// 设置背景色
		btn.setForeground(Color.WHITE);// 设置前景色
		btn.setFont(new java.awt.Font("微软楷体", 1, 15)); // 设置字体样式
	}
	public static void setButtonStyle2(JButton btn)
	{
		btn.setBackground(new Color(56, 67, 98));// 设置背景色
		btn.setForeground(Color.WHITE);// 设置前景色
		btn.setFont(new java.awt.Font("微软楷体", 1, 12)); // 设置字体样式
	}
	public static void setLabelStyle(JLabel jl)
	{
		jl.setBackground(new Color(56, 67, 98));// 设置背景色
		jl.setForeground(Color.BLACK);// 设置前景色
		jl.setFont(new java.awt.Font("微软楷体", 1, 15)); // 设置字体样式
	}




}
