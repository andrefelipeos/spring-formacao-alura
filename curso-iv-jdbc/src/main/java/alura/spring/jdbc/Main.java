package alura.spring.jdbc;

import java.sql.SQLException;
import java.util.List;

import alura.spring.jdbc.models.Product;
import alura.spring.jdbc.repository.ProductDAO;
import alura.spring.jdbc.repository.ProductJDBCDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		ProductDAO productDAO = new ProductJDBCDAO();
		List<Product> products = productDAO.findAll();

		for (Product product : products) {
			System.out.println(product);
		}
	}

}
