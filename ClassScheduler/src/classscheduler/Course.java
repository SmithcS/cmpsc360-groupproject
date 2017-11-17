package classscheduler;

/**
 * @author Smith Sopp
 */
public class Course {
    private String name;
    private String campus;
    private String semester;
    private boolean isFull;
    private int credits, time;
    
    public Course() {
    }
    
    public Course(String name, String campus, String semester, boolean isFull, int credits, int time) {
        this.name = name;
        this.campus = campus;
        this.semester = semester;
        this.isFull = isFull;
        this.credits = credits;
        this.time = time;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
