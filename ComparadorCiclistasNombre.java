
/**
 * 
 * Comparador del Nombre de los Ciclistas
 * 
 */ 
import java.util.*;  
class ComparadorCiclistasNombre implements Comparator<Ciclista>{  
    public int compare(Ciclista c1,Ciclista c2){  
        return c1.getName().compareTo(c2.getName());
    }  
}  


