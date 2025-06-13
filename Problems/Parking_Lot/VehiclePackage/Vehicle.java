package VehiclePackage;

import CommonEnum.DurationType;
import FareStrategyPackage.FareStrategy;
import FareStrategyPackage.ConcreteFareStrategy.*;

public abstract class Vehicle{

    private String vehicleType;
    private String numberPlate;
    private FareStrategy fareStrategy;

    public Vehicle(String vehicleType,String numberPlate,FareStrategy fareStrategy){
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.fareStrategy = fareStrategy;
    }

    public String getVehicleType(){
        return this.vehicleType;
    }

    public String getNumberPlate(){
        return this.numberPlate;
    }

    public double calculateFare(int duration,DurationType durationType){
        return this.fareStrategy.calculateFare(this.vehicleType,duration,durationType); 
    }
};