package designpattern.observer;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/17 18:35
 **/
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    //toHexString:返回整数参数的字符串表示形式，作为16位中的无符号整数。
    public void update() {
        System.out.println("Hexa String: " + Integer.toHexString( subject.getState() ));
    }
}
