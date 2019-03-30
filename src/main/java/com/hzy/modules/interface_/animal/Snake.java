package com.hzy.modules.interface_.animal;

import com.hzy.modules.interface_.Skill.Hunting;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/8 19:02
 * @Description version 1.0
 */
public class Snake extends Reptile implements Hunting {


    @Override
    public String getName() {
        return "Snake";
    }

    @Override
    public void move(String destination) {
        System.out.println(getName() + " move to "+ destination);
    }

    @Override
    public void drink() {
        System.out.println(" do drink !");
    }

    @Override
    public void hunting(Animal animal) {
        System.out.println(getName() + " hunting the " + animal.getName());
    }
}
