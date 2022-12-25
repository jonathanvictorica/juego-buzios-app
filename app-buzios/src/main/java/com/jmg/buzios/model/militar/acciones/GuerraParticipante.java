/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuerraParticipante {


    private Guerra guerra;
    private Jugador jugador;
    private Integer puntaje;
    private boolean activo;
    private Integer bando;

    public GuerraParticipante(Guerra guerra) {
        this.guerra = guerra;
    }

    public GuerraParticipante(Jugador jugador, Integer puntaje, boolean activo, Integer bando) {
        this.jugador = jugador;
        this.puntaje = puntaje;
        this.activo = activo;
        this.bando = bando;
    }

    static List<GuerraParticipante> buscarGuerrerosdeGuerra( Integer codigoguerra) {
        List<GuerraParticipante> guerraparticipante = new ArrayList<>();

        try {

            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from guerraparticipante where codigoguerra =" + codigoguerra + " and  activo = true");

            while (rs.next()) {
                GuerraParticipante participantenuevo = new GuerraParticipante(null);
                participantenuevo.activo = true;
                participantenuevo.bando = rs.getInt(5);
                participantenuevo.puntaje = rs.getInt(3);
                participantenuevo.jugador = Jugador.buscarJugador( rs.getInt(2));
                guerraparticipante.add(participantenuevo);

            }

        } catch (SQLException ex) {

        }
        return guerraparticipante;

    }



}
