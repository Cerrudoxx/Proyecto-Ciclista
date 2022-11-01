
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
    
    private Ciclista ciclista;

    /**
     * Constructor for objects of class Resultados
     */
    public Resultados()
    {
        // initialise instance variables
        tiempo=0;
        etapa=new Etapa();
        ciclista=new Ciclista();
    }
    
    /**
     * Constructor for objects of class Resultados
     */
    public Resultados(double tiempo, Etapa etapa, Ciclista ciclista)
    {
        // initialise instance variables
        this.tiempo=tiempo;
        this.etapa=etapa;
        this.ciclista=ciclista;
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
    
    public void setCiclista(Ciclista c){
        this.ciclista=c;
    }
    
    public Ciclista getCiclista(){
        return ciclista;
    }
    
}
