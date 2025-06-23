import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _6IOBoundExample{

    public static void main(String args[]){

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            
            cachedPool.execute(() -> {
                simulateWebRequest();
                System.out.println(Thread.currentThread().getName() + " completed I/O task.");
            });
        }

        cachedPool.shutdown();
    }

    public static void simulateWebRequest(){

        try{
            System.out.println(Thread.currentThread().getName() + " is waiting for response...");
            TimeUnit.MILLISECONDS.sleep(500);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
};