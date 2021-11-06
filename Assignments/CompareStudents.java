/*
Jasurbek Mamurov
U2010164
Lab Assignment # 7
Collection

1. Compile CompareStudents.java
2. Run StudentCollectionDemo
*/

import java.util.*;

public class CompareStudents implements Comparable<CompareStudents> {

    // data fields
    private int studentID;
    private String studentName;
    private int age;

    CompareStudents() { // no-argument constructor
        this(12345678, "Tony", 10);
    }

    CompareStudents(int studentID, String studentName, int age) { // constructor
        this.studentID = studentID;
        this.studentName = studentName;
        this.age = age;
    }

    // Getting the studentID
    public int getStudentID() {
        return studentID;
    }

    // Setting the studentID
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // Getting the studentName
    public String getStudentName() {
        return studentName;
    }

    // Setting the studentName
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    // Getting the age
    public int getAge() {
        return age;
    }

    // Setting the age
    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(CompareStudents st) {
        if (this.age > st.age)
            return 1;
        else if(this.age < st.age)
            return -1;
        else
            return 0;
    }
}

class StudentCollectionDemo{
    public static void main(String[] args) {
        //An array of 5 students
        ArrayList<CompareStudents> students = new ArrayList<CompareStudents>();

        //adding students
        students.add(new CompareStudents(1, "Pawan", 22));
        students.add(new CompareStudents(2, "Salman", 18));
        students.add(new CompareStudents(3, "Amitabh", 20));
        students.add(new CompareStudents(4, "Abdul", 19));
        students.add(new CompareStudents(5, "Ashish", 21));

	//Traversing the array before sorting
	System.out.println("\nBefore sorting---------\n");
	 for(CompareStudents student:students){
            System.out.println("Id: "+"("+student.getStudentID()+") "+
                    "Age: "+"("+student.getAge()+") "+ "Name: "+"("+student.getStudentName()+")");
        }

        //Sorting the students according to their age
        Collections.sort(students);

	System.out.println("\nAfter sorting---------\n");

	//Traversing the array after sorting
        //Students' details
        for(CompareStudents student:students){
            System.out.println("Id: "+"("+student.getStudentID()+") "+
                    "Age: "+"("+student.getAge()+") "+ "Name: "+"("+student.getStudentName()+")");
        }

    }
}