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
		String deleteSQL = "DELETE FROM products WHERE identifier = ?;";

		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement ps = connection.prepareStatement(deleteSQL);
			ps.setInt(1, identifier);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Could not access the database", e);
		}
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();

		try (Connection connection = ConnectionFactory.getConnection()) {
			String selectSQL = "SELECT products.identifier,"
					+ " products.name,"
					+ " products.description,"
					+ " categories.name AS category"
					+ " FROM products INNER JOIN categories"
					+ " ON products.category_identifier = categories.identifier;";

			PreparedStatement ps = connection.prepareStatement(selectSQL);
			ResultSet rs = ps.executeQuery();

			Product product = null;
			while (rs.next()) {
				product = new Product(rs.getString("name"), rs.getString("description"));
				product.setIdentifier(rs.getInt("identifier"));
				product.setCategory(rs.getString("category"));
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
