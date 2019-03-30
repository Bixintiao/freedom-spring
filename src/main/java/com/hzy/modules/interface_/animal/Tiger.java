package com.hzy.modules.interface_.animal;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/7 14:11
 * @Description version 1.0
 */
public class Tiger extends Mammal {

    @Override
    public String getName() {
        return "Tiger";
    }

    @Override
    public void move(String destination) {
        System.out.println(getName() + " move to "+ destination);
    }

    @Override
    public void drink() {
        System.out.println(" do drink !");
    }
}
