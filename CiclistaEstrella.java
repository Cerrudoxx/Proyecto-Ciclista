
/**
 * Guarda la informacion del nombre, la bicicleta, la habilidad, la energía,
 * los resultados, el equipo y la popularidad de la clase ciclistaEstrella
 * 
 * 
 */
public class CiclistaEstrella extends Ciclista
{
  
    private int serPopular;

   /***
     * Constructor de objetos de la clase CiclistaEstrella
     * Crea un nuevo ciclistaEstrella inicializando con parametros por defecto
     */
    public CiclistaEstrella()
    {

        serPopular=6;
    }

      /**
     * Constructor parametrizado de objetos de la clase CiclistaEstrella
     * Crea un nuevo ciclistaEstrella inicializando con parametros pasados como parametros
     * 
     * @param nombre es el nombre del ciclista
     * @param habilidad es la habilidad del ciclista
     * @param energia es la energía restante del ciclista
     * @param resultado es el resultado del ciclista
     * @param equipo es el equipo al que pertenece el ciclista
     * @param serPopular es la popularidad del ciclista
     * 
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

    /**
     * Calcula el tiempo que tarda un ciclista en una etapa y actualiza la popularidad
     * 
     * @param etp es la etapa de la que se quiere obtener el tiempo necesario
     */
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
    
}
