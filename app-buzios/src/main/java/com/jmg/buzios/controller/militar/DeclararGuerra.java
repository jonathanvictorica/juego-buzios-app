/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.militar;

import com.jmg.buzios.model.jugador.Jugador;
import com.jmg.buzios.model.militar.acciones.Guerra;
import com.jmg.buzios.model.militar.acciones.GuerraParticipante;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1	El Jugador presiona un botón y envía por parámetro el nombre del jugador que declara la guerra,el nombre del otro jugador.
 * 2	El Sistema verifica que ambos jugadores no estén protegidos por el juego, sobre las operaciones militares.
 * 3	El Sistema verifica que no exista otra guerra igual que este activa.
 * 4	El sistema almacena la guerra y sus participantes.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 3 A	El Sistema comunica al jugador que alguno de los dos esta protegido por el juego para no ser atacado y no atacar.
 * 4A	El sistema comunica al jugador que quiere declarar la guerra que ya existe una guerra con las mismas características y no se puede crear otra igual.
 */
public class DeclararGuerra {

    private Jugador jugadordeclarador;
    private Jugador jugadoratacado;

    public DeclararGuerra(Jugador jugadordeclarador, Jugador jugadoratacado) {
        this.jugadordeclarador = jugadordeclarador;
        this.jugadoratacado = jugadoratacado;
    }

    public void CUdeclararguerra() throws SQLException {
        if ((this.jugadordeclarador.isProtegido() == false) && (this.jugadoratacado.isProtegido() == false)) {
            if (Guerra.verificarjugadoresinmismaguerra(this.jugadoratacado, this.jugadordeclarador)) {
                JOptionPane.showMessageDialog(null, "No se puede declarar una guerra que ya existe o este activa.");

            } else {
                GuerraParticipante guerraparti;
                Guerra guerranueva = new Guerra();
                List<GuerraParticipante> guerraparticipantes = new ArrayList<>();

                guerraparti = new GuerraParticipante(this.jugadordeclarador, 0, true, 1);
                guerraparticipantes.add(guerraparti);

                guerraparti = new GuerraParticipante(this.jugadoratacado, 0, true, 2);
                guerraparticipantes.add(guerraparti);

                guerranueva.setParticipantes(guerraparticipantes);

                guerranueva.almacenarguerra();
                JOptionPane.showMessageDialog(null, "LA GUERRA HA COMENZADO!!!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "La guerra no puede declararse porque uno de los dos esta bajo la proteccion de ser atacado.");
        }
    }
}
