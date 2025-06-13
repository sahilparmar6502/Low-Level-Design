package VehiclePackage.ConcreteVehicles;

import VehiclePackage.Vehicle;
import FareStrategyPackage.FareStrategy;

public class Other extends Vehicle{

    public Other(String vehicleType,String numberPlate,FareStrategy fareStrategy){
        super(vehicleType,numberPlate,fareStrategy);
    }
};