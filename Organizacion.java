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
 * Guarda la informacion de todo lo relacionado con las carreras que se van a correr
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
 */
public class Organizacion
{
    private TreeSet<Etapa> etapas;

    private List<Equipo> equipos;

    private Map<Ciclista, Equipo> ciclistasMap;
    private Map<Ciclista, Equipo> ciclistasAbandonadosMap;
    Comparator<Etapa> compEtapa;
    Comparator<Equipo> compEquipo;
    Comparator<Ciclista> compCiclistasCarrera;
    boolean ordenEquipo;
    boolean ordenCiclistas;
    /**
     * Constructor por defecto de la clase organización
     * 
     * @param etapas es una set de las etapas que se van a correr
     * @param equipos es una lista de los equipos que participan
     * @param ciclistasMap es un Mapa de los ciclistas que participan
     * @param ciclistasAbandonadosMap es un map de los ciclistas que no han podido terminar
     */
    public Organizacion()
    {
        etapas=new TreeSet<Etapa>();
        equipos=new ArrayList<Equipo>();
        ciclistasMap=new TreeMap<>();
        ciclistasAbandonadosMap=new TreeMap<>();
    }

    /**
     * Constructor parametrizado de la clase organización
     * 
     * @param etapas es un set de las etapas que se van a correr
     * @param equipos es una lista de los equipos que participan
     * @param ciclistasMap es un mapa de los ciclistas que participan
     * @param ciclistasAbandonadosMap es un mapa de los ciclistas que no han podido terminar
     * @param compEtapa guarda el comparador según el cual se ordenarán las etapas
     * @param ordenEtapa guarda el orden, ascendente o descendente de como se ordenaran las etapas
     */
    public Organizacion(Comparator<Etapa> ce)
    {

        etapas=new TreeSet<Etapa>(ce);
        equipos=new ArrayList<Equipo>();
        ciclistasMap=new TreeMap<>();
        ciclistasAbandonadosMap=new TreeMap<>();
        compEtapa=ce;

    }

    /**
     * Define de que forma se quieren ordenar los equipos
     * 
     * @param compEquipo guarda el comparador según el cual se ordenarán los equipos
     * @param ordenEquipo guarda el orden, ascendente o descendente de como se ordenaran los equipos
     */
    public void setCompEquipo(Comparator<Equipo> ce, boolean oe){
        compEquipo=ce;
        ordenEquipo=oe;
    }

    /** 
     * Define de que forma se quieren ordenar los ciclistas
     * 
     * @param compCiclistasCarrera guarda el comparador según el cual se ordenarán los ciclistas
     * @param ordenCiclistas guarda el orden, ascendente o descendente de como se ordenaran los ciclistas
     */
    public void setCompCiclistas(Comparator<Ciclista> c, boolean oc){
        compCiclistasCarrera=c;
        ordenCiclistas=oc;
    } 

    /**
     * Ordena los ciclistas según el comparador que se haya definido
     */
    private void ordenarCiclistas(){
        if(ordenCiclistas==false){ 
            TreeMap<Ciclista, Equipo> sorted = new TreeMap<Ciclista, Equipo>(compCiclistasCarrera);

            sorted.putAll(ciclistasMap);
            ciclistasMap=sorted;

        }
        else{
            TreeMap<Ciclista, Equipo> sorted = new TreeMap<Ciclista, Equipo>(Collections.reverseOrder(compCiclistasCarrera));

            sorted.putAll(ciclistasMap);
            ciclistasMap=sorted;

        }

    }

    /**
     * Ordena los ciclistas que han abandonado según el comparador que se haya definido
     */
    private void ordenarCiclistasAbandonados(){

        if(ordenCiclistas==false){
            TreeMap<Ciclista, Equipo> sorted = new TreeMap<Ciclista, Equipo>(compCiclistasCarrera);

            sorted.putAll(ciclistasAbandonadosMap);
            ciclistasAbandonadosMap=sorted;
        }
        else{
            TreeMap<Ciclista, Equipo> sorted = new TreeMap<Ciclista, Equipo>(Collections.reverseOrder(compCiclistasCarrera));

            sorted.putAll(ciclistasAbandonadosMap);
            ciclistasAbandonadosMap=sorted;
        }

    }

