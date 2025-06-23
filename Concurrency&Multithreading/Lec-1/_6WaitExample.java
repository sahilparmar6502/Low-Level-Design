
class SharedResource{

    synchronized void waitExample(){
        System.out.println(Thread.currentThread().getName() + " is wating");
        try{
            wait();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " resumed after notify()");
    }
    
    synchronized void notifyExample(){
        System.out.println("Notifing a waiting Thread");
        notify();
    }
};

public class _6WaitExample{

    public static void main(String args[]){

        SharedResource shared = new SharedResource();

        Thread t1 = new Thread(() -> shared.waitExample(),"Thread1");

        Thread t2 = new Thread(() -> {
            try{
                Thread.sleep(2000);
                shared.notifyExample();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        },"Thread2");

        t1.start();
        t2.start();
    }
};

/**
 * Thread t1 = new Thread(() -> shard.waitExample(),"Thread1");
 * lambda expression
 * shorthand for creating an implementation for a functional interface
 * 
 * ||
 * 
 * Thread t1 = new Thread(() -> new Runnable(){
 *  @Override
 *  public void run(){
 *      shared.waitExample();
 *  }
 * }, "Thread1");
 * Create a new thread named "Thread-1", and when that thread runs,
 *  it will execute the method shared.waitExample().
 */