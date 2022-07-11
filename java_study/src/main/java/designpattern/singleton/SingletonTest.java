package designpattern.singleton;

/**
 * @Description 懒汉式单例模式测试
 * @Author leslie
 * @Date 2022/6/23 12:19
 **/
public class SingletonTest {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance == instance2);

    }
}
