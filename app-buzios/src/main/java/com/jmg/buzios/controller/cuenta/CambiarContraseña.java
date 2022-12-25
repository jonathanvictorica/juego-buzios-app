/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.cuenta;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.view.ciudad.VConfigurarCuenta;

import javax.swing.*;
import java.sql.SQLException;

/**
 * 1	El jugador aprieta un botón y envía su Nick y clave.
 * 2	El Sistema verifica que la nueva contraseña tenga letras y/o números solamente y debe tener un minimo de 8 caracteres.
 * 3	El Sistema verifica que la contraseña enviada no sea la misma a la que el jugador tiene.
 * 4	El Sistema verifica que la contraseña solamente tenga caracteres de letras y números nada mas.
 * 5	El Sistema almacena la nueva constraseña y envía por pantalla un mensaje al jugador que su contraseña fue cambiada exitosamente.
 * 3 A 	El Sistema envía un mensaje al jugador que la contraseña nueva debe tener solo letras y/o números y un minimo de 8 caracteres.
 * 4 A 	El Sistema envía un mensaje al jugador que la contraseña nueva es igual a la vieja y no puede ser cambiada.
 * 5 A 	El Sistema envía un mensaje por pantalla al jugador comunicándole que la contraseña no puede tener otros caracteres que no sean letras y números.
 */
public class CambiarContraseña implements Actualizar {
   private VConfigurarCuenta configurarcuenta;
    private String contraseñanueva;

    public CambiarContraseña(VConfigurarCuenta configurarcuenta, String contraseñanueva) {
        this.configurarcuenta = configurarcuenta;
        this.contraseñanueva = contraseñanueva;
    }

    public void CUcambiarcontraseña() throws SQLException {
        if (!this.configurarcuenta.getJugador().verificarcontraseñadistintaalaantigua(this.contraseñanueva)) {
            this.configurarcuenta.getJugador().modificarcontraseña(this.contraseñanueva);
            JOptionPane.showMessageDialog(configurarcuenta, "La contraseña ha sido modificada");
        } else {
            JOptionPane.showMessageDialog(configurarcuenta, "No se ha podido modificar la contraseña porque es la misma que la antigua que tenía");
        }
        this.actualizarinterfazgrafica();

    }

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        this.configurarcuenta.getTxtContraseñanueva().setText("");
        this.configurarcuenta.getTxtConfirmarContraseña().setText("");
    }
}
