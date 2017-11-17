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
        System.out.println("Hello World!");
        System.out.println(students.get(0).getfName());
        System.out.println(courses.get(0).getName());
        students = q.getByIDNum(910424703);
        System.out.println(students.get(0).getStudentID());  
        courses = q.getByCourseName("CMPSC360");
        System.out.println(courses.get(0).getName());
    }
}
