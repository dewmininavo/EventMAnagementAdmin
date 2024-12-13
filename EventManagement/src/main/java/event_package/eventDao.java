package event_package;

import java.util.*;  
import java.sql.*; 

public class eventDao {

    // Method to establish a connection to the database
    public static Connection getConnection(){  
        Connection con = null;  
        try {  
        	
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cus", "root", "1234");  
        } catch(Exception e) {
            System.out.println(e);
        }  
        return con;  
    }  

    // Save a new event record to the database
    public static int save(event e){  
        int status = 0;  
        try {  
            Connection con = eventDao.getConnection();  
            PreparedStatement ps = con.prepareStatement(  
                "insert into event(eventname, eventtype, description) values (?, ?, ?)");  
            ps.setString(1, e.getEventname());  
            ps.setString(2, e.getEventtype());  
            ps.setString(3, e.getDescription());  
              
            status = ps.executeUpdate();  
            con.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }  
        return status;  
    }  

    // Update an existing event record in the database
    public static int update(event e){  
        int status = 0;  
        try {  
            Connection con = eventDao.getConnection();  
            PreparedStatement ps = con.prepareStatement(  
                "update event set eventname=?, eventtype=?, description=? where id=?");  
            ps.setString(1, e.getEventname());  
            ps.setString(2, e.getEventtype());  
            ps.setString(3, e.getDescription());  
            ps.setInt(4, e.getId());  // Corrected the parameter index
              
            status = ps.executeUpdate();  
            con.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }  
        return status;  
    }  

    // Delete an event record by ID
    public static int delete(int id){  
        int status = 0;  
        try {  
            Connection con = eventDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("delete from event where id=?");  
            ps.setInt(1, id);  
            status = ps.executeUpdate();  
            con.close();  
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return status;  
    }  

    // Retrieve an event record by its ID
    //The result is processed, and the event object is populated with the retrieved data.
    public static event getEventById(int id){  // Renamed method to getEventById
        event e = new event();  
        try {  
            Connection con = eventDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from event where id=?");  
            ps.setInt(1, id);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setEventname(rs.getString(2));  
                e.setEventtype(rs.getString(3));  
                e.setDescription(rs.getString(4));  
            }  
            con.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }  
        return e;  
    }  

    // retrieves all events from the database
    public static List<event> getAllEvents(){  // Renamed method to getAllEvents
//For each row, a new event object is created 
//and populated, and it is added to the list
    	List<event> list = new ArrayList<event>();
        try {  
            Connection con = eventDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from event");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                event e = new event();  
                e.setId(rs.getInt(1));  
                e.setEventname(rs.getString(2));  
                e.setEventtype(rs.getString(3));  
                e.setDescription(rs.getString(4));  
                list.add(e);  
            }  
            con.close();  
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return list;  
    }  



// NEW METHOD: Get the count of events in the database
public static int getEventCount() {  
    int count = 0;  
    try {  
        Connection con = eventDao.getConnection();  
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM event");  
        ResultSet rs = ps.executeQuery();  
        if(rs.next()){  
            count = rs.getInt(1);  // Get the first column value, which is the count
        }  
        con.close();  
    } catch(Exception e) {
        e.printStackTrace();
    }  
    return count;  
}  
}