/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ejercito.VVerUnidadesMilitaresConstruccion;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class CrearUnidadMilitar implements Actualizar {
    VVerUnidadesMilitaresConstruccion vunidades;
    /*
    calcularcantidadtotalrecursos(): UNIDADMILITARCONSTRUCCION	UNIDADMILITARCONSTRUCCION
calcularcantidadtotalhabitantes(): int	UNIDADMILITAR
verificarnosuperarcapacidadmilitar(cantidadunidades : int) boolean	CIUDAD
verificarcantidadhabitantes(cantidadhabitantes: int) boolean	CIUDAD
verificarrecursosciudad(listarecursos: List<RECURSO>, cantidad: List<Integer>):boolean	CIUDAD
construirunidadesmilitares(cantidad: int): void	UNIDADMILITAR
descontarhabitantes(cantidad: int): void	CIUDAD
descontarrecursosciudad(listarecursos: List<RECURSO>,cantidad: List<Integer>): void	CIUDAD

     */

    private Ciudad ciudadjugador;
    private UnidadMilitar unidadmilitar;
    private int cantidad;


    public CrearUnidadMilitar(VVerUnidadesMilitaresConstruccion vunidades, Ciudad ciudadjugador, UnidadMilitar unidadmilitar, int cantidad) {
        this.vunidades = vunidades;
        this.ciudadjugador = ciudadjugador;
        this.unidadmilitar = unidadmilitar;
        this.cantidad = cantidad;
    }

    public void CUcrarunidadmilitar() throws SQLException {
        unidadmilitar.getUnidadmilitarconstruccion().calcularcantidadtotalrecursos(cantidad);
        unidadmilitar.cantidadtotalhabitantes(cantidad);
        if (this.vunidades.getCiudadjugador().verificarnosuperarcapacidadmilitar( cantidad, this.unidadmilitar.isBarco()) == false) {
            if (ciudadjugador.verificarcantidadhabitantes( unidadmilitar.getCantidadhabitantes())) {
                if (ciudadjugador.getCiudadrecurso().verificarrecursosciudad( unidadmilitar.getUnidadmilitarconstruccion().getRecurso(), unidadmilitar.getUnidadmilitarconstruccion().getCantidad())) {
                    CrearUnidadMilitarThread construirunidades = new CrearUnidadMilitarThread( this.ciudadjugador, this.unidadmilitar, this.cantidad, 1);
                    Thread hconstruirunidades = new Thread(construirunidades);
                    hconstruirunidades.start();

                    CrearUnidadMilitarThread descontarhabitantes = new CrearUnidadMilitarThread( this.ciudadjugador, this.unidadmilitar, this.cantidad, 2);
                    Thread hdescontarhabitantes = new Thread(descontarhabitantes);
                    hdescontarhabitantes.start();

                    CrearUnidadMilitarThread descontarrecursos = new CrearUnidadMilitarThread( this.ciudadjugador, this.unidadmilitar, this.cantidad, 3);
                    Thread hdescontarrecursos = new Thread(descontarrecursos);
                    hdescontarrecursos.start();

                    while (hdescontarrecursos.isAlive() || hdescontarhabitantes.isAlive() || hconstruirunidades.isAlive()) {
                        if ((hdescontarrecursos.isInterrupted()) || (hdescontarhabitantes.isInterrupted()) || (hconstruirunidades.isInterrupted())) {

                        }
                    }
                    JOptionPane.showMessageDialog(vunidades, "Ya tienes " + cantidad + " unidades de " + unidadmilitar.getNombre() + " nuevas en tu ciudad.");

                } else {
                    JOptionPane.showMessageDialog(vunidades, "No tienes recursos suficientes en la ciudad para construir " + cantidad + " unidades de " + unidadmilitar.getNombre() + ".");
                }
            } else {
                JOptionPane.showMessageDialog(vunidades, "No tienes suficientes habitantes para construir " + cantidad + " unidades de " + unidadmilitar.getNombre() + ".");
            }

        } else {
            JOptionPane.showMessageDialog(vunidades, "No se puede crear esta cantidad de unidades militares porque superaria la capacidad de unidades militares que soporta esta ciudad. Eleva la ciudad de nivel y podrás tener mas unidades militares.");
        }


    }

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {

    }
}

class CrearUnidadMilitarThread extends Thread {

    private Ciudad ciudadjugador;
    private UnidadMilitar unidadmilitar;
    private int cantidad;
    private int hilo;

    public CrearUnidadMilitarThread(  Ciudad ciudadjugador, UnidadMilitar unidadmilitar, int cantidad, int hilo) {

        this.ciudadjugador = ciudadjugador;
        this.unidadmilitar = unidadmilitar;
        this.cantidad = cantidad;
        this.hilo = hilo;
    }

    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    ciudadjugador.getCiudadejercito().construirunidadesmilitares( unidadmilitar, cantidad);
                } catch (SQLException ex) {
                }
                break;
            case 2:
                try {
                    ciudadjugador.descontarhabitantes( unidadmilitar.getCantidadhabitantes());
                } catch (SQLException ex) {

                }
                break;
            case 3:
                try {
                    ciudadjugador.getCiudadrecurso().descontarrecursosciudad( unidadmilitar.getUnidadmilitarconstruccion().getRecurso(), unidadmilitar.getUnidadmilitarconstruccion().getCantidad());
                } catch (SQLException ex) {
                }
                break;
        }
    }

}