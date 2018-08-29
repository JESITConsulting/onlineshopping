package net.jgw.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.jgw.shoppingbackend.dao.CategoryDao;
import net.jgw.shoppingbackend.dto.Category;
/*
 * @Repository needs the spring version and spring context 
 * added to the backend
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	// Static category for testing only
	private static List<Category> categories = new ArrayList<>();
	{
		Category cat = new Category();
		cat.setId(100);
		cat.setName("Television");
		cat.setDescription("This contains all models television");
		cat.setImageUrl("CAT_1.png");

		Category cat2 = new Category();
		cat2.setId(101);
		cat2.setName("Computers");
		cat2.setDescription("This contains all models Computers");
		cat2.setImageUrl("CAT_2.png");

		Category cat3 = new Category();
		cat3.setId(102);
		cat3.setName("Phones");
		cat3.setDescription("This contains all models Phones");
		cat3.setImageUrl("CAT_3.png");
		
		categories.add(cat);
		categories.add(cat2);
		categories.add(cat3);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	//unit testing
	public static void main(String [] args){
		CategoryDaoImpl cat = new CategoryDaoImpl();
		List <Category> categories = cat.list();
		System.out.println("Category Lising:"+cat.list().size());
		
		for(Category c: categories){
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getDescription());
			System.out.println(c.getImageUrl());
			}
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category c : categories){
			if(c.getId() == id) return c;
		}		
		return null;
	}

}
