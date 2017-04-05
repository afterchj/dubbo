package com.tpadsz.service.impl;

import com.tpadsz.service.DubbodoSomething;

/**
 * Created by hongjian.chen on 2017/4/1.
 */
public class DubbodoSomething2Impl implements DubbodoSomething {
    public String doSomething() {
        System.out.println("V2版本");
        return "V2";
    }
}
