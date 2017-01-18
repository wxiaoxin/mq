package com.king.mq.mall.mq;

import com.king.mq.order.entity.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by King on 2017/1/17.
 *
 * 订单消息生产者
 */

@Component
public class OrderMessageProducer {

    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 发送订单消息至消息队列
     * @param destination   消息队列
     * @param order         订单详情
     */
    public void sendMessage(Destination destination, final Order order) {
        if(destination == null) {
            // 未指定消息队列时,使用默认的消息队列
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                // 发送订单
                return session.createObjectMessage(order);
            }
        });
    }

}

