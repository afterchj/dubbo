package com.tpadsz.service.impl;

import com.tpadsz.service.SayHelloToClient;

/**
 * Created by hongjian.chen on 2017/3/31.
 */
public class SayHelloToClientImpl implements SayHelloToClient {
    public String sayHello(String hello) {
        System.out.println("result：" + hello);
        return hello + "\nTest is ok!";
    }
}
