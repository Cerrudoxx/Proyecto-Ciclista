

/**
 * Guarda la informacion del nombre, la dificultad y la distancia de la clase 
 * etapa
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Etapa
{  
    private String nombre;
    
    private Dificultad dificultad;
    
    private Distancia distancia;
    
    private double tiempoCiclista;

    /**
     * Constructor de objetos de la clase Etapa
     * Crea una nueva etapa inicializando con parametros por defecto
     * 
     * @param nombre es el nombre de la etapa
     * @param dificultad es la dificultad de la etapa
     * @param distancia es la distancia en kilometros de la etapa
     */
    public Etapa()
    {
        nombre=" ";
       dificultad=null;
       distancia=null;
       
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
    public Etapa(String nombre, Dificultad dificultad, Distancia distancia){
        this.nombre=nombre;
        setDificultad(dificultad);
        setDistancia(distancia);
    }

    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la etapa 
     */
    public String getName()
    {
        return nombre;
        
    }
    
    /**
     * Establece el valor del campo nombre al dado como entrada
     * 
     * @param  nombre es el nuevo valor del campo nombre
     */
    public void setName(String nombre)
    {
        this.nombre=nombre;
        
    }
    
    /**
     * Devuelve el valor del campo dificultad
     * 
     * @return     dificultad de la etapa 
     */
    public double getDificultad()
    {
        return dificultad.getValor();
        
    }
    
    /**
     * Devuelve el valor numerico del campo dificultad
     * 
     * @return     dificultad de la etapa 
     */
    public Dificultad getCampoDificultad()
    {
        return dificultad;
        
    }
    
     /**
     * Establece el valor del campo dificultad al dado como entrada
     * 
     * @param  dificultad es el nuevo valor del campo dificultad
     */
    public void setDificultad(Dificultad dificultad)
    {
        this.dificultad=dificultad;
        
    }
    
    /**
     * Devuelve el valor del campo distancia
     * 
     * @return     distancia de la etapa 
     */
    public double getDistancia()
    {
        return distancia.getValor();
        
    }
    
    /**
     * Devuelve el valor numerico del campo distancia
     * 
     * @return     distancia de la etapa 
     */
    public Distancia getCampoDistancia()
    {
        return distancia;
        
    }
    
     /**
     * Establece el valor del campo distancia al dado como entrada
     * 
     * @param  distancia es el nuevo valor del campo nombre
     */
    public void setDistancia(Distancia distancia)
    {
        this.distancia=distancia;
        
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("<etapa:");
        builder.append(getName());
        builder.append("> ");
        builder.append(getCampoDificultad());
        builder.append(" ");
        builder.append(getCampoDistancia());
        
       

        return builder.toString();
    }
    
    // /**
     // * Muestra la informacion de la etapa por pantalla
     // */
    // public void mostrarEtapa()
    // {
        // System.out.println("<etapa:"+nombre+"> <dificultad:"+dificultad+"> <distancia:"+distancia+")>");
        
    // }
    
}
