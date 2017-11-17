package classscheduler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentQueries {
    private Connection conn;
    private PreparedStatement selectAllStudents;
    private PreparedStatement selectByLName;
    private PreparedStatement newStudent;
    
    public StudentQueries() {
        try {
            conn = Database.getConnection();
            
            selectAllStudents = conn.prepareStatement("SELECT * FROM STUDENTS");
            selectByLName = conn.prepareStatement("SELECT * FROM STUDENTS WHERE"
                    + " L_NAME = ?"); 
            newStudent = conn.prepareStatement("INSERT INTO STUDENTS"
                    + "(ID_NUM, F_NAME, L_NAME, CAMPUS, SEM_STANDING, T_CREDITS)"
                    + "VALUES (?,?,?,?,?,?)");                    
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
            results = new ArrayList< Student >();
            
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
       
    private void close() {
        try {
            conn.close();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

