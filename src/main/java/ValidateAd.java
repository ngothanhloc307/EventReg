

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateAd
 */
@WebServlet("/ValidateAd")
public class ValidateAd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("Ausername");// Fetch user name 
		String password = request.getParameter("Apassword");// Fetch password
		response.setContentType("text/html");
		
		// Sets of Admin user name & password
		String userName1 = "admin01";
		String password1 = "1234";
		
		String userName2 = "admin02";
		String password2 = "5678";
		
		String userName3 = "admin03";
		String password3 = "ABCD";
		
		String userName4 = "admin04";
		String password4 = "abcd";
		
		// if-else ladder to check entries
		if(password.equals(password1) && userName.equals(userName1)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminEvent.html");
			dispatcher.forward(request, response);
		}
		else if (password.equals(password2) && userName.equals(userName2)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminEvent.html");
			dispatcher.forward(request, response);
		}
		else if (password.equals(password3) && userName.equals(userName3)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminEvent.html");
			dispatcher.forward(request, response);
		}
		else if (password.equals(password4) && userName.equals(userName4)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminEvent.html");
			dispatcher.forward(request, response);
		}
		// Credentials incorrect stay on that page only
		else {
			out.println("<center><h1>!! Please Enter Valid Username & Password for Admin !!</h1></center>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Alogin.html");
			dispatcher.include(request, response);
		}
	}

	

}
