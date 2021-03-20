package dbConnection;

import java.sql.*;
// changed some files lol

public class DBConnection {

	public Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/time_table", "root", "");
			
			if(connection != null) {
				System.out.println("Successfully Connected");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}

}
