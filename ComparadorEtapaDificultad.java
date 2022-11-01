
/**
 * 
 * Comparador de la dificultad de la etapa
 * 
 */ 
import java.util.*;  
class ComparadorEtapaDificultad implements Comparator<Etapa>{  
    public int compare(Etapa e1,Etapa e2){  
        if(e1.getDificultad()==e2.getDificultad())  
            return e1.getName().compareTo(e2.getName());  
        else if(e1.getDificultad()>e2.getDificultad())  
            return 1;  
        else  
            return -1;  
    }  
}