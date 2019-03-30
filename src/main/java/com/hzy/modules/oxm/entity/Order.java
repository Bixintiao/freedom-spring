package com.hzy.modules.oxm.entity;

import java.util.Date;
import java.util.List;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/28 14:12
 * @Description version 1.0
 */
public class Order {

    private String name;
    private Date orderDate;
    private Integer orderNumber;
    private List<OrderItem> orderItems;


    public Order() {}

    public Order(String name, Integer orderNumber) {
        this.name = name;
        this.orderNumber = orderNumber;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderDate=" + orderDate +
                ", orderNumber=" + orderNumber +
                ", orderItems=" + orderItems +
                '}';
    }
}
