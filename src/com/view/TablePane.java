package com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TablePane extends JPanel {
	
	private JPanel btnPane;
	private JTable table;
	private JButton searchBtn;
	protected JTextField searchText;
	private Dimension size;

	public TablePane(Dimension size) {
		super();
		this.size = size;
		this.setPreferredSize(size);
		FlowLayout flow = new FlowLayout(5, 5, 5);
		this.setLayout(flow);
		InitContPane();
		setSearchModel();
	}
	
	private void InitContPane() {
		JScrollPane tableJs = new JScrollPane();
		tableJs.setPreferredSize(new Dimension(size.width-20,size.height-80));
		table = new JTable();
		tableJs.setViewportView(table);
		this.add(tableJs);
		btnPane = new JPanel();
		btnPane.setPreferredSize(new Dimension(size.width-20,70));
		btnPane.setLayout(new FlowLayout(5,5,5));
		this.add(tableJs);
		this.add(btnPane);
	}
	
	private void InitData() {
		
	}
	
	private void setSearchModel() {
		searchText = new JTextField();
		searchBtn = new JButton("查询");
		searchText.setPreferredSize(new Dimension(size.width-120,30));
		searchBtn.setPreferredSize(new Dimension(80,30));
		searchBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String str = searchText.getText();
				if(str.length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入要查询的字段", "友情提示", JOptionPane.WARNING_MESSAGE,new ImageIcon(LoginView.getImages().getWarring2()));
					return;
				}
				int i = 0;
				for(; i < table.getRowCount(); i++) {
					if(table.getValueAt(i, 0).equals(str) || table.getValueAt(i, 1).equals(str)) {
						table.setRowSelectionInterval(i, i);
						table.scrollRectToVisible(table.getCellRect(i, 0, true));
						break;
					}
				}
				if(i == table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "找不到"+str);
				}
			}
		});
		btnPane.add(searchText);
		btnPane.add(searchBtn);
	}
	
	public void setAddBtn(JButton addBtn) {
		btnPane.add(addBtn);
	}
	
	public void setChangeBtn(JButton changeBtn) {
		btnPane.add(changeBtn);
	}
	
	public void setdeleteBtn(JButton deleBtn) {
		btnPane.add(deleBtn);
	}
	
	public void setRefreshBtn(JButton refreshBtn) {
		btnPane.add(refreshBtn);
	}
	
	public void setDefaultModel(DefaultTableModel model) {
		table.setModel(model);
	}
	
	public int getSelectRow() {
		return table.getSelectedRow();
	}
	
	public String getValueAt(int row,int column) {
		return table.getValueAt(row, column)+"";
	}
}
