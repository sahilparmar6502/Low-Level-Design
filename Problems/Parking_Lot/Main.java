import VehiclePackage.Vehicle;
import VehiclePackage.VehicleFactory;
import CommonEnum.DurationType;
import FareStrategyPackage.FareStrategy;
import FareStrategyPackage.ConcreteFareStrategy.*;
import ParkingLotController.ParkingLot;
import ParkingSlotsPackage.ConcreteParkingSlot.*;
import ParkingSlotsPackage.ParkingSlot;
import java.util.List;
import java.util.ArrayList;

public class Main{

    public static void main(String args[]){

        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(new BikeParkingSlot("A1","bike"));
        slots.add(new BikeParkingSlot("A2","bike"));
        slots.add(new CarParkingSlot("B1","car"));
        slots.add(new CarParkingSlot("B2","car"));

        ParkingLot parkingLot = new ParkingLot(slots);

        FareStrategy bikeFareStrategy = new BasicFareStrategy();
        FareStrategy carFareStrategy = new PremiumFareStrategy();

        Vehicle bike1 = VehicleFactory.createVehicle("bike","GJ012205",bikeFareStrategy);
        Vehicle bike2 = VehicleFactory.createVehicle("bike","GJ012215",bikeFareStrategy);

        Vehicle car1 = VehicleFactory.createVehicle("car","GJ012225",carFareStrategy);
        Vehicle car2 = VehicleFactory.createVehicle("car","GJ012235",carFareStrategy);
        Vehicle car3 = VehicleFactory.createVehicle("car","GJ012235",carFareStrategy);

        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car3);
    }
};