package com.hzy.modules.interface_.animal;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/8 19:03
 * @Description version 1.0
 */
public class Rabbit extends Mammal {

    @Override
    public String getName() {
        return "Rabbit";
    }

    @Override
    public void move(String destination) {
        System.out.println(getName() + " move to "+ destination);
    }

    @Override
    public void drink() {
        System.out.println(getName() +" do drink !");
    }


}
