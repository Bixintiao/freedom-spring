package utils;

import org.junit.Test;
import org.xml.sax.SAXException;
import utils.DBUtil.DBTool;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月10日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月10日 {填写修改说明}
 */
public class IOUtil {


    public static String inputStreamToString(InputStream is) throws IOException {
        return inputStreamToString(is,null);
    }

    public static String inputStreamToString(InputStream is, String charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        byte[] bytes = new byte[2048];
        while ((len = is.read(bytes)) != -1){
            if (null == charset)
                sb.append(new String(bytes,0,len));
            else
                sb.append(new String(bytes,0, len, charset));
        }
        is.close();
        return sb.toString();
    }


    public static String fisReadFile(String filePath) throws IOException {
        return fisReadFile(filePath,null);
    }


    public static String fisReadFile(String filePath,String charset) throws IOException {
        filePath = resolvePath(filePath);
        InputStream is = new FileInputStream(new File(filePath));
        return inputStreamToString(is, charset);
    }



    public static BufferedReader getBufferReader(String filePath) throws IOException  {
        return getBufferReader(filePath,null);
    }

    public static BufferedReader getBufferReader(String filePath, String charset) throws IOException  {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = null;
        if (null != charset)
            isr = new InputStreamReader(fis,charset);
        else
            isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        return br;
    }

    public static String brReadFile(String filePath) throws IOException {
        return brReadFile(filePath,null);
    }

    public static String brReadFile(String filePath, String charset) throws IOException {
        BufferedReader br = getBufferReader(filePath,charset);
        StringBuilder sb = new StringBuilder();
        br.lines().forEach(x->{ sb.append(x); });
        br.close();
        return sb.toString();
    }


    public static void writeToFile(String str,String filePath) throws Exception {
        PrintWriter pw = null;
        try {
            filePath = resolvePath(filePath);
            File file = new File(filePath);
            if (!file.exists()){
                file.createNewFile();
            }
            pw = new PrintWriter(file);
            pw.write(str.toCharArray());
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            pw.flush();
            pw.close();
        }
    }


    /**
     * 读取 properties 文件
     * 这里不需要 .properties后缀
     * @param classPath
     * @return
     */
    public static ResourceBundle readProperties(String classPath){
        ResourceBundle resource = ResourceBundle.getBundle(classPath);
        return resource;
    }


    public static String resolvePath(String path){
        if (path.startsWith("file:")){
            return path.substring(5);
        }
        return path;
    }


    /**
     * org.w3c.dom.Document 读取 xml 文件
     * @param xmlFile
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static javax.xml.xpath.XPath readXml1(File xmlFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.parse(xmlFile);
        javax.xml.xpath.XPathFactory xPathFactory = XPathFactory.newInstance();
        return xPathFactory.newXPath();
    }



    @Test
    public void test(){

        String filePath = "E:\\Temp\\outfile\\out1.txt";

        //r1:  file:/C:/workspace/program/idea/ubmp/target/ForTest-classes/com/sinochem/ubmp/modules/fiance/
        URL r1 = this.getClass().getResource("");
        //r2:  file:/C:/workspace/program/idea/ubmp/target/ForTest-classes/
        URL r2 = this.getClass().getResource("/");
        //r3:  file:/C:/workspace/program/idea/ubmp/target/ForTest-classes/
        URL r3 = this.getClass().getClassLoader().getResource("");
        //r4:  file:/C:/workspace/program/idea/ubmp/target/ForTest-classes/
        URL r4 = ClassLoader.getSystemResource("");
        //r5:  file:/C:/workspace/program/idea/ubmp/target/ForTest-classes/
        URL r5 = Thread.currentThread().getContextClassLoader().getResource("");

        //in a web environment
        //ServletActionContext.getServletContext().getRealPath("/");

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
    }


}
