package com.hzy.modules.oxm.castor;

import com.hzy.modules.oxm.entity.Person;
import com.hzy.modules.oxm.entity.my_order.ClientData;
import com.hzy.modules.oxm.entity.my_order.Item;
import com.hzy.modules.oxm.entity.my_order.MyOrder;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;
import org.junit.Test;

import java.io.*;
import java.util.Vector;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/28 20:57
 * @Description version 1.0
 */
public class CastorMyOrder {

    String path = "D:\\temp\\my-order.xml";

    MyOrder myOrder = null;
    {
        myOrder = new MyOrder();
        myOrder.setReference("this is _ref");


        ClientData clientData = new ClientData();
        clientData.setAddress("无锡市惠山区");
        clientData.setName("洛社");
        myOrder.setClientData(clientData);

        Item item = new Item("_reference", 99, 500f, "description");
        Item item2 = new Item("_reference", 128, 199f, "desc");

        Vector<Item> vector = new Vector<>();
        vector.add(item);
        vector.add(item2);
        myOrder.setItemsList(vector);
    }

    @Test
    public void test() throws IOException, MappingException, MarshalException, ValidationException {
        //编组到本地文件
        String xmlPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping\\MyOrder.xml";
        org.exolab.castor.mapping.Mapping mapping = new Mapping();
        mapping.loadMapping(xmlPath);

        org.exolab.castor.xml.XMLContext context = new XMLContext();
        context.addMapping(mapping);

        org.exolab.castor.xml.Marshaller marshaller = context.createMarshaller();
        Writer writer = new FileWriter(path);
        marshaller.setWriter(writer);
        marshaller.marshal(myOrder);


        // Unmarshaller 解组到VO
        Reader reader = new FileReader(path);
        org.exolab.castor.xml.Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setClass(MyOrder.class);
        MyOrder mo = (MyOrder) unmarshaller.unmarshal(reader);
        System.out.println(mo.toString());
    }

}
