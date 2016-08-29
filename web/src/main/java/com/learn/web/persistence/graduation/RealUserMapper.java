package com.learn.web.persistence.graduation;




import java.util.List;

import com.learn.bean.graduation.RealUser;
import org.springframework.stereotype.Component;


@Component
public interface RealUserMapper {
	RealUser selectByCode(String user_code);
	List<String> selectAllUsercode(String user_code);
	void insert(RealUser realuser);
	void update(RealUser realuser);
	
}
