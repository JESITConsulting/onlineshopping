package net.jgw.shoppingbackend.dao;

import java.util.List;

import net.jgw.shoppingbackend.dto.Category;

public interface CategoryDao {
	Category get(int id);
    List<Category> list();
	boolean add(Category cat);
	boolean update(Category cat);
	boolean delete(Category cat);
}
