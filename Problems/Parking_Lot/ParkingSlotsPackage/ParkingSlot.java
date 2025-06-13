package ParkingSlotsPackage;

import VehiclePackage.Vehicle;

public abstract class ParkingSlot{

    private String slotNumber;
    private String slotType;
    private Vehicle vehicle;
    private boolean occupied;

    public ParkingSlot(String slotNumber,String slotType){
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.occupied = false;
        this.vehicle = null;
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    public abstract boolean canPark(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle){

        if(this.occupied){
            System.out.println("Invalid Operation! Slot is not vacant.");
            return;
        }

        if(!canPark(vehicle)){
            System.out.println("Invalid Operation! SlotType:"+this.slotType + " Vehicle Type:"+vehicle.getVehicleType());
            return;
        }

        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void vacate(){
        if(!this.occupied){
            System.out.println("Invalid Operation. Slot is already free");
        }
        this.vehicle = null;
        this.occupied = false;
    }

    public String getSlotNumber(){
        return this.slotNumber;
    }

    public String getSlotType(){
        return this.slotType;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }
};