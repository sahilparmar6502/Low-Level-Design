
public class Main{
    public static void main(String args[]){

        NewsAgency newsAgency = new NewsAgency();

        Observer o1 = new Subscriber("Alice");
        Observer o2 = new Subscriber("bob");
        Observer o3 = new Subscriber("john");

        newsAgency.addObserver(o1);
        newsAgency.addObserver(o2);
        newsAgency.addObserver(o3);

        newsAgency.notifyObserver("UCL 2025 final is live!");
        newsAgency.notifyObserver("PSG 5 : 0 Inter");
    }
};