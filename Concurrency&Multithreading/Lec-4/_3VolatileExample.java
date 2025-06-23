
public class _3VolatileExample{

    private volatile boolean running = true;

    public void runTask(){

        System.out.println(Thread.currentThread().getName() + " is running");
        int count = 0;
        while(running){
            count += 1;
        }

        System.out.println("Count:" + count);
        System.out.println(Thread.currentThread().getName() + " is stopped");
    }

    public void stopTask(){
        running = false;
    }

    public static void main(String args[]){

        _3VolatileExample example = new _3VolatileExample();
        Thread thread = new Thread(new Runnable(){
            public void run(){
                example.runTask();
            }
        }, "WorkerThread");
        thread.start();

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){}

        example.stopTask();

        try{
            thread.join();
        }
        catch(InterruptedException e){}
    }
};