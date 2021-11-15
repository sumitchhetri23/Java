package moore;

import java.util.Scanner;


public class MooreMachine {
	public static void main(String[] args) throws Exception {
		MooreM states[] = new MooreM[5];
		states[0] = new MooreM(' ',"",0,0);
		states[1] = new MooreM('A',"00",2,4);
		states[2] = new MooreM('B',"01",2,3);
		states[3] = new MooreM('C',"11",4,3);
		states[4] = new MooreM('D',"10",3,1);
		
		//getting input
		Scanner readScanner = new Scanner(System.in);
		System.out.println("Please enter the inital State:");
		String m = readScanner.nextLine();
		System.out.println("Please enter the input: ");
		String inputValue = readScanner.nextLine();
		readScanner.close();
		if(m.length()>1) {
			throw new Exception("Invalid State");
		}
		char inState = m.charAt(0);
		char initState = Character.toUpperCase(inState);
		String[] inputArr = new String[inputValue.length()];
		for(int i=0;i<inputValue.length();i++) {
			String q = inputValue.substring(i, i+1);
			if(q.equals("1") || q.equals("0")) {
				inputArr[i] = q;
			}else {
				throw new Exception("Invalid input");
			}
		}
		char lastState = ' ';
		int startingIndex = -1;
		boolean validity = false;
		String[] path = new String[inputArr.length+1]; 
		for(int j=0;j<states.length;j++) {
			validity = states[j].checkValidityState(initState);
			if(validity) {
				startingIndex = j;
				break;
			}
		}
		if(validity && startingIndex != -1) {
			for(int k=0;k<inputArr.length;k++) {
				path[k] = states[startingIndex].transition();
				startingIndex = states[startingIndex].transitionPath(inputArr[k]);
				if(k+1 == inputArr.length) {
					path[k+1] = states[startingIndex].transition();
					lastState = states[startingIndex].stateValue();
				}
			}
			if(startingIndex == -1) {
				System.out.println("Check your inputs");
			}else {
				System.out.println("The output is: ");
				for(int j=0;j<path.length;j++) {
					System.out.printf("%s ",path[j]);
				}
				System.out.println();
				System.out.printf("The final State is: %c",lastState);
				System.out.println();
			}
		}else {
			System.out.println("The data entered does not matches with the Moore's data");
		}
	}
}


class MooreM {
	private char state;
	private String output;
	int zero;
	int one;
	
	MooreM(char state,String output,int zero, int one){
		this.state= state;
		this.output = output;
		this.zero = zero;
		this.one = one;
	}
	public boolean checkValidityState(char state) {
		String[] a = new String[2];
		int valid = Character.compare(state, this.state);
		if(valid == 0) {
			return true;
		}else {
			return false;
		}
	}
	public int transitionPath(String a) {
		if(a.equals("1")) {
			return this.one;
		}else if(a.equals("0")){
			return this.zero;
		}else {
			return -1;
		}
	}
	public String transition() {
		return this.output;
	}
	public char stateValue() {
		return this.state;
	}
}
