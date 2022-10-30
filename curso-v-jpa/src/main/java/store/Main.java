package store;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import store.dao.ProductDao;
import store.dao.ProductDaoImpl;
import store.models.Product;
import store.util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		Product mobile = new Product("XPhone", "Octacore, 2GB", new BigDecimal(1200));

		EntityManager em = JPAUtil.getEntityManager();
		ProductDao productDao = new ProductDaoImpl(em);

		em.getTransaction().begin();
		productDao.save(mobile);
		em.getTransaction().commit();
		em.close();
	}

}
