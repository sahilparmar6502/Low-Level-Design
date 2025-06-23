class MyRunnable implements Runnable{

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(i + " Thread" + Thread.currentThread().getId() + " is running!");
        }
    }
};

public class RunnableInterface{

    public static void main(String args[]){

        MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }
};