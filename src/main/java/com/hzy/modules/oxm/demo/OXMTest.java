package com.hzy.modules.oxm.demo;

import com.hzy.modules.oxm.entity.SimpleBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.castor.CastorMarshaller;
import org.w3c.dom.*;
import utils.JavaxUtil;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/11 19:17
 * @Description version 1.0
 * spring OXM + castor 编组和解组
 * castor-1.3-core.jar
 * castor-1.3-xml.jar
 */
public class OXMTest {

    private static final CastorMarshaller castorMarshaller;
    private static final SimpleBean simpleBean;
    static {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-oxm.xml");
        castorMarshaller = (CastorMarshaller) ctx.getBean("castorMarshaller");
        simpleBean = new SimpleBean(35,false,"doctor","jone");
    }


    @Test
    public void test1() throws IOException {
        FileOutputStream os = new FileOutputStream("D:\\simpleBean.xml");
        DOMResult domResult = new DOMResult();
        castorMarshaller.marshal(simpleBean, domResult);

        Node node = domResult.getNode();
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i<nodeList.getLength(); i++){
            Node item = nodeList.item(i);
            printNode(item);
            NamedNodeMap attributes = item.getAttributes();
            for (int j = 0; j<attributes.getLength(); j++){
                System.out.println(attributes.item(j));
            }
        }
    }




    @Test
    public void test2() throws IOException, ParserConfigurationException {
        String file = "D:\\simpleBean.xml";

        // 编组
        OutputStream os = new FileOutputStream(file);
        castorMarshaller.marshal(simpleBean, new StreamResult(os));


        // 编组 Document
        DOMResult domResult = new DOMResult();
        castorMarshaller.marshal(simpleBean, domResult);
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


        //解组
        InputStream fis = new FileInputStream(file);
        SimpleBean bean = (SimpleBean) castorMarshaller.unmarshal(new StreamSource(fis));
        System.err.println("解组结果:" + bean.toString());
    }


    public void printNode(Node node){
        System.out.println(node.getOwnerDocument() + node.getTextContent() + node.getChildNodes() + node.getAttributes() + node.getNodeValue());
    }
}
