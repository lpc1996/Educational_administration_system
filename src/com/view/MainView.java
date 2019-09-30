package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	/**
	 * 主界面
	 */
	private static final long serialVersionUID = 1L;
	protected PersonalInfo personalJDialog;
	protected ChangePass changePass;
	private JMenuItem exitItem;
	
	public MainView() {
		super();
		InitJFrame();
	}
	
	private void InitJFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("西安邮电大学-教务系统");
		this.setSize(700, 500);
		this.setResizable(true);
		this.setJMenuBar(createJMenuBar());
		createPersonalJMenu();
		createBackJMenu();
		this.setVisible(true);
	}
	
	private JMenuBar createJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		return menuBar;
	}
	
	private void createPersonalJMenu() {
		JMenu personalCenterMenu = new JMenu("个人中心");
		JMenuItem personalInfoItem = new JMenuItem("个人信息");
		personalInfoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				personalJDialog = new PersonalInfo();
				personalJDialog.setVisible(true);
			}
		});
		personalCenterMenu.add(personalInfoItem);
		JMenuItem changePassItem = new JMenuItem("修改密码");
		changePassItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changePass = new ChangePass();
				changePass.setVisible(true);
			}
		});
		personalCenterMenu.add(changePassItem);
		personalCenterMenu.addSeparator();
		exitItem = new JMenuItem("退出");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		personalCenterMenu.add(exitItem);
		this.getJMenuBar().add(personalCenterMenu);
	}
	
	private void createBackJMenu() {
		JMenu backJMenu = new JMenu("后台管理");
		JMenuItem stuItem = new JMenuItem("学生信息管理");
		stuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setVisible(true);
			}
		});
		backJMenu.add(stuItem);
		this.getJMenuBar().add(backJMenu);
	}
}
