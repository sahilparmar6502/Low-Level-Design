import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;  

public class _5CPUIntensiveExample{

    private static final int num_cores = Runtime.getRuntime().availableProcessors();
    // This line is declaring and initializing a constant that holds 
    // the number of CPU cores available to the Java Virtual Machine (JVM)

    public static void main(String args[]){

        ExecutorService fixedPool = Executors.newFixedThreadPool(num_cores);

        for(int i=0;i<10;i++){
            int res = performComputation();
            System.out.println(Thread.currentThread().getName() + " computer res:" + res);
        }

        fixedPool.shutdown();
    }

    public static int performComputation(){
        int sum = 0;
        for(int i=0;i<1_000_000;i++){
            sum += Math.sqrt(i);
        }
        return sum;
    }
};

/**
 * Runtime is class -> java.lang
 * getRuntime() is a static method that returns the singleton instance of the Runtime class
 * availableProcessors() -> returns the number of processors/cores that the JVM can use (as reported by the OS)
 */