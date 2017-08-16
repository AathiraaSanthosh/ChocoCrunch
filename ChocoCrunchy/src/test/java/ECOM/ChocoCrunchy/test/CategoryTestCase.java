package ECOM.ChocoCrunchy.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECOM.ChochoCrunchy.dao.CategoryDAO;
import ECOM.ChocoCrunchy.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("ECOM.ChocoCrunchy");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory() {
		 category = new Category();
		category.setActive(true);
		category.setDescription("Everlasting crunchy feel you experience!");
		category.setImageURL("CAT_1.png");
		category.setName("crunchychocolates");
	
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
	
	
	}
	*/
	
	
/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(1);
		assertEquals("Successfully fetched a single category from the table!", "chocolates",category.getName());
				
	}*/
	
	

	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
	category.setName("chocolates");
	assertEquals("Successfully updated a single category in the table!", "true", categoryDAO.update(category));

	}*/

	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(4);

		assertEquals("Successfully deleted a single category in the table!", "true", categoryDAO.delete(category));

	}*/

	/*@Test
	public void testListCategory() {
		assertEquals("Successfully fetched the list  of categories from the table!",3, categoryDAO.list().size());
	}
*/
	@Test
	public void testCRUDCategory() {
//add operation
		category = new Category();

		category.setName("crunchyChocolates");
		category.setDescription("Everlasting crunchy taste u experiance");
		category.setImageURL("/assets/images/crunchyChocolates.jpg");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Chocolates");
		category.setDescription("Aweful taste u experiance");
		category.setImageURL("/assets/images/crunchyChocolates.jpg");

		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		//fetching and updating category
		category = categoryDAO.get(1);
		category.setName("chocolates");
		assertEquals("Successfully updated a single category in the table!", "true", categoryDAO.update(category));
		
		//deleting the category
		assertEquals("Successfully deleted a single category in the table!", "true", categoryDAO.delete(category));
        
		//fetching the list
		assertEquals("Successfully fetched the list  of categories from the table!",1, categoryDAO.list().size());
		
	}}
		