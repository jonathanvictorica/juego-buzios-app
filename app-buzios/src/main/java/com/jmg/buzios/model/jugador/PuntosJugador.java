/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.jugador;

import com.jmg.buzios.config.ConexionDB;
import lombok.*;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuntosJugador {
    private Jugador jugador;
    private Integer puntosinvestigacion;
    private Integer puntosconstructor;
    private Integer puntossoldados;
    private Integer puntosdefensa;
    private Integer puntosataque;

    public PuntosJugador(Jugador jugador) {
        this.jugador = jugador;
    }



    public void buscarpuntosinvestigacionjugador() {
        try {
            /*buscar_puntos_investigacion_jugador(in nombrejugador varchar, out puntosinvestigacion int)*/
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL buscar_puntos_investigacion_jugador (?,?)");
            procedimiento.setString("nombrejugador", this.jugador.getNick());
            procedimiento.registerOutParameter("puntosinvestigacion", Types.INTEGER);

            procedimiento.execute();
            this.puntosinvestigacion = procedimiento.getInt("puntosinvestigacion");
        } catch (SQLException ex) {

        }

    }

    public void descontarpuntosinvestigacion( int puntosinvestigacion) {
        try {
            /*descontar_puntos_investigacion(in nombrejugador varchar,in puntosinvestigacion)*/

            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL descontar_puntos_investigacion (?,?)");
            procedimiento.setString("nombrejugador", this.jugador.getNick());
            procedimiento.setInt("puntos_investigacion", puntosinvestigacion);

            procedimiento.execute();
        } catch (SQLException ex) {

        }
    }



}
