package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ConnXupt {
	
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/xupt?useSSL = false&serverTimezone=UTC&charset=UTF8&allowPublicKeyRetrieval=true&useInformationSchema=true";
	private String USER = "root";
	private String PASS = "甁甉甉甆";
	private Connection conn;
	
	public ConnXupt() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(Driver);
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "加载数据库驱动失败");
			e.printStackTrace();
		}
		refreshConnection();
	}
	
	private void refreshConnection() {
		try {
			conn = DriverManager.getConnection(URL, USER, new Secret(PASS).set());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据库连接失败");
		}
	}
	
	public ResultSet excuteQuery(String sql) {
		ResultSet rs = null;
		try {
			if(conn.isClosed())
				refreshConnection();
			rs = conn.createStatement().executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rs = null;
		}
		return rs;
	}
	
	public int excuteUpdate(String sql) {
		int i = 0;
		try {
			if(conn.isClosed())
				refreshConnection();
			i = conn.createStatement().executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			i = 0;
			System.out.println(sql);
		}
		return i;
	}
	
	public void close() {
		try {
			if( !conn.isClosed() ) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String [] argv) {
		ConnXupt xupt = new ConnXupt();
		String[] title = xupt.getColumnName("base_info");
		for(int i = 0; i < title.length; i++) {
			System.out.println(title[i]);
		}
		List commentList = xupt.getComment("base_info");
		for(int i = 0; i < commentList.size(); i++) {
			System.out.println(commentList.get(i));
		}
	}
	
	public String[] getColumnName(String tableName) {
		//获取表名
		String[] title = null;
		try {
			if(conn.isClosed())
				refreshConnection();
			PreparedStatement pst = conn.prepareStatement("select * from "+tableName);
			ResultSet re = pst.executeQuery();
			ResultSetMetaData data = re.getMetaData();
			title = new String[data.getColumnCount()];
			for(int i = 0; i < title.length; i++) {
				title[i] = new String(data.getColumnName(i+1));
			}
			close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			title = null;
		}
		return title;
	}
	
	public Vector getComment(String tableName) {
		//获取表注释
		Vector commentVes = null;
		try {
			if(conn.isClosed())
				refreshConnection();
			PreparedStatement pst = conn.prepareStatement("select * from "+tableName);
			ResultSet re = pst.executeQuery("show full columns from " + tableName);
			commentVes = new Vector();
			while(re.next()) {
				commentVes.add(re.getString("Comment"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return commentVes;
	}

}
