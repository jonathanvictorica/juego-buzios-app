/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerEdificioReduccion;

/**
 * @author Alumno
 */
public class VerEdificioReduccion extends ConfigurarEdificio implements Actualizar {

    public VerEdificioReduccion(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerEdificioReduccion(this);
    }


    @Override
    public void actualizardatospantalla() {
        VVerEdificioReduccion veredificioreduccion = ((VVerEdificioReduccion) this.vedificio);
        String recursoreduccion = "";
        switch (this.edificionivel.getEdificio().getNombre()) {
            case "Carpinteria":
                recursoreduccion = "Madera";
                break;
            case "Prensa de Vino":
                recursoreduccion = "Vino";
                break;
            case "Oficina del Arquitecto":
                recursoreduccion = "Marmol";
                break;
            case "Optico":
                recursoreduccion = "Cristal";
                break;
            case "Area de Pruebas Pirotécnicas":
                recursoreduccion = "Azufre";
                break;
        }
        veredificioreduccion.getLblRecursoReducir().setText(recursoreduccion);
        veredificioreduccion.getPorcentajeReduccion().setText("" + (this.edificionivel.getNivel() * 2) + " %");
        veredificioreduccion.repaint();

    }

    @Override
    public void actualizarinterfazgrafica() {

    }

}
