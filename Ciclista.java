
/** Guarda la informacion del nombre, la bicicleta, la habilidad, la energía,
 * los resultados y el equipo de la clase ciclista
 *
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Ciclista
{
    
    private String nombre;
    private Bicicleta bicicleta;
    private int habilidad;
    private int energia;
    private int resultado;
    private Equipo equipo;
    

    /**
     * Constructor de objetos de la clase Ciclista
     * Crea un nuevo ciclissta inicializando con parametros por defecto
     */
    public Ciclista()
    {        
        nombre=" ";
        habilidad=0;
        energia=0;
        resultado=0;
    }
    
    /**
     * Constructor parametrizado de objetos de la clase Ciclista
     * Crea un nuevo ciclista inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre del ciclista
     * @param habilidad es la habilidad del ciclista
     * @param energia es la energía restante del ciclista
     * @param resultado es el resultado del ciclista
     * 
     */
    public Ciclista(String nombre, int habilidad, int energia, int resultado)
    {        
        this.nombre=nombre;
        this.habilidad=habilidad;
        this.energia=energia;
        this.resultado=resultado;
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
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la etapa 
     */
    public String getName()
    {
        
        return nombre;
        
    }
    
    /**
     * Establece el valor del campo habilidad al dado como entrada
     * 
     * @param  habilidad es el nuevo valor del campo habilidad
     */
    public void setHabilidad(int habilidad)
    {
        
        this.habilidad=habilidad;
        
    }
     /**
     * Devuelve el valor del campo habilidad
     * 
     * @return   habilidad del ciclista
     */
    public int getHabilidad()
    {
        
        return habilidad;
        
    }
    
    /**
     * Establece el valor del campo energia al dado como entrada
     * 
     * @param  energia es el nuevo valor del campo energia
     */
     public void setEnergia(int energia)
    {
        
        this.energia=energia;
        
    }
    
    /**
     * Devuelve el valor del campo energia
     * 
     * @return     energía restante
     */
    public int getEnergia()
    {
        
        return energia;
        
    }
    
    /**
     * Establece el valor del campo resultado al dado como entrada
     * 
     * @param  resultado es el nuevo valor del campo resultado
     */
     public void setResultado(int resultado)
    {
        
        this.resultado=resultado;
        
    }
    
    /**
     * Devuelve el valor del campo resultado
     * 
     * @return     resultado del ciclista
     */
    public int getResultado()
    {
        
        return resultado;
        
    }
    
    /**
     * Establece el valor del campo bicicleta al dado como entrada
     * 
     * @param  bicicleta es el nuevo valor del campo bicicleta
     */
     public void setBicicleta(Bicicleta bicicleta)
    {
        
        this.bicicleta=bicicleta;
        
    }
    
    /**
     * Devuelve el valor del campo bicicleta
     * 
     * @return     bicicleta del ciclista
     */
    public Bicicleta getBicicleta()
    {
        
        return bicicleta;
        
    }

    /**
     * Establece el valor del campo equipo al dado como entrada
     * 
     * @param  equipo es el nuevo valor del campo equipo
     
     public void setEquipo(Equipo equipo)
    {
        
        this.equipo=equipo;
        
    }
    */
    
    /**
     * Devuelve el valor del campo equipo
     * 
     * @return     equipo del ciclista
    
    public Equipo getEquipo()
    {
        
        return equipo;
        
    }
     */
    
   
}