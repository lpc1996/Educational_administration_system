package com.dao;

import java.sql.ResultSet;
import java.util.List;

public interface DaoInterface {
	List getList();
	String getColumnName();
	List getIdNameList();
	List getComment();
	String getTableComment();
	boolean deleteData(String id);
	boolean addData(Object data);
	boolean updateData(Object data,String id);
	Object setValue(ResultSet rs);
}


