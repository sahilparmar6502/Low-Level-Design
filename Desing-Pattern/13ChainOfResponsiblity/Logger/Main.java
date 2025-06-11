
public class Main{

    public static void main(String args[]){

        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        infoLogger.log(0,"DB Connection");
        infoLogger.log(1,"Insert Query!");
        infoLogger.log(2,"Delete Query!");
    }
};