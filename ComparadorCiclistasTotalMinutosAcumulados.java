
/**
 * Java class to demonstrate the use of Java Comparator.  
 * Creating a class which implements Comparator Interface (using 
 * name field)
 */ 
import java.util.*;  
class ComparadorCiclistasTotalMinutosAcumulados implements Comparator<Ciclista>{  
    public int compare(Ciclista c1,Ciclista c2){  
        if(c1.tiempoTotalAcumulado()==c2.tiempoTotalAcumulado())  
            return 0;  
        else if(c1.tiempoTotalAcumulado()>c2.tiempoTotalAcumulado())  
            return 1;  
        else  
            return -1;  
    }  
}   

