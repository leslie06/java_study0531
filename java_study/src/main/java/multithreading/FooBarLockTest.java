package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/21 11:29
 **/
public class FooBarLockTest {
    public static void main(String[] args) {
        FooBarLock fooBar = new FooBarLock(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()-> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
