package VehiclePackage.ConcreteVehicles;

import VehiclePackage.Vehicle;
import FareStrategyPackage.FareStrategy;

public class Bike extends Vehicle{

    public Bike(String vehicleType,String numberPlate,FareStrategy fareStrategy){
        super(vehicleType,numberPlate,fareStrategy);
    }
};