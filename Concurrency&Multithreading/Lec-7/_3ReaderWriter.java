import java.util.concurrent.Semaphore;

class ReaderWriter{

    private int readerCount = 0;
    private Semaphore readerLock = new Semaphore(1);
    private Semaphore writerLock = new Semaphore(1);

    public void lockRead() throws InterruptedException{

        readerLock.acquire();
        readerCount += 1;

        if(readerCount == 1){
            writerLock.acquire(); // if 1st reader then acquire the writerLock, so no writer can acquire it
        }

        readerLock.release();
    }

    public void unlockRead() throws InterruptedException{

        readerLock.acquire();
        readerCount -= 1;

        if(readerCount == 0){ // all reader are done, release the writerLock, so writer can come
            writerLock.release();
        }

        readerLock.release();
    }

    public void lockWrite() throws InterruptedException{
        writerLock.acquire();
    }

    public void unlockWrite() throws InterruptedException{
        writerLock.release();
    }
};

public class _3ReaderWriter{

    public static void main(String args[]){

        ReaderWriter rw = new ReaderWriter();

        Runnable readerTask = () -> {
            try{
                rw.lockRead();
                System.out.println(Thread.currentThread().getName() + " has acquired read-lock.");
                Thread.sleep(2000);
                
                rw.unlockRead();
                System.out.println(Thread.currentThread().getName() + " has released read-lock.");
            }       
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };

        Runnable writerTask = () -> {
            try{
                rw.lockWrite();
                System.out.println(Thread.currentThread().getName() + " has acquired write-lock.");
                Thread.sleep(2000);
                rw.unlockWrite();
                System.out.println(Thread.currentThread().getName() + " has released write-lock.");
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };

        Thread reader1 = new Thread(readerTask);
        Thread reader2 = new Thread(readerTask);
        Thread writer1 = new Thread(writerTask);

        reader1.start();
        reader2.start();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        writer1.start();

        try{
            reader1.join();
            reader2.join();
            writer1.join();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
};