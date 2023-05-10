package io.naivekyo.creational.Singleton;

public class Singleton {

    private Singleton() {
    }

    private static class LazyInitialization {
        private static Singleton singleton;
        static {
            singleton = new Singleton();
        }
    }
    
    public static Singleton getInstance() {
        return LazyInitialization.singleton;
    }
    
}
