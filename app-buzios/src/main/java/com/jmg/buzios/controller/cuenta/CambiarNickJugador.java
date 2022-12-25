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
 * 1	El jugador aprieta un botón y envía por parámetro el Nick de jugador y el Nick nuevo de jugador.
 * 2	El Sistema verifica que el nuevo Nick no sea igual al Nick viejo.
 * 3	El Sistema verifica que el Nick nuevo tenga solamente caracteres de letra y como minimo 4 caracteres.
 * 3	El Sistema verifica que el Nick nuevo no coincida con ningún Nick existente en el juego.
 * 4	El Sistema almacena el nuevo Nick, envía un mensaje al jugador que el Nick se cambio exitosamente y actualiza los datos de la pantalla.
 * 3 A	El Sistema le envía un mensaje al jugador que el Nick nuevo es igual a su Nick viejo y no puede ser cambiado por esa razón.
 * 4 A	El Sistema le envía un mensaje al jugador que el Nick debe tener solamente letras y debe tener como minimo 4 caracteres.
 * 5 A	El Sistema le envía un mensaje al jugador que el Nick nuevo no puede ser cambiado porque otro jugador lo esta usando.
 */
public class CambiarNickJugador implements Actualizar {

    private VConfigurarCuenta configurarcuenta;
    private String nicknuevo;

    public CambiarNickJugador(VConfigurarCuenta configurarcuenta, String nicknuevo) {
        this.configurarcuenta = configurarcuenta;
        this.nicknuevo = nicknuevo;
    }


    public void CUcambiarnickjugador() throws SQLException {
        if (this.configurarcuenta.getJugador().getNick().equals(this.nicknuevo)) {
            JOptionPane.showMessageDialog(configurarcuenta, "No se ha modificado el nick de jugador porque es el mismo que tiene ahora.");
        } else {
            if (this.configurarcuenta.getJugador().verificarnickdisponible( this.nicknuevo)) {
                this.configurarcuenta.getJugador().cambiarnick( this.nicknuevo);
                JOptionPane.showMessageDialog(configurarcuenta, "El nick ha sido modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(configurarcuenta, "No se puede cambiar el nick ya que esta siendo utilizado por otro jugador.");
            }
        }
        this.actualizarinterfazgrafica();
    }

    @Override
    public void actualizardatospantalla() {
        this.configurarcuenta.getJugador().setNick(this.nicknuevo);
        this.configurarcuenta.getTxtNickJugador().setText(this.nicknuevo);
    }

    @Override
    public void actualizarinterfazgrafica() {
        this.configurarcuenta.getTxtNicknuevo().setText("");
    }
}
