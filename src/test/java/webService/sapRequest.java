package webService;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.IOUtil;
import utils.JavaxUtil;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Dispatch;
import javax.xml.ws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/18 9:37
 * @Description version 1.0
 */
public class sapRequest {

    String addr1 = "http://10.1.1.15:8001/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz?sap-client=200";
    String addr2 = "http://erp07.minmetals.com.cn:8001/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz?sap-client=200";
    String addr3 = "http://ERP07.minmetals.com.cn:8001/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz";
    String nameSpace = "urn:sap-com:document:sap:soap:functions:mc-style";
    String serviceName = "ZWLY_WS_PZ";
    String portName = "ZWLY_WS_PZ";
    String username = "zhangwy";
    String password = "password";



    //使用http的方式
    @Test
    public void httpZfwlyReceiveData() throws IOException {
        URL wsUrl = new URL(addr3);
        HttpURLConnection conn = (HttpURLConnection)wsUrl.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

        OutputStream os = conn.getOutputStream();

        String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <urn:ZfwlyReceiveData>\n" +
                "         <PInput>?</PInput>\n" +
                "         <PYwxt>?</PYwxt>\n" +
                "      </urn:ZfwlyReceiveData>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        os.write(soap.getBytes());
        InputStream is = conn.getInputStream();

        String s = IOUtil.inputStreamToString(is, "utf-8");
        String a = s.replaceAll("&gt;",">").replaceAll("&lt;","<");
        System.out.println(a);
        os.close();
        conn.disconnect();
    }



