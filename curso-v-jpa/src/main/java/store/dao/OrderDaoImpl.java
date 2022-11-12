package store.dao;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Order;
import store.util.JPAUtil;

public class OrderDaoImpl implements OrderDao {

	private EntityManager entityManager = null;

	public OrderDaoImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		entityManager.getTransaction().begin();
		entityManager.remove(findByIdentifier(identifier));
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Order> findAll() {
		return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
	}

	@Override
	public Order findByIdentifier(int identifier) {
		return entityManager.find(Order.class, identifier);
	}

	@Override
	public Order save(Order order) {
		entityManager.getTransaction().begin();
		order = entityManager.merge(order);
		entityManager.getTransaction().commit();
		return order;
	}

	public BigDecimal totalSalesValue() {
		String jpqlQuery = "SELECT SUM(order.totalValue) FROM Order order";
		return entityManager.createQuery(jpqlQuery, BigDecimal.class).getSingleResult();
	}

}
