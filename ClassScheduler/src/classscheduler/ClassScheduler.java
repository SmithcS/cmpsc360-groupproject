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
            
            if(canWaitlist(courses.get(0)))
            {
                System.out.println("However, you can waitlist the course.");                    
            }
            else {
                System.out.println("Waitlist Full");
            }
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
        return c.isIsFull();
    }
    
    // If the class is on your campus, then you can schedule it
    public static boolean isCorrectCampus(Course c, Student s) {
        return c.getCampus().equals(s.getCampus());
    }
    //If the class has a prerequisite and you meet that prerequisite, then you can schedule it
    public static boolean hasPreReq(Course c, Student s, List < Enrollment> l)
    {
        Enrollment e;
        String preq = c.getPrereq();
        if(preq == null)
        {
            return true;
        }
        else
        {
           int id = s.getStudentID();
           for(int i=0;i<l.size();i++)
           {
               e = l.get(i);
               if(e.getStudentIDNum() == id)
               {
                   if(e.getCourseName().equals(preq))
                   {
                       return true;
                   }
               }
           }
           return false;
        }
    }
    //Method for adding a course for the student to the enrollment list
    public void Schedule(Student s, Course c, List < Enrollment> l)
    {
        Queries q = new Queries();
        boolean a = hasPreReq(c, s, l);
        boolean b = isCorrectCampus(c, s);
        if(a && b)
        {
            q.newEnrollment(s.getStudentID(), c.getName());
        }
        else{
            System.out.println("Unable to Schedule Class");
            l = q.getAllEnrollments();
        }
    }
    
}
