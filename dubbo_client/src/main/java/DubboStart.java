import com.alibaba.dubbo.common.json.JSON;
import com.tpadsz.after.api.RecordBillService;
import com.tpadsz.after.entity.LightBinding;
import com.tpadsz.after.entity.LightCharge;
import com.tpadsz.after.entity.LightOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Created by hongjian.chen on 2017/4/1.
 */
public class DubboStart {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConsumer.xml");
        RecordBillService billService = (RecordBillService) ctx.getBean("recordBillService");
        System.out.println("billService=" + billService);
        Map map = billService.getSumCharge("0016428081ec495b97edf124cb29d810");
        System.out.println(JSON.json(map) + "\t" + map.get("total_bill"));

        LightOperation operation = billService.getByLightUid("5bc9f45ab42e453f93ee8a966b5a9726");
        System.out.println(JSON.json(operation));

//        LightBinding binding = billService.getByDeviceId("3E94EE45B6164231A762BB8A6E531E0D");
//        System.out.println(binding);
        //访问 v1 版本
//        DubbodoSomething serviceVersion1=(DubbodoSomething) ctx.getBean("serviceVersion1");
//        System.out.println(serviceVersion1.doSomething());
//        //访问 v2 版本
//        DubbodoSomething serviceVersion2=(DubbodoSomething) ctx.getBean("serviceVersion2");
//        System.out.println(serviceVersion2.doSomething());
//        //访问随机版本
//        DubbodoSomething serviceVersion3=(DubbodoSomething) ctx.getBean("serviceVersion3");
//        System.out.println(serviceVersion3.doSomething());

    }
}
