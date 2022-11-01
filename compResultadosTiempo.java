/**
 * Java class to demonstrate the use of Java Comparator.  
 * Creating a class which implements Comparator Interface (using 
 * name field)
 */ 
import java.util.*;  
class compResultadosTiempo implements Comparator<Resultados>{  
    public int compare(Resultados r1,Resultados r2){  
        if(r1.getTiempo()==r2.getTiempo())  
            return 0;  
        else if(r1.getTiempo()>r2.getTiempo())  
            return 1;  
        else  
            return -1;  
    }  
} 
