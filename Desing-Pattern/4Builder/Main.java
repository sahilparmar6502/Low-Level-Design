
class Computer{

    //required fields
    private String RAM;
    private String CPU;

    //optional fields
    private Boolean hasGraphicsCard;
    private Boolean hasWifi;

    // private constructor -> to enforce object creation through builder only
    private Computer(ComputerBuilder builder){
        this.RAM = builder.RAM;
        this.CPU = builder.CPU;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasWifi = builder.hasWifi;
    }

    // inner builder class
    public static class ComputerBuilder{

        // Required
        private String RAM;
        private String CPU;

        // Optional
        private boolean hasGraphicsCard;
        private boolean hasWifi;

        ComputerBuilder(String RAM,String CPU){
            this.RAM = RAM;
            this.CPU = CPU;
        }

        public ComputerBuilder setHasGraphicasCard(boolean has){
            this.hasGraphicsCard = has;
            return this;
        }

        public ComputerBuilder setHasWifi(boolean has){
            this.hasWifi = has;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    };

    @Override
    public String toString(){
        return "CPU:"+CPU+" RAM:"+RAM + " HasGraphicsCard? " + hasGraphicsCard + " HasWifi? " + hasWifi;
    }
};

public class Main{
    public static void main(String args[]){

        Computer gamingPC = new Computer.ComputerBuilder("16 GB","intel 7")
        .setHasGraphicasCard(true)
        .setHasWifi(true)
        .build();

        System.out.println(gamingPC);

        Computer basic = new Computer.ComputerBuilder("4 GB","intel 4").build();

        System.out.println(basic);
    }
}