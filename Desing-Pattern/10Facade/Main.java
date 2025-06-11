
public class Main{
    public static void main(String args[]){

        HospitalFacade hospitalfacade = new HospitalFacade();

        hospitalfacade.processNewPatient("Alice");
        hospitalfacade.processNewPatient("Bob");
    }
}