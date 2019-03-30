package com.hzy.modules.oxm.handler;

import com.hzy.modules.oxm.entity.Order;
import org.exolab.castor.mapping.ConfigurableFieldHandler;
import org.exolab.castor.mapping.FieldHandler;
import org.exolab.castor.mapping.ValidityException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/29 15:28
 * @Description version 1.0
 */
public class DateConfigurableHandler implements ConfigurableFieldHandler,FieldHandler {

    private DateFormat format = null;


    //配置
    @Override
    public void setConfiguration(Properties properties)
            throws ValidityException {
        System.err.println("DateConfigurableHandler-setConfiguration:" + properties);
        String pattern = properties.getProperty("date-format");
        System.err.println("_pattern:" + pattern);
        if (pattern == null) {
            throw new ValidityException("Required parameter \"date-format\" is missing for FieldHandlerImpl.");
        }
        try {
            format = new SimpleDateFormat(pattern);
        } catch (IllegalArgumentException e) {
            throw new ValidityException("Pattern \""+pattern+"\" is not a valid date format.");
        }
    }


    @Override
    public Object getValue(Object o) throws IllegalStateException {
        System.err.println("DateConfigurableHandler-getValue:" + o);
        Order order = (Order) o;
        Date orderDate = order.getOrderDate();
        return format.format(orderDate);
    }

    @Override
    public void setValue(Object o, Object o2) throws IllegalStateException, IllegalArgumentException {
        System.err.println("DateConfigurableHandler-setValue:" + o + o2);
        if (o instanceof Order){
            Date date = null;
            try {
                date = format.parse(String.valueOf(o2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ((Order) o).setOrderDate(date);
        }
    }

    @Override
    public void resetValue(Object o) throws IllegalStateException, IllegalArgumentException {
        ((Order)o).setOrderDate(null);
    }

    @Override
    public void checkValidity(Object o) throws ValidityException, IllegalStateException {

    }

    @Override
    public Object newInstance(Object o) throws IllegalStateException {
        return null;
    }
}
