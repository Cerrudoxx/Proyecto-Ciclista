import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

/**
 * Guarda la informacion del nombre y el peso de la bicicleta 
 * etapa
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Equipo
{  
    // instance variables - replace the example below with your own
    private String nombre;
    
    private ArrayList<Ciclista> ciclistasEquipo;
    
    private ArrayList<Ciclista> ciclistasAbandonado;
    
    private ArrayList<Bicicleta> bicicletasEquipo;  
    
    Comparator<Ciclista> compCiclista;
    Comparator<Bicicleta> compBicicleta;
    boolean ordenCiclista;
    boolean ordenBicicleta;

    /**
     * Constructor de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros por defecto
     */
    public Equipo()
    {
        // initialise instance variables
        nombre=" ";
        ciclistasEquipo = new ArrayList<Ciclista>();
        ciclistasAbandonado= new ArrayList<Ciclista>();
        bicicletasEquipo= new ArrayList<Bicicleta>();
        
        
       
    }
    
    
    /** Constructor parametrizado de objetos de la clase Bicicleta
     * Crea una nueva bicicleta inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre de la bicicleta
     * @param peso es el peso (en kg) de la bicicleta 
     *
     *
     */
     
    public Equipo(String nombre, Comparator<Ciclista> cc, boolean oc, Comparator<Bicicleta> cb, boolean ob){
         this.nombre=nombre;
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
     * @return     nombre de la bicicleta 
     */
    public String getName()
    {
        // put your code here
        return nombre;
        
    }
    
    /**
     * Establece el valor del campo nombre al dado como entrada
     * 
     * @param  nombre es el nuevo valor del campo nombre
     */
    public void setName(String nombre)
    {
        // put your code here
        this.nombre=nombre;
        
    }
    
    public void anadirBicicleta(Bicicleta b){
        bicicletasEquipo.add(b);
    }

    public void ordenarCiclistas()
    {
       if(ordenCiclista)
        Collections.sort(ciclistasEquipo,compCiclista);
        else
        Collections.sort(ciclistasEquipo, Collections.reverseOrder(compCiclista));
    }
    
    public void ordenarBicicletas()
    {
       if(ordenBicicleta==false)
        Collections.sort(bicicletasEquipo,compBicicleta);
        else
        Collections.sort(bicicletasEquipo, Collections.reverseOrder(compBicicleta));
    }
    
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
    

    public Ciclista enviarAEtapa(){
        Ciclista c=new Ciclista();
        if(!ciclistasEquipo.isEmpty()){
        c=ciclistasEquipo.get(0);
        asignarBici(c);
        ciclistasEquipo.remove (0);
        }
        return c;
        
    }
    
    public void anadirCiclista(Ciclista c){
        if(c.getEnergia()>0){
            ciclistasEquipo.add(c);
        }
        else{
            ciclistasAbandonado.add(c);
        }
    }
  
    private void asignarBici(Ciclista c){
        if(!bicicletasEquipo.isEmpty()){
        c.setBicicleta(bicicletasEquipo.get(0));
    }
    }
    
    
    
    public int getNumeroCiclistas(){
        return ciclistasEquipo.size();
    }
    
    public void mostrarCiclistasEquipo(){
        Ciclista c= new Ciclista();
        for(int i=0; i<ciclistasEquipo.size(); i++){
            c=ciclistasEquipo.get(i);
            c.mostrarCiclista();
        }

    }
    /**
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la bicicleta 
     
    public String getCiclistasEquipo()
    {
        // put your code here
        return ciclistasEquipo.getName();
        
    }
    
    /**
     * Establece el valor del campo nombre al dado como entrada
     * 
     * @param  nombre es el nuevo valor del campo nombre
    
    public void setCiclistaEquipo(Ciclista CiclistaEquipo)
    {
        // put your code here
        this.ciclistasEquipo=CiclistaEquipo;
        
    } */
    
    
}