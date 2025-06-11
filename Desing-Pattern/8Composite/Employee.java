
public class Employee implements Staff{

    private String name;
    private String role;

    public Employee(String name,String role){
        this.name = name;
        this.role = role;
    }

    public void showDetails(){
        System.out.println("Name:"+name+" Role:"+role);
    }
};