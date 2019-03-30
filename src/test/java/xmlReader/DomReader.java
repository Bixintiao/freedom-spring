package xmlReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import utils.IOUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/12 9:03
 * @Description version 1.0
 * DOM的全称是Document Object Model，也即文档对象模型。在应用程序中，基于DOM的XML分析器将一个XML文档转换成一个对象模型的集合（通常称DOM树），
 * 应用程序正是通过对这个对象模型的操作，来实现对XML文档数据的操作。通过DOM接口，应用程序可以在任何时候访问XML文档中的任何一部分数据，
 * 因此，这种利用DOM接口的机制也被称作随机访问机制。
 */
public class DomReader {

    public void createDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element documentElement = document.createElement("DOCUMENT");
        document.appendChild(documentElement);
    }


    public void parseDocument() throws IOException, ParserConfigurationException, SAXException {
        String xmlPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\document_response.xml";
        String s = IOUtil.fisReadFile(xmlPath, "utf-8");

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(byteArrayInputStream);
    }

}
