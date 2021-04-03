package com.atguigu.springcloud.dao;

import com.atguigu.cloud.api.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    int insert(Order order);

    //修改订单状态，0->1
    int updateByPrimaryKey(@Param("status") Integer status, @Param("userId") Long userId);
}
