package ECOM.ChocoCrunchy.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECOM.ChocoCrunchy.dao.ProductDAO;



public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	
/*	private Product product;*/
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ECOM.ChocoCrunchy");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*
	@Test
	public void testCRUDProduct() {
		
		product = new Product();
		
		product.setName("polo 99");
		product.setBrand("Lauren");
		product.setDescription("this is description of Lauren mens wear");
		product.setUnitPrice(800);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product!",
						true,productDAO.add(product));
		
		
		product = productDAO.get(2);
		product.setName("denim");
		
		assertEquals("Something went wrong while updating a exsisting record!",
				true,productDAO.update(product));

		assertEquals("Something went wrong while deleting a exsisting record!",
				true,productDAO.delete(product));
		
		assertEquals("Something went wrong while fetching the list of products!",
				6,productDAO.list().size());
		

		
	}

*/
	
	@Test
	public void testListActiveProducts() {
		assertEquals("1 wrong while fetching the list of products!",
				26,productDAO.listActiveProducts().size());
		
	}

	@Test
	public void testListActiveProductsByCategory() {
		
		assertEquals(" 2 wrong while fetching the list of products!",3,productDAO.listActiveProductsByCategory(7).size());
		
	}

	@Test
	public void testGetLatestActiveProduct() {
		
		assertEquals(" 4 wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		}
		

}

