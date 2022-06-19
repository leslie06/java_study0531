package designpattern.observer_test;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 16:54
 **/
public class ObserverClient {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver concreteObserver = new ConcreteObserver();
        SecondObserver secondObserver = new SecondObserver();
        ThirdObserver thirdObserver = new ThirdObserver();
        subject.attach(concreteObserver);
        subject.attach(secondObserver);
        subject.attach(thirdObserver);

        //发布主题
        subject.change("恭喜毕业！");


    }
}
