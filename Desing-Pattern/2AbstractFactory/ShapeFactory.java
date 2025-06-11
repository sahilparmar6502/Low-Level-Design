
public class ShapeFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shapetype){
        if(shapetype == "circle"){
            return new Circle();
        }
        else{
            return new Rectangle();
        }
    }

    @Override
    public Color getColor(String colorname){
        return null;
    }

}