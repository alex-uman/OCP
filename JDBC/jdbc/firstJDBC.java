package jdbc;

import java.sql.*;

public class firstJDBC {

	public static void main(String[] args) {

//		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost?serverTimezone=UTC";
		String user = "root";
		String password = "p460t4";

		try (Connection connection = DriverManager.getConnection(url, user, password);) {
			try (Statement stm = connection.createStatement()) {

				String sql = "update `java_test_db`.`personen` set geburtsjahr = " + 1972 + " where vorname='" + "Mary"
						+ "'";
				stm.executeUpdate(sql);

//				sql = "SELECT * FROM java_test_db.personen order by geburtsjahr";

				sql = "SELECT * FROM java_test_db.personen order by id DESC";

				try (ResultSet res = stm.executeQuery(sql)) {

					while (res.next()) {

//						int id = res.getInt(4); // mit dem Spalten-Index
//						id = res.getInt("id"); // mit dem Spalten-Namen

						System.out.printf("id: %d | vorname: %5s | nachname: %7s | geb.: %d %n", res.getInt("id"),
								res.getString("vorname"), res.getString("nachname"), res.getInt("geburtsjahr"));
					}
				} // <- res.close()
			} // <- stm.close()

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
