package designpattern.observer_test;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 16:46
 **/
public class ConcreteSubject extends Subject {
    private String state;
    public void change(String newState){
        state = newState;
        System.out.println("主题状态：" + state);
        super.notifyAllObservers(state);
    }
}
