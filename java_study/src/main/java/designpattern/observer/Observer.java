package designpattern.observer;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/17 18:14
 **/
//定义观察者抽象类
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
