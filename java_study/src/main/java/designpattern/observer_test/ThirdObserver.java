package designpattern.observer_test;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 16:53
 **/
public class ThirdObserver implements Observer {
    public void update(String state) {
        System.out.println("三号观察者收到状态：" + state);
    }
}
