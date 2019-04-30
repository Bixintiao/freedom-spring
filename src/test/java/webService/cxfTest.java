package webService;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;



public class cxfTest {

    @Test
    public void greetingTest() throws Exception {
        String wsdlUrl = "http://localhost:9099/services/GreetingService?wsdl";
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = jaxWsDynamicClientFactory.createClient(wsdlUrl);
        Object[] result = client.invoke("greeting", "good");
        System.out.println("\n 返回数据:" + result[0]);
    }


    @Test
    public void helloServiceTest() throws Exception {
        String wsdlUrl = "http://localhost:9099/services/HelloService?wsdl";
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = jaxWsDynamicClientFactory.createClient(wsdlUrl);
        Object[] result = client.invoke("sayHello", "say good !");
        System.out.println("\n 返回数据:" + result[0]);
    }



    @Test
    public void minmetalsHelloTest() throws Exception {
        String wsdlUrl = "http://localhost:8088/services/TestService?wsdl";
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdlUrl);
        Object[] objects = client.invoke("ZfwlyReceiveData", "say good bye !");
        System.out.println("\n 返回数据:" + objects[0]);
    }





}
