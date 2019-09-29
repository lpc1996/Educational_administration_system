package com.dao;

import java.sql.ResultSet;
import java.util.List;
import com.mode.UserMode;
import com.util.ConnXupt;

public class LoginDao implements DaoInterface{
	
	private ConnXupt loginCon;

	public LoginDao() {
		loginCon = new ConnXupt();
	}
	
	public UserMode login(String idOrName,String pass) {
		UserMode user = null;
		String sql="SELECT id,login.`name`,login.`limit` FROM login where (id='"+idOrName+"' OR name='"+idOrName+"') AND pass='"+pass+"'";
		try {
			ResultSet rs = loginCon.excuteQuery(sql);
			if(rs.next()) {
				user = new UserMode();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setLimit(rs.getInt("limit"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		} finally {
			loginCon.close();
		}
		return user;
	}
	
	public boolean changePass(String id,String oldPass,String newPass) {
		boolean b = false;
		String sql = "UPDATE login SET pass='"+newPass+"' WHERE id='"+id+"' AND pass='"+oldPass+"';";
		try {
			int i = loginCon.excuteUpdate(sql);
			if(i == 0) {
				b=false;
			}else if(i == 1){
				b = true;
			}else {
				b=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(sql);
		} finally {
			// TODO: handle finally clause
			loginCon.close();
		}
		return b;
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean deleteData(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getIdNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue() {
		// TODO Auto-generated method stub
		
	}
}
