package com.atguigu.springcloud.service.impl;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Order;
import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
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

    //开启seata全局事务
    @GlobalTransactional(name = "fsp_tx_group", rollbackFor = Exception.class)
    @Override
    public void saveOrder(Order order) {
        log.info("saveOrder, param order:{}", order);
        //创建订单
        int affectedOrderRows = orderDao.insert(order);
        log.info("saveOrder, affectedOrderRows:{}", affectedOrderRows);
        //扣减库存
        CommonResult storageResult = storageService.decrease(order.getProductId(), order.getCount());
        log.info("saveOrder, storageResult:{}", storageResult);
        //扣减账户
        CommonResult accountResult = accountService.decrease(order.getUserId(), order.getMoney());
        log.info("saveOrder, accountResult:{}", accountResult);
        //修改订单状态
        int updatedOrder = orderDao.updateByPrimaryKey(0, order.getUserId());
        log.info("saveOrder, updatedOrder:{}", updatedOrder);
    }
}
