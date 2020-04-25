package com.wanyibing.dao;

import com.wanyibing.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReopsitory extends JpaRepository<Order,Integer> {


}
