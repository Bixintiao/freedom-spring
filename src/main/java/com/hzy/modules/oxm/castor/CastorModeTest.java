package com.hzy.modules.oxm.castor;

import com.hzy.modules.oxm.entity.Person;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.JavaxUtil;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.dom.DOMResult;
import java.io.*;
import java.util.Date;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/26 19:26
 * @Description
 *      使用castor 实现 javaBean 与 xml 映射
 *      castor 三种模式 : 自省模式  映射模式  描述符模式
 * github 参考文档:
 *      http://castor-data-binding.github.io/castor/
 *      https://castor-data-binding.github.io/castor/reference-guides/1.3.3/html-single/index.html#xml.framework.introspection.ouput
 */
public class CastorModeTest {

    String filePath = "D:\\temp\\person.xml";
    private static Person person = null;
    static {
        person = new Person("Ryan 'Mad Dog' Madden");
        person.setDateOfBirth(new Date(1955, 8, 15));
    }

    /**
     * 自省模式
     * */
    @Test
    public void introspection_mode_Person() throws IOException, MarshalException, ValidationException, ParserConfigurationException {
        //编组到本地 xml 文件
        Writer writer = new FileWriter(filePath);
        org.exolab.castor.xml.Marshaller.marshal(person, writer);


        //解组到对象
        Person p = (Person) org.exolab.castor.xml.Unmarshaller.unmarshal(Person.class, new FileReader(filePath));
        System.err.println("解组结果:"+p.toString());


        //编组到 org.w3c.dom.Node 节点
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        Marshaller.marshal(person, root);
        System.out.println(JavaxUtil.documentToString(document));
    }



    /**
     * 映射模式
     * */
    @Test
    public void mapping_mode_person() throws MappingException, IOException, MarshalException, ValidationException {
        String path = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping\\Person.xml";
        //load mapping
        org.exolab.castor.mapping.Mapping mapping = new Mapping();
        mapping.loadMapping(path);

        //initialize and configure XMLContext
        org.exolab.castor.xml.XMLContext context = new XMLContext();
        context.addMapping(mapping);

        // Create a Reader to the file to unmarshal from  创建一个 reader 解组
        Reader reader = new FileReader(filePath);

        // Create a new Unmarshaller
        org.exolab.castor.xml.Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setClass(Person.class);
        // Unmarshal the person object
        Person person = (Person) unmarshaller.unmarshal(reader);
        System.err.println(person.toString());


        //编码到xml
        Writer writer = new FileWriter(filePath);
        org.exolab.castor.xml.Marshaller marshaller = context.createMarshaller();
        marshaller.setWriter(writer);
        marshaller.marshal(person);
    }



    /**
     * 描述符模式
     * 编组到 StringWriter
     * */
    @Test
    public void descriptor_mode_to_stringWriter() throws XMLStreamException, MarshalException, ValidationException {
        //编组到 stringWriter
        java.io.StringWriter stringWriter = new StringWriter();
        javax.xml.stream.XMLOutputFactory factory = XMLOutputFactory.newInstance();
        javax.xml.stream.XMLStreamWriter xmlStreamWriter = factory.createXMLStreamWriter(stringWriter);

        org.exolab.castor.xml.Marshaller marshaller = new Marshaller();
        marshaller.setXmlStreamWriter(xmlStreamWriter);
        marshaller.marshal(person);
        System.err.println(stringWriter.toString());
    }


    //编组到 DOMResult
    @Test
    public void descriptor_mode_to_DOMResult() throws ParserConfigurationException, IOException, MarshalException, ValidationException {
        org.exolab.castor.xml.Marshaller marshaller = new XMLContext().createMarshaller();

        javax.xml.parsers.DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();

        marshaller.setResult(new DOMResult(document));
        marshaller.marshal(person);

        System.err.println(JavaxUtil.documentToString(document));
    }



}
