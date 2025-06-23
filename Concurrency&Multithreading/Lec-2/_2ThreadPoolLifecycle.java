import java.util.concurrent.*;

class Task implements Runnable{

    private final int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName() + " is Starting Task" + taskId);
        try{
            Thread.sleep(2000); // Timed_Waiting

            synchronized (this){
                System.out.println(Thread.currentThread().getName() + " is waiting on Task" + this.taskId);
                this.wait(1000);
            }

            System.out.println(Thread.currentThread().getName() + " completed task" + this.taskId);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
};

public class _2ThreadPoolLifecycle{

    public static void main(String args[]){

        ExecutorService executor = Executors.newFixedThreadPool(3);
        System.out.println("Thread pool is created");

        for(int i=0;i<5;i++){
            executor.submit(new Task(i));
        }

        executor.shutdown();
        System.out.println("Thread pool shutdown is initiated");

        try{
            if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdown();
                System.out.println("Forcing shutdown");
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("All Threads are terminated");
    }
};