package service;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public int getClientProductsSum(long clientId) {

		List<Product> existingProducts = productDao.getAllProducts(clientId);

		return calculateClientProductSum(existingProducts);
	}


	private int calculateClientProductSum(List<Product> existingProducts) {
		int sum =0;

		for (Product product : existingProducts) {
			sum+= product.getAmount();
		}
		return sum;
	}

}