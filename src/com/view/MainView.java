package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	protected PersonalInfo personalJDialog;
	protected ChangePass changePass;
	
	public MainView() {
		super();
		InitJFrame();
	}
	
	private void InitJFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�����ʵ��ѧ-����ϵͳ");
		this.setSize(700, 500);
		this.setResizable(true);
		this.setJMenuBar(createJMenuBar());
		createJMenu();
		this.setVisible(true);
	}
	
	private JMenuBar createJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		return menuBar;
	}
	
	private void createJMenu() {
		JMenu personalCenterMenu = new JMenu("��������");
		JMenuItem personalInfoItem = new JMenuItem("������Ϣ");
		personalInfoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				personalJDialog = new PersonalInfo();
				personalJDialog.setVisible(true);
			}
		});
		personalCenterMenu.add(personalInfoItem);
		JMenuItem changePassItem = new JMenuItem("�޸�����");
		changePassItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changePass = new ChangePass();
				changePass.setVisible(true);
			}
		});
		personalCenterMenu.add(changePassItem);
		this.getJMenuBar().add(personalCenterMenu);
	}
}
