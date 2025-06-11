
public class BedType{
    private String type;
    private boolean hasOxygenSupport;

    BedType(String type,boolean hasOxygenSupport){
        this.type = type;
        this.hasOxygenSupport = hasOxygenSupport;
    }

    public void showDetails(String bedNumber,String ward){
        System.out.println("\nBedNumber:"+bedNumber+"\nWard:"+ward+"\nType:"+type+"\nHasOxygenSupport:"+hasOxygenSupport+"\n");
    }
};