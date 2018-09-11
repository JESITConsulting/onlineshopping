package net.jgw.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.jgw.onlineshopping.exception.CategoryNotFoundException;
import net.jgw.onlineshopping.exception.ProductNotFoundException;
import net.jgw.shoppingbackend.dao.CategoryDao;
import net.jgw.shoppingbackend.dao.ProductDao;
import net.jgw.shoppingbackend.dto.Category;
import net.jgw.shoppingbackend.dto.Product;

@Controller
public class PageController {
    static Logger logger = LoggerFactory.getLogger(PageController.class);
	
    
	//Using Spring @autowire feature to create and initiate my interface CategoryDAO
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping( value={"/","/home","/index"})
	public ModelAndView index(){
		 logger.info("PageController loger level in method index: INFO");
		logger.debug("PageController loger level in method index: DEBUG");
		
		
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title","Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories",categoryDao.list());
		return mv;
	}

	
	@RequestMapping( value="/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	
	@RequestMapping( value="/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping( value="/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title","All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories",categoryDao.list());
		
		return mv;
	}
	
	@RequestMapping( value="/show/all/{id}/products")
	public ModelAndView allCategoryProducts(@PathVariable("id") int id) throws CategoryNotFoundException{
		ModelAndView mv = new ModelAndView ("page");
	
	  
		//get Category by id
		Category category = null;
		
				
		//categoryDao is our autowired class
		category = categoryDao.get(id); 
		if(category==null){
			throw new CategoryNotFoundException();
		}
		
		mv.addObject("title",category.getName());
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories",categoryDao.list());
		mv.addObject("category",category);
		
		return mv;
	   
	}
	
	
	@RequestMapping( value="/show/{id}/product")
	public ModelAndView viewSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView ("page");
		
		//get the product from the database
		Product product = productDao.get(id);
		Category category = null;
			
		if(product == null)
	    throw new ProductNotFoundException();

		
		//upadate the view count of the product
		product.setViews(product.getViews()+1);
		productDao.update(product);
		
		
		//add objects to modelandview	
		mv.addObject("title",product.getName());
		mv.addObject("userClickSingleProduct", true);
		mv.addObject("product",product);
		
		return mv;
	}
	
}
	
	

