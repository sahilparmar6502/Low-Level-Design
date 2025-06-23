import java.util.concurrent.Semaphore;

public class _1BinarySemaphore{

    private static Semaphore mutex = new Semaphore(1);

    public static void main(String args[]){

        Thread thread1 = new Thread(() -> {accessCriticalSection("Thread1");});
        Thread thread2 = new Thread(() -> {accessCriticalSection("Thread2");});

        thread1.start();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public static void accessCriticalSection(String taskName){

        try{
            System.out.println(taskName +" is trying to access Critical Section.");
            mutex.acquire();
            System.out.println(taskName + " is in Critical Section.");
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            mutex.release();
            System.out.println(taskName + " has completed its work, and released Critical Section.");
        }
    }
};