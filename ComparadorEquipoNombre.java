/**
 * 
 * Comparador de los Nombres de los Equipo
 * 
 */ 
import java.util.*;  
class ComparadorEquipoNombre implements Comparator<Equipo>{  
    public int compare(Equipo e1,Equipo e2){  
        return e1.getName().compareTo(e2.getName());
    }  
} 