package com.king.mq.order.mq;

import com.king.mq.order.api.IOrderService;
import com.king.mq.order.entity.Order;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * Created by King on 2017/1/17.
 * <p>
 * 订单消息队列
 */

@Component
public class OrderMessageConsumer {

    // 日志
    private Logger LOGGER = Logger.getLogger(OrderMessageConsumer.class);

    // 订单服务
    @Resource
    private IOrderService orderService;

    // jms模板
    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 接受消息队列中的消息
     * @param destination   消息队列
     */
    public void receive(Destination destination) {
        if (destination == null) {
            destination = jmsTemplate.getDefaultDestination();
        }
        ObjectMessage objectMessage = (ObjectMessage) jmsTemplate.receive(destination);
        try {
            Order order = (Order) objectMessage.getObject();
            LOGGER.debug("接收到消息: " + order);
            orderService.save(order);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
