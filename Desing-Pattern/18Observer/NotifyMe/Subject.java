
interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void nofityObservers();
};