package com.hzy.modules.oxm.demo;

import com.hzy.modules.oxm.entity.SimpleBean;
import com.hzy.modules.oxm.entity.VoucherItem;
import com.hzy.modules.oxm.entity.VoucherTitle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.castor.CastorMarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utils.BeanUtil;
import utils.JavaxUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/23 15:46
 * @Description version 1.0
 */
public class VoucherTest {

    private static final CastorMarshaller castorMarshaller;
    private static final SimpleBean simpleBean;
    static {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-oxm.xml");
        castorMarshaller = (CastorMarshaller) ctx.getBean("castorMarshaller");
        simpleBean = new SimpleBean(35,false,"doctor","jone");
    }

    @Test
    public void test() throws IOException, ParserConfigurationException {
        VoucherTitle head =  new VoucherTitle();

        System.out.println(head.toString());


        // 编组 Document
        DOMResult domResult = new DOMResult();
        castorMarshaller.marshal(head, domResult);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        Node domNode = domResult.getNode();
        NodeList childNodes = domNode.getChildNodes();
        for (int i = 0 ; i < childNodes.getLength(); i++){
            Node item = childNodes.item(i);
            Node node = document.importNode(item, true);
            root.appendChild(node);
        }
        System.err.println("document: \n" + JavaxUtil.documentToString(document));
    }



    @Test
    public void test1() throws IOException, ParserConfigurationException {
        VoucherItem voucherItem = new VoucherItem();

        Field[] fields = voucherItem.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(x->{
            try {
                if (x.getType() == java.math.BigDecimal.class) {
                    BeanUtil.invokeSet(voucherItem, x.getName(), BigDecimal.ONE);
                } else {
                    BeanUtil.invokeSet(voucherItem, x.getName(), "stringVal");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.err.println(voucherItem.toString());


        // 编组 Document
        DOMResult domResult = new DOMResult();
        castorMarshaller.marshal(voucherItem, domResult);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        Node domNode = domResult.getNode();
        NodeList childNodes = domNode.getChildNodes();
        for (int i = 0 ; i < childNodes.getLength(); i++){
            Node item = childNodes.item(i);
            Node node = document.importNode(item, true);
            root.appendChild(node);
        }
        System.err.println("document: \n" + JavaxUtil.documentToString(document));
    }



}
