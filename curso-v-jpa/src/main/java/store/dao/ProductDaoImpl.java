package store.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Category;
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
		return entityManager.createQuery("SELECT p FROM Product p", Product.class)
				.getResultList();
	}

	@Override
	public Product findByIdentifier(int identifier) {
		return entityManager.find(Product.class, identifier);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		String queryJPQL = "SELECT p FROM Product p WHERE p.category.name = :categoryName";
		return entityManager.createQuery(queryJPQL, Product.class)
				.setParameter("categoryName", category.getName())
				.getResultList();
	}

	@Override
	public void save(Product product) {
		this.entityManager.persist(product);
	}

}
