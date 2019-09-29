package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	/**
	 * 主界面
	 */
	private static final long serialVersionUID = 1L;
	protected PersonalInfo personalInfo;
	private JDialog contentJDialog;
	
	public MainView() {
		super();
		InitJFrame();
	}
	
	private void InitJFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("西安邮电大学-教务系统");
		this.setSize(500, 500);
		this.setResizable(false);
		this.setJMenuBar(createJMenuBar());
		createJMenu();
		this.setVisible(true);
	}
	
	private JMenuBar createJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		return menuBar;
	}
	
	private void createJMenu() {
		JMenu personalCenterMenu = new JMenu("个人中心");
		JMenuItem personalInfoItem = new JMenuItem("个人信息");
		personalInfoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(personalInfo != null) {
					personalInfo.updateUI();
				}else {
					personalInfo = new PersonalInfo();
				}
				contentJDialog = new JDialog();
				contentJDialog.setTitle("个人信息管理");
				contentJDialog.setVisible(true);
			}
		});
		personalCenterMenu.add(personalInfoItem);
		this.getJMenuBar().add(personalCenterMenu);
	}
	
	
	public static void main(String [] argv) {
		MainView main = new MainView();
		
	}
	
}
