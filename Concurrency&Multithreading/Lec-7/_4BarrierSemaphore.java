import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

class SemaphoreBarrier{

    private int parties;
    private int count;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore barrier = new Semaphore(0);

    SemaphoreBarrier(int parties){
        this.parties = parties;
        this.count = parties;
    }

    public void await() throws InterruptedException{

        mutex.acquire();
        count -= 1;

        if(count == 0){
            mutex.release();
            count = parties;
            barrier.release(parties - 1);
        }
        else{ 
            mutex.release();
            barrier.acquire();
        }
    }
};


public class _4BarrierSemaphore{
    public static void main(String args[]){

        final int num_of_threads = 3;
        final SemaphoreBarrier barrier = new SemaphoreBarrier(num_of_threads);

        ExecutorService executor = Executors.newFixedThreadPool(num_of_threads, new ThreadFactory(){
            private int counter = 1;
            @Override
            public Thread newThread(Runnable r){
                Thread t = new Thread(r, "Worker-"+counter);
                counter += 1;
                return t;
            }
        });

        for(int i=0;i<num_of_threads;i++){

            executor.submit(() -> {

                try{
                // Phase-1
                    System.out.println(Thread.currentThread().getName() + " starts Phase-1");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " completed Phase-1");

                    barrier.await();

                    // Phase-2
                    System.out.println(Thread.currentThread().getName() + " starts Phase-2");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " completed Phase-2");

                    barrier.await();

                    System.out.println(Thread.currentThread().getName() + " starts Phase-3");
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                }
            });
        }

        executor.shutdown();

        try{
            if(!executor.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("All tasks are completed yet.");
                executor.shutdownNow();
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
            executor.shutdownNow();
        }
        System.out.println("All tasks are completed.");
    }
}