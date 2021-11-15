package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
	private String name;
	private int id;
	private float gpa;
	
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	public float getGpa() {
		return this.gpa;
	}
	Student(String name, int id, float gpa){
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	} 
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public String displayResult() {

		return "-------------------------------------------------------------- \n"+"Student ID\t:"+this.id+"\nName            :"+this.name+"\nGPA             :"+this.gpa;
	}
	public static void displayMenu() {
		System.out.println("Enter: 1 to insert a new student's information,");
		System.out.println("2 to fetch and output a student's information,");
		System.out.println("3 to delete a student's information,");
		System.out.println("4 to update a student's information,");
		System.out.println("5 to output all the student information in sorted order, and");
		System.out.println("6 to exit the program");
	}

	public static int getIndexOfRecord(Student[] studentList, int g) {
		int result = -1;
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i]!=null) {
				if(studentList[i].getId() == g) {
					result = i;
					break;
				}
			}
		}
		return result;
	}
	public static int getIndexOfRecord(Student[] studentList, float num) {
		int result = -1;
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i]!=null) {
				if(studentList[i].getGpa() == num) {
					result = i;
					break;
				}
			}
		}
		return result;
	}
	
	public static void sortedOutput(Student[] studentList) {
		List<Float> value = new ArrayList<Float>();
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i]!=null) {
				value.add(studentList[i].getGpa());
			}else {				
			}
		}
		Collections.sort(value);
		Collections.reverse(value);
		for(Float g: value) {
			int res = getIndexOfRecord(studentList,g);
			System.out.println(studentList[res].displayResult());
		}

	}

}
