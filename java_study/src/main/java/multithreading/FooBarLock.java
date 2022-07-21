package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 * @Author leslie
 * @Date 2022/7/20 12:14
 **/
public class FooBarLock {
    private int n;

    public FooBarLock(int n) {
        this.n = n;
    }
    private boolean flag = true;
    private Lock lock = new ReentrantLock();
    private Condition foobarCon = lock.newCondition();

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(!flag){
                    foobarCon.await();
                }
                System.out.println("foo");
                flag = false;
                foobarCon.signal();
            }finally {
                lock.unlock();
            }

        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while (flag){
                    foobarCon.await();
                }
                System.out.println("bar");
                flag = true;
                foobarCon.signal();
            }finally {
                lock.unlock();
            }

        }
    }
}
