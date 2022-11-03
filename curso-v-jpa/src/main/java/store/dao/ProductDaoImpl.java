package store.dao;

import java.math.BigDecimal;
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
	public BigDecimal getPriceByIdentifier(int identifier) {
		return entityManager.createQuery("SELECT p.price FROM Product p WHERE p.identifier = :identifier",
					BigDecimal.class)
				.setParameter("identifier", identifier)
				.getSingleResult();
	}

	@Override
	public Product save(Product product) {
		entityManager.getTransaction().begin();
		product = entityManager.merge(product);
		entityManager.getTransaction().commit();
		return product;
	}

}
