/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.jugador.MensajePrivado;

import javax.swing.*;

/**
 * 1	El jugador aprieta un botón y envía por parámetro, el jugador que envía el mensaje, el que debe recibir el mensaje, el mensaje a enviar.
 * 2	El Sistema almacena el mensaje privado en la base de datos.
 * 3	El sistema comunica al jugador que su mensaje ha sido enviado con éxito.
 */
public class EnviarMensajeJugador {

    private Ciudad ciudadremitente;
    private Ciudad ciudaddestinataria;
    private String mensaje;
    private String titulo;

    public EnviarMensajeJugador(Ciudad ciudadremitente, Ciudad ciudaddestinataria, String mensaje, String titulo) {
        this.ciudadremitente = ciudadremitente;
        this.ciudaddestinataria = ciudaddestinataria;
        this.mensaje = mensaje;
        this.titulo = titulo;
    }

    public void CUenviarmensaje() {
        MensajePrivado mensajeprivado = new MensajePrivado(this.ciudadremitente.getJugador(), this.ciudaddestinataria.getJugador(), this.mensaje, this.titulo);
        mensajeprivado.enviarmensaje();
        JOptionPane.showMessageDialog(null, "El mensaje ha sido enviado.");

    }


}
