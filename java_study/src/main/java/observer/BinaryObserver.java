package observer;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/17 18:26
 **/
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    //toBinaryString方法：在基数2中返回整数参数的字符串表示形式为无符号整数。
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
