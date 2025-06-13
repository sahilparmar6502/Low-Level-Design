package ParkingSlotsPackage.ConcreteParkingSlot;

import VehiclePackage.Vehicle;
import ParkingSlotsPackage.ParkingSlot;

public class BikeParkingSlot extends ParkingSlot{

    public BikeParkingSlot(String slotNumber,String slotType){
        super(slotNumber,slotType);
    }

    public boolean canPark(Vehicle vehicle){
        return "bike".equalsIgnoreCase(vehicle.getVehicleType());
    }
};