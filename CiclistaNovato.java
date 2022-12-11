/**
 * Write a description of class CiclistaNovato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaNovato extends Ciclista
{
      /**
     * Constructor parametrizado de objetos de la clase CiclistaNovato
     * Crea un nuevo ciclistaNovato inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre del ciclista
     * @param habilidad es la habilidad del ciclista
     * @param energia es la energía restante del ciclista
     * @param equipo es el equipo al que pertenece el ciclista
     * 
     */
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
         
         return builder.toString();
    }
    
    /**
     * Calcula la destreza de un cilista
     */
    @Override
    public void calcularDestreza(){
    super.setDestreza(((super.getHabilidad() + 2)/120)*10);    
    }

    
}