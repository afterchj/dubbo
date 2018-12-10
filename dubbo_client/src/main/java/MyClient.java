import com.alibaba.dubbo.common.json.JSON;
import com.tpadsz.after.api.RecordBillService;
import com.tpadsz.service.SayHelloToClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by hongjian.chen on 2017/3/31.
 */
public class MyClient {

    public void sayHello() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationConsumer.xml"});
        context.start();
        //获取服务器那边的bean
        SayHelloToClient demoService = (SayHelloToClient) context.getBean("demoService");
        System.out.println(demoService.sayHello("This is a test message!"));
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationConsumer.xml");
        RecordBillService billService = (RecordBillService) ctx.getBean("recordBillService");
        System.out.println("billService=" + billService);
        System.out.println("map1=" + JSON.json(billService.getByDeviceId("dev_121qwe")));
    }
}
