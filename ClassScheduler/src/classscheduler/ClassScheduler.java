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
        
        /*
        LOGICAL RULES
        */
        

    }
}
