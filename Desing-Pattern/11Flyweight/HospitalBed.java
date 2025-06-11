

public class HospitalBed{

    private String bedNumber;
    private String ward;
    private BedType bedType;

    public HospitalBed(String bedNumber,String ward,BedType bedType){
        this.bedNumber = bedNumber;
        this.ward = ward;
        this.bedType = bedType;
    }

    public void display(){
        this.bedType.showDetails(bedNumber,ward);
    }
};