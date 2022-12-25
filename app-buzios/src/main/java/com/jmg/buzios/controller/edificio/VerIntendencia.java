/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.edificios.VVerIntendencia;

/**
 * @author Alumno
 */
public class VerIntendencia extends ConfigurarEdificio implements Actualizar {

    public VerIntendencia(VCiudad vciudad, Ciudad ciudadjugador, EdificioNivel edificionivel, int lugarciudad) {
        super(vciudad, ciudadjugador, edificionivel, lugarciudad);
        this.crearedificio();
    }

    private void crearedificio() {
        this.vedificio = new VVerIntendencia(this);
    }


    @Override
    public void actualizardatospantalla() {
        VVerIntendencia verint = ((VVerIntendencia) this.vedificio);
        verint.getLblHabitantesciudad().setText("" + this.ciudadjugador.getCantidadhabitantes());
        verint.getLblHabitantesDisponibles().setText("" + this.ciudadjugador.getCantidadhabitantesdisponibles());
        verint.getLblCapacidadMilitarCiudad().setText("" + this.ciudadjugador.getNivel().getCapacidadmilitarterrestre());
        verint.getLblCapacidadMilitarbarco().setText("" + this.ciudadjugador.getNivel().getCapacidadmilitarnaval());
        verint.getLblNivelCiudad().setText("Nivel de Ciudad: " + this.ciudadjugador.getNivel().getNivel());
        if (this.ciudadjugador.isCapital()) {
            verint.getLblCiudadCapital().setText("Capital");
        } else {
            verint.getLblCiudadCapital().setText("Colonia");

        }
        verint.getLblEstadoCiudad().setText(this.ciudadjugador.getEstado().getEstado());
        verint.getLblCrecimientoHabitante().setText("Crecimiento de Habitantes: " + this.ciudadjugador.getCrecimientodehabitante());
        verint.repaint();


    }

    @Override
    public void actualizarinterfazgrafica() {

    }


}
