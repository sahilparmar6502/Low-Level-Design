import java.util.Queue;
import java.util.LinkedList;

class ProducerConsumer{

    private Queue<Integer> buffer = new LinkedList<>(); 
    private int capacity = 5;

    public void produce() throws InterruptedException{

        int count = 1;

        while(true){

            synchronized(this){

                while(this.buffer.size() == this.capacity){
                    System.out.println("Buffer is Full! Producer is waiting...");
                    wait();
                }

                this.buffer.offer(count); // item produced
                System.out.println("Item Produced " + count);
                notifyAll(); // notify consumers waiting to consume from buffer
                count += 1;
            }

            Thread.sleep(2000);
        }
    } 

    public void consume() throws InterruptedException{

        while(true){

            synchronized (this){

                while(this.buffer.size() == 0){
                    System.out.println("Buffer is empty! Consumer is waiting...");
                    wait();
                }

                int val = this.buffer.poll(); // consume item
                System.out.println("Item Consumed " + val);
                notifyAll(); // notify Producer waiting that space is available now.
            }

            Thread.sleep(2000);
        }
    } 
};

public class _2ProducerConsumer {

    public static void main(String args[]) {

        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            public void run(){
                try{
                    pc.produce();
                }
                catch(InterruptedException e){}
            }
        });

        Thread consumerThread = new Thread(new Runnable(){
            public void run(){
                try{
                    pc.consume();
                }
                catch(InterruptedException e){}
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}