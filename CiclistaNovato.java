
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
     * Añade a la cadena de caracteres el tipo de ciclista al que pertenece
     */
     @Override
    protected String getFormattedContent(){
         StringBuilder builder = new StringBuilder();
         builder.append("<ciclistaNovato: ");
         
         // builder.append("<popularidad: ");
         // builder.append(getPopularidad());
         // builder.append(">");
         return builder.toString();
    }
    
    /**
     * Calcula la destreza de un cilista
     */
    @Override
    public void calcularDestreza(){
    super.setDestreza(((super.getHabilidad() + 2)/120)*10);    
    }
    
    @Override
    public int getPopularidad(){
        return 0;
    }
    
}