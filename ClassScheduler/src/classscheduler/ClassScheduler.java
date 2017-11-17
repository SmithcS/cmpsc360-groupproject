package classscheduler;
import java.util.List;
/**
 * @author Smith Sopp, Joe Boisse
 */
public class ClassScheduler {

    public static void main(String[] args) {    
        Queries sq = new Queries();
        List<Student> students = sq.getAllStudents();
        List<Course> courses = sq.getAllCourses();
        System.out.println("Hello World!");
        System.out.println(students.get(0).getfName());
        System.out.println(courses.get(0).getName());
    }
}
