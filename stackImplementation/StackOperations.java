package stackImplementation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackOperations {
	static float[] memArr = new float[10];
	static void pushOp(Stack<Float> jStack,float fdata) {
		jStack.push(fdata);
	}
	static void pushOp(Stack<Float> jStack,String sdata) {
		String n = sdata.substring(1);
		Integer num = Integer.parseInt(n);
		Float fdata = memArr[num];
		jStack.push(fdata);
	}
	static void popOp(Stack<Float> jStack) {
		jStack.pop();
	}
	static void popOp(Stack<Float> jStack, String sdata) {
		Float f = (Float)jStack.pop();
		String n = sdata.substring(1);
		Integer num = Integer.parseInt(n);
		memArr[num] = f;
		System.out.println(memArr[num]+" Stored in location "+sdata);
	}
	static void addOp(Stack<Float> jStack) {
		Object[] staToArray = jStack.toArray();
		Float value1 = (Float)staToArray[staToArray.length-2];
		Float value2 = (Float)staToArray[staToArray.length-1];
		Float finValue = value1+value2;
		jStack.push(finValue);
	}
	static void subOp(Stack<Float> jStack) {
		Object[] staToArray = jStack.toArray();
		Float value1 = (Float)staToArray[staToArray.length-2];
		Float value2 = (Float)staToArray[staToArray.length-1];
		Float finValue = value1-value2;
		jStack.push(finValue);
		
	}
	static void mulOp(Stack<Float> jStack) {
		Object[] staToArray = jStack.toArray();
		Float value1 = (Float)staToArray[staToArray.length-2];
		Float value2 = (Float)staToArray[staToArray.length-1];
		Float finValue = value1*value2;
		jStack.push(finValue);		
	}
	static void divOp(Stack<Float> jStack) {
		Object[] staToArray = jStack.toArray();
		Float value1 = (Float)staToArray[staToArray.length-2];
		Float value2 = (Float)staToArray[staToArray.length-1];
		Float finValue = value1/value2;
		jStack.push(finValue);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("machine.txt"));
		Stack<Float> jStack = new Stack<Float>();
		while(sc.hasNext()) {
			String st = sc.nextLine();
			String st1 = st.toUpperCase();
			//Push Operation
			if(st1.startsWith("PUSH")) {
				String data = st.substring(5);
				data = data.trim();
				try {
					Float fdata = Float.parseFloat(data);
					pushOp(jStack,fdata);
				}catch (Exception ex) {
					pushOp(jStack,data);
				}
			}
			//Pop Operation
			if(st1.startsWith("POP")) {
				String data = st.substring(4);
				data = data.trim();
				if(data == "") {
					popOp(jStack);
				}else {
					popOp(jStack,data);
				}
				
			}
			//Add Operation
			if(st1.startsWith("ADD")) {
				addOp(jStack);
			}
			//Sub Operation
			if(st1.startsWith("SUB")) {
				subOp(jStack);
			}
			//Mul Operation
			if(st1.startsWith("MUL")) {
				mulOp(jStack);
			}
			//Div Operation
			if(st1.startsWith("DIV")) {
				divOp(jStack);
			}
			
		}
		sc.close();
	}

}
