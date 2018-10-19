package com.icss.ui;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.icss.biz.Log;

public class Division {	
		public static void main(String[] args) throws URISyntaxException{
			
			
			try {
				
				Scanner in = new Scanner(System.in);
				System.out.print("请输入被除数:");
				int num1 = in.nextInt();
				Log.debug("输入被除数：" + num1); 
				
				System.out.print("请输入除数:");
				int num2 = in.nextInt();
				Log.debug("输入除数：" + num2);
				
				System.out.println(String.format("%d / %d = %d", 
						num1, num2, num1/ num2));
				Log.debug("输出运算结果：" + String.format("%d / %d = %d",
						num1, num2, num1 / num2));
				
			} catch (InputMismatchException e) {
				
				StringWriter sw = new StringWriter();  // 解决getMessage 为null 的问题  --->取得异常的详细信息（存在字符串里）
				e.printStackTrace(new PrintWriter(sw,true)); //true 为autoFlush
				String str = sw.toString();
				
				e.printStackTrace();
				Log.error("被除数和除数必须是整数\n "+ str);
				
			} catch (ArithmeticException e) {
				
				StringWriter sw = new StringWriter(); 
				e.printStackTrace(new PrintWriter(sw,true));
				String str = sw.toString();
				
				e.printStackTrace();
				Log.error(str);
				
			} catch (Exception e) {
				
				StringWriter sw = new StringWriter(); 
				e.printStackTrace(new PrintWriter(sw,true));
				String str = sw.toString();
				
				e.printStackTrace();
				Log.error(str);
			
			} finally {
				System.out.println("欢迎使用本程序！");
			}
		}
}
