import java.util.concurrent.*;

class WorkerThread implements Runnable{

    private final int taskId;

    public WorkerThread(int taskId){
        this.taskId = taskId;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running task" + taskId);
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " completed task" + taskId);
    }
};

public class _1ThreadPool {

    public static void main(String args[]){

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=0;i<5;i++){
            executor.submit(new WorkerThread(i));
        }

        executor.shutdown();
    }
};