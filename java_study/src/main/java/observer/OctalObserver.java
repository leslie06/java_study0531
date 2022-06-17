package observer;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/17 18:32
 **/
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    //toOctalString：在基数8中返回整数参数的字符串表示形式为无符号整数。
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString( subject.getState() ));
    }
}
