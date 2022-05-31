package exception;

import java.io.IOException;

/**
 * @Description 自定义异常，编写无参和有参的构造方法
 * @Author leslie
 * @Date
 **/
public class MyException extends IOException {

    public MyException(){}

    public MyException(String s){
        super(s);
    }
}
