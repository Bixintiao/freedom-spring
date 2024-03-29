package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

public class JavaxUtil {


    public static String soapMessageToString(SOAPMessage soapMessage) throws SOAPException, TransformerException {
        // Create transformer
        javax.xml.transform.TransformerFactory factory = TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = factory.newTransformer();

        // Get reply content
        Source source = soapMessage.getSOAPPart().getContent();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        transformer.transform(source, new StreamResult(bos));
        return new String(bos.toByteArray());
    }



    public static String documentToString(Document document) {
        String result = null;
        if (document != null) {
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            TransformerFactory tfac = TransformerFactory.newInstance();
            try {
                javax.xml.transform.Transformer t = tfac.newTransformer();
                t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.setOutputProperty(OutputKeys.METHOD, "xml"); // xml, html,
                // text
                t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                t.transform(new DOMSource(document.getDocumentElement()), streamResult);
            } catch (Exception e) {
                System.err.println("XML.toString(Document): " + e);
            }
            result = streamResult.getWriter().toString();
            try {
                stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //添加节点
    public static Element addElement(org.w3c.dom.Document document, org.w3c.dom.Node parent, String eleName, Object content){
        Element ele = document.createElement(eleName);
        if (null != content) {
            if (content.equals("null")){
                ele.setTextContent("");
            }
            else if (content instanceof String){
                ele.setTextContent((String) content);
            }
            else if (content instanceof BigDecimal){
                ele.setTextContent(content.toString());
            }
        }
        parent.appendChild(ele);
        return ele;
    }



}
