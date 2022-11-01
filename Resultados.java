
/**
 * Guarda la informacion de los resultados guardando el tiempo, la etapa y el ciclista 
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Resultados  
{
    // instance variables - replace the example below with your own
    private double tiempo;
    
    private Etapa etapa;
    
    private Ciclista ciclista;

    /**
     * Constructor de objetos de la clase Resultados
     * Crea un nuevo resultado inicializando con parametros por defecto
     */
    public Resultados()
    {
        // initialise instance variables
        tiempo=0;
        etapa=new Etapa();
        ciclista=new Ciclista();
    }
    
    /**
     * Constructor parametrizado de objetos de la clase Resultados
     * Crea un nuevo resultado inicializando con parametros pasados por teclado
     * 
     * @param tiempo es el resultado del ciclista
     * @param etapa es la etapa para la que se guarda el tiempo 
     * @param ciclista es el ciclista que obtiene el resultado
     * 
     */
    public Resultados(double tiempo, Etapa etapa, Ciclista ciclista)
    {
        // initialise instance variables
        this.tiempo=tiempo;
        this.etapa=etapa;
        this.ciclista=ciclista;
    }

    /**
     * Establece el valor del campo tiempo al dado como entrada
     * 
     * @param  tiempo es el nuevo valor del campo tiempo
     */
    public void setTiempo (double tiempo)
    {
        this.tiempo=tiempo;
        
    }
    /**
     * Devuelve el valor del campo tiempo
     * 
     * @return     tiempo de un ciclista en una etapa
     */
    public double getTiempo ()
    {
        return tiempo;
        
    }
    
    /**
     * Establece el valor del campo etapa al dado como entrada
     * 
     * @param  etapa es el nuevo valor del campo etapa
     */
    public void setEtapa(Etapa e){
        this.etapa=e;
    }
    
    /**
     * Devuelve el valor del campo etapa
     * 
     * @return     etapa en la que corre un ciclista
     */
    public Etapa getEtapa(){
        return etapa;
    }
    
    /**
     * Establece el valor del campo ciclista al dado como entrada
     * 
     * @param  ciclista es el nuevo valor del campo ciclista
     */
    public void setCiclista(Ciclista c){
        this.ciclista=c;
    }
    
    /**
     * Devuelve el valor del campo ciclista
     * 
     * @return     ciclista del que se guarda el resultado
     */
    public Ciclista getCiclista(){
        return ciclista;
    }
    
}
