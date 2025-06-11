import java.util.List;
import java.util.ArrayList;

class NewsAgency implements Subject{

    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer o){
        this.observers.add(o);
    }

    public void notifyObserver(String news){

        for(Observer o : observers){
            o.update(news);
        }
        System.out.println();
    }
};