
class Counter{

    private int count = 0;

    synchronized public void increment(){
        System.out.println("Start Increment " + Thread.currentThread().getName());
        this.count += 1;
        System.out.println("After Increment, Count: " + this.count);
        System.out.println("End Increment " + Thread.currentThread().getName() + "\n");
    }

    public int getCount(){
        return this.count;
    }
};

public class _1SyncMethod{

    public static void main(String args[]){

        Counter counter = new Counter();

        int num_of_threads = 5;

        Thread[] threads = new Thread[num_of_threads];

        for(int i=0;i<num_of_threads;i++){
            // threads[i] = new Thread(new Runnable(){
            //     @Override
            //     public void run(){
            //         counter.increment();
            //     }
            // });

            threads[i] = new Thread(() -> {
                counter.increment();
            });

            threads[i].start();
        }

        for(int i=0;i<num_of_threads;i++){
            try{
                threads[i].join();
            }
            catch(InterruptedException e){}
        }

        System.out.println("Final Count:" + counter.getCount());
    }
};

/**
 * _1SyncMethod$1.class
 * it is the compiled class file for an anonymous inner class.
 * You're creating an anonymous inner class that implements the Runnable interface. 
 * It's anonymous because it has no name and is defined inline.
 */