
public class FactoryProducer{

    public AbstractFactory getFactory(String factorytype){

        if(factorytype == "shape"){
            return new ShapeFactory();
        }
        else{
            return new ColorFactory();
        }
    }
}