
public class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shapetype){
        return null;
    }

    @Override
    public Color getColor(String colorname){

        if(colorname == "red"){
            return new Red();
        }
        else{
            return new Blue();
        }
    }
}