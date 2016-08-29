package com.learn.web.persistence.graduation;

import com.learn.bean.graduation.User;
import org.springframework.stereotype.Component;


@Component
public interface UserMapper {
	User selectByName(String name);
	void insert(User user);
}
