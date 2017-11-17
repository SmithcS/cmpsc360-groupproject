package classscheduler;
import java.util.List;
/**
 * @author Smith Sopp, Joe Boisse
 */
public class ClassScheduler {

    public static void main(String[] args) {
        
        StudentQueries sq = new StudentQueries();
        List<Student> students = sq.getAllStudents();
        System.out.println("Hello World!");
    }
    
}
