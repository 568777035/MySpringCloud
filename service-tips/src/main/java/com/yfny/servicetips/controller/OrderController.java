package com.yfny.servicetips.controller;


import com.yfny.servicepojo.entity.OrderEntity;
import com.yfny.servicetips.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zileShi on 2019/2/26.
 **/
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/getOrderByPermission")
    @ResponseBody
    public OrderEntity getOrderByPermission(@RequestParam(value = "permission") String permission){
        return orderService.getOrderByPermission(permission);
    }



    /**
     * 添加用户
     * @return
     */
    @PostMapping(value = "/addOrder")
    @ResponseBody
    public boolean addOrder() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(12443L);
        orderEntity.setFunction("Fff");
        orderEntity.setPermission("qf");
        return orderService.addOrder(orderEntity);
    }


}
