
/**
 * Java class to demonstrate the use of Java Comparator.  
 * Creating a class which implements Comparator Interface (using 
 * name field)
 */ 
import java.util.*;  
class ComparadorCiclistasNombre implements Comparator<Ciclista>{  
    public int compare(Ciclista c1,Ciclista c2){  
        return c1.getName().compareTo(c2.getName());
    }  
}  


