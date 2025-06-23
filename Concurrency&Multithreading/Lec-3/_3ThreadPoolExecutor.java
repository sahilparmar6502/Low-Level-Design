import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;

public class _3ThreadPoolExecutor{

    public static void main(String args[]){

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
        2, 4, 60, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>()
        );
        customPool.execute(() -> System.out.println("Task in custom pool"));

        pool.submit(() -> {
            try{
                System.out.println("Running" + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
        });

        System.out.println("Active Threads:" + pool.getActiveCount());
        System.out.println("Queue Size:" + pool.getQueue().size());

        pool.shutdown();
    }
};