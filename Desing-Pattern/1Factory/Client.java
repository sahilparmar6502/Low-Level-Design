public class Client{
    public static void main(String args[]){

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("rectangle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("circle");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("triangle");
        shape3.draw();
    }
}