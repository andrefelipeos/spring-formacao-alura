package alura.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import alura.spring.jdbc.repository.ConnectionFactory;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();

		String selectSQL = "SELECT * FROM products;";
		PreparedStatement ps = connection.prepareStatement(selectSQL);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("identifier")
					+ " : " + rs.getString("name")
					+ " : " + rs.getString("description"));
		}

		String insertSQL = "INSERT INTO products (name, description) "
				+ "VALUES ('Mouse', 'Bluetooth, wireless, black')";
		ps = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();

		rs = ps.getGeneratedKeys();
		if (rs.next()) {
			System.out.println("New id: " + rs.getInt(1));
		}

		connection.close();
	}

}
