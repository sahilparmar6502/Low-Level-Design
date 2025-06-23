
class WorkerThread implements Runnable{

    @Override
    public void run(){

        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Checking for updates...");
                Thread.sleep(2000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Thread is interrupted, Shuting down gracefully.");
        }
    }
};

public class _3ThreadInterruption{

    public static void main(String args[]) throws InterruptedException{

        Thread thread = new Thread(new WorkerThread());
        thread.start();
        // try{}
        // catch(){}
        Thread.sleep(5000);
        thread.interrupt();
    }
};