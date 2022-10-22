package alura.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		connection.close();
	}

}
