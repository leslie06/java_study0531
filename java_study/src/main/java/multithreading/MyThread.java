package multithreading;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/21 11:58
 **/
public class MyThread extends Thread {
    public void run(){
        System.out.println("123");
    }

    public static void main(String[] args){
        MyThread t = new MyThread();
        t.start();
    }
}
