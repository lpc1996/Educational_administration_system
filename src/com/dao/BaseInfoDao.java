package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mode.BaseInfo;
import com.util.ConnXupt;

public class BaseInfoDao implements DaoInterface{
	
	private ConnXupt baseInfoCon;
	private boolean isOk;

	public BaseInfoDao() {
		// TODO Auto-generated constructor stub
		this.baseInfoCon = new ConnXupt();
	}
	
	public BaseInfo getBaseInfo(String id) {
		BaseInfo baseInfo = null;
		String sql="SELECT * FROM base_info where user_id='"+id+"'";
		try {
			ResultSet rs = baseInfoCon.excuteQuery(sql);
			if(rs.next()) {
				baseInfo=(BaseInfo)setValue(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			baseInfo=null;
			System.out.println(sql);
		}finally {
			baseInfoCon.close();
		}
		return baseInfo;
	}

	@Override
	public List getList( ) {
		// TODO Auto-generated method stub
		List baseInfoList = null;
		String sql = "select * from base_info;";
		baseInfoList = getData(sql);
		
		return baseInfoList;
	}
	
	public List getList( String type) {
		List baseInfoList = null;
		String sql = setSql( type);
		baseInfoList=getData(sql);
		
		return baseInfoList;
	}
	
	private String setSql( String type) {
		String sql = new String();
		if(type.equals("")) {
			sql = "select * from base_info;";
		}
		sql = "select * from base_info where user_type = '"+type+"';";
		return sql;
	}
	
	private List getData(String sql) {
		List baseInfoList = null;
		try {
			String [] column = baseInfoCon.getColumnName("base_info");
			ResultSet rs = baseInfoCon.excuteQuery(sql);
			baseInfoList = new ArrayList();
			while(rs.next()) {
				BaseInfo baseInfo = (BaseInfo) setValue(rs);
				if(baseInfo != null) {
					baseInfoList.add(baseInfo);
				}
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			baseInfoCon.close();
		}
		return baseInfoList;
	}

	@Override
	public String getColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getIdNameList() {
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
	public boolean deleteData(String id) {
		// TODO Auto-generated method stub
		isOk = false;
		String sql = "DELETE FROM base_info where user_id='"+id+"';";
		try {
			if(baseInfoCon.excuteUpdate(sql) == 1) {
				isOk = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			baseInfoCon.close();
		}
		return isOk;
	}

	@Override
	public boolean addData(Object data) {
		// TODO Auto-generated method stub
		isOk = false;
		BaseInfo baseInfoModel = (BaseInfo)data;
		String sql = "INSERT INTO base_info values(null,'"+baseInfoModel.getUserId()+"','"
		+baseInfoModel.getName()+"','"+baseInfoModel.getFormarName()+"','"+	baseInfoModel.getSex()+"',"
				+baseInfoModel.getAge()+",'"+baseInfoModel.getNativePlace()+"','"+baseInfoModel.getIdCardType()
				+"','"+baseInfoModel.getIdCardNum()+"','"+baseInfoModel.getUserType()+"','"
				+baseInfoModel.getTel()+"');";
		try {
			if(baseInfoCon.excuteUpdate(sql) == 1) {
				isOk = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			isOk = false;
		}finally {
			baseInfoCon.close();
		}
		return isOk;
	}

	@Override
	public boolean updateData(Object data, String id) {
		// TODO Auto-generated method stub
		isOk = false;
		BaseInfo baseInfo = (BaseInfo)data;
		String sql = "update base_info set user_id='"+baseInfo.getUserId()+"',name='"+baseInfo.getName()
		+"',formar_name='"+baseInfo.getFormarName()+"',sex='"+baseInfo.getSex()+"',age="+baseInfo.getAge()
		+",native_place='"+baseInfo.getNativePlace()+"',IDCARD_type='"+baseInfo.getIdCardType()+"',IDCARD_NUM='"
		+baseInfo.getIdCardNum()+"',tel='"+baseInfo.getTel()+"' where user_id='"+id+"';";
		try {
			if(baseInfoCon.excuteUpdate(sql) == 1) {
				isOk = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isOk = false;
		}finally {
			baseInfoCon.close();
		}
		return isOk;
	}

	@Override
	public Object setValue(ResultSet rs) {
		// TODO Auto-generated method stub
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
			base.setUserType(rs.getString("user_type"));
			base.setTel(rs.getString("tel"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base;
	}

}
