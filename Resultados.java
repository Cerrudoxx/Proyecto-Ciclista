
/**
 * Write a description of class Resultados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resultados
{
    // instance variables - replace the example below with your own
    private double tiempo;
    
    private Etapa etapa;

    /**
     * Constructor for objects of class Resultados
     */
    public Resultados()
    {
        // initialise instance variables
        tiempo=0;
        etapa=new Etapa();
    }
    
    /**
     * Constructor for objects of class Resultados
     */
    public Resultados(double tiempo, Etapa etapa)
    {
        // initialise instance variables
        this.tiempo=tiempo;
        this.etapa=etapa;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setTiempo (double tiempo)
    {
        this.tiempo=tiempo;
        
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getTiempo ()
    {
        return tiempo;
        
    }
    
    public void setEtapa(Etapa e){
        this.etapa=e;
    }
    
    public Etapa getEtapa(){
        return etapa;
    }
    
}
