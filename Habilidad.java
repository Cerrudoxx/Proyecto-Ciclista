

/**
 * Enumeration class Habilidad - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Habilidad
{
    LENTA("LENTA", 4.0),
    NORMAL("NORMAL", 6.0),
    BUENA("BUENA", 8.0);
    
    private final String nombre;
    private final double valor;
    
    Habilidad(String nombre, double valor){
        this.nombre=nombre;
        this.valor=valor;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getValor(){
        return valor;
    }
    
    @Override
    public String toString(){
        return "<habilidad: "+getNombre()+" (valor: "+getValor()+")>";
    }
}

