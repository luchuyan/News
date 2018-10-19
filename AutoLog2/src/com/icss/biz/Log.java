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
	private  static File file;  //  创建文件夹
	private  static File errorTxt;  // 创建error.txt
	private  static File otherTxt;
	private  static String path;	// 存储相对路径
	private  static Date date ; //  获取当前日期
	
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
			file.mkdirs();  //  创建文件夹 
			
			try {
				errorTxt.createNewFile();     // 创建文件（txt）
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
		PrintWriter out = null; // 针对 字符
		
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
