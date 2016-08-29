package com.learn.web.service.graduation;

import com.learn.bean.graduation.Product;
import com.learn.web.persistence.graduation.OldProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OldProductService{
	@Autowired
	OldProductMapper oldProductMapper;
	public void insertOldProduct(Product oldProduct){
		oldProductMapper.insertOldProduct(oldProduct);
	}

}