    /**
     * Ordena los equipos según el comparador que se haya definido
     */
    public void ordenarEquipos(){
        if(ordenEquipo){
            Collections.sort(equipos, compEquipo);
        }
        else{
            Collections.sort(equipos, Collections.reverseOrder(compEquipo));
        }

    }

    /**
     * Muestra por pantalla el nombre de cada equipo y la media de minutos de sus ciclistas sin abandonar
     */
    public void mostrarEquipos(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        for (Equipo e: equipos){ 
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% " + e.getName()+" %%% "+"Media Minutos de Ciclistas sin abandonar "+ e.tiempoMedio() +" %%% ");
            System.out.println(" ");
            e.mostrarCiclistasEquipo();
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    /**
     * Muestra por pantalla cada etapa y su información
     */
    public void mostrarEtapas(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Etapa e: etapas){ 
            System.out.println(e);
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    /**
     * Permite llevar a cabo tadas las carreras y mostrar su clasificación
     */
    public void gestionarCampeonato(){
        ordenarEquipos();
        setCompCiclistas(new ComparadorCiclistasTotalMinutosAcumulados(), true);
        ordenarCiclistas();
        mostrarEtapas();
        mostrarEquipos();
        hacerCarreras();
        mostrarClasificacionFinal();
    }

    /**
     * Muestra los ciclistas que van a correr en una etapa, actualiza la energía de los ciclistas y muestra la classificación
     */
    private void hacerCarreras(){
        int numCarr = 1; 
        Iterator<Etapa> iteradorEtapas= etapas.iterator();
        int index=0;

        while(iteradorEtapas.hasNext()){

            Etapa e= iteradorEtapas.next();

            cargarCiclistas();
            ordenarCiclistas();

            System.out.println("********************************************************************************************************");
            System.out.printf("*** " + "CARRERA<"+numCarr+"> EN ");
            System.out.println(e);

            System.out.println("***");

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
            index++;
            numCarr++;
        }
    }

    /**
     * Muestra la clasificación de cada carrera o etapa, mostrando también los ciclistas que han abandonado la competición
     * 
     * @param e es la etapa o carrera de la que se muestra su clasificación tras correrla
     */
    private void mostrarClasificacionCarrera(Etapa e){
        ArrayList<Resultados> resultados= new ArrayList<Resultados>();
        ArrayList<Resultados> resultadosAbandonos= new ArrayList<Resultados>();
        int pos=1;
        Resultados r=new Resultados();
        Ciclista c=null;
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+e.getName() + " ++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (Map.Entry<Ciclista, Equipo> entry: ciclistasMap.entrySet()){ //int i = 0; i<ciclistasMap.size(); i++
            c=entry.getKey();
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
            double energiaAban=Math.round((rAban.getCiclista().getEnergia())*100d) / 100d;
            System.out.println("¡¡¡ Ha abandonado "+rAban.getCiclista().getName()+" - Tiempo: " + energiaAban + " Además ha abandonado para el resto del Campeonato !!!");
        }

    }

    /**
     * Se corre la carrera y se actualiza la información de los ciclistas y equipos que han participado en ella
     * 
     * @param e es la etapa o carrera que se va a correr
     */
    private void correrCarrera(Etapa e){
        int numCicl = 1;
        for (Map.Entry<Ciclista, Equipo> entry: ciclistasMap.entrySet()){//Ciclista c: ciclistas){
            Ciclista c=entry.getKey();
            System.out.println("@@@ "+ "ciclista "+ numCicl + " de "+ ciclistasMap.size());
            System.out.print(c);
            System.out.printf(" con bicicleta: ");
            System.out.printf("\n");
            System.out.print(c.getBicicleta());
            System.out.printf("en etapa " + e.getName());
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
                System.out.println("+++ "+ c.getName()+ " termina la etapa en "+ tiempo +" minutos +++");

            }
            System.out.println("+++ La energía del ciclista "+ c.getName()+" tras la carrera es "+ energia +" +++");
            System.out.println("@@@");

            if(c.getClass() ==  new CiclistaEstrella().getClass()){ 
                CiclistaEstrella ce = (CiclistaEstrella) c;
                if(tiempo<160){
                    System.out.println("+++ La popularidad del ciclista " + c.getName() +" ha aumentado y ahora su nivel de popularidad es de: " + ce.getPopularidad() +" unidades");
                }
                else{
                    System.out.println("--- La popularidad del ciclista " + c.getName() +" ha disminuido y ahora su nivel de popularidad es de: " + ce.getPopularidad() +" unidades");
                }
                System.out.println("@@@");
            }
            numCicl++;
        }

    }

    /**
     * Muestra por pantalla la clasificación final del campeonato después de que este haya concluido y los ciclistas que han abandonado la competición
     */
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
        for(Map.Entry<Ciclista, Equipo> entry: ciclistasMap.entrySet()){//(Ciclista c: ciclistas)
            Ciclista c=entry.getKey();
            double tiempoTotal=Math.round((c.tiempoTotalAcumulado())*100d) / 100d;
            System.out.println("@@@ Posición("+pos+"): " +c.getName()+ " -Tiempo Total: "+tiempoTotal+" @@@");
            c.mostrarResultadosCiclista();
            System.out.println(" ");
            pos++;
        }

        if(!(ciclistasAbandonadosMap.isEmpty())){
            System.out.println("****************************************************");
            System.out.println("********** CICLISTAS QUE ABANDONARON **********");
            System.out.println("****************************************************");
            ordenarCiclistasAbandonados();
            for(Map.Entry<Ciclista, Equipo> entry: ciclistasAbandonadosMap.entrySet()){
                double tiempoTotalAnulado=Math.round((entry.getKey().tiempoTotalAcumulado())*100d) / 100d;
                System.out.println("--- ciclistas Abandonado: "+entry.getKey().getName()+ " - Puntos Totales Anulados: "+ tiempoTotalAnulado + " ---");
                entry.getKey().mostrarResultadosCiclista();
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
            double tiempoMedia=Math.round((e.tiempoMedio())*100d)/100d;
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

    /**
     * Añade una etapa al campeonato
     * 
     * @param e es la etapa o carrera que se quiere añadir
     */
    public void anadirEtapa(Etapa e){
        etapas.add(e);
    }

    /**
     * Añade un equipo al campeonato
     * 
     * @param eq es el equipo que se quiere añadir
     */
    public void inscribirEquipo(Equipo eq){
        equipos.add(eq);
    }

    /**
     * Devuelve un ciclista a un equipo después de que haya corrido la carrera con la información actualizada si su energía es mayor que 0
     */
    public void devolverCiclista(){

        for(Map.Entry<Ciclista, Equipo> entry: ciclistasMap.entrySet()){
            entry.getValue().anadirCiclista(entry.getKey());

            entry.getValue().anadirBicicleta(entry.getKey().getBicicleta());

        }

        for(Map.Entry<Ciclista, Equipo> entry: ciclistasAbandonadosMap.entrySet()){
            entry.getValue().anadirCiclista(entry.getKey()); 
            entry.getValue().anadirBicicleta(entry.getKey().getBicicleta());

        }
        ciclistasMap.clear();
        ciclistasAbandonadosMap.clear();
    }

    /**
     * Obtiene los ciclistas de cada equipo y los agrega a la organizacion.
     * 
     * @param e es el equipo del que se envía un ciclista
     */
    public void obtenerCiclista(Equipo e){
        int index=e.getNumeroCiclistas();
        int index2=e.getNumeroCiclistasAbandonados();
        for(int i=0; i<index; i++){
            Ciclista c= e.enviarAEtapa();
            ciclistasMap.put(c, e);
        }
        for(int j=0; j<index2; j++){
            if(ciclistasAbandonadosMap.isEmpty()){
                ordenarCiclistasAbandonados();
            }
            Ciclista c= e.enviarAEtapaAbandono();
            ciclistasAbandonadosMap.put(c, e);
        }

    }

    /**
     * Carga los ciclistas de todos los equipos en la organización
     */
    private void cargarCiclistas(){
        if(ciclistasMap.isEmpty()){
            Equipo e= new Equipo();

            for(int i=0; i<equipos.size(); i++){
                e=equipos.get(i);
                obtenerCiclista(e);
            }  
        }
    }

    /**
     * Muestra todos los ciclistas que hay en la organización
     */
    private void mostrarCiclistas(){
        for (Map.Entry<Ciclista, Equipo> entry: ciclistasMap.entrySet()){//Ciclista c: ciclistas){
            Ciclista c=entry.getKey();
            System.out.println(c);
        }
    }
}
