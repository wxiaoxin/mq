package com.king.mq.order;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by King on 2017/1/17.
 *
 * 启动订单服务
 */

public class Startup {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();

        System.out.println("**********订单服务启动成功**********");

        synchronized (Startup.class) {
            while (true) {
                try {
                    Startup.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
