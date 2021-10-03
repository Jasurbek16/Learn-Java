public class InheritanceDemo {

    public static void main(String[] args) {

//registering a SOL student
        SOL_Student student_1_sol = new SOL_Student("Antwan", 1, 85, 90, 90, 95);

//details of the student
        System.out.println("\n>>>> SOL Students' Details\n");
        System.out.println("Name: " + student_1_sol.getStudentName());
        System.out.println("English: " + student_1_sol.getEnglish());
        System.out.println("Maths: " + student_1_sol.getMaths());
        System.out.println("Computer Programming: " + student_1_sol.getComputerProgramming());
        System.out.println("Intro to Economics: " + student_1_sol.getIntro_to_Eco());
        System.out.println("Total: " + student_1_sol.total_score());


//registering a SOCIE student
        SOCIE_Student student_2_soc = new SOCIE_Student("Keys", 2, 100, 100, 100, 100);

//details of the student
        System.out.println("\n>>>> SOCIE Students' Details\n");
        System.out.println("Name: " + student_2_soc.getStudentName());
        System.out.println("English: " + student_2_soc.getEnglish());
        System.out.println("Maths: " + student_2_soc.getMaths());
        System.out.println("OOP1: " + student_2_soc.getOOP1());
        System.out.println("Intro to IT: " + student_2_soc.getIntro_to_IT());
        System.out.println("Total: " + student_2_soc.total_score());
    }
}


// the super class
class Student {

    // fields
    private String studentName;
    private int studentID;
    private double english;
    private double maths;

    //constructors
//default
    Student (){
        this("John", 0, 0, 0); // call the constructor
    }

//parametrized
    Student (String sn, int sid, double eng, double m){
        setStudentName(sn);
        setStudentID(sid);
        setEnglish(eng);
        setMaths(m);
    }

    //methods
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths){
        this.maths = maths;
    }

// get the total score
    public double total_score(){
        return (this.english + this.maths);
    }
}


//the SOL subclass
class SOL_Student extends Student{
   
// fields
    private double computerProgramming;
    private double intro_to_Eco;

// constructors
// default
    SOL_Student(){
        this("John", 0, 0, 0, 0, 0);
    }

// parametrized
    SOL_Student(String sn, int sid, double eng, double m, double cp, double ite){
        super(sn, sid, eng, m);
        setComputerProgramming(cp);
        setIntro_to_Eco(ite);
    }

    // methods
    public double getComputerProgramming() {
        return computerProgramming;
    }

    public void setComputerProgramming(double computerProgramming) {
        this.computerProgramming = computerProgramming;
    }

    public double getIntro_to_Eco() {
        return intro_to_Eco;
    }

    public void setIntro_to_Eco(double intro_to_Eco) {
        this.intro_to_Eco = intro_to_Eco;
    }

// get the total score
    public double total_score() {
        return (super.total_score() + intro_to_Eco + computerProgramming);
    }
}



// the SOCIE subclass
class SOCIE_Student extends Student {
    
// fields
    private double oop1;
    private double intro_to_IT;

//constructors
// default
    SOCIE_Student(){
        this("John", 0, 0, 0, 0, 0);
    }

// parametrized
    SOCIE_Student(String sn, int sid, double eng, double m, double oop1, double iti){
        super(sn, sid, eng, m);
        setOOP1(oop1);
        setIntro_to_IT(iti);
    }

    public double getOOP1() {
        return oop1;
    }

    public void setOOP1(double oop1) {
        this.oop1 = oop1;
    }

    public double getIntro_to_IT() {
        return intro_to_IT;
    }

    public void setIntro_to_IT(double intro_to_IT) {
        this.intro_to_IT = intro_to_IT;
    }

// get the total score
    public double total_score() {
        return (super.total_score() + oop1 + intro_to_IT);
    }
}
