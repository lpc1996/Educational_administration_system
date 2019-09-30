package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mode.BaseInfo;
import com.mode.StudentModel;
import com.util.ConnXupt;

public class StudentDao implements DaoInterface{
	
	private ConnXupt studentDao;
	private boolean isOk;

	public StudentDao() {
		// TODO Auto-generated constructor stub
		studentDao = new ConnXupt();
	}
	
	public Object setValue(ResultSet rs) {
		StudentModel student = null;
		try {
			student = new StudentModel();
			student.setId(rs.getString("id"));
			student.setYear(rs.getString("year"));
			student.setCollege(rs.getString("college"));
			student.setDepartment(rs.getString("department"));
			student.setMajor(rs.getString("major"));
			student.setGrade(rs.getString("grade"));
			student.setClassId(rs.getString("class"));
			student.setCulture_level(rs.getString("culture_level"));
			student.setType(rs.getString("student_type"));
			student.setEducation(rs.getString("education"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			student = null;
		}
		return student;
	}
	
	public List getList( ) {
		List studentList = null;
		String sql = "SELECT * FROM student;";
		try {
			ResultSet rs = studentDao.excuteQuery(sql);
			studentList = new ArrayList();
			while(rs.next()) {
				StudentModel student = (StudentModel)setValue(rs);
				studentList.add(student);
			}
			studentDao.close();
		} catch (Exception e) {
			// TODO: handle exception
			studentList = null;
		}
		return studentList;
	}
	public boolean insertBaseInfo(BaseInfo base) {
		return new BaseInfoDao().addData(base);
	}
	
	public boolean deleteBaseInfo(String id) {
		return new BaseInfoDao().deleteData(id);
	}
	
	public boolean updateBaseInfo(BaseInfo base,String id) {
		return new BaseInfoDao().updateData(base,id);
	}
	
	public List getIdList() {
		List IdList = null;
		String sql = "select id from student";
		try {
			ResultSet rs = studentDao.excuteQuery(sql);
			IdList = new ArrayList();
			while(rs.next()) {
				String id = rs.getString("id");
				IdList.add(id);
			}
			studentDao.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return IdList;
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
		String sql= "DELETE FROM student where id='"+id+"'";
		try {
			if(studentDao.excuteUpdate(sql) == 1) {
				isOk = true;
			}
			studentDao.close();
		} catch (Exception e) {
			// TODO: handle exception
			isOk = false;
			e.printStackTrace();
		}
		return isOk;
	}

	@Override
	public boolean addData(Object data) {
		// TODO Auto-generated method stub
		isOk = false;
		StudentModel student = (StudentModel)data;
		String sql = "INSERT INTO student VALUES('"+student.getId()+"','"+student.getYear()+"','"+student.getCollege()+"','"+student.getDepartment()+"','"+
		student.getMajor()+"','"+student.getGrade()+"','"+student.getClassId()+"','"+student.getCulture_level()+"','"+student.getType()+
		"','"+student.getEducation()+"');";
//		System.out.println(sql);
		try {
			if( studentDao.excuteUpdate(sql) == 1) {
				isOk = true;
			}
			studentDao.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}

	@Override
	public boolean updateData(Object data, String id) {
		// TODO Auto-generated method stub
		isOk = false;
		StudentModel student = (StudentModel)data;
		String sql = "UPDATE student SET id='"+student.getId()+"', year='"+student.getYear()+"',college='"+student.getCollege()+"',department='"+student.getDepartment()
		+"',major='"+student.getMajor()+"',grade='"+student.getGrade()+"',class='"+student.getClassId()+"',culture_level='"+
				student.getCulture_level()+"',student_type='"+student.getType()+"',education='"+student.getEducation()+"' where id='"+id+"';";
		try {
			if(studentDao.excuteUpdate(sql) == 1) {
				isOk = true;
			}
			studentDao.close();
		} catch (Exception e) {
			// TODO: handle exception
			isOk = false;
			e.printStackTrace();
		}
		return isOk;
	}
}
