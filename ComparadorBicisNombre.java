
/**
 * Comparador del nombre de las bicicletas
 */ 
import java.util.*;   
class ComparadorBicisNombre implements Comparator<Bicicleta>{  
    public int compare(Bicicleta b1,Bicicleta b2){  
           
        return b1.getName().compareTo(b2.getName());  
    
    }  
}  

