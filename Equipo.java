import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

/**
 * Guarda la informacion del nombre y el peso de la bicicleta 
 * etapa
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Equipo
{  
    // instance variables - replace the example below with your own
    private String nombre;
    
    private ArrayList<Ciclista> ciclistasEquipo;
    
    private ArrayList<Ciclista> ciclistasAbandonado;
    
    private ArrayList<Bicicleta> bicicletasEquipo;  
    
    Comparator<Ciclista> compCiclista;
    boolean ordenCiclista;
    

    /**
     * Constructor de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros por defecto
     */
    public Equipo()
    {
        // initialise instance variables
        nombre=" ";
        ciclistasEquipo = new ArrayList<Ciclista>();
        ciclistasAbandonado= new ArrayList<Ciclista>();
        bicicletasEquipo= new ArrayList<Bicicleta>();
        
        
       
    }
    
    
    /** Constructor parametrizado de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta 
     *
     *
     */
     
    public Equipo(String nombre, Comparator<Ciclista> cc, boolean oc){
         this.nombre=nombre;
        ciclistasEquipo = new ArrayList<Ciclista>();
        ciclistasAbandonado= new ArrayList<Ciclista>();
        bicicletasEquipo= new ArrayList<Bicicleta>();
        compCiclista=cc;
        ordenCiclista=oc;
    }
    

    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la bicicleta 
     */
    public String getName()
    {
        // put your code here
        return nombre;
        
    }
    
    /**
     * Establece el valor del campo nombre al dado como entrada
     * 
     * @param  nombre es el nuevo valor del campo nombre
     */
    public void setName(String nombre)
    {
        // put your code here
        this.nombre=nombre;
        
    }

    public void ordenarCiclistas()
    {
       if(ordenCiclista)
        Collections.sort(ciclistasEquipo,compCiclista);
        else
        Collections.sort(ciclistasEquipo, Collections.reverseOrder(compCiclista));
    }
    
    public double tiempoTotalAcumuladoCiclistas(){
        int index=0;   
        double tiempoTotal=0;
        while(index<ciclistasEquipo.size()){
            Ciclista ciclista=ciclistasEquipo.get(index);
            tiempoTotal = tiempoTotal + ciclista.tiempoTotalAcumulado();
            index++;
        }
        return tiempoTotal;
    }
    
    public Ciclista enviarAEtapa(){
        Ciclista c=ciclistasEquipo.get(0);
        ciclistasEquipo.remove (0);
        return c;
    }
    
    public void insertarCiclista(Ciclista c){
        if(c.getEnergia()>0){
            ciclistasEquipo.add(c);
        }
        else{
            ciclistasAbandonado.add(c);
        }
    }
  
    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la bicicleta 
     
    public String getCiclistasEquipo()
    {
        // put your code here
        return ciclistasEquipo.getName();
        
    }
    
    /**
     * Establece el valor del campo nombre al dado como entrada
     * 
     * @param  nombre es el nuevo valor del campo nombre
    
    public void setCiclistaEquipo(Ciclista CiclistaEquipo)
    {
        // put your code here
        this.ciclistasEquipo=CiclistaEquipo;
        
    } */
    
    
}