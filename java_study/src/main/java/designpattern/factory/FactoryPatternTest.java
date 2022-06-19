package designpattern.factory;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/19 18:29
 **/
public class FactoryPatternTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

    }
}
