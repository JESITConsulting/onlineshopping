package net.jgw.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import net.jgw.shoppingbackend.dao.ProductDao;
import net.jgw.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDao;
	Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		// this is referring to @Repository("productDao") in class
		// ProductDaoImpl
		context.scan("net.jgw.shoppingbackend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");

	}

	@Test
	public void testProductDao() {

		// adding product to the database
	
		 this.product = new Product(); this.product.setName("Apple TV");
		 this.product.setDescription("Smart Apple TV 4K 60inch");
		 this.product.setBrand("Apple"); this.product.setCategoryId(3);
		 this.product.setUnitPrice(500.00); this.product.setSupplierId(2);
		 this.product.setActive(true);
		 assertEquals("Product successfully added to the database",true,productDao.add(product));
		 

		// Get product to the database
		this.product = productDao.get(7);
		assertEquals("Product successfully added to the database","Apple TV", product.getName());

		
		// Update product to the database
		this.product = productDao.get(4);
		this.product.setName("MAC Book Pro");
		assertEquals("Product successfully added to the database", true, productDao.update(product));
       
		
		this.product = productDao.get(6);
		assertEquals("Product successfully added to the database", true, productDao.delete(product));
       
		
		//List all products of any active status
		assertEquals("Product successfully added to the database", 7 , productDao.list().size());

		//List active  products only
		assertEquals("Product successfully added to the database", 5 , productDao.listActiveProducts().size());

		//List active  products only by category
		assertEquals("Product successfully added to the database", 3 , productDao.listActiveProductsByCategory(2).size());

		//List active  products only by lastest
		assertEquals("Product successfully added to the database", "Apple TV" , productDao.getLatestActiveProducts(2).get(0).getName());

	}

}
