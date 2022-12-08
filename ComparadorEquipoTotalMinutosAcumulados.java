
/**
 * Comparador del total de minutos acumulados por el Equipo
 */ 
import java.util.*;   
class ComparadorEquipoTotalMinutosAcumulados implements Comparator<Equipo>{  
    public int compare(Equipo e1,Equipo e2){  
        if(e1.tiempoTotalAcumuladoCiclistas()==e2.tiempoTotalAcumuladoCiclistas())  
            return e1.getName().compareTo(e2.getName());  
        else if(e1.tiempoTotalAcumuladoCiclistas()>e2.tiempoTotalAcumuladoCiclistas())  
            return 1;  
        else  
            return -1;  
    }  
}   
