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




@Test
public void testListActiveProducts()
{
	assertEquals("Something went wrong while fetching the list of  products!", 5, productDAO.listActiveProducts().size());	
}




@Test
public void testgetLatestActiveProduct()
{
	assertEquals("Something went wrong while fetching the list of  products!", 3, productDAO.getLatestActiveProducts(3).size());	
	
}

}