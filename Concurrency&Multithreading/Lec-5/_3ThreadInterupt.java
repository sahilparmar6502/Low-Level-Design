
public class _3ThreadInterupt{

    public static void main(String args[]){

        Thread thread = new Thread(() -> {
            try{
                System.out.println("Thread is going to sleep.");
                Thread.sleep(5000);
                System.out.println("Thread woke up.");
            }
            catch(InterruptedException e){
                // e.printStackTrace();
                // System.out.println(e.getMessage());|
                Thread.currentThread().interrupt();
            }
        });

        thread.start();

        try{
            Thread.sleep(1000);
            thread.interrupt();
        }
        catch(InterruptedException e){

        }
    }
};

/**
 * Thread.currentThread().interrupt();
 * used to interrupt the currently running thread
 * The thread should stop what it’s doing
 * Or at least check for interruption and gracefully exit
 */