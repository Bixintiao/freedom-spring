package webService;

import com.hzy.modules.oxm.entity.ReceiveBelnr;
import entity.ReceiveBelnrHeader;
import entity.ReceiveBelnrItem;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.soap.SOAP12Constants;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.JavaxUtil;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.ws.Dispatch;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/4/10 14:22
 * @Description version 1.0
 * 物流园业务系统获取制造费用凭证信息
 */
public class wukuang_ZfwlyReceiveBelnr {

    String wsdl = "http://ERP07.minmetals.com.cn:8001/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zco_wly_service_query/200/zwly_ws_query/zwly_ws_query?sap-client=200";
    String addr = "http://ERP07.minmetals.com.cn:8001/sap/bc/srt/rfc/sap/zco_wly_service_query/200/zwly_ws_query/zwly_ws_query";
    static ReceiveBelnr receiveBelnr = null;
    static {
        receiveBelnr = new ReceiveBelnr("7390", "2019", "01");
        receiveBelnr.setYwxt("B");
        receiveBelnr.setYwbs("RZ");
    }
    String endPoint = "http://ERP07.minmetals.com.cn:8001/sap/bc/srt/rfc/sap/zco_wly_service_query/200/zwly_ws_query/zwly_ws_query";
    String nameSpace = "urn:sap-com:document:sap:soap:functions:mc-style";



