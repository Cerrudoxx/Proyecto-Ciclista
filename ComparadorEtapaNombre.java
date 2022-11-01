
/**
 * 
 * Comparador del nombre de las Etapa
 * 
 */ 
import java.util.*;  
class ComparadorEtapaNombre implements Comparator<Etapa>{  
    public int compare(Etapa e1,Etapa e2){  
        return e1.getName().compareTo(e2.getName());
    }  
}