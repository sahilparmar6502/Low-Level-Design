
public class Main{
    public static void main(String args[]){

        Circle c1 = new Circle(45,"red");
        Circle c2 = (Circle) c1.clone();

        Rectangle r1 = new Rectangle(4,5,"blue");
        Rectangle r2 = (Rectangle) r1.clone();

        System.out.println(c1);
        System.out.println(r1);
        System.out.println(c2);
        System.out.println(r2);
    }
}