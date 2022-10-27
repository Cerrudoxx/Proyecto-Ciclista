
/**
 * Java class to demonstrate the use of Java Comparator.  
 * Creating a class which implements Comparator Interface (using 
 * name field)
 */ 
import java.util.*;  
class ComparadorCiclistasEnergia implements Comparator<Ciclista>{  
    public int compare(Ciclista c1,Ciclista c2){  
        if(c1.getEnergia()==c2.getEnergia())  
            return c1.getName().compareTo(c2.getName());  
        else if(c1.getEnergia()>c2.getEnergia())  
            return 1;  
        else  
            return -1;  
    }  
}  

