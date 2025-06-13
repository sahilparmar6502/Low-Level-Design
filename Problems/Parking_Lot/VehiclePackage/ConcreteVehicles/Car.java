package VehiclePackage.ConcreteVehicles;

import VehiclePackage.Vehicle;
import FareStrategyPackage.FareStrategy;

public class Car extends Vehicle{

    public Car(String vehicleType,String numberPlate,FareStrategy fareStrategy){
        super(vehicleType,numberPlate,fareStrategy);
    }
};