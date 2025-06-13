package ParkingLotController;

import java.util.List;
import java.util.ArrayList;
import ParkingSlotsPackage.ParkingSlot;
import VehiclePackage.Vehicle;


// singleton pattern

public class ParkingLot{

    private static ParkingLot instance;
    private List<ParkingSlot> parkingSlots;

    private ParkingLot(List<ParkingSlot> parkingSlots){
        this.parkingSlots = new ArrayList<>();
        this.parkingSlots = parkingSlots;
    }

    public static ParkingLot getInstance(List<ParkingSlot> parkingSlots){
        if(instance == null){
            instance = new ParkingLot(parkingSlots);
        }
        return instance;
    }

    public ParkingSlot findVacantSlot(String vehicleType){
        for(ParkingSlot slot : this.parkingSlots){
            if(!slot.isOccupied() && slot.getSlotType() == vehicleType){
                return slot;
            }
        }

        return null;
    }

    public ParkingSlot parkVehicle(Vehicle vehicle){

        ParkingSlot slot = findVacantSlot(vehicle.getVehicleType());

        if(slot != null){
            slot.parkVehicle(vehicle);
            System.out.println("Vehicle is successfully parked in Slot:"+slot.getSlotNumber());
            return slot;
        }

        System.out.println("No slot is available for this type:"+vehicle.getVehicleType());
        return null;
    }

    public boolean vacantSpot(ParkingSlot slot){
        Vehicle vehicle = slot.getVehicle();

        if(slot == null || !slot.isOccupied()){
            System.out.println("Slot is already vacant.");
            return false;
        }

        slot.vacate();
        System.out.println("Slot:"+slot.getSlotNumber() + " is freed by "+vehicle.getNumberPlate());
        return true;
    }

    public List<ParkingSlot> getVehicleByNumber(){
        return this.parkingSlots;
    }
};