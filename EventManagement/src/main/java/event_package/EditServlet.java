package event_package;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        // Link to CSS file
		    out.println("<link rel='stylesheet' type='text/css' href='CSS/EditServletStyle.css'>");
		    
	        out.println("<h1>Update Event</h1>");  
	        String sid = request.getParameter("id");  
	        int id = Integer.parseInt(sid);  
	          
	        // Retrieve the event details based on the given ID
	        event e = eventDao.getEventById(id);  
	          
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");  
	        out.print("<tr><td>Event Name:</td><td><input type='text' name='eventname' value='" + e.getEventname() + "'/></td></tr>");    
	        out.print("<tr><td>Event Type:</td><td>");
	        
	        // Create a dropdown with pre-selected value based on the event type
	        out.print("<select name='eventtype' style='width:150px'>");
	        out.print("<option value='Wedding'" + (e.getEventtype().equals("Wedding") ? " selected" : "") + ">Wedding</option>");  
	        out.print("<option value='Birthday'" + (e.getEventtype().equals("Birthday") ? " selected" : "") + ">Birthday</option>");  
	        out.print("<option value='Conferences'" + (e.getEventtype().equals("Conferences") ? " selected" : "") + ">Conferences</option>");  
	        out.print("</select>");
	        
	        out.print("</td></tr>");  
	        out.print("<tr><td>Description:</td><td><input type='text' name='description' value='" + e.getDescription() + "'/></td></tr>");  
	        out.print("<tr>\r\n"
	        		+ "  <td colspan='2' style='text-align: center'>\r\n"
	        		+ "    <input type='submit' value='Edit & Save' onclick=\"alert('Are you sure you want to edit and save?')\"/>\r\n"
	        		+ "  </td>\r\n"
	        		+ "</tr>\r\n"
	        		+ "");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	    }  
}
