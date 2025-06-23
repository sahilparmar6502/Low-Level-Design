import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter{

    private ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment(){

        try{
            lock.lock();
            System.out.println("Lock is acquired by " + Thread.currentThread().getName());
            this.count += 1;
        }
        finally{
            lock.unlock();
            System.out.println("Lock is released by " + Thread.currentThread().getName());
        }
    }

    public int getCount(){
        return this.count;
    }
};

public class _1ReentrantLock{

    public static void main(String args[]){

        Counter counter = new Counter();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=0;i<5;i++){
            executor.submit(() -> {
                counter.increment();
            });
        }

        executor.shutdown();

        try{
            if(executor.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("Final Count:" + counter.getCount());
            }
            else{
                System.out.println("Timeout! Not All tasks finished.");
            }
        }
        catch(InterruptedException e){
            System.out.println("Interupted while waiting for all the tasks to finish.");
            Thread.currentThread().interrupt();
        }
    }
};