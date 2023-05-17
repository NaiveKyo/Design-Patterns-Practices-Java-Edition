package io.naivekyo.structural.Proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

    /**
     * 被代理的真实对象
     */
    private Object agent;

    private JDKDynamicProxy(Object agent) {
        this.agent = agent;
    }

    /**
     * 获取动态生成的代理类实例
     * @param obj 目标接口的实现类
     * @return proxy instance
     */
    public static Object getObject(Object obj) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return Proxy.newProxyInstance(cl, obj.getClass().getInterfaces(), new JDKDynamicProxy(obj));
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object methodResult = null;
        try {
            System.out.println("proxy: before...");
            methodResult = method.invoke(this.agent, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            System.out.println("proxy: after...");
        }
        return methodResult;
    }
    
}
