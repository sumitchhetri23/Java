package hamm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class Hamming {
	private static Scanner fileRead;
	private static StringBuffer msgBuff = new StringBuffer();
	public static void checkFile() {
		try {
			fileRead = new Scanner(new File("hamming.txt"));			
			System.out.println("File hamming.txt opened");
		}
		catch (Exception e) {
			System.out.println("Try correct file address");
		}
	}
	public static void readingFile(){
		while(s.hasNextInt(16)) {
			int m = s.nextInt(16);
			String n = Integer.toBinaryString(m);
			String[] newS = new String[n.length()];
			for(int i=0; i<n.length();i++) {
				newS[i] = n.substring(i,i+1);
			}
			checkError(newS);
		}
	}
	public static void checkError(String[] val){
		int len = val.length;
		int parityLen = 0;
		if(len<=7) {
			parityLen = 3;
		}else if(len<=16) {
			parityLen = 4;
		}else if(len<=32) {
			parityLen = 5;
		}
		String[] parityArr = new String[parityLen];
		String[] dataArr = new String[len-parityLen];
		for(int i=0,j=parityArr.length-1;i<parityArr.length&&j>=0;i++,j--) {
			double d = Math.pow(2, i);
			int sub = (int)d;
			parityArr[j] = val[len-sub];
		}
		
		
		int n1 = 0;
		int n2 =0;
		int n3 = 0;
		int n4 =0;
		if(parityArr.length == 3) {
			for(int n =val.length-1; n>=0;n=n-2) {
				if(val[n].equals("1")) {
					n1 += 1;
				}
		}
			for (int w = val.length-1;w>=0;w--) {
				if(val.length-w>=4 && val.length-w<=7) {
					if(val[w].equals("1")) {
						n3 += 1;
					}
				}
			}
			for(int b=val.length-1;b>=0;b--) {
				if(val.length-b == 2||val.length-b == 3) {
					if(val[b].equals("1")) {
						n2 += 1;
					}
				}else if(val.length-b == 6||val.length-b == 7) {
					if(val[b].equals("1")) {
						n2 += 1;
					}
				}
			}
		}else if(parityArr.length == 4) {
			for (int q =val.length-1; q>=0;q=q-1) {
				if((val.length-q)%2 == 1) {
					if(val[q].equals("1")) {
						n1++;
					}					
				}
			}
			for (int w = val.length-1;w>=0;w--) {
				if(val.length-w>=4 && val.length-w<=7) {
					if(val[w].equals("1")) {
						n3 += 1;
					}
				}else if(w>=val.length-12 && w<=val.length-15) {
					if(val[w].equals("1")) {
						n3 += 1;
					}
				}
			}
			for(int e = val.length-1;e>=0;e--) {
				if(val.length-e>=8&&val.length-e<=11) {
					if(val[e].equals("1")) {
						n4 += 1;
					}
					}	
				}

			for(int b=val.length-1;b>=0;b--) {
				if(val.length-b == 2||val.length-b == 3) {
					if(val[b].equals("1")) {
						n2 += 1;
					}
				}else if(val.length-b == 6||val.length-b == 7) {
					if(val[b].equals("1")) {
						n2 += 1;
					}
				}else if(val.length-b == 10|| val.length-b == 11) {
					if(val[b].equals("1")) {
						n2 += 1;
					}
				}else if(val.length-b == 14|| val.length-b == 15) {
					if(val[b].equals("1")) {
						n2 += 1;
					}
				}
			}
			}
		//Correcting way
		int rem1 = n1%2;
		int rem2 = n2 %2;
		int rem3 = n3 %2;
		int rem4 = n4 % 2;
		int weight1 = rem1;
		int weight2 = rem2 * 2;
		int weight3 = rem3 * 4;
		int weight4 = rem4 * 8;
		int errorBit = weight1 + weight2+ weight3 +weight4;
		if(errorBit != 0) {
					if(val[len-errorBit].equals("1")) {
						val[len-errorBit]="0";
					}else {
						val[len-errorBit]="1";
					}
		}
		
		//To write
		StringBuffer str = new StringBuffer();
		if(parityLen == 3) {
			for(int j = len-1,o = dataArr.length -1;j>=0&&o>=0;) {
				if(j == len-Math.pow(2,0)||j ==len-Math.pow(2, 1)||j==len-Math.pow(2, 2)) {
					j = j-1;
				}else {
					dataArr[o] = val[j];
					o = o -1;
					j = j -1;
				}
			}
		}else if(parityLen == 4) {
			for(int j=len-1,o=dataArr.length-1;j>=0&&o>=0;) {
				if(j == len-Math.pow(2, 0)||j == len-Math.pow(2, 1)||j == len-Math.pow(2, 2)||j == len-Math.pow(2, 3)) {
					j = j -1;
				}else{				
					dataArr[o] = val[j];
					o = o-1;
					j = j-1;
				}
			}
		}
		for(int q=0;q<dataArr.length;q++) {
			str.append(dataArr[q]);
		}
		String finalStr = str.toString();
		int x = Integer.parseInt(finalStr,2);
		char p = (char)x;
		for(int q=0;q<dataArr.length;q++) {
			str.append(dataArr[q]);
		}
		sm.append(p);
		String message = "Error in bit";
		String charact = "corrected in character";
		if(errorBit != 0) {
			System.out.printf("%s %d %s %c",message,errorBit,charact, p);
			System.out.println();
		}
	
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		checkFile();
		readingFile();
		String ms = sm.toString();
		write(ms);
	}
	public static void write(String text) throws IOException {
		String filename = "output.txt";
		BufferedWriter bWrite = new BufferedWriter(new FileWriter(filename));
		bWrite.write(text);
		bWrite.close();
		System.out.printf("File %s closed",filename);
	}
}
