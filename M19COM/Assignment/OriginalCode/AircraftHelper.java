import java.util.*;

/**
 * Helper class for aircraft operations *** DO NOT MODIFY ***
 * @author Hong Guo
 * @version 1.3 - 1/10/18
 */
public class AircraftHelper
{   
	 // used in registrations
    private int regNumber = 100;  
          
    
    // Generate a aircraft with random type & number of flights and unique registration
    public Aircraft genAircraft()
    {   
        List<String> names = Arrays.asList("Antonov_An-140", "Boeing_777-300ER", "Boeing_737-800", "Canadair_CL600-2C10",
            "Airbus_A380-800", "Dornier_Do_27", "Douglas_DC-8", "Boeing_747-8", "Embraer_190", "Embraer_175", "Convair_CV-880",
            "Beechcraft_1300", "BAe_146", "Bombardier_Learjet_40", "Fairchild_Dornier_228", "Fokker_50", "Gulfstream_G550");
            
        List<String> types = Arrays.asList("JET", "PROP");
 
        
        String name = names.get((int)(names.size()*Math.random()));
        int flights = 1 + (int)(250*Math.random());     // 1..250
        String reg = genLetter() + "-" + regNumber++ + genLetter() + genLetter() + genLetter();
                  
        return new Aircraft(name, flights, reg);
    }
    

    private char genLetter()
    {
        return (char)('A' + (int)(26*Math.random()));
    }    
}
