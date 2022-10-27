import java.util.ArrayList;   
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   public void gestionarCampeonato(){
   // mostrarEtapas();//for each llamando etapas
   // mostrarEquipos();//for each llamando equipos
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
