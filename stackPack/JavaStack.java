package stackPack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class JavaStack {
	static float[] a = new float[10];
	public static void staPush(Stack<Float> sta, float val) {
		sta.push(val);
	}
	public static void staPush(Stack<Float> sta, String loctn) {
		String m = loctn.substring(1,loctn.length());
		Integer ind = Integer.parseInt(m);
		float val = (float)a[ind];
		sta.push(val);
	}
	public static void staPop(Stack<Float> sta) {
		sta.pop();
	}
	public static void staPop(Stack<Float> sta, String q) {
		String m = q.substring(1, q.length());
		Integer ind = Integer.parseInt(m);
		float value = (float)sta.pop();
		a[ind] = value;
		System.out.println(a[ind]+" Stored in location "+q);
	}
	public static void staAdd(Stack<Float> sta) {
		Object[] staArr = sta.toArray();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first+second;
		sta.push(result);
	}
	public static void staSub(Stack<Float> sta) {
		Object[] staArr = sta.toArray();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first-second;
		sta.push(result);
	}
	public static void staMul(Stack<Float> sta) {
		Object[] staArr = sta.toArray();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first*second;
		sta.push(result);
	}
	public static void staDiv(Stack<Float> sta) {
		Object[] staArr = sta.toArray();
		float first = (float) staArr[staArr.length-2];
		float second = (float) staArr[staArr.length-1];
		float result = first/second;
		sta.push(result);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new FileReader("machine.txt"));
		Stack<Float> sta = new Stack<Float>();
		String lineContent;
		while((lineContent = rd.readLine()) != null) {
			if(lineContent.startsWith("Push")||lineContent.startsWith("push")||lineContent.startsWith("push")) {
				String q = lineContent.substring(5,lineContent.length());
				q = q.trim();
				try {
					Float val = Float.parseFloat(q);
					staPush(sta,val);
				}catch (Exception e) {
					staPush(sta,q);
				}
				}
			if(lineContent.startsWith("Pop")||lineContent.startsWith("POP")||lineContent.startsWith("pop")) {
				String q = lineContent.substring(4,lineContent.length());
				q = q.trim();
				if(q == "") {
					staPop(sta);
				}else {
					staPop(sta,q);
				}
			}
			if(lineContent.startsWith("Add")||lineContent.startsWith("ADD")||lineContent.startsWith("add")) {
				staAdd(sta);
			}
			if(lineContent.startsWith("Sub")||lineContent.startsWith("SUB")||lineContent.startsWith("sub")) {
				staSub(sta);
			}
			if(lineContent.startsWith("Mul")||lineContent.startsWith("MUL")||lineContent.startsWith("mul")) {
				staMul(sta);
			}
			if(lineContent.startsWith("Div")||lineContent.startsWith("DIV")||lineContent.startsWith("div")) {
				staDiv(sta);
			}
			
			}
		rd.close();
	}

}
