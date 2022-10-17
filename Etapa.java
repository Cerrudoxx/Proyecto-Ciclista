
/**
 * Guarda la informacion del nombre, la dificultad y la distancia de la clase 
 * etapa
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Etapa
{
    // instance variables - replace the example below with your own
    private String nombre;
    
    private double dificultad;
    
    private double distancia;

    /**
     * Constructor de objetos de la clase Etapa
     * Crea una nueva etapa inicializando con parametros por defecto
     */
    public Etapa()
    {
        // initialise instance variables
        nombre=" ";
        dificultad=0;
        distancia=0;
       
    }
    /**
     * Constructor parametrizado de objetos de la clase Etapa
     * Crea una nueva etapa inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la etapa
     * @param dificultad es la dificultad de la etapa
     * @param distancia es la distancia en kilometros de la etapa
     * 
     */
    public Etapa(String nombre, double dificultad, double distancia){
        this.nombre=nombre;
        this.dificultad=dificultad;
        this.distancia=distancia;
    }

    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la etapa 
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
     * Devuelve el valor del campo dificultad
     * 
     * @return     dificultad de la etapa 
     */
    public double getDificultad()
    {
        // put your code here
        return dificultad;
        
    }
    
     /**
     * Establece el valor del campo dificultad al dado como entrada
     * 
     * @param  dificultad es el nuevo valor del campo dificultad
     */
    public void setDificultad(double dificultad)
    {
        // put your code here
        this.dificultad=dificultad;
        
    }
    
    /**
     * Devuelve el valor del campo distancia
     * 
     * @return     distancia de la etapa 
     */
    public double getDistancia()
    {
        // put your code here
        return distancia;
        
    }
    
     /**
     * Establece el valor del campo distancia al dado como entrada
     * 
     * @param  distancia es el nuevo valor del campo nombre
     */
    public void setDistancia(double distancia)
    {
        // put your code here
        this.distancia=distancia;
        
    }
}
