package net.jgw.shoppingbackend.dao;

import java.util.List;
import net.jgw.shoppingbackend.dto.Product;


public interface ProductDao {
	Product get(int id);
    List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business method
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int category_id);
	List<Product> getLatestActiveProducts(int count);
}
