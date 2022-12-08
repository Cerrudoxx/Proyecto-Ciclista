/**
 * 
 * Comparador del numero de ciclistas de equipo
 *   
 */  
import java.util.*;  
class ComparadorEquipoNumeroCiclistas implements Comparator<Equipo>{  
    public int compare(Equipo e1,Equipo e2){  
        if(e1.getNumeroCiclistas()==e2.getNumeroCiclistas())  
            return e1.getName().compareTo(e2.getName());  
        else if(e1.getNumeroCiclistas()>e2.getNumeroCiclistas())  
            return 1;  
        else  
            return -1;  
    }  
}   
