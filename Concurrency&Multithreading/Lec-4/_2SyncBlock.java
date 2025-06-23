
class Counter{

    private int count = 0;
    private Object lock = new Object();

    public void increment(){

        System.out.println("Start Increment " + Thread.currentThread().getName());

        // critical section
        synchronized (lock) {
            this.count += 1;
        }
        System.out.println("After Increment, Count: " + this.count);
        System.out.println("End Increment " + Thread.currentThread().getName() + "\n");
    }

    public int getCount(){
        return this.count;
    }
};

public class _2SyncBlock{

    public static void main(String args[]){
        Counter counter = new Counter();

        int num_of_threads = 5;

        Thread[] threads = new Thread[num_of_threads];

        for(int i=0;i<num_of_threads;i++){
            threads[i] = new Thread(new Runnable(){
                @Override
                public void run(){
                    counter.increment();
                }
            });

            // threads[i] = new Thread(() -> {
            //     counter.increment();
            // });

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

// threads[i] = new Thread(() -> {
//     counter.increment();
// });
// does not create an anonymous class because it uses a lambda expression, not an anonymous inner class.