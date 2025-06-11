
public class Rectangle implements Prototype{

    private int height;
    private int width;
    private String color;

    Rectangle(int h,int w,String c){
        this.height = h;
        this.width = w;
        this.color = c;
    }

    // Copy Constructor
    Rectangle(Rectangle rectangle){
        this.height = rectangle.height;
        this.width = rectangle.width;
        this.color = rectangle.color;
    }

    @Override
    public Prototype clone(){
        return new Rectangle(this);
    }

    @Override
    public String toString(){
        return height + " " + width + " " + color;
    }
}