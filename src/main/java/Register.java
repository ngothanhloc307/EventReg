

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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	     
	    String a1 = request.getParameter("ename");
	    String a2 = request.getParameter("enum");
	    String a3 = request.getParameter("cardno");
	    String a4 = request.getParameter("edate");
	    String a5 = request.getParameter("cvv");
	    String a6 = request.getParameter("cname");
	    
	    
	    if(a1.isBlank() && a2.isBlank() && a3.isBlank() && a4.isBlank() && a5.isBlank() && a6.isBlank()){
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Please Enter Event Details!!!');");  
            out.println("</script>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.html");
            requestDispatcher.include(request, response);
	}else{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conUrl = "jdbc:mysql://localhost:3306/evently";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(conUrl, userName, password);
			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			String queryStatement = "insert into card  "
							+ "(event_name, event_no, card_no, exp_date, cvv_no, card_holder_name) "
							+  "values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"')";
			statement.executeUpdate(queryStatement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Payment.html");
			dispatcher.forward(request, response);
			con.commit();
			con.close();
		}catch(ServletException | IOException | ClassNotFoundException | SQLException e){
            System.out.println("Exception Caught: " + e);
        }
	  }
	}

}
