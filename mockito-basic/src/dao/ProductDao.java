package dao;

import model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts(long clientId);
}
