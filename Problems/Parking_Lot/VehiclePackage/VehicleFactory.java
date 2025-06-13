package VehiclePackage;

import VehiclePackage.Vehicle;
import VehiclePackage.ConcreteVehicles.*;
import FareStrategyPackage.FareStrategy;

public class VehicleFactory{

    public VehicleFactory(){}

    public static Vehicle createVehicle(String vehicleType,String numberPlate,FareStrategy fareStrategy){

        if(vehicleType.equalsIgnoreCase("bike")){
            return new Bike(vehicleType,numberPlate,fareStrategy);
        }
        else if(vehicleType.equalsIgnoreCase("car")){
            return new Car(vehicleType,numberPlate,fareStrategy);
        }
        return new Other(vehicleType,numberPlate,fareStrategy);
    }
};