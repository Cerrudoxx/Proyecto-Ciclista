/**
 * 
 * Comparador del peso de las bicicletas
 * 
 */  
import java.util.*;  
class ComparadorBicisPeso implements Comparator<Bicicleta>{  
    public int compare(Bicicleta b1,Bicicleta b2){  
        if(b1.getPeso()==b2.getPeso())  
            return b1.getName().compareTo(b2.getName());  
        else if(b1.getPeso()>b2.getPeso())  
            return 1;  
        else  
            return -1;  
    }  
} 
