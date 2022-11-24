
/**
 * Enumeration class Dificultad - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Dificultad
{
    SENCILLA ("SENCILLA", 0.9),
    NORMAL("NORMAL", 1.0),
    COMPLEJA("COMPLEJA", 1.1);
    
    private final String nombre;
    private final double valor;
    
    Dificultad(String nombre, double valor){
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
        return "<dificultad: "+getNombre()+" (valor: "+getValor()+")>";
    }
}
