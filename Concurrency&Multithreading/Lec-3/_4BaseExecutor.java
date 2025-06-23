import java.util.concurrent.Executor;

public class _4BaseExecutor{

    public static void main(String args[]){

        Executor executor = command -> new Thread(command).start();
        executor.execute(() -> System.out.println("Simple task execution"));
    }
};