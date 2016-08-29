package com.learn.web.persistence.graduation;

import java.util.List;

import com.learn.bean.graduation.Asset;
import org.springframework.stereotype.Component;

@Component
public interface AssetMapper {
	List<Asset>selectAll(String user_code);
	List<Asset>selectAvaliable(String user_code);
	Asset selectProductById(String id);
	void updateStstus(String id);
	void insertProduct(Asset asset);
	void updateAccount(Asset asset);

}
