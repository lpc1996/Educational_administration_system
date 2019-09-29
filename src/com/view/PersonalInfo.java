package com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonalInfo extends JDialog implements Comment {
	
	/**
	 * ������Ϣ����ģ��
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
		idLab.setText("ѧ���ţ�"+LoginView.getUser().getId());
		nameLab.setText("������"+LoginView.getBase().getName());
		nickNameLab.setText("�ǳƣ�"+LoginView.getUser().getName());
		formarNameLab.setText("��������"+LoginView.getBase().getFormarName());
		ageLab.setText("���䣺"+LoginView.getBase().getAge());
		sexLab.setText("�Ա�"+LoginView.getBase().getSex());
		nativeLab.setText("���᣺"+LoginView.getBase().getNativePlace());
		idcardTypeLab.setText("֤�����ͣ�"+LoginView.getBase().getIdCardType());
		idcardNumLab.setText("֤�����룺"+LoginView.getBase().getIdCardNum());
		telLab.setText("�绰���룺"+LoginView.getBase().getTel());
	}

	@Override
	public void InitContentPane() {
		// TODO Auto-generated method stub
		this.setTitle("������Ϣ����");
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
