package ECOM.ChocoCrunchy.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECOM.ChochoCrunchy.dao.ProductDAO;
import ECOM.ChocoCrunchy.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("ECOM.ChocoCrunchy");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}


	/*@Test
	public void testCRUDProduct() {
	create operation
		product = new Product();

		product.setName("DreamChocolate");
		product.setBrand("Cadbury");
		product.setDescription("Melts in mouth with tremoundouse feel!");
		product.setUnitPrice(800);
		product.setActive(true);
		product.setCategoryId(5);
		product.setSupplierId(2);
		

		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		
		//reading and updating the category
		product = productDAO.get(2);
        product.setName("Ferrero-Rocher");
		
		assertEquals("Something went wrong while updating a new product!", true, productDAO.update(product));
		assertEquals("Something went wrong while deleting a new product!", true, productDAO.delete(product));
		
		
		//list
		assertEquals("Something went wrong while fetching the list of  products!", 6, productDAO.list().size());
		
	}
}*/

@Test
public void testListActiveProducts()
{
	assertEquals("Something went wrong while fetching the list of  products!", 5, productDAO.listActiveProducts().size());	
}

@Test
public void testListActiveProductsByCategory()
{
	assertEquals("Something went wrong while fetching the list of  products!", 3, productDAO.listActiveProductByCategory(3).size());	
	assertEquals("Something went wrong while fetching the list of  products!", 2, productDAO.listActiveProductByCategory(1).size());	

}


@Test
public void testgetLatestActiveProduct()
{
	assertEquals("Something went wrong while fetching the list of  products!", 3, productDAO.getLatestActiveProducts(3).size());	
	
}

}