package com.learn.web.service.graduation;

import java.util.List;

import com.learn.bean.graduation.FuzzyMatch;
import com.learn.bean.graduation.Product;
import com.learn.web.persistence.graduation.ProductMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	@Autowired
	ProductMapper productmapper;
//	@Cacheable(value="myCache",key="#root.targetClass + #root.methodName")
	public List<Product> selectAll(){
		List<Product>products=productmapper.selectAll();
		return products;
	};
	
	public void insert(Product product){
		productmapper.insert(product);
	}

	public Product selectById(@Param("id")String id) {
		Product product=productmapper.selectById(id);
		return product;
	}
	public void cancel(String id){
		productmapper.cancel(id);
	}
	@Cacheable(value="myCache",key="#root.methodName+#root.targetClass ")
	public List<FuzzyMatch> selectMatchs(){
		List<FuzzyMatch>fuzzyMatchs=productmapper.selectMatchs();
		return fuzzyMatchs;
	}
	
	public void update(Product product){
		productmapper.update(product);
	}
}
