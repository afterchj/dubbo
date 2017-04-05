import com.tpadsz.service.DubbodoSomething;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

/**
 * Created by hongjian.chen on 2017/4/1.
 */
public class DubboStart {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationConsumer.xml");
        //访问 v1 版本
        DubbodoSomething serviceVersion1=(DubbodoSomething) ctx.getBean("serviceVersion1");
        System.out.println(serviceVersion1.doSomething());
        //访问 v2 版本
        DubbodoSomething serviceVersion2=(DubbodoSomething) ctx.getBean("serviceVersion2");
        System.out.println(serviceVersion2.doSomething());
        //访问随机版本
        DubbodoSomething serviceVersion3=(DubbodoSomething) ctx.getBean("serviceVersion3");
        System.out.println(serviceVersion3.doSomething());

    }
}
