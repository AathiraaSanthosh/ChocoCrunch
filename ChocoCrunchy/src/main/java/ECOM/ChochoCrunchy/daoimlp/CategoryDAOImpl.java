package ECOM.ChochoCrunchy.daoimlp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ECOM.ChochoCrunchy.dao.CategoryDAO;
import ECOM.ChocoCrunchy.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
private static List<Category> categories = new ArrayList<>();
	
	
	static {
		
		Category category = new Category();
		
		category.setId(1);
		category.setName("crunchyChocolates");
		category.setDescription("Everlasting crunchy taste u experiance");
		category.setImageURL("/assets/images/crunchyChocolates.jpg");
		
		categories.add(category);
		
		
		
		category = new Category();
		
		category.setId(2);
		category.setName("blackandwhitechocolates");
		category.setDescription("Black Thunder covering milky white layer ");
		category.setImageURL("/assets/images/blackandwhitechocolates.jpg");
		
		categories.add(category);
		
		
		category = new Category();
		
		category.setId(3);
		category.setName("chocolates");
		category.setDescription("enjoy this peculiar feel of rejoicing");
		category.setImageURL("/assets/images/chocolates.jpg");
		
		categories.add(category);
		
	}
	
	
	@Override
	public List<Category> list() {
		
		
		return null;
	}


	@Override
	public Category get(int id) {
		
		//enhanced for loop
		for(Category category : categories){
			
			if(category.getId() == id) return category;
			
			
		}
		
		return null;
		
	}

}
