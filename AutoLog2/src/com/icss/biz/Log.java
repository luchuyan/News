package com.icss.biz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	private  static File file;  //  �����ļ���
	private  static File errorTxt;  // ����error.txt
	private  static File otherTxt;
	private  static String path;	// �洢���·��
	private  static Date date ; //  ��ȡ��ǰ����
	
//	
//	public LogBiz() throws URISyntaxException {
//		 path = this.getClass().getClassLoader().getResource("").toURI().getPath() + "log/"+
//					new SimpleDateFormat("yyyy-MM-dd").format(date);
//	}
	 
	static {
		date = new Date();
		
		try {
			path = Log.class.getResource("").toURI().getPath() + "log/" + new SimpleDateFormat("yyyy/MM/dd").format(date);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		file = new File(path);
		errorTxt = new File(path + "/error.txt");
		otherTxt = new File(path + "/other.txt");
		
		if(!file.exists()) {
			file.mkdirs();  //  �����ļ��� 
			
			try {
				errorTxt.createNewFile();     // �����ļ���txt��
				otherTxt.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
	public static void debug(String info) {
		writer(info, otherTxt);
	}
	
	public static void info(String info) {
		writer(info, otherTxt);
	}
	
	public static void warn(String info) {
		writer(info, otherTxt);
	}
	
	public static void error(String info) {
		writer(info, errorTxt);
	}
	
	private static void writer(String info , File fileName) {
		PrintWriter out = null; // ��� �ַ�
		
		try {
			
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
			out.println(date +"---" + info);
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			out.close();
		}
	}
}
