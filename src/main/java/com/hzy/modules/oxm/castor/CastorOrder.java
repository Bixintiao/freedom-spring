package com.hzy.modules.oxm.castor;

import com.hzy.modules.oxm.entity.Order;
import com.hzy.modules.oxm.entity.OrderItem;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;
import org.junit.Test;
import org.w3c.dom.Document;
import utils.BeanUtil;
import utils.JavaxUtil;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/28 15:41
 * @Description version 1.0
 */
public class CastorOrder {

    String filePath = "D:\\temp\\order.xml";
    public static Order order = null;
    static {
        order = new Order("order-1", 2);
        order.setOrderDate(new Date());
        OrderItem item1 = new OrderItem("identity1", "order-name", 1500, BigDecimal.ONE);
        OrderItem item2 = new OrderItem("identity2", "order-name2", 1800, BigDecimal.ZERO);
        order.setOrderItems(Arrays.asList(item1, item2));
    }

    @Test
    public void castor_order() throws IOException, MappingException, MarshalException, ValidationException, ParserConfigurationException {
        Mapping mapping = new Mapping();
        mapping.loadMapping("D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping\\order.xml");


        //编组到本地文件
        Writer writer = new FileWriter(filePath);
        XMLContext xmlContext = new XMLContext();
        xmlContext.addMapping(mapping);
        Marshaller marshaller = xmlContext.createMarshaller();
        marshaller.setWriter(writer);
        marshaller.marshal(order);



        //out
        Reader r = new FileReader(filePath);
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1024];
        while ( r.read(buf) != -1){
            sb.append(buf);
        }
        r.close();
        System.err.println("_________________sb:\n" + sb);


        //Unmarshaller to Order.class
        Reader reader = new FileReader(filePath);
        Unmarshaller unmarshaller = xmlContext.createUnmarshaller();
        unmarshaller.setClass(Order.class);
        Order order = (Order) unmarshaller.unmarshal(reader);
        System.err.println("unmarshaller-result:\n"+order.toString());


        //编组到document
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        marshaller.setResult(new DOMResult(document));
        marshaller.marshal(order);
        System.err.println("marshaller-DOMResult:\n"+JavaxUtil.documentToString(document));
    }


    @Test
    public void test() throws Exception {
        Date orderDate = (Date) BeanUtil.invokeGet(order, "orderDate");
        System.err.println(orderDate);
        BeanUtil.invokeSet(order,"orderDate", new Date(2012-1900, 12 ,12));
        System.err.println(order.getOrderDate());
    }



}
