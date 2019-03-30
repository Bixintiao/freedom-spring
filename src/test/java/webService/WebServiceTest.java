package webService;

import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.sun.xml.internal.ws.developer.JAXWSProperties;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import utils.JavaxUtil;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Dispatch;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class WebServiceTest {


    Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 通过UrlConnection调用Webservice服务
     * url 发布地址/方法名
     * 		http://localhost:9987/wsdemo/Webservice/sayHello
     */
    @Test
    public void call3() throws IOException {
        URL wsUrl = new URL("http://localhost:9987/wsdemo/Webservice/sayHello");

        HttpURLConnection conn = (HttpURLConnection)wsUrl.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

        OutputStream os = conn.getOutputStream();

        //请求体
        String soap = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:method=\"http://service.wedemo.hzy.com/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" >" +
                "<soap:Body> <method:sayHello><arg0>ai ya ya</arg0>  </method:sayHello> </soap:Body> </soap:Envelope>";


        os.write(soap.getBytes());
        InputStream is = conn.getInputStream();

        byte[] b = new byte[1024];
        int len = 0;
        String s = "";
        while((len = is.read(b)) != -1){
            String ss = new String(b,0,len,"UTF-8");
            s += ss;
        }

        is.close();
        os.close();
        conn.disconnect();
    }




    /**
     * 直接用SOAP访问webService
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        String wsdlUrl = "http://localhost:9987/wsdemo/Webservice?wsdl";
        String nameSpace = "http://service.wedemo.hzy.com/";
        String serviceName = "WebServiceImplService";
        String portName = "WebServiceImplPort";
        String responseName = "return";

        // 1.create a service
        URL url = new URL(wsdlUrl);
        QName qname = new QName(nameSpace, serviceName);
        javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);

        // 2.create Dispatch object
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(nameSpace, portName),
                SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);

        // 3. create soapMessage
        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createMessage();
        soapMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "UTF-8");

        // 3.1 create SOAPEnvlove
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.setPrefix("soap");
        envelope.addNamespaceDeclaration("method", nameSpace);
        //envelope.removeAttribute("xmls:env");

        // 3.2 create SOAPheader
        SOAPHeader soapHeader = envelope.getHeader();
        if (null == soapHeader) {
            soapHeader = envelope.addHeader();
        }
        soapHeader.setPrefix("soap");


        // 3.3 create SOAPBody
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soap");
        SOAPElement operation = soapBody.addChildElement(new QName(nameSpace, "sayHello", "method"));
        operation.addChildElement("arg0").setValue("aiyaya");


        // print soapMessage to console
        System.out.println("----------------------- 发送的消息 -----------------------");
        //soapMessage.writeTo(System.out);
        System.out.println(JavaxUtil.soapMessageToString(soapMessage));

        // set timeout
        dispatch.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 180000);
        dispatch.getRequestContext().put(JAXWSProperties.REQUEST_TIMEOUT, 180000);
        SOAPMessage response = dispatch.invoke(soapMessage);

        // 4. get response and transfer to dom object
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();

        // 输出响应结果
        System.out.println("----------------------- 响应结果 -----------------------");
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        String xml = writer.toString();
        System.out.println("xml:" + xml);


        String result = doc.getElementsByTagName(responseName).item(0).getTextContent();
        System.out.println("result:" + result);
    }



    @Test
    public void getRegionDataset_soap11() throws MalformedURLException, SOAPException, TransformerException {

        String wsdlDocumentLocation = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
        String nameSpace = "http://WebXml.com.cn/";
        String serviceName = "WeatherWS";
        String portName = "WeatherWSSoap";

        javax.xml.ws.Service service = javax.xml.ws.Service.create(new URL(wsdlDocumentLocation), new QName(nameSpace, serviceName));
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(nameSpace, portName),
                SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);


        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("method", nameSpace);

        SOAPHeader soapHeader = envelope.getHeader();
        soapHeader.addAttribute(new QName(nameSpace, "SOAPAction", "method"), "http://WebXml.com.cn/getRegionDataset");

        SOAPBody soapBody = envelope.getBody();
        SOAPElement operation = soapBody.addBodyElement(new QName("http://WebXml.com.cn/", "getRegionDataset"));


        MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
        mimeHeaders.setHeader("SOAPAction","http://WebXml.com.cn/getRegionDataset");

        //请求webService
        SOAPMessage response = dispatch.invoke(soapMessage);

        // 输出响应结果
        System.out.println("---------------------- response document ----------------------");
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
    }


}
