package store.dao;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Category;
import store.models.Product;
import store.util.JPAUtil;

public class ProductDaoImpl implements ProductDao {

	private EntityManager entityManager = null;

	public ProductDaoImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		entityManager.getTransaction().begin();
		entityManager.remove(findByIdentifier(identifier));
		entityManager.getTransaction().commit();
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
		return entityManager.createNamedQuery("Products.productsByCategory", Product.class)
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
