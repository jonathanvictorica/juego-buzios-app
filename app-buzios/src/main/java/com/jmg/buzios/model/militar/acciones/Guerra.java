/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guerra {

    private Integer codigoguerra;
    private boolean guerraactiva;
    private Date fechainicio;
    private Time horainicio;

    private Date fechafin;
    private Time horafin;
    private List<GuerraParticipante> participantes = new ArrayList<>();
    private Integer bandoganador;



    public static boolean verificarjugadoresinmismaguerra( Jugador jugadoratacado, Jugador jugadordeclarador) {

        return false;
    }

    public static void buscarGuerrasActivas( List<Guerra> guerras) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from guerra where guerraactiva=true");

            while (rs.next()) {
                Guerra guerranuevo = new Guerra();
                guerranuevo.codigoguerra = rs.getInt(1);
                guerranuevo.guerraactiva = rs.getBoolean(2);
                guerranuevo.fechainicio = rs.getDate(3);
                guerranuevo.horainicio = rs.getTime(4);
                guerranuevo.fechafin = rs.getDate(5);
                guerranuevo.horafin = rs.getTime(6);
                guerranuevo.participantes = GuerraParticipante.buscarGuerrerosdeGuerra( guerranuevo.codigoguerra);

                for (int i = 0; i < guerranuevo.participantes.size(); i++) {
                    guerranuevo.participantes.get(i).setGuerra(guerranuevo);
                }


                guerras.add(guerranuevo);
            }


        } catch (SQLException ex) {

        }


    }



    public void almacenarguerra() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ALMACENAR_GUERRA(?,?,?,?)");
        procedimiento.setString("jugadoratacador", this.participantes.get(0).getJugador().getNick());
        procedimiento.setInt("bandoatacador", this.participantes.get(0).getBando());
        procedimiento.setString("jugadoratacado", this.participantes.get(1).getJugador().getNick());
        procedimiento.setInt("bandoatacado", this.participantes.get(1).getBando());


        procedimiento.execute();
    }

    public void almacenarguerrero( Jugador jugadoraunirse, Integer bandoelegido) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL almacenar_guerrero(?,?,?)");
        procedimiento.setInt("codigoguerra", this.codigoguerra);
        procedimiento.setString("nickjugador", jugadoraunirse.getNick());
        procedimiento.setInt("bando", bandoelegido);


        procedimiento.execute();


    }

    public boolean verificarjugadorexisteenguerra( Jugador jugadoraunirse) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_jugador_existe_en_guerra(?,?,?)");
        procedimiento.setInt("codigoguerra", this.codigoguerra);
        procedimiento.setString("nickjugador", jugadoraunirse.getNick());
        procedimiento.registerOutParameter("existe", Types.BOOLEAN);

        procedimiento.execute();
        return procedimiento.getBoolean("existe");
    }

    public void comunicaramiembrosnuevoingreso( Jugador jugadoraunirse, Integer bando) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL comunicar_a_miembros_nuevo_ingreso(?,?,?)");
        procedimiento.setInt("codigoguerra", this.codigoguerra);
        procedimiento.setString("nickjugador", jugadoraunirse.getNick());
        procedimiento.setInt("bando", bando);

        procedimiento.execute();


    }

    public void quitarguerrero( Jugador jugadoraunirse, Integer bandoelegido) {

    }


}
