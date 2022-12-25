/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.jugador;

import com.jmg.buzios.config.ConexionDB;
import lombok.*;

import javax.swing.*;
import java.sql.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MensajePrivado {


    private int codigomensaje;
    private Jugador jugemitente;
    private Jugador jugdestinataria;
    private String Mensaje;
    private String titulo;
    private Date fecha;
    private Time hora;
    private boolean leido;

    public MensajePrivado(Jugador ciudadjugemitente, Jugador ciudadjugdestinataria, String Mensaje, String titulo) {
        this.jugemitente = ciudadjugemitente;
        this.jugdestinataria = ciudadjugdestinataria;
        this.Mensaje = Mensaje;
        this.titulo = titulo;
    }



    public static void inicializarmensajes( JComboBox cboMensajes, List<MensajePrivado> mensajesprivados, Jugador jugador) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select mensajeprivado.codigomensaje"
                    + ",jugador.nick,mensajeprivado.mensaje,"
                    + "mensajeprivado.titulo,mensajeprivado.fecha,"
                    + "mensajeprivado.hora,mensajeprivado.leido "
                    + "from mensajeprivado , jugador where"
                    + " jugador.codigojugador = mensajeprivado.codigojugadorremi and"
                    + " mensajeprivado.codigojugadorrec=" + jugador.getCodigojugador() + "");

            while (rs.next()) {
                MensajePrivado mensajeprivado = new MensajePrivado();
                mensajeprivado.jugdestinataria = jugador;
                mensajeprivado.titulo = rs.getString(4);
                mensajeprivado.Mensaje = rs.getString(3);
                mensajeprivado.fecha = rs.getDate(5);
                mensajeprivado.hora = rs.getTime(6);
                mensajeprivado.leido = rs.getBoolean(7);
                mensajeprivado.codigomensaje = rs.getInt(1);
                mensajeprivado.jugemitente = new Jugador(rs.getString(2));
                mensajesprivados.add(mensajeprivado);


            }
            for (int i = 0; i < mensajesprivados.size(); i++) {

                cboMensajes.addItem(mensajesprivados.get(i).titulo);

            }
        } catch (SQLException ex) {

        }

    }



    public void enviarmensaje() {
        try {
            /*ENVIARMENSAJE(IN NICKJUGADOR VARCHAR(30),NICKRECEPTOR VARCHAR(30),MENSAJE VARCHAR(255), TITULO VARCHAR30))*/
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ENVIARMENSAJE (?,?,?,?)");
            procedimiento.setString("NICKJUGADOR", this.jugemitente.getNick());
            procedimiento.setString("NICKRECEPTOR", this.jugdestinataria.getNick());
            procedimiento.setString("MENSAJE", this.Mensaje);
            procedimiento.setString("TITULO", this.titulo);
            procedimiento.execute();
        } catch (SQLException ex) {

        }

    }


}
