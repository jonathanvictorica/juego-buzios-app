/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ejercito;

import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class DestruirUnidadMilitar {

    private UnidadMilitar unidadmilitar;
    private Arma arma;
    private Integer cantidad;
    private VCiudad vciudad;

    public DestruirUnidadMilitar(UnidadMilitar unidadmilitar, Arma arma, Integer cantidad, VCiudad vciudad) {
        this.unidadmilitar = unidadmilitar;
        this.arma = arma;
        this.cantidad = cantidad;
        this.vciudad = vciudad;
    }
    /*Que solamente aparezcan en mostrar unidades militare slas unidades disponibles*/

    public void CUDestruirUnidadMilitar() throws SQLException {
        if (this.vciudad.getCiudad().getCiudadejercito().verificarcantidadasignamientoarma( unidadmilitar, arma, cantidad)) {
            this.vciudad.getCiudad().getCiudadejercito().eliminarunidades(this.unidadmilitar, this.arma, this.cantidad);
            this.vciudad.getCiudad().getCiudadejercito().inicializarejercitodeciudad();

            JOptionPane.showMessageDialog(vciudad, "Las unidades fueron eliminadas.");
        } else {
            if (this.arma != null) {
                JOptionPane.showMessageDialog(vciudad, "No dispone de " + this.cantidad + " unidades de " + this.unidadmilitar.getNombre() + " que tengan el arma " + this.arma.getNombrearma());
            } else {
                JOptionPane.showMessageDialog(vciudad, "No dispone de " + this.cantidad + " unidades de " + this.unidadmilitar.getNombre() + ".");

            }
        }
    }
}
