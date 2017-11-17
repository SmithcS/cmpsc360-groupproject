package classscheduler;
import java.util.List;
/**
 * @author Smith Sopp, Joe Boisse
 */
public class ClassScheduler {

    public static void main(String[] args) {
        Queries q = new Queries();
        List<Student> students = q.getAllStudents();
        List<Course> courses = q.getAllCourses();
        List<Enrollment> enrollments = q.getAllEnrollments();
        
        //testing adding new student
        //q.newStudent(910424705, "John", "Doe", "Main", "Fall", 15);
        students = q.getAllStudents();
        System.out.println(students.get(1).getfName());
        
        //testing adding new course
        //q.newCourse("CMPSC473", "Main", "Spring", false, 3, 1315);
        courses = q.getAllCourses();
        System.out.println(courses.get(1).getName());

        //testing adding new enrollment
        //q.newEnrollment(910424704, "CMPSC473");
        enrollments = q.getAllEnrollments();
        System.out.println(enrollments.get(1).getStudentIDNum());
        
        courses = q.getByCourseName("STAT418");
        //Example of logic in use
        if (isAvailableSeat(courses.get(0))) {
            System.out.println("Free seat!");
        } else {
            System.out.println("No space.");
        }
        
    }
    /*
    LOGICAL RULES
    */  
    
    // If there is an available seat, then you can schedule the class
    public static boolean isAvailableSeat(Course c) {
        if (c.isIsFull()) {
            return false;
        } else {
            return true;
        }
    }
    
    // If the class is full, then you can waitlist it
    public static boolean canWaitlist(Course c) {
        if (c.isIsFull()) {
            return true;
        } else {
            return false;
        }
    }
    
    // If the class is on your campus, then you can schedule it
    public static boolean isCorrectCampus(Course c, Student s) {
        if (c.getCampus() == s.getCampus()) {
            return true;
        } else {
            return false;
        }
    }
}
