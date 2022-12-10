
/**
 * Write a description of class CiclistaEstrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaEstrella extends Ciclista
{
    // instance variables - replace the example below with your own
    private int serPopular;

    /**
     * Constructor for objects of class CiclistaEstrella
     */
    public CiclistaEstrella()
    {

        serPopular=6;
    }

    /**
     * Constructor for objects of class CiclistaEstrella
     */
    public CiclistaEstrella(String nombre, Habilidad habilidad, double energia, Equipo e)
    {

        super(nombre, habilidad, energia, e);
        serPopular=6;
    }

    public int getPopularidad(){
        return serPopular;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public void calcularDestreza(){
        super.setDestreza(((super.getHabilidad() + 6)/140)*10);    
    }

    @Override
    public boolean equals (Ciclista c) {
        if(this == c) {
            return true;
        }

        if (! (c instanceof CiclistaEstrella)) {
            return false; 
        }
        
        CiclistaEstrella other = (CiclistaEstrella) c;
        return  (super.equals(other) &&  getPopularidad()==other.getPopularidad());
    }
    
     @Override
    public int hashCode ()
     {
        int result = 17;
        
        result = 7 * result + super.hashCode();
        result = 13 * result + getPopularidad();
        return result;
     }


    @Override
    protected String getFormattedContent(){
        StringBuilder builder = new StringBuilder();
        builder.append("<ciclistaEstrella: ");

        //builder.append(super.toString());
        // builder.append("<popularidad: ");
        // builder.append(getPopularidad());
        // builder.append(">");
        return builder.toString();
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(" <popularidad: ");
        builder.append(getPopularidad());
        builder.append("> ");
        return builder.toString();
    }

    @Override
    public double getTiempoResultado(Etapa E){
        double resultado=super.getTiempoResultado(E);
        if(resultado<160){
            this.serPopular=this.serPopular+4;
        }
        else{
            this.serPopular--;
        }
        return resultado;
    }
}
