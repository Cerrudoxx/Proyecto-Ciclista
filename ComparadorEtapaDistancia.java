/**
 * 
 * Comparador de la distancia de la etapa
 * 
 */ 
import java.util.*;   
class ComparadorEtapaDistancia implements Comparator<Etapa>{  
    public int compare(Etapa e1,Etapa e2){  
        if(e1.getDistancia()==e2.getDistancia())  
            return e1.getName().compareTo(e2.getName());  
        else if(e1.getDistancia()>e2.getDistancia())  
            return 1;  
        else  
            return -1;  
    }  
}
