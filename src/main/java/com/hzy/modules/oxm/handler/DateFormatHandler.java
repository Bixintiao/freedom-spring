package com.hzy.modules.oxm.handler;


import com.alibaba.fastjson.JSON;
import com.hzy.modules.oxm.entity.Order;
import org.exolab.castor.mapping.ValidityException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/28 14:56
 * @Description version 1.0
 */
public class DateFormatHandler implements org.exolab.castor.mapping.FieldHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object getValue(Object o) throws IllegalStateException {
        System.err.println("DateFormatHandler-getValue:" + JSON.toJSONString(o));
        Order order = (Order) o;
        Date orderDate = order.getOrderDate();
        return sdf.format(orderDate);
    }

    @Override
    public void setValue(Object o, Object dateString)
            throws IllegalStateException, IllegalArgumentException {
        System.err.println("DateFormatHandler-setValue:" + o + dateString);
        if (o instanceof Order){

            try {
                Date date = sdf.parse(String.valueOf(dateString));
                ((Order) o).setOrderDate(date);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void resetValue(Object o) throws IllegalStateException, IllegalArgumentException {
        System.err.println("DateFormatHandler-resetValue:" + o);
    }

    @Override
    public void checkValidity(Object o) throws ValidityException, IllegalStateException {
    }

    @Override
    public Object newInstance(Object o) throws IllegalStateException {
        System.err.println("DateFormatHandler-newInstance:" + o);
        return null;
    }
}
