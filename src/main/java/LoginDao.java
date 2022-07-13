import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public static boolean validate(String user_name, String pass_word) throws SQLException{
		boolean status = false;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 	Connection conURL = DriverManager.getConnection("jdbc:mysql://localhost:3306/evently", "root", "root");
				PreparedStatement preparedStatement = conURL.prepareStatement("select * from plogindetails where userName=? and userPassword=?");
				preparedStatement.setString(1, user_name);
				preparedStatement.setString(2, pass_word);
				ResultSet resultSet = preparedStatement.executeQuery();
				status = resultSet.next();
				conURL.close();
			
		} catch (ClassNotFoundException e) {	
			Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, e);
		}
			return status;
	}
	
	public static boolean duplicate_username(String user_name) throws SQLException{
		boolean status = false;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 	Connection conURL = DriverManager.getConnection("jdbc:mysql://localhost:3306/evently", "root", "root");
				PreparedStatement preparedStatement = conURL.prepareStatement("select * from plogindetails where userName=?");
				preparedStatement.setString(1, user_name);
				ResultSet resultSet = preparedStatement.executeQuery();
				status = resultSet.next();
				conURL.close();
			
		} catch (ClassNotFoundException e) {	
			Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, e);
		}
			return status;
	}
	
}

