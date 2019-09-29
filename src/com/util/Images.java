package com.util;

import java.awt.Image;
import java.awt.Toolkit;

public class Images {
	
	private Image schoolLogo;
	private Image loginBG;
	private Image background2;
	private Image failed;
	private Image woman;
	private Image icon;
	private Image login;
	private Image logo_o;
	private Image main;
	private Image man;
	private Image search;
	private Image successful;
	private Image user;
	private Image warring2;
	private final String urlPre="/com/lib/images/";
	private Toolkit toolKit;

	public Images() {
		// TODO Auto-generated constructor stub
		toolKit = Toolkit.getDefaultToolkit();
	}

	public Image getSchoolLogo() {
		this.schoolLogo = toolKit.getImage(this.getClass().getResource(urlPre+"school_logo.jpg"));
		return schoolLogo;
	}

	public Image getLoginBG() {
		this.loginBG = toolKit.getImage(this.getClass().getResource(urlPre+"loginBG.jpg"));
		return loginBG;
	}

	public Image getBackground2() {
		this.background2=toolKit.getImage(this.getClass().getResource(urlPre+"background2.jpg"));
		return background2;
	}

	public Image getFailed() {
		this.failed=toolKit.getImage(this.getClass().getResource(urlPre+"failed1.png"));
		return failed;
	}

	public Image getWoman() {
		this.woman=toolKit.getImage(this.getClass().getResource(urlPre+"woman.gif"));
		return woman;
	}

	public Image getIcon() {
		this.icon=toolKit.getImage(this.getClass().getResource(urlPre+"icon.png"));
		return icon;
	}

	public Image getLogin() {
		this.login=toolKit.getImage(this.getClass().getResource(urlPre+"login.gif"));
		return login;
	}

	public Image getLogo_o() {
		this.logo_o=toolKit.getImage(this.getClass().getResource(urlPre+"logo_0.png"));
		return logo_o;
	}

	public Image getMain() {
		this.main=toolKit.getImage(this.getClass().getResource(urlPre+"main.jpg"));
		return main;
	}

	public Image getMan() {
		this.man=toolKit.getImage(this.getClass().getResource(urlPre+"man.gif"));
		return man;
	}

	public Image getSearch() {
		this.search=toolKit.getImage(this.getClass().getResource(urlPre+"search.png"));
		return search;
	}

	public Image getSuccessful() {
		this.successful=toolKit.getImage(this.getClass().getResource(urlPre+"yes2.png"));
		return successful;
	}

	public Image getUser() {
		this.user=toolKit.getImage(this.getClass().getResource(urlPre+"user.gif"));
		return user;
	}
	
	public Image getWarring2() {
		this.warring2=toolKit.getImage(this.getClass().getResource(urlPre+"warring2.png"));
		return warring2;
	}


}
