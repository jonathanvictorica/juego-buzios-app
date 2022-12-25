package com.jmg.buzios.scheduler;

import com.jmg.buzios.service.*;

public class SchedulerBuzios {


    public void execute(){
        AsignarRecurso asignarrecursos = new AsignarRecurso();
        Thread hiloasignarrecursos = new Thread(asignarrecursos);
        hiloasignarrecursos.start();

        AsignarInvestigadores investigadoresnuevos = new AsignarInvestigadores();
        Thread hiloasignarinvestigadores = new Thread(investigadoresnuevos);
        hiloasignarinvestigadores.start();

        AsignarHabitantesCiudad habitantes = new AsignarHabitantesCiudad();
        Thread habitanteshilo = new Thread(habitantes);
        habitanteshilo.start();

        DescontarVinoyOro descontaroro = new DescontarVinoyOro(false);
        Thread descontarorohilo = new Thread(descontaroro);
        descontarorohilo.start();

        DescontarVinoyOro descontarvino = new DescontarVinoyOro(true);
        Thread descontarvinohilo = new Thread(descontarvino);
        descontarvinohilo.start();


        DescargarEmbarcacionesRecursos embarcaciones = new DescargarEmbarcacionesRecursos();
        Thread embarcacioneshilo = new Thread(embarcaciones);
        embarcacioneshilo.start();

    }
}
