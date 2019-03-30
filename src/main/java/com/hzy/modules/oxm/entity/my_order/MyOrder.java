package com.hzy.modules.oxm.entity.my_order;

import java.util.Enumeration;
import java.util.Vector;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/28 20:41
 * @Description version 1.0
 */
public class MyOrder {

    private String _ref;
    private ClientData _client;
    private Vector _items;
    private float _total;




    public void setReference(String ref) {
        _ref = ref;
    }

    public String getReference() {
        return _ref;
    }

    public void setClientData(ClientData client) {
        _client = client;
    }

    public ClientData getClientData() {
        return _client;
    }

    public void setItemsList(Vector items) {
        _items = items;
    }

    public Vector getItemsList() {
        return _items;
    }


    public void setTotal(float total) {
        _total = total;
    }

    public float getTotal() {
        return _total;
    }

    // Do some processing on the data
    public float getTotalPrice() {
        float total = 0.0f;

        for (Enumeration e = _items.elements(); e.hasMoreElements() ;) {
            Item item = (Item) e.nextElement();
            total += item._quantity * item._unitPrice;
        }

        return total;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "_ref='" + _ref + '\'' +
                ", _client=" + _client +
                ", _items=" + _items +
                ", _total=" + _total +
                '}';
    }
}
