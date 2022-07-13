

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String eventNo = request.getParameter("EventNo");
		String eventNname = request.getParameter("EventName");
		String coordinatorName = request.getParameter("coordinatorName");
		String coordinatorNo = request.getParameter("CoordinatorNo");
		String fee = request.getParameter("fee");
		String venue = request.getParameter("venue");
		String date = request.getParameter("date");
		
		if(eventNo.isBlank() && eventNname.isBlank() && coordinatorName.isBlank() && coordinatorNo.isBlank() && fee.isBlank() && venue.isBlank() && date.isBlank()) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Enter Event Details!!!');");
			out.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("CreateE.html");
			dispatcher.include(request, response);
		}else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String conUrl = "jdbc:mysql://localhost:3306/evently";
				String username = "root";
				String password = "root";
				Connection con = DriverManager.getConnection(conUrl, username, password);
				con.setAutoCommit(false);
				
				Statement statement = con.createStatement();
				String queryStatement = "insert into event  "
						+ "(event_no, event_name, coordinator_name, coordinator_no, free, venue, date_time) "
						+  "values('"+eventNo+"','"+eventNname+"','"+coordinatorName+"','"+coordinatorNo+"','"+fee+"','"+venue+"','"+date+"')";
				statement.executeUpdate(queryStatement);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("CreateE.html");
				dispatcher.include(request, response);
				
				// out.println("<br><center><h3> Event Added</h3></center>");
				//System.out.println("Added to the database!!!");
				 response.setContentType("text/html");
	             out.println("<script type=\"text/javascript\">");  
	             out.println("alert('Success! ... Event Details Added To Database!');");  
	             out.println("</script>");
	 			 con.commit();
	 			 con.close();	
				
			}catch(ServletException | IOException | ClassNotFoundException | SQLException e){
				System.out.println("Exception caught" + e);
			}
		}
		
		
	}

}
