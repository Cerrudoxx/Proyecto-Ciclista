import java.util.ArrayList;
import java.util.ArrayList;
/** Guarda la informacion del nombre, la bicicleta, la habilidad, la energía,
 * los resultados y el equipo de la clase ciclista
 *
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public abstract class Ciclista
{
    
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private ArrayList<Resultados> resultado;
    private Equipo equipo;
    private boolean abandono;
    private double destreza;
    

    /**
     * Constructor de objetos de la clase Ciclista
     * Crea un nuevo ciclissta inicializando con parametros por defecto
     */
    public Ciclista()
    {        
        nombre=" ";
        bicicleta=null;
        habilidad=null;
        energia=0;
        this.resultado=new ArrayList<Resultados>();
        abandono=false;
        destreza=0;
    }
    
    /**
     * Constructor parametrizado de objetos de la clase Ciclista
     * Crea un nuevo ciclista inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre del ciclista
     * @param habilidad es la habilidad del ciclista
     * @param energia es la energía restante del ciclista
     * @param resultado es el resultado del ciclista
     * @param equipo es el equipo al que pertenece el ciclista
     * 
     */
    public Ciclista(String nombre, Habilidad habilidad, double energia, Equipo e)//
    {        
        this.nombre=nombre;
        this.habilidad=habilidad;
        this.energia=energia;
        this.resultado=new ArrayList<Resultados>();
        this.abandono=false;
       this.equipo=e;
        this.destreza=0;
    }
    
    /**
     * Constructor parametrizado de objetos de la clase Ciclista
     * Crea un nuevo ciclista inicializando con parametros pasados por teclado incluyendo la bicicleta
     * 
     * @param nombre es el nombre del ciclista
     * @param bicicleta es la bicicleta asignada al ciclista
     * @param habilidad es la habilidad del ciclista
     * @param energia es la energía restante del ciclista
     * @param resultado es el resultado del ciclista
     * @param equipo es el equipo al que pertenece el ciclista
     * 
     */
    public Ciclista(String nombre, Bicicleta bicicleta, Habilidad habilidad, double energia, Equipo e)
    {        
        this.nombre=nombre;
        this.bicicleta=bicicleta;
        setHabilidad(habilidad);
        this.energia=energia;
        this.resultado=new ArrayList<Resultados>();
        this.abandono=false;
        this.equipo=e;
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
     * Devuelve el valor del campo nombre
     * 
     * @return     nombre de la etapa 
     */
    public String getName()
    {
        return nombre; 
    }
    
    /**
     * Establece el valor del campo habilidad al dado como entrada
     * 
     * @param  habilidad es el nuevo valor del campo habilidad
     */
    public void setHabilidad(Habilidad habilidad)
    {  
       this.habilidad=habilidad; 
    }
    
     /**
     * Devuelve el valor del campo habilidad
     * 
     * @return   habilidad del ciclista
     */
    public double getHabilidad()
    { 
        return habilidad.getValor(); 
    }
    
    /**
     * Devuelve el valor numerico del campo habilidad
     * 
     * @return     habilidad del ciclista
     */
    public Habilidad getCampoHabilidad()
    {
        return habilidad;
        
    }
    
    public double getDestreza(){
        return destreza;
    }
    
    public void setDestreza(double d){
        destreza=d;
    }
    
    /**
     * Establece el valor del campo energia al dado como entrada
     * 
     * @param  energia es el nuevo valor del campo energia
     */
     public void setEnergia(double energia)
    {
        this.energia=energia;
    }
    
    /**
     * Devuelve el valor del campo energia
     * 
     * @return     energía restante
     */
    public double getEnergia()
    {  
        return energia;  
    }
    
    /**
     * Establece el valor del campo bicicleta al dado como entrada
     * 
     * @param  bicicleta es el nuevo valor del campo bicicleta
     */
     public void setBicicleta(Bicicleta bicicleta)
    {
        this.bicicleta=bicicleta;
    }
    
    /**
     * Devuelve el valor del campo bicicleta, en caso de estar vacia muestra un mensaje de error.
     * 
     * @return     bicicleta del ciclista
     */
    public Bicicleta getBicicleta()
    {
        if(bicicleta==null){
            System.out.println("El ciclista no tiene bicicleta asignada");
        }
        return bicicleta;
        
    }
    
       /** * Establece el valor del campo equipo al dado como entrada
     * 
     * @param  equipo es el nuevo valor del campo equipo
     */
     public void setEquipo(Equipo equipo)
    {
        
        this.equipo=equipo;
        
    }
    
    /**
     * Devuelve el valor del campo equipo
     * 
     * @return     equipo del ciclista
    */
    public Equipo getEquipo()
    {
        
        return equipo;
        
    }
    
    public boolean equals (Ciclista c) {
        if (this == c) {
            return true;
        }
        
        if (! (c instanceof Ciclista)) {
            return false; 
        }
        
        Ciclista other = (Ciclista) c;
        
        return ((getName().equals(other.getName())) && 
        (getCampoHabilidad().equals(other.getCampoHabilidad()) && 
        getEnergia()==other.getEnergia()));//&&
        //getEquipo()==other.getEquipo()));
    }
      
    public int hashCode ()
     {
        int result = 17;
        result = 7 * result + getName().hashCode();
        result = 13 * result + getCampoHabilidad().hashCode();
      // result = 19 * result + getEnergia().hashcode();
      // result = 23 * result + getEquipo().hashcode();
        
        return result;
     }
    
    /**
     * Recibe una nueva bicicleta del equipo y se la cambia al ciclista
     * 
     */
    public void cambiarBicicletaEquipo(Bicicleta b)
    {
        if(b!=null)
        setBicicleta(b);
        
    }

    /**
     * Comprueba si la energia del ciclista es igual o menor que 0 y en caso afirmativo
     * cambia el valor de abandono.
     * 
     * @return   el valor del campo abandono
     * 
     */
    public boolean abandono(){
        if(energia<=0){
            this.abandono = true;
        }
        return this.abandono;
    }
    
    
    
    /**
     * Establece el tiempo como resultado de la etapa dada.
     * 
     * @param Etapa es la etapa en la cual se ha obtenido el resultado
     * @param tiempo es el es el tiempo obtenido tiempo
     */
    public void setResultado(Etapa E, double tiempo){
        resultado.add(new Resultados(tiempo, E, this));
        
    }
    
    /**
     * Establece el tiempo como resultado de la etapa dada.
     * 
     * @param Etapa es la etapa de la cual se desea obtener el resultado
     * 
     * @return el resultado de la etapa dada
     * 
     */
    public Resultados getResultado(Etapa e){
        Resultados r=new Resultados();
        for(int i = 0; i<resultado.size();i++){
            
            if(resultado.get(i).getEtapa()==e){
                r=resultado.get(i);
            }
        }
        return r;
    }
    
     /**
     * Establece el tiempo como resultado de la etapa dada.
     * 
     * @param Etapa es la etapa de la cual se desea obtener el tiempo
     * 
     * @return devuelve el tiempo obtenido en la etapa dada
     * 
     */                                              
    public double getTiempoResultado(Etapa E){
        Resultados r=new Resultados();
        double tiempores=0;
        for (int i = 0; i<resultado.size(); i++){
            r=resultado.get(i);
           if (r.getEtapa()==E){
               tiempores=r.getTiempo();
           }
        }
        return tiempores;
    }
    
     /**
     * Devuelve la cantidad de etapas en las que se han obtenido resultados
     * 
     * 
     * @return devuelve el tamaño de la lista de resultados
     * 
     */    
    public int totalEtapas(){
        return resultado.size();
    }
    
    /**
     * Devuelve el tiempo total acumulado en todas las etapas que se han completado
     * 
     * 
     * @return devuelve el tiempo total acumulado en todas las etapas
     * 
     */   
    public double tiempoTotalAcumulado(){
        int index=0;   
        double tiempoTotal=0;
        while(index<resultado.size()){
            Resultados res=resultado.get(index);
            if(res.getTiempo()>0){
            tiempoTotal = tiempoTotal + res.getTiempo();
        } 
            index++;
        }
        return tiempoTotal;
    }
    
    /**
     * Devuelve el numero de etapas terminadas
     * 
     * 
     * @return devuelve el tamaño de la lista de resultados
     * 
     */  
    public int etapasTerminadas(){
        return resultado.size();
    }
    
    /**
     * Devuelve la etapa en la que se ha abandonado
     * 
     * 
     * @return devuelve la etapa en la que el tiempo es negativo
     * 
     */  
    public Etapa etapaAbandonada(){
        int index=0;
        Etapa etapa=new Etapa();

        while(index<=resultado.size()){
            Resultados res=resultado.get(index);
            if(res.getTiempo()<0){
                etapa=res.getEtapa();
            }
        }
        return etapa;
    }
    
    /**
     * Calcula la energia restante del ciclista en la etapa dada como parametro asi como el tiempo 
     * obtenido en la etapa y lo almacena como resultado
     * 
     * 
     * @param la etapa en la cual se quiere calcular el resultado y la energia del ciclista
     * 
     */  
    public void actualizarResultadoEnergia(Etapa etp){ 
        double tiempo=bicicleta.calcularTiempoNecesario(this, etp);
        energia=energia-tiempo;
        abandono();
        if(abandono==false){
            setResultado(etp, tiempo);
        }
        else{
            setResultado(etp, energia);
        }
    }
    
 
    /**
     * 
     * Muestra los resultados del ciclista.
     * 
     */
    public void mostrarResultadosCiclista(){
        for(Resultados r: resultado){
            double tiempo=Math.round((r.getTiempo())*100d) / 100d;
            System.out.println("Carrera("+r.getEtapa().getName()+") - Tiempo: " + tiempo+" minutos");
        }
    }
     
    // /**
     // * 
     // * Muestra el ciclista por pantalla.
     // * 
     // */
    // public void mostrarCiclista(){
        // double energiaRedondeada=Math.round((energia)*100d) / 100d;
        // double tiempoTotal=Math.round((tiempoTotalAcumulado())*100d) / 100d;

        // System.out.println("<ciclista:"+nombre+"> <energía:"+energiaRedondeada+"> <habilidad: "+habilidad+"> <tiempo acumulado sin abandonar:"+tiempoTotal+ "> <abandonado:"+abandono+">");
    // }
    
    private double redondearEnergia(){
        return Math.round((energia)*100d) / 100d;
    }
    
    private double tiempoAcumuladoRedondeado(){
        return Math.round((tiempoTotalAcumulado())*100d) / 100d;
    }
    
    @Override
    public String toString(){
        
        StringBuilder builder = new StringBuilder();
        builder.append(getFormattedContent());
        builder.append(getName());
        builder.append("> <energía:");
        builder.append(redondearEnergia());
        builder.append("> ");
        builder.append(getCampoHabilidad());
        builder.append(" <tiempo acumulado sin abandonar:");
        builder.append(tiempoAcumuladoRedondeado());
        builder.append("> <abandonado:");
        builder.append(abandono);
        builder.append(">");
        return builder.toString();
    }
    
    protected abstract String getFormattedContent();
    
    public abstract void calcularDestreza();
   
}
   
