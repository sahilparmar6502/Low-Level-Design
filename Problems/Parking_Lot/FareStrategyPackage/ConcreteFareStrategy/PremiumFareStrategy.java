package FareStrategyPackage.ConcreteFareStrategy;

import CommonEnum.DurationType;
import FareStrategyPackage.FareStrategy;

public class PremiumFareStrategy implements FareStrategy{

    public double calculateFare(String vehicleType,int duration,DurationType durationType){

        switch(vehicleType.toLowerCase()){
            case "bike":
                return durationType == DurationType.HOURS ? duration * 6.0 : duration * 6.0 * 24;
            case "car":
                return durationType == DurationType.HOURS ? duration * 10.0 : duration * 10.0 * 24;
            case "auto":
                return durationType == DurationType.HOURS ? duration * 8.0 : duration * 8.0 * 24;
            default:
                return durationType == DurationType.HOURS ? duration * 12.0 : duration * 12.0 * 24;
        }
    }
};