package paging;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
public class PageFrameImple {
	private static int lineCount = 0; 
	private static int h = 0;
	private static String[] frameA = new String[8];
	private static Scanner readScanner;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readScanner = new Scanner(new File("virtual.txt"));
		int i =0;
		String filename = "physical.txt";
		BufferedWriter bWrite = new BufferedWriter(new FileWriter(filename));

		while(readScanner.hasNextInt(16)) {
			lineCount = lineCount + 1;
			int readData = readScanner.nextInt(16);
			String str = Integer.toHexString(readData);
			String binaryValue = Integer.toBinaryString(readData);
			String subBinaryValue = "0";
			int len = binaryValue.length();
			int q = len -8;
			subBinaryValue = binaryValue.substring(0,q);
			String offsetValue = binaryValue.substring(q,binaryValue.length());
			int dec = Integer.parseInt(subBinaryValue,2);
			String frameBlock = "";
			String hexSubString = Integer.toHexString(dec);
			List<String> nameList = new ArrayList<>(Arrays.asList(frameA));
			if(i == 8) {
				i = 0;
			}
			if(nameList.contains(hexSubString)) {
				h += 1;
				int b = getFrameNumber(hexSubString);
				frameBlock = Integer.toBinaryString(b);
			}else{
				frameBlock = Integer.toBinaryString(i);
				if(frameA[i] != null) {
					System.out.printf("Page Fault: Page %s loaded in frame %d replaces page %s",hexSubString,i,frameA[i]);
					System.out.println();					
				}
				frameA[i] = hexSubString;
				i = i + 1;
			}
			String toWrite = frameBlock.concat(offsetValue);
			String physicalAddress = new BigInteger(toWrite,2).toString(16);
			
			// Writing to physical.txt
			try {
				bWrite.write(physicalAddress);
				bWrite.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		//Final Output and closing files
		System.out.printf("File %s closed",filename);
		System.out.println();
		double n = (double)h/(double)lineCount;
		String hitRatio = Double.toString(n);
		System.out.printf("Hit ratio: %s",hitRatio);
		readScanner.close();
		bWrite.close();

	}
	
	//frameNumber for hit data
	public static int getFrameNumber(String hexSubString) {
		int res = 0;
		for(int i =0;i<frameA.length;i++) {
			if(frameA[i]!= null) {
				if(frameA[i].equalsIgnoreCase(hexSubString)) {
					res = i;
				}
			}
		}
		return res;
	}
}
