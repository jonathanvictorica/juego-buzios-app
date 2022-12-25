/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.investigacion;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.investigacion.Investigacion;
import com.jmg.buzios.model.investigacion.InvestigacionJugador;
import com.jmg.buzios.model.investigacion.TemaInvestigacion;
import com.jmg.buzios.view.academia.VVerinvestigaciones;

/**
 * @author Alumno
 */
public class VerInvestigacion {

    private Ciudad ciudadjugador;

    private VVerinvestigaciones verinvestigaciones;

    public VerInvestigacion(Ciudad ciudadjugador) {
        this.ciudadjugador = ciudadjugador;
    }

    public void CUverinvestigacion() {
        int maximoeconomia = Investigacion.maximoNumerodeTema( new TemaInvestigacion("Economía"));
        int maximonavegacion = Investigacion.maximoNumerodeTema( new TemaInvestigacion("Navegación"));
        int maximociencia = Investigacion.maximoNumerodeTema( new TemaInvestigacion("Ciencia"));
        int maximomilicia = Investigacion.maximoNumerodeTema( new TemaInvestigacion("Milicia"));

        int numeroinvestigacioneconomia = 0;
        int numeroinvestigacionnavegacion = 0;
        int numeroinvestigacionciencia = 0;
        int numeroinvestigacionmilicia = 0;

        InvestigacionJugador investigacionjugador = new InvestigacionJugador(this.ciudadjugador.getJugador());
        numeroinvestigacioneconomia = investigacionjugador.buscarUltimaInvestigacion( "Economía");
        numeroinvestigacionnavegacion = investigacionjugador.buscarUltimaInvestigacion( "Navegación");
        numeroinvestigacionciencia = investigacionjugador.buscarUltimaInvestigacion( "Ciencia");
        numeroinvestigacionmilicia = investigacionjugador.buscarUltimaInvestigacion( "Milicia");
        //verificar si ha investigado el nivel maximo de 
        //ese tema para inicializar solamente el ultimo
        Investigacion investigacioneconomia;
        Investigacion investigacionnavegacion;
        Investigacion investigacionmilitar;
        Investigacion investigacionciencia;


        if (numeroinvestigacioneconomia < maximoeconomia) {
            investigacioneconomia = new Investigacion(numeroinvestigacioneconomia, new TemaInvestigacion("Economía"));

        } else {
            investigacioneconomia = new Investigacion(maximoeconomia, new TemaInvestigacion("Economía"));
        }

        if (numeroinvestigacionnavegacion < maximonavegacion) {
            investigacionnavegacion = new Investigacion(numeroinvestigacionnavegacion, new TemaInvestigacion("Navegación"));
        } else {
            investigacionnavegacion = new Investigacion(maximonavegacion, new TemaInvestigacion("Navegación"));

        }
        if (numeroinvestigacionmilicia < maximomilicia) {
            investigacionmilitar = new Investigacion(numeroinvestigacionmilicia, new TemaInvestigacion("Milicia"));
        } else {
            investigacionmilitar = new Investigacion(maximomilicia, new TemaInvestigacion("Milicia"));
        }

        if (numeroinvestigacionciencia < maximociencia) {
            investigacionciencia = new Investigacion(numeroinvestigacionciencia, new TemaInvestigacion("Ciencia"));
        } else {
            investigacionciencia = new Investigacion(maximociencia, new TemaInvestigacion("Ciencia"));
        }
        investigacioneconomia.inicializarInvestigacion();
        investigacionnavegacion.inicializarInvestigacion();
        investigacionmilitar.inicializarInvestigacion();
        investigacionciencia.inicializarInvestigacion();


        this.verinvestigaciones = new VVerinvestigaciones(investigacioneconomia, investigacionnavegacion, investigacionmilitar, investigacionciencia, this.ciudadjugador);

        if (numeroinvestigacioneconomia < maximoeconomia) {
            this.verinvestigaciones.getCmdInvestigacionEconomia().setEnabled(true);
        } else {
            this.verinvestigaciones.getCmdInvestigacionEconomia().setEnabled(false);

        }


        if (numeroinvestigacionmilicia < maximomilicia) {
            this.verinvestigaciones.getCmdInvestigacionMilitar().setEnabled(true);
        } else {
            this.verinvestigaciones.getCmdInvestigacionMilitar().setEnabled(false);
        }

        this.verinvestigaciones.repaint();

    }


}
