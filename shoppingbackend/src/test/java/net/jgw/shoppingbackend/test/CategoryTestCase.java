package net.jgw.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.jgw.shoppingbackend.dao.CategoryDao;
import net.jgw.shoppingbackend.dto.Category;

public class CategoryTestCase {
    
	//this is need to accest the applicaiton context inorder to access the beans
	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;
	
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext ();
		context.scan("net.jgw.shoppingbackend");
		context.refresh();
		
		//get the categoryDao repository for DAO (data access object)
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	/* tesing the add method of categoryDao */
	@Test
	public void testAddCategory(){
		
	    category = new Category();
		category.setName("TVs");
		category.setDescription("This category contains all TV's");
		category.setImageUrl("IMG_5.png");
		category.setActive(true);
	
	assertEquals("Successfully add the category to the table.",true,categoryDao.add(category));
	
	
	/* tesing the update method of categoryDao */
	category = categoryDao.get(104);
	category.setName("Televisions");;
	assertEquals("Successfully get a update category.",true,categoryDao.update(category));
	
	
	/* tesing the delete method of categoryDao */
	category = categoryDao.get(104);
	assertEquals("Successfully get a delete category.",true,categoryDao.delete(category));
	
	
	/* tesing the delete method of categoryDao */
	assertEquals("Successfully get a delete category.",4,categoryDao.list().size());
	
	}
}
	

