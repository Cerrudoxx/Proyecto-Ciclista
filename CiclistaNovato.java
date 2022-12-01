
/**
 * Write a description of class CiclistaNovato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaNovato extends Ciclista
{
    // instance variables - replace the example below with your own
    
    
    public CiclistaNovato(String nombre, Habilidad habilidad, double energia, Equipo e)
    {
      
        super(nombre, habilidad, energia, e);
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public void calcularDestreza(){
    super.setDestreza(((super.getHabilidad() + 2)/120)*10);    
    }
    
}