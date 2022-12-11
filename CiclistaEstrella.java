
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

     /**
     * Devuelve la popularidad de un ciclista
     * 
     * @return popularidad del ciclista
     */
     public int getPopularidad(){
        return serPopular;
     }

     /**
     * Calcula la destreza de un cilista
     */
     @Override
     public void calcularDestreza(){
        super.setDestreza(((super.getHabilidad() + 6)/140)*10);    
     }

     /**
     * Devuelve true si nos encontramos ante el mismo ciclista y false en caso contrario.
     * 
     * @param c es el ciclista con el que queremos comparar
     * 
     * @return true si ambos ciclistas son el mismo
     */
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
    
     /**
     * devuelve un valor entero que representa de forma inequívoca a un ciclista.
     * 
     * @return el valor que representa al ciclista
     */
     @Override
     public int hashCode ()
     {
        int result = 17;
        
        result = 7 * result + super.hashCode();
        result = 13 * result + getPopularidad();
        return result;
     }

    /**
     * Añade a la cadena de caracteres el tipo de ciclista al que pertenece
     */
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

    /**
     * Transforma en una cadena de caracteres todos los datos de un ciclista.
     */
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
    public double tiempo(Etapa etp){
        double tiempo = super.tiempo(etp);
        
        if(tiempo<160){
            this.serPopular=this.serPopular+4;
         }
         else{
            this.serPopular--;
         }
         return tiempo;
    }
    // @Override
    // public double getTiempoResultado(Etapa E){
        // double resultado=super.getTiempoResultado(E);
        // if(resultado<160){
            // this.serPopular=this.serPopular+4;
        // }
        // else{
            // this.serPopular--;
        // }
        // return resultado;
    // }
}
