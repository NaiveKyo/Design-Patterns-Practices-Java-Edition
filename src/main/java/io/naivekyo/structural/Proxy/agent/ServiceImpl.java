package io.naivekyo.structural.Proxy.agent;

public class ServiceImpl implements Service{
    @Override
    public void doSomething1() {
        System.out.println("agent: do something1.");
    }

    @Override
    public void doSomething2() {
        System.out.println("agent: do something 2.");
    }
}
