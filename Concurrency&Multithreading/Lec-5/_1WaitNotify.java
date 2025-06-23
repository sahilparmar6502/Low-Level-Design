
class WaitNotify{

    private boolean conditionMet = true;
    private Object lock = new Object();

    public void doWait(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            while(this.conditionMet){
                try{
                    lock.wait();
                }
                catch(InterruptedException e){}
            }
            System.out.println(Thread.currentThread().getName() + " resumed execution");
        }
    }

    public void doNotify(){
        synchronized (lock){
            conditionMet = false;
            System.out.println(Thread.currentThread().getName() + " called notify()");
            lock.notify();
        }
    }

    public void doNotifyAll(){
        synchronized (lock){
            conditionMet = false;
            System.out.println(Thread.currentThread().getName() + " called notifyAll()");
            lock.notifyAll();
        }
    }
};

public class _1WaitNotify{

    public static void main(String args[]){

        WaitNotify wn = new WaitNotify();

        Thread waiter1 = new Thread(() -> {wn.doWait();}, "waiter1");
        Thread waiter2 = new Thread(() -> {wn.doWait();}, "waiter2");
        Thread waiter3 = new Thread(() -> {wn.doWait();}, "waiter3");

        waiter1.start();
        waiter2.start();
        waiter3.start();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        Thread notifier = new Thread(() -> {wn.doNotifyAll();}, "notifier");
        notifier.start();

        try{
            waiter1.join();
            waiter2.join();
            waiter3.join();
            notifier.join();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
};