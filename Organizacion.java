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
    private ArrayList<Etapa> etapas;
    
    private ArrayList<Equipo> equipos;
    
    private ArrayList<Ciclista> ciclistas;
    
    private ArrayList<Ciclista> ciclistasAbandonados;
    
    Comparator<Etapa> compEtapa;
    
    Comparator<Equipo> compEquipo;
    
    Comparator<Ciclista> compCiclistasCarrera;
    
    boolean ordenEtapa;
    
    boolean ordenEquipo;
    
    boolean ordenCiclistas;
    

    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion()
    {
        // initialise instance variables
        etapas=new ArrayList<Etapa>();
        equipos=new ArrayList<Equipo>();
        ciclistas=new ArrayList<Ciclista>();
        ciclistasAbandonados=new ArrayList<Ciclista>();
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
        ciclistasAbandonados=new ArrayList<Ciclista>();
        compEtapa=ce;
    }
    
   
    public void setCompEquipo(Comparator<Equipo> ce, boolean oe){
         compEquipo=ce;
         ordenEquipo=oe;
    }
    
    public void setCompCiclistas(Comparator<Ciclista> c, boolean oc){
         compCiclistasCarrera=c;
         ordenCiclistas=oc;
    } 
    
        public void ordenarEtapas(){
         if(ordenEtapa==false){//false
        Collections.sort(etapas,compEtapa);
    }
        else{
        Collections.sort(etapas, Collections.reverseOrder(compEtapa));
    } 
    }
    
   
   
   
    private void ordenarCiclistas(){
        if(ordenCiclistas==false)//false
        Collections.sort(ciclistas, compCiclistasCarrera);
        else
        Collections.sort(ciclistas, Collections.reverseOrder(compCiclistasCarrera));
    
    }
    
    public void ordenarEquipos(){
         if(ordenEquipo)///true
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
       //setCompEquipo
       ordenarEquipos();
       setCompCiclistas(new ComparadorCiclistasTotalMinutosAcumulados(), true);
       ordenarCiclistas();
       mostrarEtapas();//for each llamando etapas
       mostrarEquipos();//for each llamando equipos //muestra los equipos y sus ciclistas
       hacerCarreras();
       mostrarClasificacionFinal();
   }
   
   private void hacerCarreras(){
       //mientras haya ciclistas para competir sigo
       
       //while(!ciclistas.isEmpty() || ciclistas.size()==1){   
      
       int numCarr = 1; ////////////////asegurar comparadores
       
       
       for(int index=0; index<etapas.size(); index++){
       Etapa e= etapas.get(index);
          cargarCiclistas();
          ordenarCiclistas();
           //etapas.remove(0);
          System.out.println("********************************************************************************************************");
           System.out.printf("*** " + "CARRERA<"+numCarr+"> EN ");
           e.mostrarEtapa();
           System.out.println(" ***");
           
           System.out.println("********************************************************************************************************");
           System.out.println("********************************************************************************************************");
           
           System.out.println("******************************** Ciclistas que van a competir en "+ e.getName()+" *******************************");
           System.out.println("********************************************************************************************************");
           
           mostrarCiclistas();
           
           System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
           System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " +e.getName() +" ++++++++++++++++++++++++++"); 
           System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
           correrCarrera(e);
           mostrarClasificacionCarrera(e);
           devolverCiclista();
           
       numCarr++;
       
       
           
       //recorrer etapas y traer ciclitas de cada equipo
       //para cada ciclista y mostrar resuktado estapa
       
       // mientras(){
           // obtener ciclistas a competir para cada ciclista:
           // ciclista.correr(etapa
           // mostrar resul etapa
           // devolver ciclistas a equipos)
       // }
    }
        
    
   }
   
   private void mostrarClasificacionCarrera(Etapa e){
       ArrayList<Resultados> resultados= new ArrayList<Resultados>();
       ArrayList<Resultados> resultadosAbandonos= new ArrayList<Resultados>();
       int pos=1;
       Resultados r=new Resultados();
       Ciclista c=new Ciclista();
       System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+e.getName() + " ++++++++++++++++++");
       System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       for (int i = 0; i<ciclistas.size(); i++){
           c=ciclistas.get(i);
           r=c.getResultado(e);
           if(c.abandono()==true){
           resultadosAbandonos.add(r);
        }
        else{
            resultados.add(r);
        }
        }
       Collections.sort(resultados, new compResultadosTiempo());
       for(Resultados res: resultados){
        
           double tiempoCiclista=Math.round((res.getCiclista().getTiempoResultado(e))*100d) / 100d;
           System.out.println("@@@ Posicion("+pos+") "+res.getCiclista().getName()+" - Tiempo: "+tiempoCiclista+" minutos @@@");
           pos++;
    
        }
       for(Resultados rAban: resultadosAbandonos){
            System.out.println("¡¡¡ Ha abandonado "+rAban.getCiclista().getName()+" - Tiempo: " + rAban.getCiclista().getEnergia()+ " Además ha abandonado para el resto del Campeonato");
       }
      
   }
   
   private void correrCarrera(Etapa e){
       int numCicl = 1;
        for (Ciclista c: ciclistas){
               System.out.println("@@@ "+ "ciclista "+ numCicl + " de "+ ciclistas.size());
               c.mostrarCiclista();
               System.out.printf("con bicicleta: ");
               c.getBicicleta().mostrarBicicleta();
               System.out.printf(" en etapa " + e.getName());
               double velocidad=Math.round((c.getBicicleta().calcularVelocidad(c, e))*100d) / 100d;
               double tiempo=Math.round((c.getBicicleta().calcularTiempoNecesario(c, e))*100d) / 100d;
               c.actualizarResultadoEnergia(e);
               double energia=Math.round((c.getEnergia())*100d) / 100d;
               System.out.println(" ");
               System.out.println("+++ Con estas condiciones el ciclista "+ c.getName()+ " con la bicicleta "+c.getBicicleta().getName()+" alcanza una velocidad de "+ velocidad +" km/hora +++");
               if(c.abandono()==true){
                   double tiempoEnCarrera=tiempo+energia;
                   System.out.println("¡¡¡ El ciclista " + c.getName() + " se quedó sin energia a falta de " + Math.abs(energia) +" minutos para terminar !!!");
                   System.out.println("¡¡¡ En el momento de quedarse sin energia llevaba en carrera "+ tiempoEnCarrera +" minutos !!!");
               }
               else{
               System.out.println("+++ "+ c.getName()+ " termina la etapa en "+ tiempo +" minutos ++");
               
            }
            System.out.println("+++ La energia del ciclista "+ c.getName()+" tras la carrera es "+ energia +" +++");
            System.out.println("@@@");
               numCicl++;
           }
           
           
        
       
   }
   
   private void mostrarClasificacionFinal(){
       System.out.println("****************************************************");
       System.out.println("**************** FIN DEL CAMPEONATO ****************");
       System.out.println("****************************************************");
       System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS **********");
       System.out.println("****************************************************");
       cargarCiclistas();
       setCompCiclistas(new ComparadorCiclistasTotalMinutosAcumulados(), false);
       ordenarCiclistas();
       int pos=1;
       for(Ciclista c: ciclistas){
           double tiempoTotal=Math.round((c.tiempoTotalAcumulado())*100d) / 100d;
           System.out.println("@@@ Posicion("+pos+"): " +c.getName()+ " -Tiempo Total: "+tiempoTotal+" @@@");
           c.mostrarResultadosCiclista();
           System.out.println(" ");
           pos++;
       }
       
       if(!ciclistasAbandonados.isEmpty()){
       System.out.println("****************************************************");
       System.out.println("********** CICLISTAS QUE ABANDONARON **********");
       System.out.println("****************************************************");
       for(Ciclista cAban: ciclistasAbandonados){
           double tiempoTotalAnulado=Math.round((cAban.tiempoTotalAcumulado())*100d) / 100d;
           System.out.println("--- ciclistas Abandonado: "+cAban.getName()+ " - Puntos Totales Anulados: "+ tiempoTotalAnulado + " ---");
           cAban.mostrarResultadosCiclista();
           System.out.println(" ");
           
       }
           
       }
       
       devolverCiclista();
       
       
       System.out.println("****************************************************");
       System.out.println("********** CLASIFICACIÓN FINAL DE EQUIPOS **********");
       System.out.println("****************************************************");
       setCompEquipo(new ComparadorEquipoTotalMinutosAcumulados(), true);
       ordenarEquipos();
       int posEquip=1;
       for (Equipo e: equipos){
           double tiempoMedia=Math.round((tiempoMedio(e))*100d)/100d;
           System.out.println("@@@ Posicion("+posEquip+ ") " +e.getName()+" con " +tiempoMedia+" minutos de media @@@");
           System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
           System.out.println("%%% "+ e.getName()+ " %%% Media Minutos de Ciclistas sin abandonar "+tiempoMedia+" %%%");
           System.out.println(" ");
           e.mostrarCiclistasEquipo();
           e.mostrarCiclistasAbandonados();
           System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
           posEquip++;
       }
       
       
       
   }
   
   public void anadirEtapa(Etapa e){
       etapas.add(e);
   }
   
   public void inscribirEquipo(Equipo eq){
       equipos.add(eq);
   }
   
   public void devolverCiclista(){
       int index=ciclistas.size();
       int index2=ciclistasAbandonados.size();
       for(int i=0; i<index; i++){
           Ciclista c = ciclistas.get(0);
           c.getEquipo().anadirCiclista(c); 
           c.getEquipo().anadirBicicleta(c.getBicicleta());
           ciclistas.remove(0);
       }
       for(int j=0; j<index2; j++){
           Ciclista c = ciclistasAbandonados.get(0);
           c.getEquipo().anadirCiclista(c); 
           c.getEquipo().anadirBicicleta(c.getBicicleta());
           ciclistasAbandonados.remove(0);
       }
       
   }
   
   public void obtenerCiclista(Equipo e){
       int index=e.getNumeroCiclistas();
       int index2=e.getNumeroCiclistasAbandonados();
       for(int i=0; i<index; i++){
           Ciclista c= e.enviarAEtapa();
           ciclistas.add(c);
       }
       for(int j=0; j<index2; j++){
           Ciclista c= e.enviarAEtapaAbandono();
           ciclistasAbandonados.add(c);
       }
       
   }
   
   private void cargarCiclistas(){
       if(ciclistas.isEmpty()){
       Equipo e= new Equipo();
       
       for(int i=0; i<equipos.size(); i++){
           e=equipos.get(i);
           obtenerCiclista(e);
       }  
     }
   }
   
    private void mostrarCiclistas(){
       for (Ciclista c: ciclistas){
           c.mostrarCiclista();
       }
   }
}
