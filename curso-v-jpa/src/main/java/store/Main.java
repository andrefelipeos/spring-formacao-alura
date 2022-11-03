package store;

import java.math.BigDecimal;
import java.util.List;

import store.dao.CategoryDaoImpl;
import store.dao.ProductDao;
import store.dao.ProductDaoImpl;
import store.models.Category;
import store.models.Product;

public class Main {

	public static void main(String[] args) {
		Category clothes = new CategoryDaoImpl().findByIdentifier(13);
		Product tshirt = new Product("Basic 0", "White basic T-shirt", new BigDecimal(40), clothes);
		ProductDao pd = new ProductDaoImpl();
		pd.save(tshirt);

		List<Product> listOfClothes = pd.findByCategory(clothes);
		for (Product product : listOfClothes) {
			System.out.println(product.getName() + ": " + product.getDescription());
		}
	}

}
