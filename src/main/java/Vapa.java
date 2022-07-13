

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vapa
 */
@WebServlet("/Vapa")
public class Vapa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// fetch data from HTML page
		String userName = request.getParameter("Pausername");
		String password = request.getParameter("Papassword");
		
		if(userName.isBlank() && password.isBlank()){
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Please Enter Your Login Details!!!');");  
            out.println("</script>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Plogin.html");
            requestDispatcher.include(request, response);
        }else {
        	try {
        		if(LoginDao.validate(userName, password)) {
        			RequestDispatcher dispatcher = request.getRequestDispatcher("ParticipantEvent.html");
        			dispatcher.forward(request, response);
        		}
        		else {
        			out.print("<center><h1>Sorry username or password incorrect</h1></center>");
        			RequestDispatcher dispatcher = request.getRequestDispatcher("Plogin.html");
        			dispatcher.include(request, response);
        		}
        		
        	}catch (SQLException ex) {
                Logger.getLogger(Vapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		
		out.close();	
	}

}
