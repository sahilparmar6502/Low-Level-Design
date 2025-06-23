
class MyThread extends Thread{

   @Override
   public void run(){
        for(int i=0;i<5;i++){
            System.out.println(i+ "Thread " + Thread.currentThread().getId() + " is running!");
        }
   } 
};

public class ThreadClass{

    public static void main(String args[]){

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();
    }
};