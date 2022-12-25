/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerAcademia;

import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VerAcademia extends ConfigurarEdificio implements Actualizar {

    public VerAcademia(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.vedificio = new VVerAcademia(this);
    }


    @Override
    public void actualizardatospantalla() {
        VVerAcademia veracademia = ((VVerAcademia) this.vedificio);
        this.vciudad.getCiudad().inicializarciudad();
        try {
            this.vciudad.getCiudad().getCiudadacademia().inicializaracademiadeciudad();
        } catch (SQLException ex) {

        }
        this.ciudadjugador.getCiudadacademia().setCiudad(ciudadjugador);
        veracademia.getLblCantidadhabitante().setText(this.ciudadjugador.getCantidadhabitantesdisponibles() + "");
        veracademia.getLblCantidadtrabajdor().setText(this.ciudadjugador.getCiudadacademia().getInvestigadores() + "");
        veracademia.repaint();


    }

    @Override
    public void actualizarinterfazgrafica() {

    }

}
