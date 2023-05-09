package io.naivekyo.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingletonTestClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                System.out.println(Singleton.getInstance());
            });
        }

        TimeUnit.SECONDS.sleep(3);
    }
}
