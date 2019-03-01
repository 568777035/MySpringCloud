package com.yfny.servicetips.service;

import com.yfny.servicecommon.pojo.OrderEntity;
import com.yfny.servicetips.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
