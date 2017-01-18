package com.king.mq.order.api;

import com.king.mq.order.entity.Order;

/**
 * Created by King on 2017/1/17.
 *
 * 订单服务接口
 */

public interface IOrderService {

    void save(Order order);

}
