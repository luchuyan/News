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
				System.out.print("�����뱻����:");
				int num1 = in.nextInt();
				Log.debug("���뱻������" + num1); 
				
				System.out.print("���������:");
				int num2 = in.nextInt();
				Log.debug("���������" + num2);
				
				System.out.println(String.format("%d / %d = %d", 
						num1, num2, num1/ num2));
				Log.debug("�����������" + String.format("%d / %d = %d",
						num1, num2, num1 / num2));
				
			} catch (InputMismatchException e) {
				
				StringWriter sw = new StringWriter();  // ���getMessage Ϊnull ������  --->ȡ���쳣����ϸ��Ϣ�������ַ����
				e.printStackTrace(new PrintWriter(sw,true)); //true ΪautoFlush
				String str = sw.toString();
				
				e.printStackTrace();
				Log.error("�������ͳ�������������\n "+ str);
				
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
				System.out.println("��ӭʹ�ñ�����");
			}
		}
}
