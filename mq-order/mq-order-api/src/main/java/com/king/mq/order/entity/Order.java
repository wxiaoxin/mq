package com.king.mq.order.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by King on 2017/1/17.
 *
 * 订单
 */

public class Order implements Serializable {

    /**
     * 订单主键
     */
    private String id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 购买商品数量
     */
    private int itemNumber;

    /**
     * 购买时间
     */
    private Date time;


    // ===== 空构造器 ===== //

    public Order() {}



    // ===== get/set ===== //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", itemNumber=" + itemNumber +
                ", time=" + time +
                '}';
    }
}
