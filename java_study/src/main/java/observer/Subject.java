package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/17 18:13
 **/
//定义目标类
public class Subject {
    //创建集合，存储所有观察者们
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    //atach方法添加所有观察者
    public void attach(Observer observer){
        observers.add(observer);
    }
    //通知方法调用观察者update方法
    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
