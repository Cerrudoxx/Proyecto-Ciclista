
/**
 * Enumeration class Distancia - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Distancia
{
    CORTA("CORTA", 150),
    INTERMEDIA("INTERMEDIA", 200),
    LARGA("LARGA", 225);
    
    private final String nombre;
    private final double valor;
    
    Distancia(String nombre, double valor){
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
        return "<distancia: "+getNombre()+" (valor: "+getValor()+")>";
    }
    
}

