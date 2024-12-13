package event_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/event-count")
public class EventCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Get the count of events from the database
        int eventCount = eventDao.getAllEvents().size(); // Assuming getAllEvents returns the list of events

        // Create JSON response
        out.print("{\"count\": " + eventCount + "}");

        out.flush();
        out.close();
    }
}
