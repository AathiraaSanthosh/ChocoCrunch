package ECOM.ChochoCrunchy.dao;

import java.util.List;

import ECOM.ChocoCrunchy.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
//business methods	
List<Product> listActiveProductByCategory(int categoryId);
List<Product> getLatestActiveProducts(int count);
List<Product> listActiveProducts();


}
