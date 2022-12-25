/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.comercio;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.*;

import java.sql.CallableStatement;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfertaJugador extends Oferta {

    private Jugador jugador;


    public OfertaJugador(Jugador jugador, Recurso recurso, int cantidad, boolean orobuscado, Recurso recursobuscado, boolean booleanjugador) {
        super(recurso, cantidad, orobuscado, recursobuscado, booleanjugador);
        this.jugador = jugador;
    }





    public void reservaroferta() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL RESERVAR_OFERTA(?,?,?,?,?)");
        procedimiento.setString("NICKJUGADOR", this.getJugador().getNick());
        procedimiento.setString("RECURSOAVENDER", this.getRecurso().getNombrerecurso());
        procedimiento.setInt("CANTIDAD", this.getCantidad());
        procedimiento.setString("RECURSOACAMBIO", this.getRecursobuscado().getNombrerecurso());
        procedimiento.setBoolean("ORO", this.isOrobuscado());
        procedimiento.execute();


    }


}
