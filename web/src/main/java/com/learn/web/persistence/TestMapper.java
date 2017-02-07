package com.learn.web.persistence;

import com.learn.bean.test.user;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by linkage on 2016/8/29.
 */
@Component
public interface TestMapper {
    List<user> getUser();

    List<user> getUsername(String name);
}
