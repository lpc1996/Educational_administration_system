package com.view;

import javax.swing.JDialog;

public class GUIModel extends JDialog {

	public GUIModel() {
		super();
		this.setIconImage(LoginView.getImages().getSchoolLogo());
		this.setLocationRelativeTo(null);
	}
	
	class TextJDialog extends JDialog{
		public TextJDialog() {
			super();
			this.setIconImage(LoginView.getImages().getSchoolLogo());
			this.setLocationRelativeTo(null);
		}
	}
}
