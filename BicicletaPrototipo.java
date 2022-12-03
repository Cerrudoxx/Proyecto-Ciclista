
/**
 * Write a description of class BicicletaPrototipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaPrototipo extends Bicicleta
{
    

    /**
     * Constructor for objects of class BicicletaPrototipo
     */
    public BicicletaPrototipo(String nombre, Peso peso)
    {
        // initialise instance variables
        super(nombre, peso);
    }

    /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    @Override
    public double calcularTiempoNecesario(Ciclista c, Etapa e)
    {
        double tiempo=(e.getDistancia()/calcularVelocidad(c, e))*60 ;
        return tiempo;        
    }
}
