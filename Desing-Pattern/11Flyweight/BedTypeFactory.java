import java.util.*;

public class BedTypeFactory{
    private static final Map<String,BedType> bedTypeMap = new HashMap<>();

    public static BedType getBedType(String type,boolean hasOxygenSupport){
        String key = type + "-" + hasOxygenSupport;

        if(!bedTypeMap.containsKey(key)){
            bedTypeMap.put(key,new BedType(type,hasOxygenSupport));
        }
        return bedTypeMap.get(key);
    }
};