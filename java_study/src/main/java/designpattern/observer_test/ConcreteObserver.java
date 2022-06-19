package designpattern.observer_test;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 16:51
 **/
public class ConcreteObserver implements Observer {
    public void update(String state) {
        System.out.println("一号观察者收到状态：" + state);
    }
}
