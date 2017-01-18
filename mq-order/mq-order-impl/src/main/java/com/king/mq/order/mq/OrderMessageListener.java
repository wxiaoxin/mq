package com.king.mq.order.mq;

import com.king.mq.order.api.IOrderService;
import com.king.mq.order.entity.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

/**
 * Created by King on 2017/1/17.
 * <p>
 * 订单消息监听器
 */

@Component
public class OrderMessageListener implements MessageListener {

    // 日志
    private Logger LOGGER = Logger.getLogger(OrderMessageListener.class);

    // 订单服务
    @Resource
    private IOrderService orderService;

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            Order order = (Order) objectMessage.getObject();
            LOGGER.debug("接收到消息: " + order);
            orderService.save(order);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
