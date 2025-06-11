
class Subscriber implements Observer{

    private String name;

    Subscriber(String name){
        this.name = name;
    }

    public void update(String news){
        System.out.println(this.name + " received breaking news:" + news);
    }
};