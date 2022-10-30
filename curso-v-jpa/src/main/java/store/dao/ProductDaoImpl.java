package store.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Product;

public class ProductDaoImpl implements ProductDao {

	private EntityManager entityManager = null;

	public ProductDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByIdentifier(int identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		this.entityManager.persist(product);
	}

}
