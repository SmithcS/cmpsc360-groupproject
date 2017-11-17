package classscheduler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {
    private Connection conn;
    private PreparedStatement selectAllStudents;
    private PreparedStatement selectByIDNum;
    private PreparedStatement newStudent;
    private PreparedStatement selectAllCourses;
    private PreparedStatement selectByCourseName;
    private PreparedStatement newCourse;
    private PreparedStatement selectAllEnrollments;
    private PreparedStatement newEnrollment;
    
    public Queries() {
        try {
            conn = Database.getConnection();
            
            selectAllStudents = conn.prepareStatement("SELECT * FROM STUDENTS");
            selectByIDNum = conn.prepareStatement("SELECT * FROM STUDENTS WHERE"
                    + " ID_NUM = ?"); 
            newStudent = conn.prepareStatement("INSERT INTO STUDENTS"
                    + "(ID_NUM, F_NAME, L_NAME, CAMPUS, SEM_STANDING, T_CREDITS)"
                    + "VALUES (?,?,?,?,?,?)");     
            selectAllCourses = conn.prepareStatement("SELECT * FROM COURSES");
            selectByCourseName = conn.prepareStatement("SELECT * FROM COURSES WHERE"
                    + " C_NAME = ?");  
            newCourse = conn.prepareStatement("INSERT INTO COURSES"
                    + "(C_NAME, CAMPUS, SEMESTER, IS_FULL, CREDITS, C_TIME)"
                    + "VALUES (?,?,?,?,?,?)");
            selectAllEnrollments = conn.prepareStatement("SELECT * FROM ENROLLMENT");
            newEnrollment = conn.prepareStatement("INSERT INTO ENROLLMENT"
                    + "(STUDENT_ID_NUM, COURSE_NAME)"
                    + "VALUES (?,?)");
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
        
    public List<Student> getAllStudents() {
        List<Student> results = null;
        ResultSet rs = null;
        
        try {
            rs = selectAllStudents.executeQuery();
            results = new ArrayList<Student>();
            
            while(rs.next()) {
                results.add(new Student (
                    rs.getInt("ID_NUM"),
                    rs.getString("F_NAME"), 
                    rs.getString("L_NAME"),
                    rs.getString("CAMPUS"), 
                    rs.getString("SEM_STANDING"),
                    rs.getInt("T_CREDITS")
                ));        
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
        finally {
            try {
                rs.close();
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }
    
    public List<Student> getByIDNum(int id) {
        List< Student > results = null;
        ResultSet rs = null;
        
        try {
            selectByIDNum.setInt(1, id);
            rs = selectByIDNum.executeQuery();
            results = new ArrayList<Student>();
            
            while(rs.next()) {
                results.add(new Student (
                    rs.getInt("ID_NUM"),
                    rs.getString("F_NAME"), 
                    rs.getString("L_NAME"),
                    rs.getString("CAMPUS"), 
                    rs.getString("SEM_STANDING"),
                    rs.getInt("T_CREDITS")
                ));        
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }    
        
        finally {
            try {
                rs.close();
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        
        return results;
    }
    
    public void newStudent(int id_num, String fName, String lName, String campus, String semester, int tCredits) {       
        try {
            newStudent.setInt(1, id_num);
            newStudent.setString(2, fName);
            newStudent.setString(3, lName);
            newStudent.setString(4, campus);
            newStudent.setString(5, semester);
            newStudent.setInt(6, tCredits);
            newStudent.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
    }
    
    public List<Course> getAllCourses() {
        List<Course> results = null;
        ResultSet rs = null;
        
        try {
            rs = selectAllCourses.executeQuery();
            results = new ArrayList<Course>();
            
            while(rs.next()) {
                results.add(new Course (
                    rs.getString("C_NAME"),
                    rs.getString("CAMPUS"),
                    rs.getString("SEMESTER"),
                    rs.getBoolean("IS_FULL"),
                    rs.getInt("CREDITS"),
                    rs.getInt("C_TIME")
                ));        
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
        finally {
            try {
                rs.close();
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }
    
    public List<Course> getByCourseName(String name) {
        List<Course> results = null;
        ResultSet rs = null;
        
        try {
            selectByCourseName.setString(1, name);
            rs = selectByCourseName.executeQuery();
            results = new ArrayList<Course>();
            
            while(rs.next()) {
                results.add(new Course (
                    rs.getString("C_NAME"),
                    rs.getString("CAMPUS"),
                    rs.getString("SEMESTER"),
                    rs.getBoolean("IS_FULL"),
                    rs.getInt("CREDITS"),
                    rs.getInt("C_TIME")
                ));        
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
        finally {
            try {
                rs.close();
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }
    
    public void newCourse(String name, String campus, String semester, boolean isFull, int credits, int time) {       
        try {
            newCourse.setString(1, name);
            newCourse.setString(2, campus);
            newCourse.setString(3, semester);
            newCourse.setBoolean(4, isFull);
            newCourse.setInt(5, credits);
            newCourse.setInt(6, time);
            newCourse.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
    }
    
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> results = null;
        ResultSet rs = null;
        
        try {
            rs = selectAllEnrollments.executeQuery();
            results = new ArrayList<Enrollment>();
            
            while(rs.next()) {
                results.add(new Enrollment (
                    rs.getInt("STUDENT_ID_NUM"),
                    rs.getString("COURSE_NAME")
                ));        
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
        finally {
            try {
                rs.close();
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }
    
    public void newEnrollment(int studentIDNum, String courseName) { 
        try {
            newEnrollment.setInt(1, studentIDNum);
            newEnrollment.setString(2, courseName);
            newEnrollment.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();      
        }   
        
    }
       
    private void close() {
        try {
            conn.close();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

