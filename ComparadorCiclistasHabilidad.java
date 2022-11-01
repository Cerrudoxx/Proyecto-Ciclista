
/**
 * Comparador de la Habilidad de los ciclistas  
 * 
 */ 
import java.util.*;  
class ComparadorCiclistasHabilidad implements Comparator<Ciclista>{  
  
    public int compare(Ciclista c1,Ciclista c2){  
        if(c1.getHabilidad()==c2.getHabilidad())  
            return c1.getName().compareTo(c2.getName());  
        else if(c1.getHabilidad()>c2.getHabilidad())  
            return 1;  
        else  
            return -1;  
    }  
}   

    

