package classscheduler;

public class Student {
    private int studentID;
    private String fName, lName;
    private String campus, semStanding;
    private int tCredits;
     
    public Student() {   
    }

    public Student(int studentID, String fName, String lName, String campus, String semStanding, 
            int tCredits) {
        this.studentID = studentID;
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

    public double getTCredits() {
        return tCredits;
    }

    public void setTCredits(int tCredits) {
        this.tCredits = tCredits;
    }
}
