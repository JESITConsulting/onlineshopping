package net.jgw.shoppingbackend.dao;

import java.util.List;

import net.jgw.shoppingbackend.dto.Category;

public interface CategoryDao {
    List<Category> list();
	Category get(int id);
}
