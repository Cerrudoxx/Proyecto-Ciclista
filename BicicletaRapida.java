
/**
 * Write a description of class BicicletaRapida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaRapida extends Bicicleta
{
    // instance variables - replace the example below with your own
    private double velocidadExtra;

    /**
     * Constructor for objects of class BicicletaRapida
     */
    public BicicletaRapida(String nombre, Peso peso, double velocidadExtra)
    {
        // initialise instance variables
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

    
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
         builder.append("\n");
          builder.append("VelocidadExtra: ");
        builder.append(getVelocidadExtra());
        builder.append("\n");
        return builder.toString();
    }
    
  
    /**
     * Establece el valor del campo peso al dado como entrada
     * 
     * @param  peso es el nuevo valor del campo peso
     */
    @Override
    public double calcularVelocidad(Ciclista c, Etapa e)
    {
        return super.calcularVelocidad(c, e) + velocidadExtra;
    }

}
