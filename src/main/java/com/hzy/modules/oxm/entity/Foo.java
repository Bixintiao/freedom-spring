package com.hzy.modules.oxm.entity;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/29 15:55
 * @Description version 1.0
 */
public class Foo {

    private Color _color = null;
    private int _size = 0;
    private String _name = null;

    public Foo() {
    }

    public Color getColor() {
        return _color;
    }

    public String getName() {
        return _name;
    }

    public int getSize() {
        return _size;
    }

    public void setColor(Color color) {
        _color = color;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setSize(int size) {
        _size = size;
    }


}
