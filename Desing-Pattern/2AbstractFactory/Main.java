
public class Main{
    public static void main(String args[]){

        FactoryProducer factoryproducer = new FactoryProducer();

        AbstractFactory shapeFactory = factoryproducer.getFactory("shape");

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();

        AbstractFactory colorFactory = factoryproducer.getFactory("color");

        Color redColor = colorFactory.getColor("red");
        redColor.fill();

        Color blueColor = colorFactory.getColor("blue");
        blueColor.fill();
    }
}