/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ciudad;

import com.jmg.buzios.model.ciudad.Ciudad;

import javax.swing.*;
import java.sql.SQLException;


public class CambiarNombreCiudad {
    private Ciudad ciudadacambiarnombre;
    private String nombrenuevo;

    public CambiarNombreCiudad(Ciudad ciudadacambiarnombre, String nombrenuevo) {
        this.ciudadacambiarnombre = ciudadacambiarnombre;
        this.nombrenuevo = nombrenuevo;
    }

    public void CUcambiarnombreciudad() throws SQLException {
        if (this.ciudadacambiarnombre.getNombre().equals(this.nombrenuevo)) {
            JOptionPane.showMessageDialog(null, "El nuevo nombre debe ser distinto al viejo nombre de la ciudad.");
        } else {
            if (this.ciudadacambiarnombre.getJugador().verificarnombredeciudaddisponible( this.ciudadacambiarnombre.getNombre(), this.nombrenuevo)) {

                this.ciudadacambiarnombre.cambiarnombre( this.nombrenuevo);
                this.ciudadacambiarnombre.setNombre(nombrenuevo);

                JOptionPane.showMessageDialog(null, "Se ha modificado el nombre de la ciudad");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede modificar el nombre de la ciudad, porque este mismo nombre lo tiene otra ciudad existente en su imperio.");
            }

        }
    }

}
