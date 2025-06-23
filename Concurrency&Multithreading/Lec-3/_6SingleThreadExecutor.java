import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class _6SingleThreadExecutor{

    public static void main(String args[]){

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            throw new RuntimeException("Boom!");
        });

        try{
            future.get();
        }
        catch(ExecutionException e){
            System.out.println(e.getMessage());
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }
};