    /**
     * axis
     * @throws Exception
     */
    @Test
    public void ZfwlyReceiveBelnrTest() throws Exception {
        org.apache.axis.client.Service service = new Service();
        org.apache.axis.client.Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endPoint));
        call.setOperationName(new QName(nameSpace, "ZfwlyReceiveBelnr"));
        call.addParameter("PInput", XMLType.SOAP_STRING, javax.xml.rpc.ParameterMode.IN);
        call.addParameter("PBelnr", org.apache.axis.encoding.XMLType.SOAP_STRING, javax.xml.rpc.ParameterMode.OUT);
        call.addParameter("POutput", org.apache.axis.encoding.XMLType.SOAP_STRING, javax.xml.rpc.ParameterMode.OUT);
        call.setReturnType(XMLType.SOAP_STRING);// 设置返回类型
        call.setUseSOAPAction(true);


        String s = JavaxUtil.documentToString(getPInput(receiveBelnr));
        System.err.println(s);

        // 给方法传递参数，并且调用方法
        Object[] obj = new Object[]{s};
        Object o = call.invoke(obj);
        System.out.println("响应结果:"+o);
        parse_zfwlyReceiveBelnr_PBelnr(o.toString());
    }


    /**
     * @throws Exception
     * JAX-WS(Java API for XML Web Services)
     */
    @Test
    public void soapMessage() throws Exception{
        String location = "http://ERP07.minmetals.com.cn:8001/sap/bc/srt/rfc/sap/zco_wly_service_query/200/zwly_ws_query/zwly_ws_query";
        String nameSpace = "urn:sap-com:document:sap:soap:functions:mc-style";
        String server = "zwly_ws_query";
        String port = "ZCO_WLY_SERVICE_QUERY";


        QName serviceName = new QName(nameSpace, server);
        QName portName = new QName(nameSpace, port, "tns");
        javax.xml.ws.Service service = javax.xml.ws.Service.create(serviceName);
        service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, location);
        Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);


        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        soapEnvelope.addNamespaceDeclaration("urn", "urn:sap-com:document:sap:soap:functions:mc-style");
        SOAPBody soapBody = soapEnvelope.getBody();
        SOAPElement zfwlyReceiveBelnr = soapBody.addChildElement(new QName(nameSpace, "ZfwlyReceiveBelnr", "urn"));
        SOAPElement pInput = zfwlyReceiveBelnr.addChildElement("PInput");


        Document pInput_textContent = getPInput(receiveBelnr);
        pInput.setTextContent(JavaxUtil.documentToString(pInput_textContent));


        System.out.println("请求报文:");
        System.err.println(JavaxUtil.soapMessageToString(soapMessage));
        SOAPMessage response = dispatch.invoke(soapMessage);
        System.out.println("响应结果:");
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        System.out.println(JavaxUtil.documentToString(doc));
        parse_zfwlyReceiveBelnr_response(doc);
    }


    void parse_zfwlyReceiveBelnr_response(Document document) throws Exception{
        XPath xPath = XPathFactory.newInstance().newXPath();
        org.w3c.dom.Node PBelnr = (org.w3c.dom.Node)xPath.evaluate("//PBelnr", document, XPathConstants.NODE);
        org.w3c.dom.Node POutput = (org.w3c.dom.Node)xPath.evaluate("//POutput", document, XPathConstants.NODE);


        parse_zfwlyReceiveBelnr_PBelnr(PBelnr.getTextContent());
        parse_zfwlyReceiveBelnr_POutput(POutput.getTextContent());
    }


    void parse_zfwlyReceiveBelnr_POutput(String s) throws Exception{
        if (null == s || s.equals(""))
            return;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(byteArrayInputStream);
        XPath xPath = XPathFactory.newInstance().newXPath();
        org.w3c.dom.Node repCode = (org.w3c.dom.Node)xPath.evaluate("//DOCUMENTRESPONSE/RSPCODE", document, XPathConstants.NODE);
        org.w3c.dom.Node repMsg = (org.w3c.dom.Node)xPath.evaluate("//DOCUMENTRESPONSE/RSPMSG", document, XPathConstants.NODE);
        org.w3c.dom.Node receiveDate = (org.w3c.dom.Node)xPath.evaluate("//DOCUMENTRESPONSE/RECEIVE_DATA", document, XPathConstants.NODE);
        org.w3c.dom.Node receiveTime = (org.w3c.dom.Node)xPath.evaluate("//DOCUMENTRESPONSE/RECEIVE_TIME", document, XPathConstants.NODE);
    }


    public List<ReceiveBelnrHeader> parse_zfwlyReceiveBelnr_PBelnr(String s) throws Exception{
        if (null == s || s.equals(""))
            return null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(byteArrayInputStream);

        XPath xPath = XPathFactory.newInstance().newXPath();
        org.w3c.dom.Node FI_DOC_HEADER = (org.w3c.dom.Node)xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER/FI_DOC_HEADER", document, XPathConstants.NODE);
        org.w3c.dom.Node FI_DOC_ITEMS = (org.w3c.dom.Node)xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER/FI_DOC_ITEMS", document, XPathConstants.NODE);
        NodeList heads = FI_DOC_HEADER.getChildNodes();
        NodeList items = FI_DOC_ITEMS.getChildNodes();
        List<ReceiveBelnrHeader> headerList = new ArrayList<ReceiveBelnrHeader>();
        for (int i = 0; i<heads.getLength(); i++){
            Node head = heads.item(i);
            NodeList properties = head.getChildNodes();
            ReceiveBelnrHeader header = new ReceiveBelnrHeader();
            for (int j = 0; j<properties.getLength(); j++){
                Node pro = properties.item(j);
                switch (pro.getNodeName()){
                    case "BUKRS":
                        header.setBukrs(pro.getTextContent());
                        break;
                    case "GJAHR":
                        header.setGjahr(pro.getTextContent());
                        break;
                    case "BELNR":
                        header.setBelnr(pro.getTextContent());
                        break;
                    case "MONAT":
                        header.setMonat(pro.getTextContent());
                        break;
                    case "NUMPG":
                        header.setNumpg(pro.getTextContent());
                        break;
                    case "USNAM":
                        header.setUsnam(pro.getTextContent());
                        break;
                    case "BLDAT":
                        header.setBldat(pro.getTextContent());
                        break;
                    case "BUDAT":
                        header.setBudat(pro.getTextContent());
                        break;
                    case "BLART":
                        header.setBlart(pro.getTextContent());
                        break;
                    case "STBLG":
                        header.setStblg(pro.getTextContent());
                        break;
                    default:
                        break;
                }
            }
            headerList.add(header);
        }
        for (int i=0; i<items.getLength();i++){
            Node item = items.item(i);
            NodeList properties = item.getChildNodes();
            ReceiveBelnrItem itm = new ReceiveBelnrItem();
            for (int j = 0; j<properties.getLength(); j++){
                Node pro = properties.item(j);
                switch (pro.getNodeName()){
                    case "BUKRS":
                        itm.setBukrs(pro.getTextContent());
                        break;
                    case "GJAHR":
                        itm.setGjahr(pro.getTextContent());
                        break;
                    case "BELNR":
                        itm.setBelnr(pro.getTextContent());
                        break;
                    case "BUZEI":
                        itm.setBuzei(pro.getTextContent());
                        break;
                    case "BSCHL":
                        itm.setBschl(pro.getTextContent());
                        break;
                    case "HKONT":
                        itm.setHkont(pro.getTextContent());
                        break;
                    case "WRBTR":
                        itm.setWrbtr(pro.getTextContent());
                        break;
                    case "XNEGP":
                        itm.setXnegp(pro.getTextContent());
                        break;
                    case "LIFNR":
                        itm.setLifnr(pro.getTextContent());
                        break;
                    case "KUNNR":
                        itm.setKunnr(pro.getTextContent());
                        break;
                    case "PRCTR":
                        itm.setPrctr(pro.getTextContent());
                        break;
                    case "KOSTL":
                        itm.setKostl(pro.getTextContent());
                        break;
                    case "ZUONR":
                        itm.setZuonr(pro.getTextContent());
                        break;
                    case "SGTXT":
                        itm.setSgtxt(pro.getTextContent());
                        break;
                    case "RSTGR":
                        itm.setRstgr(pro.getTextContent());
                        break;
                    case "SHKZG":
                        itm.setShkzg(pro.getTextContent());
                        break;
                    default:
                        break;
                }
            }
            for (ReceiveBelnrHeader head : headerList){
                if (head.getBukrs().equals(itm.getBukrs()) && head.getGjahr().equals(itm.getGjahr()) && head.getBelnr().equals(itm.getBelnr())){
                    head.getItems().add(itm);
                }
            }
        }
        return headerList;
    }



    Document getPInput(ReceiveBelnr receiveBelnr) throws ParserConfigurationException {
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sendDate = sdf.format(d);
        sdf.applyPattern("HH:mm:ss");
        String sendTime = sdf.format(d);

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("DOCUMENT");
        document.appendChild(root);
        Element reverse_voucher = addElement(document, root, "REVERSE_VOUCHER", null);
        addElement(document, reverse_voucher, "YWXT", receiveBelnr.getYwxt());
        addElement(document, reverse_voucher, "YWBS", receiveBelnr.getYwbs());
        addElement(document, reverse_voucher, "BUKRS", receiveBelnr.getBukrs());
        addElement(document, reverse_voucher, "GJAHR", receiveBelnr.getGjahr());
        addElement(document, reverse_voucher, "MONAT", receiveBelnr.getMonat());
        addElement(document, reverse_voucher, "SEND_DATE", sendDate);
        addElement(document, reverse_voucher, "SEND_TIME", sendTime);
        return document;
    }

    Element addElement(Document document, Element parent,String eleName, String textContent){
        Element ele = document.createElement(eleName);
        if (null != textContent)
            ele.setTextContent(textContent);
        parent.appendChild(ele);
        return ele;
    }


}
