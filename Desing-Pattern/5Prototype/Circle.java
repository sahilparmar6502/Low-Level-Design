
public class Circle implements Prototype{
    private int radius;
    private String color;

    Circle(int r,String c){
        this.radius = r;
        this.color = c;
    }

    // copy constructor
    Circle(Circle circle){
        this.radius = circle.radius;
        this.color = circle.color;
    }

    @Override
    public Prototype clone(){
        return new Circle(this);
    }

    @Override
    public String toString(){
        return radius + " " + color;
    }
};