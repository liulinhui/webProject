package com.learn.web.persistence.graduation;

import java.util.List;

import com.learn.bean.graduation.FuzzyMatch;
import com.learn.bean.graduation.Product;
import org.springframework.stereotype.Component;



@Component
public interface ProductMapper {
	List<Product> selectAll();
	void insert(Product product);
	Product selectById(String id);
	void cancel(String id);
	List<FuzzyMatch>selectMatchs();
	void update(Product product);
}
