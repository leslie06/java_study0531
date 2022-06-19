package designpattern.observer_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 16:39
 **/
public abstract class Subject {
    List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }
    public void notifyAllObservers(String state){
        for(Observer observer : observers){
            observer.update(state);
        }
    }

}
