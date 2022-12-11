

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EquipoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EquipoTest
{
    /**
     * Default constructor for test class EquipoTest
     */
    public EquipoTest()
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
    public void TestTiempoMedio()
    {
        ComparadorCiclistasHabilidad comparadcic = new ComparadorCiclistasHabilidad();
        ComparadorBicisPeso comparadbic = new ComparadorBicisPeso();
        Equipo equipo1 = new Equipo("Movistar Women", comparadcic, true, comparadbic, true);
        CiclistaExperimentado ciclista1 = new CiclistaExperimentado("NORSGAARD", Habilidad.NORMAL, 1145, equipo1);
        CiclistaNovato ciclista2 = new CiclistaNovato("SIERRA", Habilidad.BUENA, 1130, equipo1);
        Etapa etapa1 = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);
        Etapa etapa2 = new Etapa("compleja corta", Dificultad.COMPLEJA, Distancia.CORTA);
        BicicletaRapida biciclet1 = new BicicletaRapida("CANYON Ultimate CFR eTap", Peso.LIGERA, 0.4);
        Bicicleta biciclet2 = new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2", Peso.NORMAL);
        ciclista1.setBicicleta(biciclet1);
        ciclista2.setBicicleta(biciclet2);
        ciclista1.actualizarResultadoEnergia(etapa1);
        ciclista2.actualizarResultadoEnergia(etapa1);
        ciclista1.actualizarResultadoEnergia(etapa2);
        ciclista2.actualizarResultadoEnergia(etapa2);        
        equipo1.anadirCiclista(ciclista1);
        equipo1.anadirCiclista(ciclista2);
        assertEquals(2, equipo1.getNumeroCiclistas());
        assertEquals(475.5275, equipo1.tiempoTotalAcumuladoCiclistas(), 0.1);
        assertEquals(237.7675, equipo1.tiempoMedio(), 0.1);
    }
    
    @Test
    public void TestEnviarAEtapa()
    {
        ComparadorCiclistasEnergia comparadcic = new ComparadorCiclistasEnergia();
        ComparadorBicisPeso comparadbic = new ComparadorBicisPeso();
        Equipo equipo1 = new Equipo("DSM Women", comparadcic, true, comparadbic, true);
        BicicletaRapida biciclet1 = new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15", Peso.LIGERA, 0.3);
        Bicicleta biciclet2 = new Bicicleta("SCOTT CONTESSA ADDICT RC 15", Peso.PESADA);
        CiclistaNovato ciclista1 = new CiclistaNovato("WIEBES", Habilidad.NORMAL, 1190, equipo1);
        CiclistaEstrella ciclista2 = new CiclistaEstrella("LIPPERT", Habilidad.NORMAL, 1160, equipo1);
        equipo1.anadirBicicleta(biciclet1);
        equipo1.anadirBicicleta(biciclet2);
        equipo1.anadirCiclista(ciclista1);
        equipo1.anadirCiclista(ciclista2);
        assertEquals(ciclista2, equipo1.enviarAEtapa());
        assertEquals(1, equipo1.getNumeroCiclistas());
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


