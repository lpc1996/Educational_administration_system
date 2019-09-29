package com.dao;

import java.util.List;

public interface DaoInterface {
	List getList();
	String getColumnName();
	List getIdNameList();
	List getComment();
	String getTableComment();
	boolean deleteData(String id);
	void setValue();
}


