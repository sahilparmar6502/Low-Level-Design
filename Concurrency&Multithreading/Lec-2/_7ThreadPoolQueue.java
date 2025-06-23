import java.util.concurrent.*;

public class _7ThreadPoolQueue{
    public static void main(String args[]){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
            new ThreadPoolExecutor.AbortPolicy()
        );

        for(int i=1;i<=10;i++){
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running task" + taskId);
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupte();
                }
            });
        }

        executor.shutdown();
    }
};