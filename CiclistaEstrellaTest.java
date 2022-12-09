

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CiclistaEstrellaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CiclistaEstrellaTest
{
    /**
     * Default constructor for test class CiclistaEstrellaTest
     */
    public CiclistaEstrellaTest()
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
    public void TestTiempoTotalAcumulado()
    {
        Etapa etapa1 = new Etapa("prueba1", Dificultad.SENCILLA, Distancia.LARGA);
        Etapa etapa2 = new Etapa("prueba2", Dificultad.COMPLEJA, Distancia.INTERMEDIA);
        Bicicleta biciclet1 = new Bicicleta("bicprueba", Peso.LIGERA);
        ComparadorCiclistasEnergia cmpprueba = new ComparadorCiclistasEnergia();
        ComparadorBicisPeso cpruebabici = new ComparadorBicisPeso();
        Equipo equipo1 = new Equipo("eqprueba", cmpprueba, true, cpruebabici, true);
        CiclistaEstrella ciclista1 = new CiclistaEstrella("cicprueba", Habilidad.NORMAL, 300, equipo1);
        assertEquals(148.8375, biciclet1.calcularTiempoNecesario(ciclista1, etapa1), 0.1);
        ciclista1.setResultado(etapa1, 148.8375);
        assertEquals(161.7, biciclet1.calcularTiempoNecesario(ciclista1, etapa2), 0.1);
        ciclista1.setResultado(etapa2, 161.7);
        assertEquals(310.5375, ciclista1.tiempoTotalAcumulado(), 0.1);
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
