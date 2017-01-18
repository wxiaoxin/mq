package com.king.mq.order.impl;

import com.king.mq.order.api.IOrderService;
import com.king.mq.order.entity.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by King on 2017/1/17.
 *
 * 订单服务
 */

@Service
public class OrderService implements IOrderService {

    // 日志
    private Logger LOGGER = Logger.getLogger(OrderService.class);

    public void save(Order order) {
        LOGGER.debug("订单服务执行保存订单操作,订单详情:\t" + order);
    }

}