    @Test
    public void axisZfwlyReceiveData() throws ServiceException, IOException {

        String xml = IOUtil.fisReadFile("C:\\Users\\韩正禹\\Desktop\\sap.xml", "utf-8");
        System.err.println("xml:\n"+xml);

        String endPoint = addr3;
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endPoint));
        call.setOperationName(new QName(nameSpace, "ZfwlyReceiveData"));
        call.addParameter("PInput", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        call.addParameter("PYwxt", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
        call.setUseSOAPAction(true);


        // 给方法传递参数，并且调用方法
        Object[] obj = new Object[]{ xml, "B" };
        Object o = call.invoke(obj);
        System.out.println(" --------------------- ");
        System.out.println(o);
    }


    // 使用 java
    @Test
    public void testZfwlyReceiveData() throws MalformedURLException, SOAPException, TransformerException {
        String wsdlDocumentLocation = addr1;
        String nameSpace = "urn:sap-com:document:sap:soap:functions:mc-style";
        String serviceName = "ZWLY_WS_PZ";
        String portName = "ZWLY_WS_PZ_soap12";

        javax.xml.ws.Service service = javax.xml.ws.Service.create(new URL(wsdlDocumentLocation), new QName(nameSpace, serviceName));
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(nameSpace, portName), SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);

        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn","urn:sap-com:document:sap:soap:functions:mc-style");
        SOAPBody body = envelope.getBody();
        SOAPElement operation = body.addChildElement("ZfwlyReceiveData");
        operation.setPrefix("urn");
        SOAPElement pInput = operation.addChildElement("PInput");
        SOAPElement pYwxt = operation.addChildElement("PYwxt");
        pYwxt.setTextContent("B");

        MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
        mimeHeaders.setHeader("SOAPAction","urn:sap-com:document:sap:soap:functions:mc-style:ZCO_WLY_SERVICE_PZ:ZfwlyReceiveDataRequest");


        System.out.println("---------------------- 请求报文 ----------------------");
        System.err.println(JavaxUtil.soapMessageToString(soapMessage));



        //请求webService
        SOAPMessage response = dispatch.invoke(soapMessage);

        // 输出响应结果
        System.out.println("---------------------- 响应结果 ----------------------");
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        System.err.println(JavaxUtil.documentToString(doc));

    }



    @Test
    public void test03() throws SOAPException, TransformerException {
        QName serviceName = new QName("http://erp07.minmetals.com.cn", "ZWLY_WS_PZ", "minmetals");
        QName portName = new QName("http://erp07.minmetals.com.cn", "ZWLY_WS_PZ");
        javax.xml.ws.Service service = javax.xml.ws.Service.create(serviceName);
        service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, addr2);


        Dispatch<SOAPMessage> dispatch = service.createDispatch(portName,
                SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);
        MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage soapMessage = mf.createMessage();
        SOAPPart part = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        envelope.addNamespaceDeclaration("minmetals", "http://erp07.minmetals.com.cn");
        SOAPBody body = envelope.getBody();
        SOAPElement operation = body.addChildElement("ZfwlyReceiveData");


        SOAPMessage response = dispatch.invoke(soapMessage);
        SOAPBody soapBody = response.getSOAPBody();
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(soapBody), new StreamResult(writer));
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        String xml = writer.toString();
        System.out.println("----------------------------------");
        System.out.println(xml);
    }




    public Document buildDocument(String data) throws ParserConfigurationException{
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();

        Element documentElement = document.createElement("DOCUMENT");
        document.appendChild(documentElement);
        Element reverse_voucher = document.createElement("REVERSE_VOUCHER");
        documentElement.appendChild(reverse_voucher);
        Element fi_doc_header = document.createElement("FI_DOC_HEADER");
        reverse_voucher.appendChild(fi_doc_header);
        Element fi_doc_items = document.createElement("FI_DOC_ITEMS");
        reverse_voucher.appendChild(fi_doc_items);



        // header
        Element header = document.createElement("HEAD");
        fi_doc_header.appendChild(header);
        header.appendChild(createNewElement(document,"YWXT",""));
        header.appendChild(createNewElement(document,"YW_ID",""));
        header.appendChild(createNewElement(document,"BUKRS",""));
        header.appendChild(createNewElement(document,"GJAHR",""));
        header.appendChild(createNewElement(document,"BKTXT",""));
        header.appendChild(createNewElement(document,"USNAM",""));
        header.appendChild(createNewElement(document,"BLDAT",""));
        header.appendChild(createNewElement(document,"BUDAT",""));
        header.appendChild(createNewElement(document,"MONAT",""));
        header.appendChild(createNewElement(document,"BLART",""));
        header.appendChild(createNewElement(document,"WAERS",""));
        header.appendChild(createNewElement(document,"KURSF",""));
        header.appendChild(createNewElement(document,"NUMPG",""));
        header.appendChild(createNewElement(document,"XBLNR",""));
        header.appendChild(createNewElement(document,"R_BELNR",""));
        header.appendChild(createNewElement(document,"STGRD",""));
        header.appendChild(createNewElement(document,"STODT",""));
        header.appendChild(createNewElement(document,"ZYW_TYPE",""));
        header.appendChild(createNewElement(document,"ZADDITIONAL1",""));
        header.appendChild(createNewElement(document,"ZADDITIONAL2",""));
        header.appendChild(createNewElement(document,"ZADDITIONAL3",""));
        header.appendChild(createNewElement(document,"ZADDITIONAL4",""));


        // items
        Element item = document.createElement("ITEM");
        fi_doc_items.appendChild(item);
        item.appendChild(createNewElement(document,"YW_ID", ""));
        item.appendChild(createNewElement(document,"BUKRS", ""));
        item.appendChild(createNewElement(document,"GJAHR", ""));
        item.appendChild(createNewElement(document,"BUZEI", ""));
        item.appendChild(createNewElement(document,"BSCHL", ""));
        item.appendChild(createNewElement(document,"HKONT", ""));
        item.appendChild(createNewElement(document,"WRBTR", ""));
        item.appendChild(createNewElement(document,"DMBTR", ""));
        item.appendChild(createNewElement(document,"XNEGP", ""));
        item.appendChild(createNewElement(document,"UMSKZ", ""));
        item.appendChild(createNewElement(document,"LIFNR", ""));
        item.appendChild(createNewElement(document,"KUNNR", ""));
        item.appendChild(createNewElement(document,"PRCTR", ""));
        item.appendChild(createNewElement(document,"KOSTL", ""));
        item.appendChild(createNewElement(document,"VBUND", ""));
        item.appendChild(createNewElement(document,"MENGE", ""));
        item.appendChild(createNewElement(document,"MEINS", ""));
        item.appendChild(createNewElement(document,"MWSKZ", ""));
        item.appendChild(createNewElement(document,"FWBAS", ""));
        item.appendChild(createNewElement(document,"PAOBJNR", ""));
        item.appendChild(createNewElement(document,"AUFNR", ""));
        item.appendChild(createNewElement(document,"EBELN", ""));
        item.appendChild(createNewElement(document,"EBELP", ""));
        item.appendChild(createNewElement(document,"ZUONR", ""));
        item.appendChild(createNewElement(document,"SGTXT", ""));
        item.appendChild(createNewElement(document,"RSTGR", ""));
        item.appendChild(createNewElement(document,"MATNR", ""));
        item.appendChild(createNewElement(document,"GSBER", ""));
        item.appendChild(createNewElement(document,"PMNTTRMS", ""));
        item.appendChild(createNewElement(document,"VALUT", ""));
        item.appendChild(createNewElement(document,"ZFBDT", ""));
        item.appendChild(createNewElement(document,"ZZIST", ""));
        item.appendChild(createNewElement(document,"XREF1", ""));
        item.appendChild(createNewElement(document,"XREF2", ""));
        item.appendChild(createNewElement(document,"XREF3", ""));
        item.appendChild(createNewElement(document,"WDATE", ""));
        item.appendChild(createNewElement(document,"WNAME", ""));
        item.appendChild(createNewElement(document,"WORT1", ""));
        item.appendChild(createNewElement(document,"REGIO", ""));
        item.appendChild(createNewElement(document,"WBZOG", ""));
        item.appendChild(createNewElement(document,"WORT2", ""));
        item.appendChild(createNewElement(document,"WBANK", ""));
        item.appendChild(createNewElement(document,"ANRED", ""));
        item.appendChild(createNewElement(document,"NAME1", ""));
        item.appendChild(createNewElement(document,"ORT01", ""));
        item.appendChild(createNewElement(document,"LAND1", ""));
        item.appendChild(createNewElement(document,"ZADDITIONAL1", ""));
        item.appendChild(createNewElement(document,"ZADDITIONAL2", ""));
        item.appendChild(createNewElement(document,"ZADDITIONAL3", ""));
        item.appendChild(createNewElement(document,"ZADDITIONAL4", ""));
        item.appendChild(createNewElement(document,"ZADDITIONAL5", ""));
        item.appendChild(createNewElement(document,"ZADDITIONAL6", ""));

        return document;
    }


    public Element createNewElement(Document document,String tagName, String textContent){
        Element element = document.createElement(tagName);
        element.setTextContent(textContent);
        return element;
    }




    @Test
    public void test3(){
        String authorization = new sun.misc.BASE64Encoder().encode((username + ":" + password).getBytes());
        System.out.println(authorization);
    }





}
