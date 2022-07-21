package multithreading;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/21 12:03
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
