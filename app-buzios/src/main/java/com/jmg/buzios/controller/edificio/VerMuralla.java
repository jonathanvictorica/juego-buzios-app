/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerMuralla;

/**
 * @author Alumno
 */
public class VerMuralla extends ConfigurarEdificio implements Actualizar {

    public VerMuralla(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerMuralla(this);
    }

    @Override
    public void actualizardatospantalla() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarinterfazgrafica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
