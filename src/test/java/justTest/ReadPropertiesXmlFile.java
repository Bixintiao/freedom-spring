package justTest;


import org.junit.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import utils.IOUtil;
import utils.JavaxUtil;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月15日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月15日 {填写修改说明}
 */
public class ReadPropertiesXmlFile {


    /**
     * 读取 properties 文件
     */
    @Test
    public void test01(){
        // 读取 system.properties  这里不需要 .properties后缀
        ResourceBundle resource = ResourceBundle.getBundle("system");
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            String val = resource.getString(key);
            System.out.println("key:"+key +"\t\t val:"+ val);
        }
    }


    /**
     * org.w3c.dom.Document 读取 xml 文件
     * @throws IOException
     */
    @Test
    public void readXml() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        String xmlPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\voucher.xml";

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(new File(xmlPath));
        System.out.println(doc.getDocumentElement().getTextContent());


        javax.xml.xpath.XPathFactory xPathFactory = XPathFactory.newInstance();
        javax.xml.xpath.XPath xPath = xPathFactory.newXPath();


        org.w3c.dom.Node head_node = (Node) xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER[1]/FI_DOC_HEADER[1]", doc, XPathConstants.NODE);
        NodeList childNodes = head_node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++){
            System.out.println(childNodes.item(i).getNodeName() +":" + childNodes.item(i).getTextContent());
        }

    }



    @Test
    public void test2() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        String xmlPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\document_response.xml";
        //文件转String
        String s = IOUtil.fisReadFile(xmlPath, "utf-8");
        System.out.println("读取文件:\n" + s);


        //String 转 Document
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(byteArrayInputStream);


        //Document 转 String
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty("encoding", "UTF-8");// 解决中文问题，试过用GBK不行
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        t.transform(new DOMSource(doc), new StreamResult(bos));
        System.out.println("document 转 String 1");
        System.out.println(bos.toString());


        System.out.println("document 转 String 2");
        System.out.println(JavaxUtil.documentToString(doc));
    }








}
