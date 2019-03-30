package webService;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.w3c.dom.Document;
import utils.IOUtil;
import utils.JavaxUtil;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.ws.Dispatch;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

/**
 * freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/1 9:50
 * @Description webService地址： http://www.webxml.com.cn/zh_cn/web_services.aspx
 * version 1.0
 */
public class WeatherWsTest {


    String wsdlDocumentLocation = "http://10.1.1.15:8001/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz?sap-client=200?wsdl";




    /**
     * 使用 HttpURLConnection 的方式连接
     * @throws IOException
     */
    @Test
    public void getRegionDatasetTest() throws IOException  {
        URL wsUrl = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionDataset");
        HttpURLConnection conn = (HttpURLConnection)wsUrl.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

        OutputStream os = conn.getOutputStream();

        String soap = "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getRegionDataset xmlns=\"http://WebXml.com.cn/\" />\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

        os.write(soap.getBytes());
        InputStream is = conn.getInputStream();

        System.out.println(IOUtil.inputStreamToString(is, "UTF-8"));
        os.close();
        conn.disconnect();
    }






    /**
     * use SOAP 1.1
     * @throws MalformedURLException
     * @throws SOAPException
     * @throws TransformerException
     */
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
        //soapHeader.addAttribute(new QName(nameSpace, "SOAPAction", "method"), "http://WebXml.com.cn/getRegionDataset");

        SOAPBody soapBody = envelope.getBody();
        SOAPElement operation = soapBody.addBodyElement(new QName("http://WebXml.com.cn/", "getRegionDataset"));


        MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
        mimeHeaders.setHeader("SOAPAction","http://WebXml.com.cn/getRegionDataset");
        //mimeHeaders.setHeader("Content-Type","text/xml; charset=utf-8");
        //mimeHeaders.addHeader("Host", "ws.webxml.com.cn");

        System.out.println("------------------- allHeaders ---------------------");
        Iterator allHeaders = mimeHeaders.getAllHeaders();
        while (allHeaders.hasNext()){
            System.out.println(JSON.toJSONString(allHeaders.next()));
        }


        System.out.println("---------------------- request soapMessage ----------------------");
        System.out.println(JavaxUtil.soapMessageToString(soapMessage));

        //请求webService
        SOAPMessage response = dispatch.invoke(soapMessage);

        // 输出响应结果
        System.out.println("---------------------- response document ----------------------");
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        System.out.println(JavaxUtil.documentToString(doc));
    }




    /**
     * use SOAP 1.2
     * @throws MalformedURLException
     * @throws SOAPException
     * @throws TransformerException
     */
    @Test
    public void getRegionDataset_soap12() throws MalformedURLException, SOAPException, TransformerException {
        String wsdlDocumentLocation = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
        String nameSpace = "http://WebXml.com.cn/";
        String serviceName = "WeatherWS";
        String portName = "WeatherWSSoap12";


        javax.xml.ws.Service service = javax.xml.ws.Service.create(new URL(wsdlDocumentLocation), new QName(nameSpace, serviceName));
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(nameSpace, portName), SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);

        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPHeader soapHeader = soapEnvelope.getHeader();
        SOAPBody soapBody = soapEnvelope.getBody();
        soapBody.addChildElement(new QName(nameSpace, "getRegionDataset"));

        MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
        //mimeHeaders.addHeader("soapAction","http://WebXml.com.cn/getRegionDataset");


        System.out.println("---------------------- request soapMessage ----------------------");
        System.out.println(JavaxUtil.soapMessageToString(soapMessage));

        // 请求webService
        SOAPMessage response = dispatch.invoke(soapMessage);

        // 输出响应结果
        System.out.println("---------------------- response document ----------------------");
        Iterator resHeader = response.getMimeHeaders().getAllHeaders();
        while (resHeader.hasNext()){
            System.out.println(JSON.toJSONString(resHeader.next()));
        }
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        System.out.println(JavaxUtil.documentToString(doc));
    }





    /**
     * use SOAP 1.1
     * @throws MalformedURLException
     * @throws SOAPException
     * @throws TransformerException
     * 获得支持的城市/地区名称和与之对应的ID
     */
    @Test
    public void getSupportCityString_soap12() throws MalformedURLException, SOAPException, TransformerException {
        String wsdlDocumentLocation = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
        String nameSpace = "http://WebXml.com.cn/";
        String serviceName = "WeatherWS";
        String portName = "WeatherWSSoap12";


        javax.xml.ws.Service service = javax.xml.ws.Service.create(new URL(wsdlDocumentLocation), new QName(nameSpace, serviceName));
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(nameSpace, portName), SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);

        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPHeader soapHeader = soapEnvelope.getHeader();
        SOAPBody soapBody = soapEnvelope.getBody();
        SOAPElement operation = soapBody.addChildElement(new QName(nameSpace, "getSupportCityString"));


        SOAPElement theRegionCode = operation.addChildElement("theRegionCode");
        theRegionCode.setTextContent("北京");


        System.err.println("\n ---------------------- request soapMessage ---------------------- \n");
        System.err.println(JavaxUtil.soapMessageToString(soapMessage));

        // 请求webService
        SOAPMessage response = dispatch.invoke(soapMessage);

        // 输出响应结果
        System.out.println("---------------------- response document ----------------------");
        Iterator resHeader = response.getMimeHeaders().getAllHeaders();
        while (resHeader.hasNext()){
            System.out.println(JSON.toJSONString(resHeader.next()));
        }
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        System.err.println(JavaxUtil.documentToString(doc));
    }



}
