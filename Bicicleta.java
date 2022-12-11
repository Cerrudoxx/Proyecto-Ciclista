/**
 * Guarda la informacion del nombre y el peso de la bicicleta 
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
 */
public class Bicicleta  
{
    private String nombre;

    private Peso peso;

    /**
     * Constructor de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros por defecto
     */
    public Bicicleta()
    {
        nombre=" ";
        peso=null;  
    }

    /**
     * Constructor parametrizado de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta 
     * 
     */
    public Bicicleta(String nombre, Peso peso){
        this.nombre=nombre;
        setPeso(peso);
    }

    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la bicicleta 
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
     * Devuelve el valor del campo peso
     * 
     * @return    peso de la bicicleta 
     */
    public double getPeso()
    {
        return peso.getValor(); 
    }

    /**
     * Devuelve el valor del campo peso
     * 
     * @return    peso de la bicicleta 
     */
    public Peso getCampoPeso()
    {
        return peso; 
    }

    /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    public void setPeso(Peso peso)
    {
        this.peso=peso;
    }

    /**
     * Devuelve true si nos encontramos ante la misma bicicleta y false en caso contrario.
     * 
     * @param b es la bicicleta con la que queremos comparar
     * 
     * @return true si ambas bicicletas son la misma
     */
    public boolean equals (Bicicleta b) {
        if (this == b) {
            return true;
        }

        if (! (b instanceof Bicicleta)) {
            return false; 
        }

        Bicicleta other = (Bicicleta) b;
        return ((getName().equals(other.getName())) &&
            (getCampoPeso().equals(other.getCampoPeso())));
    }

    /**
     * devuelve un valor entero que representa de forma inequívoca a una bicicleta.
     * 
     * @return el valor que representa a la bicicleta
     */
    @Override
    public int hashCode ()
    {
        int result = 17;
        result = 7 * result + getName().hashCode();
        result = 13 * result + getCampoPeso().hashCode();
        return result;
    }

    /**
     * Calcula la velocidad de un ciclista en una etapa
     * 
     * @param  c es el ciclista que usa la bicicleta y e es la etapa de la que queremos obtener el tiempo
     */
    public double calcularVelocidad(Ciclista c, Etapa e)
    {
        double velocidad= (c.getHabilidad()*100)/(getPeso()*e.getDificultad());
        return velocidad;
    }

    /**
     * Calcula el tiempo necesario para que el ciclista c termine la etapa e 
     * 
     * @param  c es el ciclista que usa la bicicleta y e es la etapa de la que queremos obtener el tiempo
     */
    public double calcularTiempoNecesario(Ciclista c, Etapa e)
    {

        double tiempo=(e.getDistancia()/calcularVelocidad(c, e))*60 ;
        return tiempo;              
    }

    /**
     * Transforma en una cadena de caracteres todos los datos de una bicicleta.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(getTipoBicicleta());
        builder.append(getName());
        builder.append("> ");
        builder.append(getCampoPeso());
        builder.append(" ");
        return builder.toString();
    }

    /**
     * Devuelve el tipo de bicicleta al que pertenece
     */
    protected String getTipoBicicleta(){
        return "<Bicicleta: ";
    }
    
}