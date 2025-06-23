
public class SleepExample{

    public static void main(String args[]){

        System.out.println("Thread is going to sleep...");
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Exception");
        }

        System.out.println("Thread woke up after sleeping..");
    }
};