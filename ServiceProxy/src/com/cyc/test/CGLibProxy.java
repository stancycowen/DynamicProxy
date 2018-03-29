package com.cyc.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cyc
 */
public class CGLibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }

    private static CGLibProxy instance =  new CGLibProxy();

    private CGLibProxy(){};

    public static CGLibProxy getInstance() {
        return instance;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        eatBefore();
        Object result = methodProxy.invokeSuper(o,objects);
        eatAfter();
        return result;
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
