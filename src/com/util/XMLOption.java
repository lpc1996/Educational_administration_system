package com.util;

import java.awt.Dimension;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mode.Settings;

public class XMLOption {
	
	private Document document;
	private String XMLPath;
	public XMLOption(String path) {
		XMLPath = path;
		load();
	}
	
	private void load(){
		document = null;
		try {
			//System.out.println(XMLPath);
			SAXReader saxReader = new SAXReader();
			document = (Document) saxReader.read(XMLOption.class.getResource(XMLPath));
		} catch (Exception e) {
			// TODO: handle exception
			document = null;
		}
		
	}
	
	public Settings ReadSetting() {
		Settings setting = new Settings();
		Element settings = document.getRootElement();
		Element title = settings.elements().get(0);
		setting.setTitle(title.getText());
		Element size = settings.elements().get(1);
		Element width = size.elements().get(0);
		Element height = size.elements().get(1);
		setting.setSize(new Dimension(Integer.parseInt(width.getText()), Integer.parseInt(height.getText())));
		return setting;
	}
	
	public static void main(String [] argv) {
		XMLOption xml = new XMLOption("/com/lib/Settings.xml");
		xml.ReadSetting();
	}
}
