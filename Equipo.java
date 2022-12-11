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
 * Guarda la informacion del equipo: ciclistas que le pertenecen, ciclistas que abandonan y
 * bicicletas que abandonan
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Equipo
{  
    private String nombre;
    
    //private Map<Ciclista,Bicicleta> ciclistasEquipoBicicletas;
    
    //private Map<Ciclista,Bicicleta> ciclistasEquipoBicicletasAbandono;
    
    private ArrayList<Ciclista> ciclistasEquipo;
    
    private ArrayList<Ciclista> ciclistasAbandonado;
    
    private ArrayList<Bicicleta> bicicletasEquipo;  
    
    Comparator<Ciclista> compCiclista;
    Comparator<Bicicleta> compBicicleta;
    boolean ordenCiclista;
    boolean ordenBicicleta;

    /**
     * Constructor de objetos de la clase equipo
     * Crea una nuevo equipo con valores por defecto
     * 
     * @param nombre es el nombre del equipo
     * @param ciclistasEquipo es una lista con los ciclistas que pertenecen al equipo
     * @param ciclistasAbandonado es una lista con los ciclistas que de un equipo que abandonaron 
     * @param bicicletasEquipo es una lista de las bicicletas que pertenecen al equipo
     */
    public Equipo()
    {
        nombre=" ";
        
        // ciclistasEquipoBicicletas=new TreeMap<>();
        // ciclistasEquipoBicicletasAbandono=new TreeMap<>();
        ciclistasEquipo = new ArrayList<Ciclista>();
        ciclistasAbandonado= new ArrayList<Ciclista>();
        bicicletasEquipo= new ArrayList<Bicicleta>();
    }
    
    
    /** Constructor parametrizado de objetos de la clase Equipo
     * Crea un nuevo equipo inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre del equipo
     * @param ciclistasEquipo es una lista con los ciclistas que pertenecen al equipo
     * @param ciclistasAbandonado es una lista con los ciclistas que de un equipo que abandonaron 
     * @param bicicletasEquipo es una lista de las bicicletas que pertenecen al equipo
     * @param cc es el comparador de ciclistas
     * @param oc es el booleano que indica si los ciclistas se ordenan ascendente o descendentemente
     * @param cb es el comparador de bicicletas
     * @param ob es el booleano que indica si las bicicletas se ordenan ascendente o descendentemente
     *
     */
     
    public Equipo(String nombre, Comparator<Ciclista> cc, boolean oc, Comparator<Bicicleta> cb, boolean ob){
         this.nombre=nombre;
         // if(oc){
         // ciclistasEquipoBicicletas=new TreeMap<>(cc);
        // }
        // else{
          // ciclistasEquipoBicicletas=new TreeMap<>(Collections.reverseOrder(cc));
        // }
        

        // ciclistasEquipoBicicletasAbandono=null;
        ciclistasEquipo = new ArrayList<Ciclista>();
        ciclistasAbandonado= new ArrayList<Ciclista>();
        bicicletasEquipo= new ArrayList<Bicicleta>();
        compCiclista=cc;
        ordenCiclista=oc;
        compBicicleta=cb;
        ordenBicicleta=ob;
    }
    

    /**
     * Devuelve el valor del campo nombre
     * 
     * @return nombre del equipo 
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
     * Devuelve true si nos encontramos ante el mismo equipo y false en caso contrario.
     * 
     * @param eq es el equipo con el que queremos comparar
     * 
     * @return true si ambos equipos son el mismo
     */
    public boolean equals (Equipo eq) {
        if (this == eq) {
            return true;
        }
        
        if (! (eq instanceof Equipo)) {
            return false; 
        }
        
        Equipo other = (Equipo) eq;
        
        return (getName()==other.getName());
    }
    
    /**
     * devuelve un valor entero que representa de forma inequívoca a un equipo.
     * 
     * @return el valor que representa al equipo
     */
    @Override
    public int hashCode ()
     {
        int result = 17;
        result = 7 * result + getName().hashCode();
        
        return result;
     }
    
    /**
     * Añade una bicicleta a la lista de bicicletas de un equipo
     * 
     * @param  b es la bicicleta que se quiere añadir
     */
    public void anadirBicicleta(Bicicleta b){
        bicicletasEquipo.add(b);
        ordenarBicicletas();
    }

    /**
     * Ordena los ciclistas del equipo (se ordenará por el campo comparador al que se llame)
     * 
     */
    public void ordenarCiclistas()
    {
       if(ordenCiclista){
       // ciclistasEquipoBicicletas=new TreeMap<>(compCiclista);
       // ciclistasEquipoBicicletasAbandono=new TreeMap<>();
        Collections.sort(ciclistasEquipo, compCiclista);
    }
        else{
        Collections.sort(ciclistasEquipo, Collections.reverseOrder(compCiclista));
    }
    }    
    
    /**
     * Ordena las bicicletas del equipo (se ordenará por el campo comparador al que se llame)
     * 
     */
    public void ordenarBicicletas()
    {
       if(ordenBicicleta)
        Collections.sort(bicicletasEquipo,compBicicleta);
        else
        Collections.sort(bicicletasEquipo, Collections.reverseOrder(compBicicleta));
    }
    
    /**
     * Calcula el tiempo acumulado de los ciclistas de un equipo
     * 
     * @return suma de los tiempos de los ciclistas de los equipos
     */
    public double tiempoTotalAcumuladoCiclistas(){
        int index=0;   
        double tiempoTotal=0;
        while(index<ciclistasEquipo.size()){
            Ciclista ciclista=ciclistasEquipo.get(index);
            tiempoTotal = tiempoTotal + ciclista.tiempoTotalAcumulado();
            index++;
        }
        return tiempoTotal;
    }
    
     /**
     * Envía a una etapa el primer ciclista de la lista del equipo con la primera bicileta y lo elimina de la lista
     * 
     * @return ciclista con bicicleta
     */
    public Ciclista enviarAEtapa(){
        Ciclista c=null; 
        if(!ciclistasEquipo.isEmpty()){
        c=ciclistasEquipo.get(0);
        asignarBici(c);
        ciclistasEquipo.remove (0);
        }
        return c;
        
    }
    
    
     /**
     * Envía a una etapa el primer ciclista de la lista de ciclistas que han abandonado
     * y lo elimina de la lista
     * 
     * @return ciclista que haya abandonado
     */
    public Ciclista enviarAEtapaAbandono(){
        Ciclista c=null;
        if(!ciclistasAbandonado.isEmpty()){
        c=ciclistasAbandonado.get(0);  
        ciclistasAbandonado.remove(0);
    }
     return c;
    } 
    
    /**
     * Añade un ciclista a un equipo
     */
    public void anadirCiclista(Ciclista c){
        if(c.getEnergia()>0){
            ciclistasEquipo.add(c);
            //ciclistasEquipoBicicletas.put(c, null);
        }
        else{
            //ciclistasEquipoBicicletasAbandono.put(c, null);
            ciclistasAbandonado.add(c);
        }
        
        ordenarCiclistas();
    }
  
    /**
     * Asigna la primera bicicleta de la lista de bicicletas de un equipo a un ciclista
     * 
     * @param c es el ciclista al que se le va a asignar la bicileta
     */
    private void asignarBici(Ciclista c){
        if(!bicicletasEquipo.isEmpty()){
           c.setBicicleta(bicicletasEquipo.get(0));
           bicicletasEquipo.remove(0);
    }
    }
    
    /**
     * Calcula el numero de ciclistas de un equipo
     * 
     * @return numero de ciclistas de un equipo
     */
    public int getNumeroCiclistas(){
        return ciclistasEquipo.size();
    }
    
    /**
     * Calcula el numero de ciclistas que han abandonado
     * 
     * @return numero de ciclistas que han abandonada
     */
     public int getNumeroCiclistasAbandonados(){
        return ciclistasAbandonado.size();
    }
    
    /**
     * Muestra cada uno de los ciclistas pertenecientes a un equipo
     */
    public void mostrarCiclistasEquipo(){
        Ciclista c=null;
        for(int i=0; i<ciclistasEquipo.size(); i++){
            c=ciclistasEquipo.get(i);
            System.out.println(c);
            //c.mostrarCiclista();
        }

    }
    
    /**
     * Muestra cada uno de los ciclistas que hayan abandonado.
     */
    public void mostrarCiclistasAbandonados(){
        Ciclista c=null;
        for(int i=0; i<ciclistasAbandonado.size(); i++){
            c=ciclistasAbandonado.get(i);
             System.out.println(c);
            //c.mostrarCiclista();
        }

    }
    
    /**
     * Calcula la media de minutos sin abandonar de los ciclistas de un equipo
     * 
     * @param e es el equipo del que se quiere calcular
     * 
     * @return el resultado de calcular la media de minutos sin abandonar de los ciclistas de un equipo
     */
    public double tiempoMedio(){
        double tMedio=0;
        if(getNumeroCiclistas()!=0){
            tMedio=tiempoTotalAcumuladoCiclistas()/getNumeroCiclistas();
        }
        return tMedio;
    }

}