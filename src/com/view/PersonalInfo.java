package com.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonalInfo extends JPanel {

	public PersonalInfo() {
		// TODO Auto-generated constructor stub
		super();
		InitJPanel();
	}
	
	private void InitJPanel() {
		JPanel contentPanel = new JPanel();
		JLabel nickname = new JLabel("Í«≥∆");
		contentPanel.add(nickname);
		this.add(contentPanel);
	}
	
}
