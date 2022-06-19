package designpattern.factory;

/**
 * @Description 创建一个工厂类用于创建对象
 * @Author leslie
 * @Date 2022/6/19 18:22
 **/
public class ShapeFactory {
    //getShape方法根据类型创建对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }else if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        return null;
    }
}
