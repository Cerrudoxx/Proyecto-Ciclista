
/**
 * Guarda la informacion del nombre, el peso y la velocidadExtra de la bicicletaRapida
 * 
 * 
 */
public class BicicletaRapida extends Bicicleta
{

    private double velocidadExtra;

    /**
     * Constructor de objetos de la clase BicicletaRapida
     * Crea una nueva bicicletaRapida inicializando con parametros por defecto
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta
     * @param velocidadExtra es la velocidad extra de la bicicleta rapida
     * 
     */
    public BicicletaRapida(String nombre, Peso peso, double velocidadExtra)
    {

        super(nombre, peso);
        this.velocidadExtra = velocidadExtra;
    }

    /**
     * Devuelve el valor del campo velocidadExtra
     * 
     * @return   velocidadExtra de la bicicleta rapida
     */
    public double getVelocidadExtra()
    {
        return velocidadExtra; 
    }

    /**
     * Devuelve true si nos encontramos ante la misma bicicleta y false en caso contrario.
     * 
     * @param b es la bicicleta con la que queremos comparar
     * 
     * @return true si ambas bicicletas son la misma
     */
    @Override
    public boolean equals (Bicicleta b) {
        if(this == b) {
            return true;
        }

        if (! (b instanceof BicicletaRapida)) {
            return false; 
        }

        BicicletaRapida other = (BicicletaRapida) b;
        return  (super.equals(other) &&  getVelocidadExtra()==other.getVelocidadExtra());  
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
        double vel_extra=getVelocidadExtra();
        result = 7 * result + super.hashCode();
        result = 13 * result + (int) vel_extra;
        return result;
    }

    /**
     * Transforma en una cadena de caracteres todos los datos de una bicicleta.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(" <VelocidadExtra: ");
        builder.append(getVelocidadExtra());
        builder.append(" > ");
        return builder.toString();
    }

    /**
     * Devuelve el tipo de bicicleta al que pertenece
     */
    @Override
    protected String getTipoBicicleta(){
        return "<BicicletaRapida: ";
    }

    /**
     * Calcula la velocidad de un ciclista en una etapa
     * 
     * @param  c es el ciclista que usa la bicicleta y e es la etapa de la que queremos obtener el tiempo
     */
    @Override
    public double calcularVelocidad(Ciclista c, Etapa e)
    {
        return super.calcularVelocidad(c, e) + getVelocidadExtra();
    }

}
