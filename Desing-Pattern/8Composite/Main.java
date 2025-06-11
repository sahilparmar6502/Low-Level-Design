
public class Main{

    public static void main(String args[]){

        Staff doc1 = new Employee("Dr. Som","Surgeon");
        Staff doc2 = new Employee("Dr. Tom","Surgeon");

        Staff nurse1 = new Employee("Nurse Alice","Senior Nurse");
        Staff nurse2 = new Employee("Nurse Bob","Junior Nurse");

        Department dept1 = new Department("Surgery Department");
        dept1.add(doc1);
        dept1.add(doc2);

        Department dept2 = new Department("Nursing Department");
        dept2.add(nurse1);
        dept2.add(nurse2);

        Department hospital_members = new Department("Hospital Members");
        hospital_members.add(dept1);
        hospital_members.add(dept2);

        hospital_members.showDetails();
    }
};