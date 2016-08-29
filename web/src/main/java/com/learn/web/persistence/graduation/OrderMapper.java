package com.learn.web.persistence.graduation;

import java.util.List;

import com.learn.bean.graduation.Order;
import org.springframework.stereotype.Component;




@Component
public interface OrderMapper {
	void insert(Order order);
	List<Order> selectAll(String user_code);
	void deleteOrder(String id);
    void updateOrder(String id);
    Order selectOrderById(String id);
    void updateOrderBuy(Order order);
    void insertOldOrder(Order order);
}
