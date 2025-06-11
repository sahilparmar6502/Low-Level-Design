import java.util.List;
import java.util.ArrayList;

public class Department implements Staff{

    private String name;
    List<Staff> members = new ArrayList<Staff>();

    public Department(String name){
        this.name = name;
    }

    public void add(Staff s){
        members.add(s);
    }

    public void remove(Staff s){
        members.add(s);
    }

    public void showDetails(){
        System.out.println("Department name:"+this.name);

        for(Staff s : members){
            s.showDetails();
        }
    }
};