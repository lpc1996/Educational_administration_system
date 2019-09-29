package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingView extends PublicView {

	private Dimension desktopSize;

	public SettingView(Dimension desktopSize) {
		super("系统设置");
		// TODO Auto-generated constructor stub
		this.desktopSize = desktopSize;
		InitJPanel();
	}
	
	private void InitJPanel() {
		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		this.setSize(desktopSize);
		this.setLocation(0,0);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		JPanel IOPane = new JPanel();
		IOPane.setLayout(new GridLayout(0, 1));
		JPanel windowPane = new JPanel();
//		windowPane.setLayout();
		JPanel titlePane = new JPanel();
		titlePane.setPreferredSize(new Dimension(desktopSize.width-10,36));
		//titlePane.setLayout(new GridLayout(1, 0));
		titlePane.setBorder(BorderFactory.createLineBorder(Color.RED));
		JLabel titleLab =new JLabel("标题");
		titleLab.setBorder(BorderFactory.createLineBorder(Color.black));
		titleLab.setPreferredSize(new Dimension(80,24));
		JTextField titleText = new JTextField();
		titleText.setPreferredSize(new Dimension(200,24));
		titlePane.add(titleLab);
		titlePane.add(titleText);
		windowPane.add(titlePane);
		IOPane.add(windowPane);
		contentPane.add(IOPane,BorderLayout.CENTER);
		this.setContentPane(contentPane);
	}

}
