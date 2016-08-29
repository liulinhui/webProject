package com.learn.web.service.graduation;

import java.util.List;

import com.learn.bean.graduation.Asset;
import com.learn.web.persistence.graduation.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AssetService {
	@Autowired
	AssetMapper assetMapper;

	public List<Asset> selectAll(String user_code) {
		List<Asset> assets = assetMapper.selectAll(user_code);
		return assets;
	}

	public List<Asset> selectAvaliable(String user_code) {
		List<Asset> assets = assetMapper.selectAvaliable(user_code);
		return assets;
	}
	
	public Asset selectProductById(String id) {
		Asset asset=assetMapper.selectProductById(id);
		return asset;
	}
	
	public void updateStatus(String id){
		assetMapper.updateStstus(id);
	}
	
	public void insertProduct(Asset asset){
		assetMapper.insertProduct(asset);
	}
	public void updateAccount(Asset asset){
		assetMapper.updateAccount(asset);
	}

}
