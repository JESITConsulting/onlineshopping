package net.jgw.onlineshopping.exception;

import java.io.Serializable;

public class CategoryNotFoundException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public CategoryNotFoundException(){
		this("Category Not Found!");		
	}
	
	public CategoryNotFoundException(String message){		
		this.message = System.currentTimeMillis()+ " : "+message;
	}
}
