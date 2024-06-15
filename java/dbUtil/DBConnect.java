package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection openConnection() {
		Connection conn = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/library";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection( dbURL,username,password);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return conn;
		
	}
}
