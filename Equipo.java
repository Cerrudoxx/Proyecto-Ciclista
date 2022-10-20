import java.util.ArrayList;
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
    
    /**
     * Constructor parametrizado de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta 
     * 
     
    public Equipo(String nombre){
         this.nombre=nombre;
        ciclistasEquipo = new ArrayList<Ciclista>();
        ciclistasAbandonado= new ArrayList<Ciclista>();
        bicicletasEquipo= new ArrayList<Bicicleta>();
    }
    */

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