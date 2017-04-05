import com.tpadsz.service.SayHelloToClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
