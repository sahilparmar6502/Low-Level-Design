package ParkingSlotsPackage.ConcreteParkingSlot;

import VehiclePackage.Vehicle;
import ParkingSlotsPackage.ParkingSlot;

public class CarParkingSlot extends ParkingSlot{

    public CarParkingSlot(String slotNumber,String slotType){
        super(slotNumber,slotType);
    }

    public boolean canPark(Vehicle vehicle){
        return "car".equalsIgnoreCase(vehicle.getVehicleType());
    }
};