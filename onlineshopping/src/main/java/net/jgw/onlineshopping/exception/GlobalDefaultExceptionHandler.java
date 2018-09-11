package net.jgw.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/***
* THis is the class that will handle all the exceptions thrown
* @ControllerAdvice: Specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, or 
* @ModelAttribute methods to be shared across multiple @Controller classes
*
*
*/
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Page - invalid request");
		mv.addObject("errorDesc","The url you entered is invalid please check your request!");
		mv.addObject("title","404 Error page");
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Product not found");
		mv.addObject("errorDesc","The product request is not a valid product!");
		mv.addObject("title","Product Not Found");
		return mv;
	}
	
	
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ModelAndView handlerCategoryNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Category not found");
		mv.addObject("errorDesc","The category request is not a valid category id!");
		mv.addObject("title","Category Not Found");
		return mv;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){		
		ModelAndView mv = new ModelAndView("error");
		
		//for dev only
		/*StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);*/
		
		mv.addObject("errorTitle","Exception occured: Contact your system administrator");
		mv.addObject("errorDesc","The server has experience a critical error please contact your Administrator"+ex.toString());
		mv.addObject("title","Exception");
		
		return mv;
	}

}
