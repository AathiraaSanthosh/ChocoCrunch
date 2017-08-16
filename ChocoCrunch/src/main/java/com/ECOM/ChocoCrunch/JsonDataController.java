package com.ECOM.ChocoCrunch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ECOM.ChochoCrunchy.dao.ProductDAO;

@Controller
@RequestMapping("/json/data")
public class JsonDataController<Product> 
{

	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<ECOM.ChocoCrunchy.dto.Product> getAllProducts() {
		
	return productDAO.listActiveProducts();	
	}
	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<ECOM.ChocoCrunchy.dto.Product> getProductsByCategory(@PathVariable int id) {
		
	return productDAO.listActiveProductByCategory(id);	
	}
}
