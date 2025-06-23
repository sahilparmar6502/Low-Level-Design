
class SafeLock{

    private final Object lock = new Object();

    void waitForSignal(){
        synchronized (lock){
            try{
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                lock.wait(3000);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    };
};

public class _4ThreadLeak{

    public static void main(String args[]){

        SafeLock safeLock = new SafeLock();
        new Thread(safeLock::waitForSignal, "Thread1").start();
        //new Thread(() -> safeLock.waitForSignal(), "Thread1").start();
    }
};


/*
new Thread(safeLock::waitForSignal, "Thread1").start();

||

new Thread(() -> safeLock.waitForSignal(), "Thread1").start();
*/