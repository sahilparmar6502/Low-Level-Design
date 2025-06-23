import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TryLockExample{

    private final ReentrantLock lock = new ReentrantLock();

    public void longTask(String taskName){

        try{
            lock.lock();
            System.out.println(taskName + " acquired lock.");
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
            System.out.println(taskName + " released lock.");
        }
    };

    public void tryLongTask(String taskName){

        try{
            if(lock.tryLock(2, TimeUnit.SECONDS)){
                try{
                    lock.lock();
                    System.out.println(taskName + " acquired lock.");
                }
                finally{
                    lock.unlock();
                    System.out.println(taskName + " released lock.");
                }
            }
            else{
                System.out.println(taskName + " not able to acquire lock.");
            }
        }
        catch(InterruptedException  e){
            e.printStackTrace();
        }

        System.out.println(taskName + " is returning.");
    };
};

public class _3TryLock{

    public static void main(String args[]){

        TryLockExample example = new TryLockExample();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> { example.longTask("Thread1");});

        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        executor.submit(() -> { example.tryLongTask("Thread2");});

        executor.shutdown();
    }
};