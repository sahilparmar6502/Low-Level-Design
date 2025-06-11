import java.util.ArrayList;
import java.util.List;


interface Staff {
    void showDetails();
}

class Employee implements Staff {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + role);
    }
}


class Department implements Staff {
    private String name;
    private List<Staff> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addStaff(Staff s) {
        members.add(s);
    }

    public void removeStaff(Staff s) {
        members.remove(s);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (Staff s : members) {
            s.showDetails();
        }
    }
}

public class Temp {
    public static void main(String[] args) {
        // Leaf objects
        Staff doc1 = new Employee("Dr. Smith", "Surgeon");
        Staff doc2 = new Employee("Dr. Alice", "Surgeon");
        Staff nurse1 = new Employee("Nurse Mary", "Senior Nurse");
        Staff nurse2 = new Employee("Nurse Tom", "Junior Nurse");

        // Composite objects
        Department surgeryDept = new Department("Surgery Department");
        surgeryDept.addStaff(doc1);
        surgeryDept.addStaff(doc2);

        Department nursingDept = new Department("Nursing Department");
        nursingDept.addStaff(nurse1);
        nursingDept.addStaff(nurse2);

        Department hospital = new Department("Hospital Staff");
        hospital.addStaff(surgeryDept);
        hospital.addStaff(nursingDept);

        // Show full structure
        hospital.showDetails();
    }
}

