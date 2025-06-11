
public class Main{
    public static void main(String args[]){

        HospitalBed bed1 = new HospitalBed("a101","ward-a",BedTypeFactory.getBedType("ICU",true));
        HospitalBed bed2 = new HospitalBed("a102","ward-a",BedTypeFactory.getBedType("ICU",true));
        HospitalBed bed3 = new HospitalBed("b201","ward-b",BedTypeFactory.getBedType("General",false));

        bed1.display();
        bed2.display();
        bed3.display();
    }
}