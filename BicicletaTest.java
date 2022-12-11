

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BicicletaTest
{
    /**
     * Default constructor for test class BicicletaTest
     */
    public BicicletaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        
    }

     @Test
    public void TestCalcularVelocidad()
    {
        ComparadorBicisPeso comparad1 = new ComparadorBicisPeso();
        ComparadorCiclistasHabilidad comparad2 = new ComparadorCiclistasHabilidad();
        Equipo equipo1 = new Equipo("Trek Segafredo Women", comparad2, false, comparad1, false);
        CiclistaExperimentado ciclista1 = new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL, 1175, equipo1);
        Etapa etapa1 = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);
        Bicicleta biciclet1 = new Bicicleta("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);
        assertEquals(90.7029, biciclet1.calcularVelocidad(ciclista1, etapa1), 0.1);
    }

    @Test
    public void TestCalcularTiempoNecesario()
    {
       
        ComparadorCiclistasHabilidad comparad1 = new ComparadorCiclistasHabilidad();
        ComparadorBicisPeso comparad2 = new ComparadorBicisPeso();
        Equipo equipo1 = new Equipo("Trek Segafredo Women", comparad1, false, comparad2, false);
        Etapa etapa1 = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);
        Bicicleta biciclet1 = new Bicicleta("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);
        CiclistaExperimentado ciclista1 = new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL, 1175, equipo1);
        assertEquals(148.8423, biciclet1.calcularTiempoNecesario(ciclista1, etapa1), 0.1);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

   
}


