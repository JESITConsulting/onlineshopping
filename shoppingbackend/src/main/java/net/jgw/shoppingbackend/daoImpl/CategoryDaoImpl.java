package net.jgw.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;


//import org.hibernate.SessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jgw.shoppingbackend.dao.CategoryDao;
import net.jgw.shoppingbackend.dto.Category;
/*
 * @Repository needs the spring context 
 * added to the backend
 * 
 * Spring @Repository annotation is used to indicate that the class provides the 
 * mechanism for storage, retrieval, search, update and delete operation on objects.
 */

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
    
	@Autowired 
    SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String hsql = "FROM Category WHERE active = :active";
		Query hquery = sessionFactory.getCurrentSession().createQuery(hsql);
		hquery.setParameter("active", true);		
		return hquery.getResultList();
	}

	
	 //get a category based on id
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
   
	@Override
	public boolean add(Category cat) {
		// TODO Auto-generated method stub
		try{
			
			sessionFactory.getCurrentSession().persist(cat);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}//finally{sessionFactory.getCurrentSession().close();}
		
		
	}

	@Override
	public boolean update(Category cat) {
		// TODO Auto-generated method stub
				try{
					
					sessionFactory.getCurrentSession().update(cat);
					return true;
					
				}catch(Exception ex){
					ex.printStackTrace();
					return false;
				}//finally{sessionFactory.getCurrentSession().close();}
	}

	@Override
	public boolean delete(Category cat) {
		
		cat.setActive(false);
		// TODO Auto-generated method stub
				try{
					
					sessionFactory.getCurrentSession().update(cat);
					return true;
					
				}catch(Exception ex){
					ex.printStackTrace();
					return false;
				}//finally{sessionFactory.getCurrentSession().close();}
	}
}
