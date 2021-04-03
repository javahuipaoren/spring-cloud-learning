package com.atguigu.springcloud.service.impl;

import com.atguigu.cloud.api.entity.Order;
import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    public void saveOrder(Order order) {
        log.info("saveOrder, param order:{}", order);
        //创建订单
        orderDao.insert(order);
        //扣减库存
        storageService.decrease(order.getProductId(), 1);
        //扣减账户
        accountService.decrease(order.getUserId(), order.getMoney());
        //修改订单状态
        orderDao.updateByPrimaryKey(0, order.getUserId());
    }
}
