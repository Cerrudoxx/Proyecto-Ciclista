     public class DatosCampeonatoCompletoFinal
{
    
    public DatosCampeonatoCompletoFinal(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
    /**
     * Carga las etapas, ciclistas y bicicletas que participaran
     */
     private void initData(Organizacion organizacion)
    {
        //constructor de etapas pide ( String nombre, double dificultad, double distancia)
        // Etapa etapa1 = new Etapa("sencilla larga", 0.9, 200);
        // Etapa etapa2 = new Etapa("compleja corta", 1.1, 150);
        // Etapa etapa3 = new Etapa("normal intermedia", 1.0, 175);
        // Etapa etapa4 = new Etapa("sencilla intermedia", 0.9, 175);
        // Etapa etapa5 = new Etapa("compleja intermedia", 1.1, 175);
        // Etapa etapa6 = new Etapa("normal larga", 1.0, 200);
        Etapa etapa1 = new Etapa("sencilla larga", Dificultad.SENCILLA,Distancia.LARGA);
        Etapa etapa2 = new Etapa("compleja corta", Dificultad.COMPLEJA,Distancia.CORTA);
        Etapa etapa3 = new Etapa("normal intermedia", Dificultad.NORMAL,Distancia.INTERMEDIA);
        Etapa etapa4 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        Etapa etapa5 = new Etapa("compleja intermedia", Dificultad.COMPLEJA, Distancia.INTERMEDIA);
        Etapa etapa6 = new Etapa("normal larga", Dificultad.NORMAL, Distancia.LARGA);
        organizacion.anadirEtapa(etapa1);
        
        organizacion.anadirEtapa(etapa1);
        organizacion.anadirEtapa(etapa2);
        organizacion.anadirEtapa(etapa3);
        organizacion.anadirEtapa(etapa4);
        organizacion.anadirEtapa(etapa5);
        organizacion.anadirEtapa(etapa6);
        

        //Equipo movistarWomen = new Equipo("Movistar Women", //ciclistas comparados ascendentemente por habilidad (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre));
        //Equipo dSMWomen= new Equipo("DSM Women", //ciclistas comparados ascendentemente por energía (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre)););
        //Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women", //ciclistas comparados descendentemente por habilidad (si iguales por nombre), bicicletas comparadas descendentemente por peso (si iguales por nombre)););
        Equipo movistarWomen = new Equipo("Movistar Women", new ComparadorCiclistasHabilidad(), true, new ComparadorBicisPeso(), true);
        Equipo dSMWomen= new Equipo("DSM Women", new ComparadorCiclistasEnergia(), true, new ComparadorBicisPeso(), true);
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women", new ComparadorCiclistasHabilidad(), false, new ComparadorBicisPeso(), false);
        
        organizacion.inscribirEquipo(movistarWomen);
        organizacion.inscribirEquipo(trekSegafredoWomen);
        organizacion.inscribirEquipo(dSMWomen);
        
        organizacion.setCompEquipo(new ComparadorEquipoNombre(), true);
        
        //constructor de bicicletas pide ( String nombre, double peso)
        
        // dSMWomen.anadirBicicleta(new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15",Peso.LIGERA, 0.3)); 
        // dSMWomen.anadirBicicleta(new BicicletaPrototipo("SCOTT CONTESSA ADDICT 15",Peso.NORMAL));
        // dSMWomen.anadirBicicleta(new BicicletaNormal("SCOTT CONTESSA ADDICT RC 15",Peso.PESADA));

        dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT eRIDE 15",Peso.LIGERA)); 
        dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT 15",Peso.NORMAL));
        dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",Peso.PESADA));
        
        dSMWomen.ordenarBicicletas();
        
        // //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        // // dSMWomen.anadirCiclista(new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, dSMWomen));
        // // dSMWomen.anadirCiclista(new CiclistaEstrella("LIPPERT", Habilidad.NORMAL, 1160, dSMWomen));
        // // dSMWomen.anadirCiclista(new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, dSMWomen));
        // dSMWomen.anadirCiclista(new Ciclista("WIEBES",  Habilidad.NORMAL, 1190, dSMWomen));
        // dSMWomen.anadirCiclista(new Ciclista("LIPPERT", Habilidad.NORMAL, 1160, dSMWomen));
        // dSMWomen.anadirCiclista(new Ciclista("LABOUS", Habilidad.BUENA, 1150, dSMWomen));

        // dSMWomen.ordenarCiclistas();
        
        // //constructor de bicicletas pide ( String nombre, double peso)  
        // // trekSegafredoWomen.anadirBicicleta(new BicicletaNormal("TREK Madone SLR 9 eTap Gen 7",Peso.LIGERA));
        // // trekSegafredoWomen.anadirBicicleta(new BicicletaRapida("TREK Emonda SLR 9 eTap",Peso.NORMAL, 0.5));
        // // trekSegafredoWomen.anadirBicicleta(new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4",Peso.PESADA));
        
        // trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",Peso.LIGERA));
        // trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Emonda SLR 9 eTap",Peso.NORMAL));
        // trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Domane SLR 9 eTap Gen 4",Peso.PESADA));
        
        // trekSegafredoWomen.ordenarBicicletas();
        
        // //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        // // trekSegafredoWomen.anadirCiclista(new CiclistaEstrella("BALSAMO", Habilidad.NORMAL,1180, trekSegafredoWomen));
        // // trekSegafredoWomen.anadirCiclista(new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL,1175, trekSegafredoWomen));
        // // trekSegafredoWomen.anadirCiclista(new CiclistaNovato("CORDON-RAGOT", Habilidad.BUENA, 1120, trekSegafredoWomen));
        
        // trekSegafredoWomen.anadirCiclista(new Ciclista("BALSAMO", Habilidad.NORMAL,1180, trekSegafredoWomen));
        // trekSegafredoWomen.anadirCiclista(new Ciclista("LONGO-BORGHINI", Habilidad.NORMAL,1175, trekSegafredoWomen));
        // trekSegafredoWomen.anadirCiclista(new Ciclista("CORDON-RAGOT", Habilidad.BUENA, 1120, trekSegafredoWomen));
        
        // trekSegafredoWomen.ordenarCiclistas();
        
        // //constructor de bicicletas pide ( String nombre, double peso)
        
        // // movistarWomen.anadirBicicleta(new BicicletaRapida("CANYON Ultimate CFR eTap",Peso.LIGERA, 0.4));
        // // movistarWomen.anadirBicicleta(new BicicletaNormal("CANYON Aeroad CF SLX 8 Disc Di2",Peso.NORMAL));
        // // movistarWomen.anadirBicicleta(new BicicletaPrototipo("CANYON Endurace CF SLX 9 Di2",Peso.PESADA));
        
        // movistarWomen.anadirBicicleta(new Bicicleta("CANYON Ultimate CFR eTap",Peso.LIGERA));
        // movistarWomen.anadirBicicleta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",Peso.NORMAL));
        // movistarWomen.anadirBicicleta(new Bicicleta("CANYON Endurace CF SLX 9 Di2",Peso.PESADA));
        
        // movistarWomen.ordenarBicicletas();
        
        // //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
         // // movistarWomen.anadirCiclista(new CiclistaEstrella("VAN VLEUTEN", Habilidad.NORMAL,1200, movistarWomen));
        // // movistarWomen.anadirCiclista(new CiclistaExperimentado("NORSGAARD", Habilidad.NORMAL,1145, movistarWomen));
        // // movistarWomen.anadirCiclista(new CiclistaNovato("SIERRA", Habilidad.BUENA, 1130, movistarWomen));   
         // movistarWomen.anadirCiclista(new Ciclista("VAN VLEUTEN", Habilidad.NORMAL,1200, movistarWomen));
        // movistarWomen.anadirCiclista(new Ciclista("NORSGAARD", Habilidad.NORMAL,1145, movistarWomen));
        // movistarWomen.anadirCiclista(new Ciclista("SIERRA", Habilidad.BUENA, 1130, movistarWomen));   
        
        // movistarWomen.ordenarCiclistas();

    }

}