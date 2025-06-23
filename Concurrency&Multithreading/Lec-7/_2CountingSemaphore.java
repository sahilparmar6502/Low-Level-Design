import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _2CountingSemaphore{

    private static Semaphore permits = new Semaphore(3);

    public static void main(String args[]){

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // for(int i=0;i<10;i++){
        //     executor.submit(() -> {
        //         accessResource(i);
        //     });
        // } 
        // Lambdas (and anonymous classes) in Java can only capture local variables that are final or effectively final.
        // clarity, safety, simplicity
        // prevents race condition

        for(int i=0;i<10;i++){
            final int id = i + 1;
            executor.submit(new Runnable(){
                public void run(){
                    accessResource(id);
                }
            });
        }

        executor.shutdown();

        try{
            if(executor.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("All tasks are finished.");
            }
        }
        catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " is interrupted.");
        }
    }

    public static void accessResource(int taskName){

        try{
            System.out.println("Thread" + taskName + " is trying access resource.");
            permits.acquire();
            System.out.println("Thread" + taskName + " is using resource.");
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Thread" + taskName + " is interrupted.");
        }
        finally{
            permits.release();
            System.out.println("Thread" + taskName + " released resource.");
        }
    }
};