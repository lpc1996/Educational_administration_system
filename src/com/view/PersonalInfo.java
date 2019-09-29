package com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonalInfo extends JDialog implements Comment {
	
	/**
	 * 个人信息管理模块
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension labSize;
	private privateJLabel idLab;
	private privateJLabel nickNameLab;
	private privateJLabel nameLab;
	private privateJLabel formarNameLab;
	private privateJLabel ageLab;
	private privateJLabel sexLab;
	private privateJLabel nativeLab;
	private privateJLabel idcardTypeLab;
	private privateJLabel idcardNumLab;
	private privateJLabel telLab;

	public PersonalInfo() {
		super();
		InitContentPane();
		InitData();
	}

	/**
	 *
	 */
	@Override
	public void InitData() {
		// TODO Auto-generated method stub
		idLab.setText("学工号："+LoginView.getUser().getId());
		nameLab.setText("姓名："+LoginView.getBase().getName());
		nickNameLab.setText("昵称："+LoginView.getUser().getName());
		formarNameLab.setText("曾用名："+LoginView.getBase().getFormarName());
		ageLab.setText("年龄："+LoginView.getBase().getAge());
		sexLab.setText("性别："+LoginView.getBase().getSex());
		nativeLab.setText("籍贯："+LoginView.getBase().getNativePlace());
		idcardTypeLab.setText("证件类型："+LoginView.getBase().getIdCardType());
		idcardNumLab.setText("证件号码："+LoginView.getBase().getIdCardNum());
		telLab.setText("电话号码："+LoginView.getBase().getTel());
	}

	@Override
	public void InitContentPane() {
		// TODO Auto-generated method stub
		this.setTitle("个人信息管理");
		this.setSize(534,246);
		this.setLocation(0, 0);
		labSize = new Dimension(200,30);
		
		contentPane = new JPanel();
		FlowLayout flowLayout = new FlowLayout(5);
		contentPane.setLayout(flowLayout);
		
		idLab = new privateJLabel();
		contentPane.add(idLab);
		nameLab = new privateJLabel();
		contentPane.add(nameLab);
		nickNameLab = new privateJLabel();
		contentPane.add(nickNameLab);
		formarNameLab = new privateJLabel();
		contentPane.add(formarNameLab);
		ageLab = new privateJLabel();
		contentPane.add(ageLab);
		sexLab = new privateJLabel();
		contentPane.add(sexLab);
		nativeLab = new privateJLabel();
		contentPane.add(nativeLab);
		idcardTypeLab = new privateJLabel();
		contentPane.add(idcardTypeLab);
		idcardNumLab = new privateJLabel();
		contentPane.add(idcardNumLab);
		telLab = new privateJLabel();
		contentPane.add(telLab);
		
		this.setContentPane(contentPane);
	}
	
	class privateJLabel extends JLabel{
		public privateJLabel(){
			this.setPreferredSize(labSize);
		}
	}

}
