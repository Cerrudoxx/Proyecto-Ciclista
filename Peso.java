

/**
 * Enumeration class Dificultad - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Peso
{
    LIGERA ("LIGERA", 7.35),
    NORMAL ("NORMAL", 7.50),
    PESADA ("COMPLEJA", 7.85);
    
    private final String nombre;
    private final double valor;
    
    Peso(String nombre, double valor){
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
        return "<peso: "+getNombre()+" (valor: "+getValor()+")>";
    }
}
