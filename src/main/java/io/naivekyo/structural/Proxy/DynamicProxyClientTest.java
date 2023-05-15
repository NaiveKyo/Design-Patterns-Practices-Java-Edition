package io.naivekyo.structural.Proxy;

import io.naivekyo.structural.Proxy.agent.Service;
import io.naivekyo.structural.Proxy.agent.ServiceImpl;
import io.naivekyo.structural.Proxy.proxy.JDKDynamicProxy;

public class DynamicProxyClientTest {
    public static void main(String[] args) {
        Service s = new ServiceImpl();
        Service proxy = (Service) JDKDynamicProxy.getObject(s);
        proxy.doSomething1();
        proxy.doSomething2();
    }
}
