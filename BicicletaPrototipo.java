
/**
 *Guarda la informacion del nombre y el peso de la bicicletaPrototipo
 * 
 * 
 */
public class BicicletaPrototipo extends Bicicleta
{

    /**
     * Constructor de objetos de la clase BicicletaPrototipo
     * Crea una nueva bicicletaPrototipo inicializando con parametros dados como parametros
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta 
     */
    public BicicletaPrototipo(String nombre, Peso peso)
    {
        super(nombre, peso);
    }

    /**
     * Devuelve el tipo de bicicleta al que pertenece
     */
    @Override
    protected String getTipoBicicleta(){
        return "<BicicletaPrototipo: ";
    }

    /**
     * Calcula el tiempo necesario para que el ciclista c termine la etapa e 
     * 
     * @param  c es el ciclista que usa la bicicleta y e es la etapa de la que queremos obtener el tiempo
     */
    @Override
    public double calcularTiempoNecesario(Ciclista c, Etapa e)
    {
        c.calcularDestreza();
        double tiempo=(e.getDistancia()/(calcularVelocidad(c, e)*c.getDestreza())) ;
        return tiempo;        
    }
}
