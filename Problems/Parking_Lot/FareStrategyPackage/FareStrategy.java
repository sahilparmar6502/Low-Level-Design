package FareStrategyPackage;

import CommonEnum.DurationType;

public interface FareStrategy{
    double calculateFare(String vehicleType,int duration,DurationType durationType);
};