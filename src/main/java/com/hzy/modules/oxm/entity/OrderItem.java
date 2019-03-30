package com.hzy.modules.oxm.entity;

import java.math.BigDecimal;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/28 13:56
 * @Description version 1.0
 */
public class OrderItem {

    private String identity;

    private String name;

    private Integer quantity;

    private BigDecimal amount;

    public OrderItem() {}

    public OrderItem(String identity, String name, Integer quantity, BigDecimal amount) {
        this.identity = identity;
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
