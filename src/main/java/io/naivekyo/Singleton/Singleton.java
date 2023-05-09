package io.naivekyo.Singleton;

public final class Singleton {

    private Singleton() {
    }

    private static class LazyInitialization {
        private static Singleton instance = null;
        static {
            instance = new Singleton();
        }
    }
    
    public static Singleton getInstance() {
        return LazyInitialization.instance;
    }
    
}
