/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.investigacion;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.view.edificios.VVerAcademia;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class AsignarInvestigadores implements Actualizar {

    private Ciudad ciudadjugador;
    private int cantidadasignar;

    private VVerAcademia ver_academia;

    public AsignarInvestigadores(Ciudad ciudadjugador, int cantidadasignar, VVerAcademia ver_academia) {
        this.ciudadjugador = ciudadjugador;
        this.cantidadasignar = cantidadasignar;
        this.ver_academia = ver_academia;
    }


    public void CUAsignarinvestigadores() throws SQLException {
        if (cantidadasignar <= ciudadjugador.getCiudadacademia().getInvestigadores()) {
            ciudadjugador.aumentarhabitantesdisponibles( (this.ciudadjugador.getCiudadacademia().getInvestigadores() - this.cantidadasignar));
            ciudadjugador.getCiudadacademia().actualizarinvestigadores( cantidadasignar);
            JOptionPane.showMessageDialog(null, "Investigadores Asignados!!!");

        } else {
            if (this.ciudadjugador.getCantidadhabitantesdisponibles() >= (cantidadasignar - ciudadjugador.getCiudadacademia().getInvestigadores())) {
                ciudadjugador.descontarHabitantesDisponibles((this.cantidadasignar - ciudadjugador.getCiudadacademia().getInvestigadores()));
                ciudadjugador.getCiudadacademia().actualizarinvestigadores( cantidadasignar);
                JOptionPane.showMessageDialog(null, "Investigadores Asignados!!!");
            } else {
                JOptionPane.showMessageDialog(null, "No tienes suficientes habitantes disponibles.");
            }

        }


        //actualizar datos
        ciudadjugador.inicializarHabitantes();
        ciudadjugador.getCiudadacademia().inicializaracademiadeciudad();


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
