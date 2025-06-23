import java.util.concurrent.atomic.AtomicInteger;

public class _4AtomicCounterExample{

    private AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        int newCount = counter.incrementAndGet();
    }

    public int getCount(){
        return counter.get();
    }

    public static void main(String args[]){

        final _4AtomicCounterExample example = new _4AtomicCounterExample();

        int num_of_threads = 10;
        int add = 100;

        Thread[] threads = new Thread[num_of_threads];

        for(int i=0;i<num_of_threads;i++){

            threads[i] = new Thread(new Runnable(){
                public void run(){
                    for(int i=0;i<add;i++){
                        example.increment();
                    }
                }
            }, "Thread" + (i+1));

            threads[i].start();
        }

        for(int i=0;i<num_of_threads;i++){
            try{
                threads[i].join();
            }
            catch(InterruptedException e){}
        }

        System.out.println("Final Count:" + example.getCount());
    }
};