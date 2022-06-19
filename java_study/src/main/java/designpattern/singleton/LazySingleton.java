package designpattern.singleton;

/**
 * @Description 懒汉式，线程不安全
 * @Author leslie
 * @Date 2022/6/19 18:40
 **/
public class LazySingleton {
    private static LazySingleton instance;
    //让构造函数为 private，这样该类就不会被实例化
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
