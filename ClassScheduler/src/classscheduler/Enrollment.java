package classscheduler;
/**
 * @author smithsopp
 */
public class Enrollment {
    private int studentIDNum;
    private String courseName;
    
    public Enrollment() {
    }
    
    public Enrollment(int studentIDNum, String courseName) {
        this.studentIDNum = studentIDNum;
        this.courseName = courseName;
    }

    public int getStudentIDNum() {
        return studentIDNum;
    }

    public void setStudentIDNum(int studentIDNum) {
        this.studentIDNum = studentIDNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
