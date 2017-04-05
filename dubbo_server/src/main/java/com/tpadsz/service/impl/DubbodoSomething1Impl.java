package com.tpadsz.service.impl;

import com.tpadsz.service.DubbodoSomething;

/**
 * Created by hongjian.chen on 2017/4/1.
 */
public class DubbodoSomething1Impl implements DubbodoSomething {
    public String doSomething() {
        System.out.println("V1版本");
        return "V1";
    }
}
