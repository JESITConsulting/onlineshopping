package net.jgw.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jgw.shoppingbackend.dao.ProductDao;
import net.jgw.shoppingbackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
    
	//hibernate session factory
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createQuery("From Product").list();
	}

	
	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}		
	}

	
	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}		
	}
	

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try{
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("From Product Where isActive = :isActive",Product.class)
				 .setParameter("isActive", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int category_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("From Product Where isActive = :isActive AND categoryId = :categoryId",Product.class)
				 .setParameter("isActive", true)
				 .setParameter("categoryId", category_id)
				 .getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("From Product Where isActive = :isActive ORDER BY id desc",Product.class)
				 .setParameter("isActive", true)
				 .setFirstResult(0)
				 .setMaxResults(count)
				 .getResultList();
	}

}
