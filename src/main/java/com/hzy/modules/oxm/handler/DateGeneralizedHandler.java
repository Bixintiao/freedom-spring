package com.hzy.modules.oxm.handler;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/29 15:20
 * @Description version 1.0
 */
public class DateGeneralizedHandler extends org.exolab.castor.mapping.GeneralizedFieldHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Object convertUponGet(Object o) {

        System.err.println("DateGeneralizedHandler-convertUponGet:" + o);
        if (null == o) return null;
        Date date = (Date)o;
        return sdf.format(date);
    }

    @Override
    public Object convertUponSet(Object o) {
        System.err.println("DateGeneralizedHandler-convertUponSet:"+o);
        try {
            return sdf.parse(String.valueOf(o));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Class getFieldType() {
        System.err.println("DateGeneralizedHandler-getFieldType:");
        return Date.class;
    }
}
