package com.hzy.modules.oxm.castor;

import com.hzy.modules.oxm.entity.Foo;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.junit.Test;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/29 15:59
 * @Description version 1.0
 */
public class CastorColorTest {


    @Test
    public void test() throws IOException, MappingException, MarshalException, ValidationException {
        String mappingPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\oxmMapping\\color.xml";
        Mapping mapping = new Mapping();
        mapping.loadMapping(mappingPath);


        String xmlPath = "D:\\workspace\\idea\\freedom-spring\\src\\main\\resources\\xml\\Foo.xml";
        Reader reader = new FileReader(xmlPath);
        Unmarshaller unmarshaller = new Unmarshaller(Foo.class);
        unmarshaller.setMapping(mapping);
        Foo foo = (Foo) unmarshaller.unmarshal(reader);

        System.err.println(foo.toString());

        PrintWriter printWriter = new PrintWriter(System.out);
        Marshaller marshaller = new Marshaller(printWriter);
        marshaller.setMapping(mapping);
        marshaller.marshal(foo);
        printWriter.close();
    }


}
