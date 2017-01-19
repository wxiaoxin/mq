package com.king.mq.order.api;

import com.king.mq.order.entity.Order;

/**
 * Created by King on 2017/1/17.
 *
 * 订单服务接口
 */

public interface IOrderService {

    /**
     * 保存订单
     * @param order     订单对象
     */
    void save(Order order);

}
