package javaStack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class JStack {
	public static void stapush(Stack sta, float a) {
		sta.push(new Float(a));
	}
	public static void stapush(Stack sta, String a) {
		Object[] staArr = sta.toArray();
		a = a.trim();
		int ind = Integer.parseInt(a.substring(1));
		sta.push(staArr[ind]);		
	}
	
	public static float stapop(Stack sta,String q) {
		Object[] staArr = sta.toArray();
		q = q.trim();
		int ind = Integer.parseInt(q.substring(1));
		float a = (float)staArr[ind];
		System.out.println(a + " Stored in location "+q.trim());
		return a;
	}
	public static void staAdd(Stack sta) {
		Object[] staArr = sta.toArray();
		sta.pop();
		sta.pop();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first+second;
		sta.push(result);
	}
	public static void staSub(Stack sta) {
		Object[] staArr = sta.toArray();
		sta.pop();
		sta.pop();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first-second;
		sta.push(result);
	}
	public static void staMul(Stack sta) {
		Object[] staArr = sta.toArray();
		sta.pop();
		sta.pop();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first*second;
		sta.push(result);
	}
	public static void staDiv(Stack sta) {
		Object[] staArr = sta.toArray();
		sta.pop();
		sta.pop();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first/second;
		sta.push(result);
	}
	public static void main( String[] args) throws IOException {
		float a = 0;
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Coding\\machine.txt"));
		Stack sta = new Stack();
		String line;
		while((line = in.readLine()) != null) {
			if(line.startsWith("Push")||line.startsWith("push")) {
				String val = line.substring(5,line.length());
				val = val.trim();
				try {
				Float q = Float.parseFloat(val);
				stapush(sta,q);
				}catch(Exception e) {
					stapush(sta,val);
				}
			}
			if(line.startsWith("pop")||line.startsWith("Pop")) {
				String val = line.substring(3,line.length());
				a = stapop(sta,val);
			}
			if(line.startsWith("Add")||line.startsWith("add")) {
				staAdd(sta);
			}
			if(line.startsWith("Sub")||line.startsWith("sub")) {
				staSub(sta);
			}
			if(line.startsWith("Mul")||line.startsWith("mul")||line.startsWith("MUL")) {
				staMul(sta);
			}
			if(line.startsWith("Div")||line.startsWith("div")||line.startsWith("DIV")) {
				staDiv(sta);
			}
		}
		in.close();
		/*		System.out.println("Stack: "+sta);
		System.out.println("enter command");
		String n = readScanner.nextLine();
		if(n.startsWith("push")) {
			String m = n.substring(5,n.length());
			Float q = Float.parseFloat(m);
			stapush(sta,q);
			stapop(sta);
*/
		
		}
	}

