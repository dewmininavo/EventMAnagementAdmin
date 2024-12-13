package event_package;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        String sid = request.getParameter("id");  
        
        // Validate the ID parameter
        if (sid == null || sid.isEmpty()) {
            response.sendRedirect("ViewServlet?message=Error: ID parameter is missing.");
            return;
        }
        
        int id = 0;
        try {
            id = Integer.parseInt(sid);
        } catch (NumberFormatException e) {
            response.sendRedirect("ViewServlet?message=Error: Invalid ID format.");
            return;
        }

        // Delete the event
        int status = eventDao.delete(id);  

        // Redirect based on the deletion status
        if (status > 0) {
            response.sendRedirect("ViewServlet?message=Event deleted successfully.");
        } else {
            response.sendRedirect("ViewServlet?message=Error: Unable to delete the event. ID may not exist.");
        }
    }  
}
