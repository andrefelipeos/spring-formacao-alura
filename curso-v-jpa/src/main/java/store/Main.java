package store;

import store.dao.CategoryDaoImpl;
import store.models.Category;

public class Main {

	public static void main(String[] args) {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		Category toChange = categoryDao.findByIdentifier(13);
		toChange.setName("CLOTHES");
		categoryDao.save(toChange);
	}

}
