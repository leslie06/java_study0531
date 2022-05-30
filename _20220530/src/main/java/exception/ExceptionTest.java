package exception;

/**
 *  * @Description 自定义异常类的测试
 *  * 1.方法先抛出自定义异常，输出异常内容
 *  * 2.把方法用try catch围绕，输出e
 *  * @Author leslie
 * @Date
 **/
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            func();
        } catch (MyException e) {
            System.out.println(e);
        }
    }

    public static void func() throws MyException {
        throw new MyException("这是一个异常");
    }

}
