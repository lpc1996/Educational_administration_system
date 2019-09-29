package com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.dao.LoginDao;
import com.util.Secret;

public class ChangePass extends JDialog implements Comment {

	private JPanel contentPane;
	private JPasswordField oldText;
	private JPasswordField[] newPassText;
	private JButton sublimBtn;
	private JButton exitBtn;

	public ChangePass() {
		// TODO Auto-generated constructor stub
		super();
		InitContentPane();
		sublimAction();
	}

	

	@Override
	public void InitData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void InitContentPane() {
		// TODO Auto-generated method stub
		this.setTitle("修改密码");
		this.setLocation(0, 0);
		this.setIconImage(LoginView.getImages().getSchoolLogo());
		this.setSize(400,220);
		
		contentPane = new JPanel();
		FlowLayout flow = new FlowLayout(5);
		contentPane.setLayout(flow);
		JLabel oldPassLab = new JLabel();
		oldPassLab.setPreferredSize(new Dimension(80,30));
		oldPassLab.setText("旧密码：");
		oldText = new JPasswordField();
		oldText.setPreferredSize(new Dimension(200,30));
		JLabel[] newPassLab = new JLabel[2];
		newPassLab[0] = new JLabel("新密码：");
		newPassLab[0].setPreferredSize(new Dimension(80,30));
		newPassLab[1] = new JLabel("确认密码：");
		newPassLab[1].setPreferredSize(new Dimension(80,30));
		newPassText = new JPasswordField[2];
		newPassText[0] = new JPasswordField();
		newPassText[0].setPreferredSize(new Dimension(200,30));
		newPassText[1] = new JPasswordField();
		newPassText[1].setPreferredSize(new Dimension(200,30));
		contentPane.add(oldPassLab);
		contentPane.add(oldText);
		contentPane.add(newPassLab[0]);
		contentPane.add(newPassText[0]);
		contentPane.add(newPassLab[1]);
		contentPane.add(newPassText[1]);
		sublimBtn = new JButton("修改");
		exitBtn = new JButton("退出");
		contentPane.add(sublimBtn);
		contentPane.add(exitBtn);
		this.setContentPane(contentPane);
	}
	
	private void sublimAction() {
		sublimBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(oldText.getPassword().length == 0 || newPassText[0].getPassword().length == 0 || newPassText[1].getPassword().length ==0) {
					JOptionPane.showMessageDialog(null, "请输入密码！", "警告", JOptionPane.WARNING_MESSAGE, new ImageIcon(LoginView.getImages().getWarring2()));
					return;
				}
				String oldPass = new Secret(oldText.getPassword()).set();
				String newPass = new Secret(newPassText[0].getPassword()).set();
				if(!newPass.equals(new Secret(newPassText[1].getPassword()).set())) {
					JOptionPane.showMessageDialog(null, "两次输入的密码不同，请重新输入", "警告", JOptionPane.WARNING_MESSAGE, new ImageIcon(LoginView.getImages().getWarring2()));
					return ;
				}
				LoginDao loginDao = new LoginDao();
				if(loginDao.changePass(LoginView.getUser().getId(), oldPass, newPass)) {
					JOptionPane.showMessageDialog(null, "密码修改成功，请重新登陆", "提示消息",JOptionPane.INFORMATION_MESSAGE , new ImageIcon(LoginView.getImages().getYes2()));
					dispose();
					LoginView.reLogin();
				}else {
					JOptionPane.showMessageDialog(null, "密码修改失败成功", "提示消息",JOptionPane.ERROR_MESSAGE , new ImageIcon(LoginView.getImages().getError2()));
				}
			}
		});
	}
	
	private void exitAction() {
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

}
