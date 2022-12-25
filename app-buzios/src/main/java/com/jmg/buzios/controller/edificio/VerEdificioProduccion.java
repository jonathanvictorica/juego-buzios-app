/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerEdificioProduccion;

/**
 * @author Alumno
 */
public class VerEdificioProduccion extends ConfigurarEdificio implements Actualizar {

    public VerEdificioProduccion(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerEdificioProduccion(this);
    }


    @Override
    public void actualizardatospantalla() {
        int produccionporhora = 0;
        int produccionplus = 0;
        int producciontotal = 0;
        if (this.edificionivel.getEdificio().getNombre().equals("Cabaña del guarda Bosque")) {
            produccionporhora = this.ciudadjugador.getCiudadproduccion().getCantidadmaderaporhora();
            produccionplus = (int) ((this.edificionivel.getNivel() * 2) * produccionporhora) / 100;
            producciontotal = produccionporhora + produccionplus;
        } else {
            produccionporhora = this.ciudadjugador.getCiudadproduccion().getCantidadporhora();
            produccionplus = (int) ((this.edificionivel.getNivel() * 2) * produccionporhora) / 100;
            producciontotal = produccionporhora + produccionplus;

        }

        VVerEdificioProduccion veredificioproduccion = ((VVerEdificioProduccion) this.vedificio);
        veredificioproduccion.getLblCantidadProduccionHora().setText("" + produccionporhora);
        veredificioproduccion.getLblPlusProduccion().setText(produccionplus + "");
        veredificioproduccion.getTotalProduccion().setText("" + producciontotal);
        veredificioproduccion.repaint();
    }

    @Override
    public void actualizarinterfazgrafica() {

    }

}
