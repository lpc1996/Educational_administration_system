package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mode.BaseInfo;
import com.util.ConnXupt;

public class BaseInfoDao {
	
	private ConnXupt baseInfoCon;

	public BaseInfoDao() {
		// TODO Auto-generated constructor stub
		this.baseInfoCon = new ConnXupt();
	}
	
	private BaseInfo getData(ResultSet rs) {
		BaseInfo base = null;
		try {
			base = new BaseInfo();
			base.setUserId(rs.getString("user_id"));
			base.setName(rs.getString("name"));
			base.setFormarName(rs.getString("formar_name"));
			base.setAge(rs.getInt("age"));
			base.setSex(rs.getString("sex"));
			base.setNativePlace(rs.getString("native_place"));
			base.setIdCardType(rs.getString("IDCARD_type"));
			base.setIdCardNum(rs.getString("IDCARD_NUM"));
			base.setUserType(rs.getString("type"));
			base.setTel(rs.getString("tel"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base;
	}
	public BaseInfo getBaseInfo(String id) {
		BaseInfo baseInfo = null;
		String sql="SELECT * FROM base_info where id='"+id+"'";
		try {
			ResultSet rs = baseInfoCon.excuteQuery(sql);
			if(rs.next()) {
				baseInfo=getData(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			baseInfo=null;
		}finally {
			baseInfoCon.close();
		}
		return baseInfo;
	}

}
