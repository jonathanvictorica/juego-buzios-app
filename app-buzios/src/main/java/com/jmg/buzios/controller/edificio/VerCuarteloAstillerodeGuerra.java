/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerAstilerodeGuerra;
import com.jmg.buzios.view.edificios.VVerCuartel;

/**
 * @author Alumno
 */
public class VerCuarteloAstillerodeGuerra extends ConfigurarEdificio implements Actualizar {

    public VerCuarteloAstillerodeGuerra(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        if (this.edificionivel.getEdificio().getNombre().equals("Cuartel")) {
            this.vedificio = new VVerCuartel(this);
        } else {
            this.vedificio = new VVerAstilerodeGuerra(this);
        }
    }


    @Override
    public void actualizardatospantalla() {
    }

    @Override
    public void actualizarinterfazgrafica() {
    }

}
