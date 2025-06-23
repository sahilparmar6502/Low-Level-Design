import java.util.concurrent.*;

public class CallableInterface2{

    public static void main(String args[]){

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "Task Completed";
        };

        try{

        Future<String> future = executor.submit(task);

        System.out.println("Result from task1:");
        String result = future.get();
        System.out.println(result);
        }
        catch(InterruptedException | ExecutionException e){}

        executor.shutdown();
    }
};