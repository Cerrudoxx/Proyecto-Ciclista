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
    
    @Override
    public int hashCode ()
     {
        int result = 17;
        result = 7 * result + getName().hashCode();
        result = 13 * result + getCampoPeso().hashCode();
        return result;
     }


        /**
         * Establece el valor del campo peso al dado como entrada
         * 
         * @param  peso es el nuevo valor del campo peso
         */
        public double calcularVelocidad(Ciclista c, Etapa e)
        {
        double velocidad= (c.getHabilidad()*100)/(getPeso()*e.getDificultad());
        return velocidad;
    }

    /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    public double calcularTiempoNecesario(Ciclista c, Etapa e)
    {
        double tiempo=(e.getDistancia()/calcularVelocidad(c, e))*60 ;
        return tiempo;        
    }

    // public String toString(){
        // return "<bicicleta: "+getName()+"> <peso: "+getPeso()+"> ";
    // }
    
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

    protected String getTipoBicicleta(){
        return "<Bicicleta: ";
    }
    // /**
     // * Muestra la informacion de la bicicleta por pantalla
     // */
    // public void mostrarBicicleta(){
        // System.out.printf("<bicicleta: "+nombre+"> <peso: "+peso+"> ");
    // }

}