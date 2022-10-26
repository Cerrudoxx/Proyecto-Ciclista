
/**
 * Java class to demonstrate the use of Java Comparator.  
 * Creating a class which implements Comparator Interface (using 
 * name field)
 */ 
import java.util.*;  
class ComparadorBicisNombre implements Comparator<Bicicleta>{  
    public int compare(Bicicleta b1,Bicicleta b2){  
           
        return b1.getName().compareTo(b2.getName());  
    
    }  
}  
