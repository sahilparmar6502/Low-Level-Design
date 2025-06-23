import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

class MyCallable implements Callable<String>{

    private final String name;

    public MyCallable(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception{
        
        StringBuilder res = new StringBuilder();
        for(int i=0;i<5;i++){
            res.append(i).append(" ").append(this.name).append(" is").append(" running").append("\n");
        }
        return res.toString();
    }
};

public class CallableInterface{
    public static void main(String args[]){

        ExecutorService executor = Executors.newFixedThreadPool(2);

        MyCallable callable1 = new MyCallable("Task1");
        MyCallable callable2 = new MyCallable("Task2");

        try{
            Future<String> future1 = executor.submit(callable1);
            Future<String> future2 = executor.submit(callable2);

            System.out.println("result from task1:");
            System.out.println(future1.get());

            System.out.println("result from task2:");
            System.out.println(future2.get());
        }
        catch(InterruptedException | ExecutionException e){
            System.out.println("exception occurred in execution." + e.getMessage());
        }
        finally{
            executor.shutdown();
        }
    }
};