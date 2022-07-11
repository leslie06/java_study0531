package designpattern.singleton;

/**
 * @Description 懒汉式
 * @Author leslie
 * @Date 2022/7/11 17:46
 **/
public class SingleTon {
    private static SingleTon instance = new SingleTon();
    public static SingleTon getInstance(){
        return instance;
    }
}
