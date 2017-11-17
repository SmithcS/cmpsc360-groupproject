package classscheduler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {
    private Connection conn;
    private PreparedStatement selectAllStudents;
    private PreparedStatement selectByLName;
    private PreparedStatement newStudent;
    private PreparedStatement selectAllCourses;
    private PreparedStatement newCourse;
    
    public Queries() {
        try {
            conn = Database.getConnection();
            
            selectAllStudents = conn.prepareStatement("SELECT * FROM STUDENTS");
            selectByLName = conn.prepareStatement("SELECT * FROM STUDENTS WHERE"
                    + " L_NAME = ?"); 
            newStudent = conn.prepareStatement("INSERT INTO STUDENTS"
                    + "(ID_NUM, F_NAME, L_NAME, CAMPUS, SEM_STANDING, T_CREDITS)"
                    + "VALUES (?,?,?,?,?,?)");     
            selectAllCourses = conn.prepareStatement("SELECT * FROM COURSES");
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
                    rs.getDouble("T_CREDITS")
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
    
    public List<Student> getByLName(String name) {
        List< Student > results = null;
        ResultSet rs = null;
        
        try {
            selectByLName.setString(1, name);
            rs = selectByLName.executeQuery();
            results = new ArrayList<Student>();
            
            while(rs.next()) {
                results.add(new Student (
                    rs.getInt("ID_NUM"),
                    rs.getString("F_NAME"), 
                    rs.getString("L_NAME"),
                    rs.getString("CAMPUS"), 
                    rs.getString("SEM_STANDING"),
                    rs.getDouble("T_CREDITS")
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
    
    public List<Course> getAllCourses() {
        List<Course> results = null;
        ResultSet rs = null;
        
        try {
            rs = selectAllCourses.executeQuery();
            results = new ArrayList<Course>();
            
            while(rs.next()) {
                results.add(new Course (
                    rs.getString("NAME"),
                    rs.getString("CAMPUS"),
                    rs.getString("SEMESTER"),
                    rs.getBoolean("IS_FULL"),
                    rs.getInt("CREDITS"),
                    rs.getInt("TIME")
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
       
    private void close() {
        try {
            conn.close();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

