package alura.spring.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import alura.spring.jdbc.models.Product;

public class ProductJDBCDAO implements ProductDAO {

	public void deleteByIdentifier(int identifier) {

	}

	public List<Product> findAll() {
		return null;
	}

	public void save(Product product) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			String insertSQL = "INSERT INTO products (name, description) VALUES (?, ?)";

			PreparedStatement ps = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				product.setIdentifier(rs.getInt(1));
			}
		} catch (Exception e) {
			throw new DAOException("Could not access the database", e);
		}
	}

}
