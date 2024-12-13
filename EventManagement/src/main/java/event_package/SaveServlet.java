package event_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve form parameters
        String eventname = request.getParameter("eventname");
        String eventtype = request.getParameter("eventtype");
        String description = request.getParameter("description");

        // Create an event object and set properties
        event e = new event();
        e.setEventname(eventname);
        e.setEventtype(eventtype);
        e.setDescription(description);

        // Save the event using eventDao
        int status = eventDao.save(e);
        
        // Check if the save was successful
        if (status > 0) {
            // Redirect to ViewServlet to show the saved data
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! Unable to save the record.");
        }

        out.close();
    }
}
