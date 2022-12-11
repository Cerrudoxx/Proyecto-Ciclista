import java.util.ArrayList;  
import java.util.Comparator;
import java.util.*; 
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Guarda la informacion del nombre, la dificultad y la distancia de la clase 
 * etapa
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
 */
public class Etapa
{  
    private String nombre;

    private Dificultad dificultad;

    private Distancia distancia;

    private double tiempoCiclista;

    /**
     * Constructor de objetos de la clase Etapa
     * Crea una nueva etapa inicializando con parametros por defecto
     * 
     * @param nombre es el nombre de la etapa
     * @param dificultad es la dificultad de la etapa
     * @param distancia es la distancia en kilometros de la etapa
     */
    public Etapa()
    {
        nombre=" ";
        dificultad=null;
        distancia=null;

    }

    /**
     * Constructor parametrizado de objetos de la clase Etapa
     * Crea una nueva etapa inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la etapa
     * @param dificultad es la dificultad de la etapa
     * @param distancia es la distancia en kilometros de la etapa
     * 
     */
    public Etapa(String nombre, Dificultad dificultad, Distancia distancia){
        this.nombre=nombre;
        setDificultad(dificultad);
        setDistancia(distancia);
    }

    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la etapa 
     */
    public String getName()
    {
        return nombre;

    }

    /**
     * Establece el valor del campo nombre al dado como entrada
     * 
     * @param  nombre es el nuevo valor del campo nombre
     */
    public void setName(String nombre)
    {
        this.nombre=nombre;

    }

    /**
     * Devuelve el valor del campo dificultad
     * 
     * @return     dificultad de la etapa 
     */
    public double getDificultad()
    {
        return dificultad.getValor();

    }

    /**
     * Devuelve el valor numerico del campo dificultad
     * 
     * @return     dificultad de la etapa 
     */
    public Dificultad getCampoDificultad()
    {
        return dificultad;

    }

    /**
     * Establece el valor del campo dificultad al dado como entrada
     * 
     * @param  dificultad es el nuevo valor del campo dificultad
     */
    public void setDificultad(Dificultad dificultad)
    {
        this.dificultad=dificultad;

    }

    /**
     * Devuelve el valor del campo distancia
     * 
     * @return     distancia de la etapa 
     */
    public double getDistancia()
    {
        return distancia.getValor();

    }

    /**
     * Devuelve el valor numerico del campo distancia
     * 
     * @return     distancia de la etapa 
     */
    public Distancia getCampoDistancia()
    {
        return distancia;

    }

    /**
     * Establece el valor del campo distancia al dado como entrada
     * 
     * @param  distancia es el nuevo valor del campo nombre
     */
    public void setDistancia(Distancia distancia)
    {
        this.distancia=distancia;

    }

    /**
     * Devuelve true si nos encontramos ante la misma etapa y false en caso contrario.
     * 
     * @param e es la etapa con la que queremos comparar
     * 
     * @return true si ambas etapas son la misma
     */
    public boolean equals (Etapa e) {
        if (this == e) {
            return true;
        }

        if (! (e instanceof Etapa)) {
            return false; 
        }

        Etapa other = (Etapa) e;

        return (getName().equals(other.getName()) &&
            getDificultad()==other.getDificultad() &&
            getDistancia()==other.getDistancia());
    }

    /**
     * devuelve un valor entero que representa de forma inequívoca a una etapa.
     * 
     * @return el valor que representa a la etapa
     */
    @Override
    public int hashCode ()
    {
        int result = 17;
        result = 7 * result + getName().hashCode();
        result = 13 * result + (int) getDificultad();
        result = 19 * result + (int) getDistancia();
        return result;
    }

    /**
     * Transforma en una cadena de caracteres todos los datos de una etapa.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("<etapa:");
        builder.append(getName());
        builder.append("> ");
        builder.append(getCampoDificultad());
        builder.append(" ");
        builder.append(getCampoDistancia());


        return builder.toString();
    }

}
