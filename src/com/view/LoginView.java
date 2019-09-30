package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import com.dao.BaseInfoDao;
import com.dao.LoginDao;
import com.mode.BaseInfo;
import com.mode.UserMode;
import com.util.Images;
import com.util.Secret;

public class LoginView extends JDialog {
	
	private static UserMode user;
	private static BaseInfo base;
	private static MainView mainView;
	private static Images images;
	private JButton loginBtn;
	private JButton exitBtn;
	private JTextField nameText;
	private JPasswordField passText;
	private JPanel cententPane;
	private LoginDao loginDao;
	private static LoginView loginView;
	private static Dimension screenSize;

	public LoginView() {
		// TODO Auto-generated constructor stub
		super();
		loginDao = new LoginDao();
		LoginView.images = new Images();
		LoginView.screenSize = new Dimension();
		InitView();
	}
	
	private void InitView() {
		this.setSize(new Dimension(296, 356));
		this.setResizable(false);
		this.setTitle("欢迎登陆");
		
		this.setIconImage(LoginView.getImages().getSchoolLogo());
		this.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		loginBtn = new JButton();
		loginBtn.setText("登陆");
		loginBtn.setBounds((296/2 - 85), 280, 80, 32); 
		
		exitBtn = new JButton();
		exitBtn.setText("退出");
		exitBtn.setBounds((296/2 + 5), 280, 80, 32);
	
		JLabel userLab = new JLabel();
		userLab.setIcon(new ImageIcon(LoginView.getImages().getUser()));
		userLab.setBounds(new Rectangle(0, 160, 280, 110));
		
		JLabel nameLab = new JLabel("用户名：");
		nameLab.setBounds(new Rectangle(40, 195, 80, 32));
		JLabel passLab = new JLabel("密码：");
		passLab.setBounds(new Rectangle(40, 230, 80,32));
		
		nameText = new JTextField();
		nameText.setBounds(new Rectangle(120, 195, 124, 32));
		
		passText = new JPasswordField();
		passText.setBounds(new Rectangle(120, 230, 124, 32));
		
		JLabel logoLab = new JLabel();
		logoLab.setIcon(new ImageIcon(LoginView.getImages().getLoginBG()));
		logoLab.setBounds(new Rectangle(0, 0, 296, 150));
		
		getRootPane().setDefaultButton(loginBtn);
		
		cententPane = new JPanel();
		cententPane.setLayout(null);
		cententPane.setBackground(new Color(255, 255, 255));
		cententPane.add(logoLab);
		cententPane.add(loginBtn);
		cententPane.add(exitBtn);
		cententPane.add(nameLab);
		cententPane.add(nameText);
		cententPane.add(passLab);
		cententPane.add(passText);
		cententPane.add(userLab);
		this.setContentPane(cententPane);
		
		signInActionListener signIn = new signInActionListener();
		loginBtn.addActionListener(signIn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}

	public static UserMode getUser() {
		return user;
	}

	public static BaseInfo getBase() {
		return base;
	}

	public static Images getImages() {
		return images;
	}
	
	public static void main(String [] args) {
		LoginView.loginView = new LoginView();
		loginView.setVisible(true);
	}
	
	class signInActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String idOrName = nameText.getText();
			String pass=new Secret(passText.getPassword()).set();
			if(idOrName.length() == 0) {
				JOptionPane.showMessageDialog(null, "请输入用户名或ID");
				return ;
			}else if(pass.length()==0) {
				JOptionPane.showMessageDialog(null, "请输入密码");
				return ;
			}
			
			LoginView.user=loginDao.login(idOrName, pass);
			if(LoginView.user == null) {
				JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误，请重新输入", "警告", JOptionPane.WARNING_MESSAGE, new ImageIcon(LoginView.getImages().getWarring2()));
				return ;
			}else {
				BaseInfoDao baseDao = new BaseInfoDao();
				LoginView.base=baseDao.getBaseInfo(LoginView.user.getId());
				LoginView.mainView = new MainView();
				LoginView.mainView.setVisible(true);
				LoginView.loginView.dispose();
			}
		}
		
	}

	public static void reLogin() {
		LoginView.mainView.dispose();
		LoginView.loginView = new LoginView();
		LoginView.loginView.setVisible(true);
	}

	public static Dimension getScreenSize() {
		return screenSize;
	}
}


