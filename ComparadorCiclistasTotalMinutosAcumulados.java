
/**
 * 
 * Comparador del numero total de minutos acumulados
 *  
 */ 
import java.util.*;  
class ComparadorCiclistasTotalMinutosAcumulados implements Comparator<Ciclista>{  
    public int compare(Ciclista c1,Ciclista c2){  
        if(c1.tiempoTotalAcumulado()==c2.tiempoTotalAcumulado())  
            return c1.getName().compareTo(c2.getName());  
        else if(c1.tiempoTotalAcumulado()>c2.tiempoTotalAcumulado())  
            return 1;  
        else  
            return -1;  
    }  
}   

