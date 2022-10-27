import java.util.ArrayList;  
import java.util.Comparator;
import java.util.*; 
/**
 * Write a description of class Organizacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Organizacion
{
    // instance variables - replace the example below with your own
    private ArrayList<Etapa> etapas;
    
    private ArrayList<Equipo> equipos;
    
    private ArrayList<Ciclista> ciclistas;
    
    Comparator<Etapa> compEtapa;
    
    Comparator<Equipo> compEquipo;
    
    Comparator<Ciclista> compCiclistasCarrera;
    
    boolean ordenEtapa;
    
    boolean ordenEquipo;
    
    boolean ordenCiclistas;
    
    //listaEquipos;
    //listaEtapa;
    

    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion()
    {
        // initialise instance variables
        etapas=new ArrayList<Etapa>();
        equipos=new ArrayList<Equipo>();
        ciclistas=new ArrayList<Ciclista>();
    }
    
    
    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion(Comparator<Etapa> ce, boolean oe)
    {
        // initialise instance variables
        etapas=new ArrayList<Etapa>();
        equipos=new ArrayList<Equipo>();
        ciclistas=new ArrayList<Ciclista>();
        compEtapa=ce;
    }
    
   
    public void setCompEquipo(Comparator<Equipo> ce, boolean oe){
         compEquipo=ce;
         ordenEquipo=oe;
    }
    
    public void mostrarEquipos(){
        Equipo e=new Equipo();
        for(int i=0; i<equipos.size(); i++){
            e=equipos.get(i);
            double tiempoMedio=e.tiempoTotalAcumuladoCiclistas()/e.getNumeroCiclistas();
            System.out.printf("%%% " +e.getName()+" %%% "+"Media Minutos de Ciclistas sin abandonar "+tiempoMedio+" %%% ");
            e.mostrarCiclistasEquipo();
        }
    }
    

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   public void gestionarCampeonato(){
   // mostrarEtapas();//for each llamando etapas
   // mostrarEquipos();//for each llamando equipos //muestra los equipos y sus ciclistas
   // hacerCarreras();
   // mostrarClasificacionFinal();
   }
   
   private void hacerCarreras(){
       //mientras haya ciclistas para competir sigo
       //recorrer etapas y traer ciclitas de cada equipo
       //para cada ciclista y mostrar resuktado estapa
       
       // mientras(){
           // obtener ciclistas a competir para cada ciclista:
           // ciclista.correr(etapa
           // mostrar resul etapa
           // devolver ciclistas a equipos)
       // }
   }
   
   public void anadirEtapa(Etapa e){
       etapas.add(e);
   }
   
   public void devolverCiclista(){
       for(int i=0; i<ciclistas.size(); i++){
           Ciclista c = ciclistas.get(i);
           c.getEquipo().insertarCiclista(c);          
       }
   }
   
   public void obtenerCiclista(Equipo e){
       for(int i=0; i<e.getNumeroCiclistas(); i++){
           Ciclista c= e.enviarAEtapa();
           ciclistas.add(c);
       }
   }
    
}
