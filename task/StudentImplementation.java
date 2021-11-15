package task;

import java.util.Scanner;

public class StudentImplementation{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner readInput = new Scanner(System.in);
		try {
		System.out.print("Enter the size of data set:");
		int totalNumber = readInput.nextInt();
		System.out.print("Enter the initial size of data set: ");
		int initialNumber = readInput.nextInt();
		if(initialNumber>totalNumber) {
			System.out.println("Initial size of data set cannot be greater than the size of data set");
		}else {
			Student[] studentList = new Student[totalNumber];

			if(initialNumber<=0) {
				
			}else {
			
				for(int i=1;i<=initialNumber;i++) {
					String name = "Student"+i;
					int id = i;
					float GPA = (float) (8.0-i);
					studentList[i-1] = new Student(name,id,GPA);
				}
			}
				int numberOfEntries = initialNumber;
				for(int j=0;j<1;) {
					System.out.println("--------------------------------------------------------------");
					Student.displayMenu();
					try {
						int userInputMenu = readInput.nextInt();
						if(userInputMenu==6) {
							System.out.println("Exited successfully");
							readInput.close();
							break;
						}else {
							if(userInputMenu==1) {
								try {
									System.out.println("Enter Student Name :");
									String studentName = readInput.next();
									System.out.println("Enter Student Grade :");
									float studentGrade = readInput.nextFloat();
									if(studentList[numberOfEntries]==null&&numberOfEntries<=totalNumber) {
										studentList[numberOfEntries] = new Student(studentName,numberOfEntries+1,studentGrade);
										if(numberOfEntries == studentList.length-1) {
											numberOfEntries = 0;
										}else {
											numberOfEntries++;
										}
									}else if(numberOfEntries>totalNumber||studentList[numberOfEntries]!=null){
										numberOfEntries = -1;
										for(int i=0;i<studentList.length;i++) {
											if(studentList[i]==null) {
												numberOfEntries = i;
												break;
											}
										}
										if(numberOfEntries == -1) {
											System.out.println("Records full.");
										}else {
											studentList[numberOfEntries] = new Student(studentName,numberOfEntries+1,studentGrade);
										}
									}
								}catch(Exception e) {
									throw e;
								}
							}else if(userInputMenu == 5) {
								Student.sortedOutput(studentList);
							}else if(userInputMenu == 2){
								System.out.print("Enter the student ID whose details you need to see:");
								try {
									int q = readInput.nextInt();
									int m = Student.getIndexOfRecord(studentList,q);
									if(m==-1) {
										System.out.println("Student record does not exist");
									}else {
									System.out.println("Student ID: "+studentList[m].getId());
									System.out.println("Name: "+studentList[m].getName());
									System.out.println("GPA: "+studentList[m].getGpa());
									}
								}catch(Exception e) {
									throw e;
								}
							}else if(userInputMenu ==3) {
								try{
									System.out.print("Enter the student ID: ");
									int toBeDeleted = readInput.nextInt();
									int ind = Student.getIndexOfRecord(studentList,toBeDeleted);			
									if(ind == -1) {
										System.out.println("ID does not Exist");
									}else {
										studentList[ind] = null;
									}
								}catch(Exception e) {
									throw e;
								}
								
							}else if(userInputMenu == 4) {
								try {
									System.out.print("Enter the student ID: ");
									int toBeUpdated = readInput.nextInt();
									int ind = Student.getIndexOfRecord(studentList,toBeUpdated);
									if(ind == -1) {
										System.out.println("No student have the student ID:"+toBeUpdated);
									}else {
										System.out.println("    1 to update name");
										System.out.println("    2 to update gpa");
										int selectedType = readInput.nextInt();
										if(selectedType == 1) {											
											System.out.print("Enter the new name: ");
											String newName = readInput.next();
											studentList[ind].setName(newName);
											System.out.println("Student name updated successfully");
										
										}else if(selectedType == 2) {
											System.out.print("Enter the new GPA: ");
											float newGPA = readInput.nextFloat();
											studentList[ind].setGpa(newGPA);
											System.out.println("Student GPA updated successfully");
										}
										
									}
									
								}catch(Exception e) {
									throw e;
								}
							}
						}
					}catch(Exception e) {
						throw e;
					}
				}
			}
		}catch(Exception e) {
			throw e;
		}
	}
}

