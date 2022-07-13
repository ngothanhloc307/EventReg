
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TraH
 */
@WebServlet("/TraH")
public class TraH extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		  out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<h1 style=\"text-align: center\">Welcome To Evently ... An Event Management Portal!</h1>");
	      out.println("<title> Transactions Page</title>");
	      out.println("<link rel=\"stylesheet\" href=\"total.css\">");
	      out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
	      out.println("</head>");
	      out.println("<body>");
	      
	      try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  String conUrl = "jdbc:mysql://localhost:3306/evently";
	    	  String userName = "root";
	    	  String password = "root";
	    	  Connection con = DriverManager.getConnection(conUrl, userName, password);
	    	  con.setAutoCommit(false);
	    	  Statement statement = con.createStatement();
	    	  String sqlQuery = "select * from card";
	    	  ResultSet resulSet = statement.executeQuery(sqlQuery);
	    	  out.println("<center><h1> Transaction  Details </h1> </center> ");
	          out.println("<div>");
	          out.println("<left><p><a href=\"TransactionDetails.html\"><button> Event Details Page </button> </a></p></left>");
	          out.println("<center>");
	          out.println("<table border=1 width=50% height=50%>");  
	          out.println("<tr><th>Event No</th><th>Event Name</th><th>Name</th><th>Payment Date</th>"); 
	          
	          while(resulSet.next()) {
	        	  
	        	  String eventNumber = resulSet.getString("event_no");
	        	  String eventName = resulSet.getString("event_name");
	        	  String expDate = resulSet.getString("exp_date");
	        	  String cardName = resulSet.getString("card_holder_name");
	        	 
	        	  out.println("<tr><td>" + eventNumber + "</td><td>" + eventName + "</td><td>"+expDate+"</td><td>" + cardName +"</td></tr>"); 
	          }
	          
	          con.commit();
	          con.close(); 
	          out.println("</table>"); 
	          out.println("</h3></center>");
	          out.println("</div>");
	          out.println("<div><label class=\"topnav-right\"> © 1999-2022 Evently. All rights reserved. </label></div>");
	          out.print("</body>");
	          out.print("</html>");
	    	  
	    	  
	      }catch(ClassNotFoundException | SQLException e){
	            System.out.println("Exception Caught: " + e);
	        }
	       
	}

}
