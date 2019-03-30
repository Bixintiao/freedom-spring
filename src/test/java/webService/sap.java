package webService;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.IOUtil;
import utils.JavaxUtil;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/6 9:16
 * @Description version 1.0
 */
public class sap {


    String address  = "http://erp07.minmetals.com.cn:8001/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz?wsdl";
    String address2 = "http://10.1.1.15:8001/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz?wsdl";


    @Test
    public void buildSapXml() throws ParserConfigurationException {
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



        System.out.println(JavaxUtil.documentToString(document));
    }

    public Element createNewElement(Document document,String tagName, String textContent){
        Element element = document.createElement(tagName);
        element.setTextContent(textContent);
        return element;
    }


    @Test
    public void parseResponse() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String xmlPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\document_response.xml";
        String s = IOUtil.fisReadFile(xmlPath, "utf-8");

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(byteArrayInputStream);

        XPath xPath = XPathFactory.newInstance().newXPath();
        org.w3c.dom.Node rspCode = (Node)xPath.evaluate("//DOCUMENTRESPONSE/RSPCODE", doc, XPathConstants.NODE);
        org.w3c.dom.Node rspMsg = (Node)xPath.evaluate("//DOCUMENTRESPONSE/RSPMSG", doc, XPathConstants.NODE);
        org.w3c.dom.Node receiveData = (Node)xPath.evaluate("//DOCUMENTRESPONSE/RECEIVE_DATA", doc, XPathConstants.NODE);
        org.w3c.dom.Node receiveTime = (Node)xPath.evaluate("//DOCUMENTRESPONSE/RECEIVE_TIME", doc, XPathConstants.NODE);

        System.out.println(rspCode.getTextContent());
        System.out.println(rspMsg.getTextContent());
        System.out.println(receiveData.getTextContent());
        System.out.println(receiveTime.getTextContent());
    }


    /**
     * 请求制造费用凭证信息
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     */
    @Test
    public void getFeeVoucherRequest() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String path = "C:\\Users\\韩正禹\\Desktop\\文档\\sap\\getFeeVoucherRequest.xml";
        String s = IOUtil.fisReadFile(path, "utf-8");

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(byteArrayInputStream);

        System.out.println(JavaxUtil.documentToString(doc));

        XPath xPath = XPathFactory.newInstance().newXPath();
        org.w3c.dom.Node company = (Node)xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER/COMPANY", doc, XPathConstants.NODE);
        org.w3c.dom.Node year = (Node)xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER/YEAR", doc, XPathConstants.NODE);
        org.w3c.dom.Node monat = (Node)xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER/MONAT", doc, XPathConstants.NODE);
        org.w3c.dom.Node hkont = (Node)xPath.evaluate("//DOCUMENT/REVERSE_VOUCHER/HKONT", doc, XPathConstants.NODE);

        System.out.println(company.getTextContent());
        System.out.println(year.getTextContent());
        System.out.println(monat.getTextContent());
        System.out.println(hkont.getTextContent());
    }



    @Test
    public void getFeeVoucherRequest2() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String path = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\getFeeVoucherRequest-more.xml";
        String s = IOUtil.fisReadFile(path, "utf-8");

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(byteArrayInputStream);

        System.out.println(JavaxUtil.documentToString(doc));

        XPath xPath = XPathFactory.newInstance().newXPath();
        org.w3c.dom.Node items  = (Node)xPath.evaluate("//DOCUMENT/ITEMS", doc, XPathConstants.NODE);
        org.w3c.dom.Node reverse_voucher  = (Node)xPath.evaluate("//DOCUMENT/ITEMS/REVERSE_VOUCHER", doc, XPathConstants.NODE);

        NodeList childNodes = items.getChildNodes();
        for (int i = 0; i<childNodes.getLength(); i++){
            Node item = childNodes.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE){
                NodeList reverse_vouchers = item.getChildNodes();
                for (int j = 0; j<childNodes.getLength(); j++){
                    Node n = reverse_vouchers.item(j);
                    System.out.println("j:"+j+"   "+ n.getNodeName() + "  " + n.getTextContent());
                }
            }
        }
    }


    public void printNode(Node item){
        System.out.println("item:"+ item.getNodeName() +" NodeValue:"+ item.getNodeValue() +"   NodeType:"+ item.getNodeType() + "   TextContent:" + item.getTextContent());
    }



    @Test
    public void getSendSAPVoucherResult() throws ServiceException, MalformedURLException, RemoteException {
        String endPoint = "http://localhost:8088/services/sendSAPVoucherResult";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endPoint));
        call.setOperationName(new QName("http://service.jk.minmetals.baosight.com", "sendSAPVoucherResult"));
        call.addParameter("data", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
        call.setUseSOAPAction(true);


        Object[] obj = new Object[]{ JavaxUtil.documentToString(createRequest()) };
        Object o = call.invoke(obj);
        System.out.println(" --------------------- ");
        System.out.println(o);
    }




    public Document createRequest() {
        Document document = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.newDocument();

            Element documentElement = document.createElement("DOCUMENT");
            document.appendChild(documentElement);

            Element reverse_voucher = document.createElement("REVERSE_VOUCHER");
            documentElement.appendChild(reverse_voucher);

            reverse_voucher.appendChild(createNewElement(document,"COMPANY", "公司代码"));
            reverse_voucher.appendChild(createNewElement(document,"YEAR", "会计年度"));
            reverse_voucher.appendChild(createNewElement(document,"MONAT", "过账期间"));
            reverse_voucher.appendChild(createNewElement(document,"SAPDOC_ID", "SAP凭证ID"));
            reverse_voucher.appendChild(createNewElement(document,"DOCUMENT_ID", "宝信凭证ID"));
            reverse_voucher.appendChild(createNewElement(document,"STATUS", "1"));
            reverse_voucher.appendChild(createNewElement(document,"REASON", ""));
            reverse_voucher.appendChild(createNewElement(document,"SEND_DATA", "发送日期"));
            reverse_voucher.appendChild(createNewElement(document,"SEND_TIME", "发送时间"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return document;
    }




    @Test
    public void createResponse() throws ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();

        Element documentElement = document.createElement("DOCUMENT");
        document.appendChild(documentElement);


        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(d);

        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String nowTime = sdf2.format(d);

        documentElement.appendChild(createNewElement(document,"RSPCODE", "1"));
        documentElement.appendChild(createNewElement(document,"RSPMSG", "1"));
        documentElement.appendChild(createNewElement(document,"RECEIVE_DATE", nowDate));
        documentElement.appendChild(createNewElement(document,"RECEIVE_TIME", nowTime));

        System.out.println(JavaxUtil.documentToString(document));
    }


    String a = "http://erp07.minmetals.com.cn:8001/sap/bc/srt/rfc/sap/zco_wly_service_pz/200/zwly_ws_pz/zwly_ws_pz";





}
