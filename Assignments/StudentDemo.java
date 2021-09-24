public class StudentDemo {

    public static void main(String[] args) {

        Student student_one = new Student(1, "John Doe", 18);
        Student student_two = new Student(2, "Trevor", 20);

	//first student's details
        System.out.println("\nThe first student's\nID: "
                + student_one.getStudentID() + "\nName: "
                + student_one.getStudentName() + "\nAge: "
                + student_one.getAge());

	//second student's details
        System.out.println("\nThe second student's\nID: "
                + student_two.getStudentID() + "\nName: "
                + student_two.getStudentName() + "\nAge: "
                + student_two.getAge());
	
	//changing data
	student_one.setStudentName("Sarah");
	student_one.setStudentID(5);
        student_one.setAge(22);
        student_two.setStudentName("Jimmy");
        student_two.setStudentID(4);
	student_two.setAge(25);

        System.out.println("\nAfter changing some details of students.\n");

        System.out.println("The first student's\nID: "
                + student_one.getStudentID() + "\nName: "
                + student_one.getStudentName() + "\nAge: "
                + student_one.getAge());
        System.out.println("\nThe second student's\nID: "
                + student_two.getStudentID() + "\nName: "
                + student_two.getStudentName() + "\nAge: "
                + student_two.getAge());
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
    public void setAge(int Age) {
        this.Age = Age;
    }
}
