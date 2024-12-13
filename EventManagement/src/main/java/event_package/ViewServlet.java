package event_package;

import java.io.IOException;  

import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	        throws ServletException, IOException {  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	   
	    // Link to CSS file
	    out.println("<link rel='stylesheet' type='text/css' href='CSS/ViewServletStyle.css'>");
	   
	    out.println("<h1>Event List</h1>");  
	      
	    List<event> list = eventDao.getAllEvents();  
	      
	    out.print("<table border='1' width='100%'>");  
	    out.print("<tr><th>Id</th><th>Event Name</th><th>Event Type</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");  
	    for(event e : list){  
	        out.print("<tr>");
	        out.print("<td>" + e.getId() + "</td>");
	        out.print("<td>" + e.getEventname() + "</td>");
	        out.print("<td>" + e.getEventtype() + "</td>");
	        out.print("<td>" + e.getDescription() + "</td>");
	        out.print("<td><a class='button' href='EditServlet?id=" + e.getId() + "' onclick=\"return confirm('Are you sure you want to edit this event?');\">Edit</a></td>");
	        out.print("<td><a class='button' href='DeleteServlet?id=" + e.getId() + "' onclick=\"return confirm('Are you sure you want to delete this event?');\">Delete</a></td>");
	        
	        out.print("</tr>");  
	    }  
	    out.print("</table>");  
	    
	    // Move the "Add New Employee" link to the footer at the bottom of the page
	    out.println("<footer><a class='button' href='index.html'>Add New Event</a></footer>");  
	    
	    out.close();  
	}
}
