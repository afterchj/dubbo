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

        LightBinding binding = billService.getByDeviceId("DBD370724B054036B5EF2DAB23128225");
        System.out.println(binding);

        LightOperation operation = billService.getByLightUid(binding.getLightUid());
        System.out.println(JSON.json(operation));

        LightCharge charge = new LightCharge();
        charge.setUid(binding.getBossUid());
        billService.insetBill(binding, operation, charge);
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
