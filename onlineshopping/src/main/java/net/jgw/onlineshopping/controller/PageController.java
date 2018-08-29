package net.jgw.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.jgw.shoppingbackend.dao.CategoryDao;
import net.jgw.shoppingbackend.dto.Category;

@Controller
public class PageController {
    //Using Spring @autowire feature to create and initiate my interface CategoryDAO
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping( value={"/","/home","/index"})
	public ModelAndView index(){
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
	public ModelAndView allCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView ("page");
	    
		//get Category by id
		Category category = null;
		
		//categoryDao is our autowired class
		category = categoryDao.get(id); 
		
		mv.addObject("title",category.getName());
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories",categoryDao.list());
		mv.addObject("category",category);
		
		return mv;
	}
	
}
