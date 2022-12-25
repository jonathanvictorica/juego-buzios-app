/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.ciudad.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoMilitar extends MovimientoBarcoActual {
    private CargaMilitar cargamiliar;
    private Ataque ataque;


    public MovimientoMilitar(Ciudad ciudadjugatacante, Ciudad ciudadjugatacado) {
        super(ciudadjugatacante, ciudadjugatacado);
        this.cargamiliar = new CargaMilitar(this);
    }



    public void almacenarmovimientomilitar() throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL  ALMACENAR_MOVIMIENTO_MILITAR(?,?,?,?,?,?,?)");

        procedimiento.setString("nicksalida", this.ciudadsalida.getJugador().getNick());
        procedimiento.setString("ciudadsalida", this.ciudadsalida.getNombre());
        procedimiento.setString("nickllegada", this.ciudaddestino.getJugador().getNick());
        procedimiento.setString("ciudadllegada", this.ciudaddestino.getNombre());
        procedimiento.setInt("tiempotarda", this.tiempo);
        procedimiento.setInt("codigoataque", this.ataque.getCodigoataque());

        procedimiento.registerOutParameter("codigomov", Types.INTEGER);
        procedimiento.execute();
        this.codigomov = procedimiento.getInt("codigomov");


    }


}
