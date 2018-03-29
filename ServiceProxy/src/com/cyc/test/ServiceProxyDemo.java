package com.cyc.test;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author cyc11845
 */
public class ServiceProxyDemo {
    public static void  main(String args[]){
//        HumenImpl humen = new HumenImpl();
//        humen.eat("apple");
//
//
//        HumenProxy proxy = new HumenProxy();
//        proxy.eat("rice");
//
//        //jdk proxy---1
//        Humen humen = new HumenImpl();
//        DynamicProxy dynamicProxy = new DynamicProxy(humen);
//        Humen humemProxy = (Humen) Proxy.newProxyInstance(humen.getClass().getClassLoader(),
//                humen.getClass().getInterfaces(),dynamicProxy);
//        humemProxy.eat("apple");
//
//        //jdk proxy---2
//        DynamicProxy dynamicProxy = new DynamicProxy(new HumenImpl());
//        Humen humenProxy = dynamicProxy.getProxy();
//        humenProxy.eat("orange");

        //CGLib Proxy
        Humen humemProxy = CGLibProxy.getInstance().getProxy(HumenImpl.class);
        humemProxy.eat("watermelon");

    }
}

