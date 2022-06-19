package designpattern.observer_test;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 16:52
 **/
public class SecondObserver implements Observer {
    public void update(String state) {
        System.out.println("二号观察者收到状态：" + state);
    }
}
