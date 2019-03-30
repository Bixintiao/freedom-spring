package com.hzy.modules.oxm.handler;

import com.hzy.modules.oxm.entity.Color;
import org.exolab.castor.mapping.GeneralizedFieldHandler;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/29 15:49
 * @Description version 1.0
 */
public class ColorHandler extends GeneralizedFieldHandler {


    @Override
    public Object convertUponGet(Object value) {
        System.err.println("ColorHandler-convertUponGet:"+value);
        if (value == null) return null;
        Color color = (Color)value;
        return color.toString();
    }

    @Override
    public Object convertUponSet(Object o) {
        System.err.println("ColorHandler-convertUponSet:"+o);
        return Color.valueOf((String)o);
    }

    @Override
    public Class getFieldType() {
        return Color.class;
    }


}
