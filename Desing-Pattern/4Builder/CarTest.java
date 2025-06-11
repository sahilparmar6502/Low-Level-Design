
class Car{

    //required features
    private String engine;
    private String tire;
    private String color;

    //optional features
    private boolean hasAC;
    private boolean hasMusicSystem;
    private boolean autoDrive;

    // private constructor -> to enforce object creation only by Builder Class
    private Car(CarBuilder builder){
        this.engine = builder.engine;
        this.tire = builder.tire;
        this.color = builder.color;

        this.hasAC = builder.hasAC;
        this.hasMusicSystem = builder.hasMusicSystem;
        this.autoDrive = builder.autoDrive;
    }

    public static class CarBuilder{

        private String engine;
        private String tire;
        private String color;

        //optional features
        private boolean hasAC;
        private boolean hasMusicSystem;
        private boolean autoDrive;

        CarBuilder(String engine,String tire,String color){
            this.engine = engine;
            this.tire = tire;
            this.color = color;
        }

        public CarBuilder setHasAC(boolean has){
            this.hasAC = has;
            return this;
        }

        public CarBuilder setHasMusicSystem(boolean has){
            this.hasMusicSystem = has;
            return this;
        }

        public CarBuilder setAutoDrive(boolean has){
            this.autoDrive = has;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    public String toString(){
        return engine + " " + tire + " " + color + " " + hasAC + " " + hasMusicSystem + " " + autoDrive;
    }
}

public class CarTest{
    public static void main(String args[]){

        Car car1 = new Car.CarBuilder("engine 5x","JPG","Red").build();

        Car car2 = new Car.CarBuilder("engine 10x","JPG-1","Blue")
        .setHasAC(true)
        .setHasMusicSystem(true)
        .build();

        Car car3 = new Car.CarBuilder("engine 15x","JPGe-1","Black")
        .setHasAC(true)
        .setHasMusicSystem(true)
        .setAutoDrive(true)
        .build();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}