package alura.spring.jdbc.repository;

import java.util.List;

import alura.spring.jdbc.models.Product;

public interface ProductDAO {

	public void deleteByIdentifier(int identifier);

	public List<Product> findAll();

	public void save(Product product);

}
