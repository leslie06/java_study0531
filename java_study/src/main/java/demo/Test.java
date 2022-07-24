package demo;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/24 16:38
 **/
public class Test {

    public static void main(String[] args) {
        Line lin = new Line();
        Student stu = new Student();
        lin.setEmplymentClass("科目是：数学");
        lin.setMoney(20);
        stu.setName("张三");
        stu.setScore(88.0);
        stu.setLin(lin);
        stu.exam();
        stu.studyLine();
    }
}
