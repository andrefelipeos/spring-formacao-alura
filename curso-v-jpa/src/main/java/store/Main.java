package store;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import store.dao.CategoryDao;
import store.dao.CategoryDaoImpl;
import store.dao.ProductDao;
import store.dao.ProductDaoImpl;
import store.models.Category;
import store.models.Product;
import store.util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		Category mobiles = new Category("MOBILES");
		Product mobile = new Product("XPhone", "Octacore, 2GB", new BigDecimal(1200), mobiles);

		EntityManager em = JPAUtil.getEntityManager();
		CategoryDao categoryDao = new CategoryDaoImpl(em);
		ProductDao productDao = new ProductDaoImpl(em);

		em.getTransaction().begin();
		categoryDao.save(mobiles);
		productDao.save(mobile);
		em.getTransaction().commit();
		em.close();
	}

}
