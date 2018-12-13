package com.example.demo;

import com.tpadsz.service.SayHelloToClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.demo.service.MsgSendService;

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

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationConsumer.xml");
//        RecordBillService billService = (RecordBillService) ctx.getBean("recordBillService");
//        System.out.println("billService=" + billService);
//        System.out.println("map1=" + JSON.json(billService.getByDeviceId("dev_121qwe")));

        MsgSendService sendService = (MsgSendService) ctx.getBean("sendService");
        System.out.println("sendService="+sendService);
//        String code = sendService.updateCheckOut("9", "18170756879");
//        System.out.println("code=" + code);
        String value = sendService.checkValidation("12312", "18170756879");
        System.out.println("value=" + value);

    }
}
