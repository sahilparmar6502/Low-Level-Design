import java.util.List;
import java.util.ArrayList;

class IphoneStockSubject implements Subject{

    private List<Observer> observers;
    private int stock;

    IphoneStockSubject(int stock){
        this.stock = stock;
        this.observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void nofityObservers(){
        for(Observer observer : observers){
            observer.update("Hurry Up! Iphone is in stock now.");
        }
    }

    public void setData(int newStock){
        if(this.stock == 0){
            nofityObservers();
        }
        stock += newStock;
    }
};