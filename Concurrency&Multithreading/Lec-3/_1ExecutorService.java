import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class _1ExecutorService{

    public static void main(String args[]){

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            System.out.println("Running task by " + Thread.currentThread().getName());
        });

        // executor.shutdown(); not allowed
        
        for(int i=0;i<10;i++){
            executor.submit(() -> {
                System.out.println("Running " + Thread.currentThread().getName());
            });
        }

        System.out.println("Active Threads:" + executor.getActiveCount());
        System.out.println("Queue Size:" + executor.getQueue().size());

        executor.shutdown();
    }
};