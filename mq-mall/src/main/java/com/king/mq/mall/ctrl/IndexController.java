package com.king.mq.mall.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.king.mq.mall.mq.OrderMessageProducer;
import com.king.mq.order.entity.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by King on 2017/1/17.
 *
 * 首页控制器
 */

@Controller
public class IndexController {

    // 日志
    private Logger LOGGER = Logger.getLogger(IndexController.class);

    // 订单消息生产者
    @Resource
    private OrderMessageProducer orderMessageProducer;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    private ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    /**
     * 订单
     * @return
     */
    @RequestMapping("/order")
    @ResponseBody
    private String order(Order order) {

        // 生成订单信息
        order.setId(UUID.randomUUID().toString());
        order.setUserName("小明");
        order.setTime(new Date(System.currentTimeMillis()));

        LOGGER.debug(order);

        // 发送订单消息到队列中
        orderMessageProducer.sendMessage(null, order);

        // 请求结果
        Map<String, Object> resp = new HashMap<>();
        resp.put("flag", true);
        resp.put("msg", "订单消息发送成功");

        return JSONObject.toJSONString(resp);
    }

}
