/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;
import com.jmg.buzios.view.islas.VRecolectarRecurso;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class AsignarTrabajadores {

    private Isla isla;
    private Integer trabajadoresnuevos;//cantidad total nueva 
    private Integer trabajadores;//cantidad vieja de trabajadores
    private Ciudad ciudadjugador;//ciudad del jugador
    private String recurso;


    private VRecolectarRecurso vrecolectarrecurso;

    public AsignarTrabajadores(Isla isla, Integer trabajadoresnuevos, Integer trabajadores, Ciudad ciudadjugador, String recurso) {
        this.isla = isla;
        this.trabajadoresnuevos = trabajadoresnuevos;
        this.trabajadores = trabajadores;
        this.ciudadjugador = ciudadjugador;
        this.recurso = recurso;
    }


    public void CUAsignarTrabajadores() throws SQLException {


        if (trabajadoresnuevos <= trabajadores) {
            ciudadjugador.aumentarhabitantesdisponibles( (this.trabajadores - this.trabajadoresnuevos));
            ciudadjugador.getCiudadproduccion().asignarnuevostrabajadores( this.trabajadoresnuevos, recurso);
            JOptionPane.showMessageDialog(vrecolectarrecurso, "Trabajadores Asignados!!!");

        } else {
            if (this.ciudadjugador.getCantidadhabitantesdisponibles() >= (trabajadoresnuevos - trabajadores)) {
                ciudadjugador.descontarHabitantesDisponibles( (this.trabajadoresnuevos - this.trabajadores));
                ciudadjugador.getCiudadproduccion().asignarnuevostrabajadores( this.trabajadoresnuevos, recurso);
                JOptionPane.showMessageDialog(vrecolectarrecurso, "Trabajadores Asignados!!!");
            } else {
                JOptionPane.showMessageDialog(vrecolectarrecurso, "No tienes suficientes habitantes disponibles.");
            }

        }


        //actualizar datos
        ciudadjugador.inicializarHabitantes();
        ciudadjugador.getCiudadproduccion().inicializarproduccionciudad();


    }


}
