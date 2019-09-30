package com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.dao.BaseInfoDao;
import com.dao.StudentDao;
import com.mode.BaseInfo;
import com.mode.StudentModel;
import com.util.ConnXupt;

public class StudentInfo extends GUIModel implements Comment {

	private JPanel contentPane;
	private FlowLayout flow;
	private TablePane tablePane;
	private StudentDao studentDao;
	private BaseInfoDao baseDao;
	private List studentBaseList;

	public StudentInfo() {
		super();
		this.setTitle("学生信息管理");
		this.setSize(1180,600);
		studentDao = new StudentDao();
		baseDao = new BaseInfoDao();
		InitContentPane();
		InitTable();
	}

	@Override
	public void InitData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void InitContentPane() {
		// TODO Auto-generated method stub
		
		contentPane = new JPanel();
		flow = new FlowLayout(5, 5, 5);
		contentPane.setLayout(flow);
		
		tablePane = new TablePane(new Dimension(1160,400));
//		tablePane.setPreferredSize();
		tablePane.updateUI();
		contentPane.add(tablePane);
		this.setContentPane(contentPane);
	}
	
	private void InitTable() {
		studentBaseList = baseDao.getList();
		Vector titleVec = new ConnXupt().getComment("base_info");
		titleVec.remove(0);
		DefaultTableModel model = new DefaultTableModel(titleVec,studentBaseList.size());
		for(int i = 0; i < studentBaseList.size() ; i++) {
			BaseInfo student = (BaseInfo)studentBaseList.get(i);
			model.setValueAt(student.getUserId(),i , 0);
			model.setValueAt(student.getName(), i, 1);
			model.setValueAt(student.getFormarName(), i, 2);
			model.setValueAt(student.getSex(), i, 3);
			model.setValueAt(student.getAge(), i, 4);
			model.setValueAt(student.getNativePlace(), i, 5);
			model.setValueAt(student.getIdCardType(), i, 6);
			model.setValueAt(student.getIdCardNum(), i, 7);
			model.setValueAt(student.getUserType(), i, 8);
			model.setValueAt(student.getTel(), i, 9);
		}
		tablePane.setDefaultModel(model);
	}

}
