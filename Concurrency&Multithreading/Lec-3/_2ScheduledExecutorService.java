import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _2ScheduledExecutorService{

    public static void main(String args[]){

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> {
            System.out.println("Schedule after 3 Seconds");
        }, 3, TimeUnit.SECONDS);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(int corePoolSize);
        ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);

        scheduler.shutdown();
    }
};