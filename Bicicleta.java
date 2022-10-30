/**
 * Guarda la informacion del nombre y el peso de la bicicleta 
 * etapa
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Bicicleta  
{
    // instance variables - replace the example below with your own
    private String nombre;
    
    private double peso;
    

    /**
     * Constructor de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros por defecto
     */
    public Bicicleta()
    {
        // initialise instance variables
        nombre=" ";
        peso=0;
     
        
       
    }
    
    /**
     * Constructor parametrizado de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta 
     * 
     */
    public Bicicleta(String nombre, double peso){
        this.nombre=nombre;
        this.peso=peso;
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
    
    /**
     * Devuelve el valor del campo peso
     * 
     * @return    peso de la bicicleta 
     */
    public double getPeso()
    {
        // put your code here
        return peso;
        
    }
    
     /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    public void setPeso(double peso)
    {
        // put your code here
        this.peso=peso;
        
    }
    
    /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    public double calcularVelocidad(Ciclista c, Etapa e)
    {
        // put your code here
        double velocidad= (c.getHabilidad()*100)/(peso*e.getDificultad());
        return velocidad;
        
    }
    
    /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    public double calcularTiempoNecesario(Ciclista c, Etapa e)
    {
        // put your code here
        double tiempo=(e.getDistancia()/calcularVelocidad(c, e))*60 ;
        return tiempo;        
    }
    
     public void mostrarBicicleta(){
        System.out.printf("<bicicleta: "+nombre+"> <peso: "+peso+"> ");
    }
    
}