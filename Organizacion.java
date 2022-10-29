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
    
    public void ordenarEquipos(){
         if(ordenEquipo==false)
        Collections.sort(equipos, compEquipo);
        else
        Collections.sort(equipos, Collections.reverseOrder(compEquipo));
    }
    
    
    
    public void mostrarEquipos(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
       
        for (Equipo e: equipos){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% " + e.getName()+" %%% "+"Media Minutos de Ciclistas sin abandonar "+ tiempoMedio(e) +" %%% ");
            System.out.println(" ");
            e.mostrarCiclistasEquipo();
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
    
    public void mostrarEtapas(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Etapa e: etapas){ 
            e.mostrarEtapa();
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    
    public void ordenarEtapas(){
         if(ordenEtapa==false)
        Collections.sort(etapas,compEtapa);
        else
        Collections.sort(etapas, Collections.reverseOrder(compEtapa));
    }
    
    
    private double tiempoMedio(Equipo e){
        double tMedio=0;
        if(e.getNumeroCiclistas()!=0){
        tMedio=e.tiempoTotalAcumuladoCiclistas()/e.getNumeroCiclistas();
        }
        return tMedio;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   public void gestionarCampeonato(){
   ordenarEtapas();
   setCompEquipo(new ComparadorEquipoNombre(), false);
   ordenarEquipos();
   mostrarEtapas();//for each llamando etapas
   mostrarEquipos();//for each llamando equipos //muestra los equipos y sus ciclistas
   hacerCarreras();
   // mostrarClasificacionFinal();
   }
   
   private void hacerCarreras(){
       //mientras haya ciclistas para competir sigo
        Etapa e= etapas.get(0);
           etapas.remove(0);
           //obtenerCiclista(eq);
       while(!ciclistas.isEmpty() || ciclistas.size()==1){
          
           for (Equipo eq: equipos){
               
               for(int i=0; i<ciclistas.size(); i++){
               Ciclista c=ciclistas.get(i);
               c.actualizarResultadoEnergia(e);
            }
            devolverCiclista();
            }
       }
       //recorrer etapas y traer ciclitas de cada equipo
       //para cada ciclista y mostrar resuktado estapa
       
       // mientras(){
           // obtener ciclistas a competir para cada ciclista:
           // ciclista.correr(etapa
           // mostrar resul etapa
           // devolver ciclistas a equipos)
       // }
   }
   
   private void mostrarClasificacionFinal(){
       
   }
   
   public void anadirEtapa(Etapa e){
       etapas.add(e);
   }
   
   public void inscribirEquipo(Equipo eq){
       equipos.add(eq);
   }
   
   public void devolverCiclista(){
       for(int i=0; i<ciclistas.size(); i++){
           Ciclista c = ciclistas.get(i);
           c.getEquipo().anadirCiclista(c);          
       }
   }
   
   public void obtenerCiclista(Equipo e){
       for(int i=0; i<e.getNumeroCiclistas(); i++){
           Ciclista c= e.enviarAEtapa();
           ciclistas.add(c);
       }
   }
    
}
