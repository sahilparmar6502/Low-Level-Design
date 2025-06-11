public class ShapeFactory{
    
    public Shape getShape(String s){

        if(s == "rectangle"){
            return new Rectangle();
        }
        else if(s == "circle"){
            return new Circle();
        }
        else{
            return new Triangle();
        }
    }
}