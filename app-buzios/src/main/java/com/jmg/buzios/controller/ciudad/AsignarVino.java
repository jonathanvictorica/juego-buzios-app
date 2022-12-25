/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ciudad;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.view.edificios.VVerTaberna;

import javax.swing.*;
import java.sql.SQLException;


public class AsignarVino {

    private VVerTaberna vvertaberna;
    private Integer cantidad;
    private Ciudad ciudadjugador;

    public AsignarVino(VVerTaberna vvertaberna, Integer cantidad, Ciudad ciudadjugador) {
        this.vvertaberna = vvertaberna;
        this.cantidad = cantidad;
        this.ciudadjugador = ciudadjugador;
    }


    public void CUasignarvino() throws SQLException {
        if (this.ciudadjugador.getCiudadrecurso().verificarservirvino( this.cantidad)) {
            this.ciudadjugador.getCiudadedificios().servirvino( this.cantidad);

            JOptionPane.showMessageDialog(vvertaberna, "Vino Servido.");

        } else {
            JOptionPane.showMessageDialog(vvertaberna, "No tienes suficiente vino para asignar.");
        }
    }


}
