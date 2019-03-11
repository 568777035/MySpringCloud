package com.yfny.servicetips.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.yfny.servicepojo.entity.OrderEntity;
import com.yfny.servicetips.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zileShi on 2019/2/26.
 **/
@Service
public class OrderServiceImpl{

    @Autowired
    private OrderMapper orderMapper;


    public OrderEntity getOrderByPermission(String permission) {
        return orderMapper.getOrderByPermission(permission);
    }


    @LcnTransaction //分布式事务注解
    @Transactional
    public boolean addOrder(OrderEntity record) {
        boolean result = false;
        orderMapper.insertSelective(record);
        result = true;
        return result;
    }

}
