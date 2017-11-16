
package classscheduler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentQueries 
{
    private Connection conn;
    private PreparedStatement selectAllStudents;
    private PreparedStatement selectByLName;
    private PreparedStatement newStudent;
    
    public StudentQueries()
    {
        try
        {
            conn = Database.getConnection();
            
            selectAllStudents = conn.prepareStatement("SELECT * FROM STUDENTS");
            
            selectByLName = conn.prepareStatement("SELECT * FROM STUDENTS WHERE"
                    + "LName = ?");
            
            newStudent = conn.prepareStatement("INSERT INTO STUDENTS"
                    + "(ID_Number, FName, LName, Campus, TotalCredits)"
                    + "VALUES (?,?,?,?,?)");
                             
           
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
        
    public List< Student > getAllStudents()
    {
        List< Student > results = null;
        ResultSet resultSet = null;
        try
        {
            resultSet = selectAllStudents.executeQuery();
            results = new ArrayList< Student >();
            
            while(resultSet.next())
            {
                results.add(new Student (resultSet.getInt(ID_NUMBER),
                    resultSet.getString("FName"), resultSet.getString("LName"),
                    resultSet.getString("Campus"), 
                    resultSet.getString("TotalCredits")));        
            }
        }
        catch (SQLException sqlException)
            
            
        {
            sqlException.printStackTrace();      
        }    
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException sqlException)
            {
                sqlException.printStackTrace();
                close();
            }
        }
        
        return results;
    }
    
    public List< Student > getByLName(String name)
    {
        List< Student > results = null;
        ResultSet resultSet = null;
        
        try
        {
            selectByLName.setString(1, name);
            resultSet = selectByLName.executeQuery();
            results = new ArrayList< Student >();
            while(resultSet.next())
            {
                results.add(new Student (resultSet.getInt(ID_NUMBER),
                    resultSet.getString("FName"), resultSet.getString("LName"),
                    resultSet.getString("Campus"), 
                    resultSet.getString("TotalCredits")));        
            }
        }
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();      
        }    
        
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException sqlException)
            {
                sqlException.printStackTrace();
                close();
            }
        }
        
        return results;
    }
        

    private void close() 
    {
        try
        {
            conn.close();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}

