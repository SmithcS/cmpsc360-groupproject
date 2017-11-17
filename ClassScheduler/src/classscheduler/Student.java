package classscheduler;

public class Student {
    private int studentID;
    private String fName, lName;
    private String campus, semStanding;
    private double credits, tCredits;
     
    public Student() {   
    }

    public Student(String fName, String lName, String campus, String semStanding, 
            double tCredits) {
        this.fName = fName;
        this.lName = lName;
        this.campus = campus;
        this.semStanding = semStanding;
        this.tCredits = tCredits;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getSemStanding() {
        return semStanding;
    }

    public void setSemStanding(String semStanding) {
        this.semStanding = semStanding;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double gettCredits() {
        return tCredits;
    }

    public void settCredits() {
        this.tCredits = tCredits+credits;
    }
}
