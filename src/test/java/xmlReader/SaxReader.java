package xmlReader;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/11 21:37
 * @Description version 1.0
 * SAX的全称是Simple APIs for XML，也即XML简单应用程序接口。与DOM不同，SAX提供的访问模式是一种顺序模式，这是一种快速读写XML数据的方式。
 * 当使用SAX分析器对XML文档进行分析时，会触发一系列事件，并激活相应的事件处理函数，应用程序通过这些事件处理函数实现对XML文档的访问，
 * 因而SAX接口也被称作事件驱动接口。
 */
public class SaxReader {


    @Test
    public void saxParse() throws ParserConfigurationException, SAXException, IOException {
        String file = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\bookStore.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        SAXParserHandler handler = new SAXParserHandler();
        saxParser.parse(file, handler);

        System.out.println(".................... 解析结果 ....................");
        handler.getBookList().forEach(x->{
            System.out.println(x.toString());
        });
    }


    public class SAXParserHandler extends DefaultHandler{
        String value = null;
        Book book = null;
        private List<Book> bookList = new ArrayList<Book>();
        int bookIndex = 0;

        public List<Book> getBookList(){
            return bookList;
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("SAX解析开始");
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("SAX解析結束");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //调用DefaultHandler类的startElement方法
            super.startElement(uri, localName, qName, attributes);
            if (qName.equals("book")){
                bookIndex ++;
                book = new Book();
                System.out.println("======================开始遍历某一本书的内容=================");
                int num = attributes.getLength();
                for (int i = 0;i<num; i++){
                    System.out.println("book    i:"+i +"    qName:"+ attributes.getQName(i) + "     value:" + attributes.getValue(i));
                    if (attributes.getQName(i).equals("id")) {
                        book.setId(attributes.getValue(i));
                    }
                }
            }
            else {
                System.out.println("    qName:" + qName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if (qName.equals("book")){
                bookList.add(book);
                book = null;
                System.out.println("======================結束遍历某一本书的内容=================");
            }
            else if (qName.equals("name")){
                book.setName(value);
            }
            else if (qName.equals("author")){
                book.setAuthor(value);
            }
            else if (qName.equals("year")){
                book.setYear(value);
            }
            else if (qName.equals("price")){
                book.setPrice(value);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            value = new String(ch, start, length);
            System.out.println("characters    value:" + value);
        }
    }

}
