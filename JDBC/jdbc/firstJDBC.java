package jdbc;

import java.sql.*;

public class firstJDBC {

	public static void main(String[] args) {

//		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost?serverTimezone=UTC";
		String user = "root";
		String password = "p460t4";

		try (Connection connection = DriverManager.getConnection(url, user, password);) {

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
