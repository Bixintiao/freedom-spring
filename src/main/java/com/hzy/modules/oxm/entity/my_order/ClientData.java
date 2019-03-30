package com.hzy.modules.oxm.entity.my_order;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/28 20:42
 * @Description version 1.0
 */
public class ClientData {

    private String _name;
    private String _address;

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getAddress() {
        return _address;
    }
}
