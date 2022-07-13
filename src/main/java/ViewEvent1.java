

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEvent1
 */
@WebServlet("/ViewEvent1")
public class ViewEvent1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 out.println("<html>");
	     out.println("<head>");
	     out.println("<title>Event Page</title>");
	     out.println("<link rel=\"stylesheet\" href=\"total.css\">");
	     out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
	     out.println("</head>");
	     out.println("<body>");
	     
	     try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			String conUrl = "jdbc:mysql://localhost:3306/evently";
			String username = "root";
			String password = "root";
	    	 Connection con;
	    	 con = DriverManager.getConnection(conUrl, username, password);
	    	 con.setAutoCommit(false);
	    	 response.setContentType("text/html");
	    	 Statement statement = con.createStatement();
	    	 ResultSet resultSet = statement.executeQuery("select* from event");
	    	 out.println("<h1 style=\"text-align: center\">Welcome To Evently ... An Event Management Portal!</h1>");
	         out.println("<center><h1>Event Details</h1></center>");
	         out.println("<div>");
	         out.println("<center>");
	         out.println("<table border=1 width=50% height=50%>");  
	         out.println("<tr><th>Event Number</th><th>Event Name</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>");
	       //request.getParameter
	         while(resultSet.next()) {
	        	 String event_no = resultSet.getString("event_no");
	        	 String event_name = resultSet.getString("event_name");
	        	 String coordinator_name = resultSet.getString("coordinator_name");
	        	 String coordinator_no = resultSet.getString("coordinator_no");
	        	 String fee = resultSet.getString("free");
	        	 String venue = resultSet.getString("venue");
	        	 String date = resultSet.getString("date_time");
	        	 out.println("<tr><td>" + event_no + "</td><td>" + event_name +"</td><td>"+coordinator_name+"</td><td>"+coordinator_no+"</td><td>"+fee+"</td><td>"+venue+"</td><td>"+date+"</td></tr>");   
	        	 
	         }
	    	 
	         con.commit();
	            con.close();
	            out.println("</table>"); 
	            out.println("<br>");
	            out.println("</div>");
	            out.println("</center>");
	            out.println("<div>");
	            out.println("<label class=\"topnav-right\"> © 1999-2022 Evently. All rights reserved. </label>");
	            out.println("</div>");
	            out.print("</body>");
	            out.print("</html>");
	    	 
	    	 
	     }catch(ClassNotFoundException | SQLException e){
	            System.out.println("Exception Caught: " + e);
	        }
		
	}

}
