package com.learn.web.persistence.graduation;

import com.learn.bean.graduation.Product;
import org.springframework.stereotype.Component;


@Component
public interface OldProductMapper {
	void insertOldProduct(Product oldProduct);

}
