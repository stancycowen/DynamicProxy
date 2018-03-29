package com.cyc.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object taget;

    public DynamicProxy(Object taget){
        this.taget = taget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        eatBefore();
        Object result = method.invoke(taget, args);
        eatAfter();
        return result;
    }

    /**
     * get proxy
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(taget.getClass().getClassLoader(),
                taget.getClass().getInterfaces(), this);
    }

    /**
     * eat before
     */
    private void eatBefore(){
        System.out.println("cook");
    }

    /**
     * eat after
     */
    private void eatAfter(){
        System.out.println("swap");
    }
}
