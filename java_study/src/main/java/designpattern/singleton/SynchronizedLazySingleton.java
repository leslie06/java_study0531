package designpattern.singleton;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 18:50
 **/
public class SynchronizedLazySingleton {
    private static SynchronizedLazySingleton instance;
    private SynchronizedLazySingleton(){}
    public static synchronized SynchronizedLazySingleton getInstance(){
        if(instance == null){}{
            instance = new SynchronizedLazySingleton();
        }
        return instance;
    }
}
