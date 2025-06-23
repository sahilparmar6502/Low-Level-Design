import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ReadWriteLogExample{

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int logValue = 0;

    public void read(String taskName){

        try{
            lock.readLock().lock();
            System.out.println(taskName + " acquired read-lock.");

            System.out.println("Log Value:" + this.logValue);
        }
        finally{
            lock.readLock().unlock();
            System.out.println(taskName + " released read-lock.");
        }
        System.out.println();
    }

    public void write(String taskName, int newValue){

        try{
            lock.writeLock().lock();
            System.out.println(taskName + " acquired write-lock.");

            this.logValue = newValue;

            System.out.println("New value has written." + this.logValue);
        }
        finally{
            lock.writeLock().unlock();
            System.out.println(taskName + " released write-lock.");
        }
        System.out.println();
    }
};

public class _2ReadWriteLock{
    public static void main(String args[]){


        ReadWriteLogExample example = new ReadWriteLogExample();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> { example.read("Reader1");});
        executor.submit(() -> { example.read("Reader2");});

        executor.submit(() -> { example.write("Writer1",100);});

        executor.submit(() -> { example.read("Reader3");});

        executor.shutdown();

        try{
            if(executor.awaitTermination(10,TimeUnit.SECONDS)){
                System.out.println("All tasks are finished.");
            }
            else{
                System.out.println("Timeout! All tasks are finished.");
            }
        }
        catch(InterruptedException e){}
    }
};