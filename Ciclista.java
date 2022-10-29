import java.util.ArrayList;
/** Guarda la informacion del nombre, la bicicleta, la habilidad, la energía,
 * los resultados y el equipo de la clase ciclista
 *
 * 
 * @author Jesús Cerrudo, Pablo Polo y Marco Vega. 
 * @version 1.0
*/
public class Ciclista
{
    
    private String nombre;
    private Bicicleta bicicleta;
    private double habilidad;
    private double energia;
    private ArrayList<Resultados> resultado;
    private Equipo equipo;
    private boolean abandono;
    

    /**
     * Constructor de objetos de la clase Ciclista
     * Crea un nuevo ciclissta inicializando con parametros por defecto
     */
    public Ciclista()
    {        
        nombre=" ";
        habilidad=0;
        energia=0;
        this.resultado=new ArrayList<Resultados>();
        abandono=false;
    }
    
    /**
     * Constructor parametrizado de objetos de la clase Ciclista
     * Crea un nuevo ciclista inicializando con parametros pasados por teclado
     * 
     * @param nombre es el nombre del ciclista
     * @param habilidad es la habilidad del ciclista
     * @param energia es la energía restante del ciclista
     * @param resultado es el resultado del ciclista
     * 
     */
    public Ciclista(String nombre, double habilidad, double energia, Equipo e)
    {        
        this.nombre=nombre;
        this.habilidad=habilidad;
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
    public void setHabilidad(double habilidad)
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
        
        return habilidad;
        
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
     * Devuelve el valor del campo bicicleta
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
    
      
    /**
     * Devuelve el valor del campo bicicleta
     * 
     * @return     bicicleta del ciclista
     */
    public Bicicleta cambiarBicicletaEquipo(Bicicleta bicicletaB)
    {
        
        //TO DO
        if(bicicleta==null){
            System.out.println("El ciclista no tiene bicicleta asignada");
        }
        
        return bicicleta;
        
        
    }

    public boolean abandono(){
        if(energia<=0){
            this.abandono = true;
        }
        return this.abandono;
    }

    
    

     
    public void setResultado(Etapa E, double tiempo){
        resultado.add(new Resultados(tiempo, E));//COMPROBAR
        
    }
    
    public int totalEtapas(){
        return resultado.size();//COMPROBAR
    }
    
    public double tiempoTotalAcumulado(){
        int index=0;   
        double tiempoTotal=0;
        while(index<resultado.size()){
            Resultados res=resultado.get(index);
            tiempoTotal = tiempoTotal + res.getTiempo();
            index++;
        }
        return tiempoTotal;
    }
    
    public int etapasTerminadas(){
        return resultado.size();
    }
    
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
    
    public void actualizarResultadoEnergia(Etapa etp){ //Bicicleta bic){
        double tiempo=bicicleta.calcularTiempoNecesario(this, etp);
        if(abandono()==false){
            setResultado(etp, tiempo);
            energia=energia-tiempo;
        }
        else{
            double tiempoRestante = energia-tiempo;
            setResultado(etp, tiempoRestante);
        }
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
     
    public void mostrarCiclista(){
        System.out.println("<ciclista:"+nombre+"> <energía:"+energia+"> <tiempo acumulado sin abandonar:"+tiempoTotalAcumulado()+ "<abandonado:"+abandono+")>");
    }
   
}
   
