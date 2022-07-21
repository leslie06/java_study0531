package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/21 12:05
 **/
public class MyCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}
