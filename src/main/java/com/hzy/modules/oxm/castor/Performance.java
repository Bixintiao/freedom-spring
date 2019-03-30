package com.hzy.modules.oxm.castor;

import com.hzy.modules.oxm.entity.Order;
import com.hzy.modules.oxm.entity.OrderItem;
import com.hzy.modules.oxm.entity.Person;
import com.hzy.modules.oxm.entity.my_order.ClientData;
import com.hzy.modules.oxm.entity.my_order.Item;
import com.hzy.modules.oxm.entity.my_order.MyOrder;
import org.castor.mapping.BindingType;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;
import org.junit.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/29 16:15
 * @Description version 1.0
 * Performance Considerations
 */
public class Performance {


    private static Person person = null;
    public static Order order = null;
    static MyOrder myOrder = null;
    static {
        person = new Person("Ryan 'Mad Dog' Madden");
        person.setDateOfBirth(new Date(1955, 8, 15));

        order = new Order("order-1", 2);
        order.setOrderDate(new Date());
        OrderItem item1 = new OrderItem("identity1", "order-name", 1500, BigDecimal.ONE);
        OrderItem item2 = new OrderItem("identity2", "order-name2", 1800, BigDecimal.ZERO);
        order.setOrderItems(Arrays.asList(item1, item2));



        myOrder = new MyOrder();
        myOrder.setReference("this is _ref");


        ClientData clientData = new ClientData();
        clientData.setAddress("无锡市惠山区");
        clientData.setName("洛社");
        myOrder.setClientData(clientData);

        Item i1 = new Item("_reference", 99, 500f, "description");
        Item i2 = new Item("_reference", 128, 199f, "desc");

        Vector<Item> vector = new Vector<>();
        vector.add(i1);
        vector.add(i2);
        myOrder.setItemsList(vector);
    }


    /**
     * @throws IOException
     * @throws MappingException
     * @throws MarshalException
     * @throws ValidationException
     * 一次加载多个mapping
     */
    @Test
    public void loadMoreMapping() throws IOException, MappingException, MarshalException, ValidationException {

        String p1 = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping\\order.xml";
        Mapping m1 = new Mapping();
        m1.loadMapping(p1);

        String p2 = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping\\Person.xml";
        Mapping m2 = new Mapping();
        m2.loadMapping(p2);

        XMLContext xmlContext = new XMLContext();
        xmlContext.addMapping(m1);
        xmlContext.addMapping(m2);

        Marshaller marshaller = xmlContext.createMarshaller();
        PrintWriter printWriter = new PrintWriter(System.out);
        marshaller.setWriter(printWriter);
        marshaller.marshal(order);

        marshaller.marshal(person);

        marshaller.marshal(myOrder);
        printWriter.close();
    }


    /**
     * @throws ResolverException
     * @throws IOException
     * @throws MarshalException
     * @throws ValidationException
     * 加载整个包
     */
    @Test
    public void loadPackage() throws ResolverException, IOException, MarshalException, ValidationException {
        XMLContext xmlContext = new XMLContext();
        xmlContext.addPackage("D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping");

        Marshaller marshaller = xmlContext.createMarshaller();
        PrintWriter printWriter = new PrintWriter(System.out);
        marshaller.setWriter(printWriter);
        marshaller.marshal(order);

        marshaller.marshal(person);
        printWriter.close();
    }


    @Test
    public void pre_loading() throws ResolverException {
        XMLClassDescriptorResolver xmlClassDescriptorResolver =
                (XMLClassDescriptorResolver) ClassDescriptorResolverFactory.createClassDescriptorResolver(BindingType.XML);
        xmlClassDescriptorResolver.addPackage("D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping");

    }



}
