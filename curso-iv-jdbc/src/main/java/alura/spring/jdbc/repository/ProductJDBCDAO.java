package alura.spring.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import alura.spring.jdbc.models.Product;

public class ProductJDBCDAO implements ProductDAO {

	public void deleteByIdentifier(int identifier) {

	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();

		try (Connection connection = ConnectionFactory.getConnection()) {
			String selectSQL = "SELECT * FROM products;";

			PreparedStatement ps = connection.prepareStatement(selectSQL);
			ResultSet rs = ps.executeQuery();

			Product product = null;
			while (rs.next()) {
				product = new Product(rs.getString("name"), rs.getString("description"));
				product.setIdentifier(rs.getInt("identifier"));
				products.add(product);
			}
		} catch (SQLException e) {
			throw new DAOException("Could not access the database", e);
		}

		return products;
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
