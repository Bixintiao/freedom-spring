package com.hzy.modules.interface_;

import com.hzy.modules.interface_.animal.Animal;
import com.hzy.modules.interface_.animal.Rabbit;
import com.hzy.modules.interface_.animal.Snake;
import com.hzy.modules.interface_.animal.Tiger;
import com.hzy.modules.interface_.person.Hunter;
import org.junit.Test;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/7 14:01
 * @Description version 1.0
 */
public class Test_ {


    @Test
    public void test1(){
        Hunter hunter = new Hunter();
        hunter.setName("Hunter");
        System.out.println(hunter.toString());

        Animal rabbit = new Rabbit();
        rabbit.drink();
        Animal snake = new Snake();
        ((Snake) snake).hunting(rabbit);
        Animal tiger = new Tiger();
        tiger.move("森林");

        hunter.hunting(snake);
    }



}
