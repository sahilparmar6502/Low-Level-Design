import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class _5Future{

    public static void main(String args[]) throws ExecutionException, InterruptedException{

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<String> future = executor.submit(() -> "Hello ExecutorService");

        System.out.println(future.get());

        executor.shutdown();
    }
};