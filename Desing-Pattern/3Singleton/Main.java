import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Logger{
    private static Logger instance; // private static instance
    public List<String> logs;

    private Logger(){ // private constructor
        logs = new ArrayList<>();
    }

    public static Logger getInstance(){ // public static method getInstance()
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message){
        logs.add(message);
    }

    public void printLogs(){
        System.out.println("Log:"+logs);
    }
}

public class Main{
    public static void main(String args[]){

        Logger logger1 = Logger.getInstance();
        logger1.log("DB connected");
        logger1.printLogs();

        Logger logger2 = Logger.getInstance();
        logger2.log("Insert query");

        
        System.out.println("Printting Log using logger2 object");
        logger2.printLogs();

        System.out.println("Printting Log using logger1 object");
        logger1.printLogs();

    }
}