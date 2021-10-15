/**
 Jasurbek Mamurov
 U2010164
 Assignment #5
 Exception Handling
**/

import java.util.Scanner;

class AgeOutOfRange extends Exception{

    AgeOutOfRange(String str){
        super(str);
    }
}

class Student {

    // data fields
    private int StudentID;
    private String StudentName;
    private int Age;

    Student() { // default constructor
        this.StudentID = 12345678;
        this.StudentName = "Tony";
        this.Age = 10;
    }

    Student(int StudentID, String StudentName, int Age) { // constructor
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.Age = Age;
    }

    // Getting the studentID
    public int getStudentID() {
        return StudentID;
    }

    // Setting the studentID
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    // Getting the studentName
    public String getStudentName() {
        return StudentName;
    }

    // Setting the studentName
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }


    // Getting the age
    public int getAge() {
        return Age;
    }

    // Setting the age
    public void setAge(int Age) throws AgeOutOfRange {
            if (Age < 1 || Age >= 100)
                throw new AgeOutOfRange("Invalid range is used\nThe correct one is in (1-100)");
            else
                this.Age = Age;
        }
}



// Driver class
class ExceptionDemo {

    public static void main(String[] args) {

        String StudentName;
        int StudentAge, StudentID;
        Student student_one = new Student();

        Scanner sc = new Scanner(System.in);
        System.out.println("\nCreating a new student:");
        System.out.print("\n Enter Name: ");
        StudentName = sc.nextLine();
        student_one.setStudentName(StudentName);

        System.out.print("\n Enter ID: ");
        StudentID = sc.nextInt();
        student_one.setStudentID(StudentID);

        System.out.print("\n Enter Age: ");
        StudentAge = sc.nextInt();
        try {
            student_one.setAge(StudentAge);
            //Student's details
            System.out.println("\nThe student's\nID: "
                    + student_one.getStudentID() + "\nName: "
                    + student_one.getStudentName() + "\nAge: "
                    + student_one.getAge());
        }
        catch (AgeOutOfRange ex){
            System.out.println(ex);
	    ex.printStackTrace();
	    
        }


    }
}



