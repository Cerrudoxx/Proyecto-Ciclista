
/**
 * Java class to demonstrate the use of Java Comparator.  
 * Creating a class which implements Comparator Interface (using 
 * name field)
 */ 
import java.util.*;  
class ComparadorEtapaNombre implements Comparator<Etapa>{  
    public int compare(Etapa e1,Etapa e2){  
        return e1.getName().compareTo(e2.getName());
    }  
}