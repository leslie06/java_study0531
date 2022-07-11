package designpattern.singleton;

/**
 * @Description 饿汉式 线程安全
 * @Author leslie
 * @Date 2022/6/19 18:46
 **/
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }
}
