/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

@Getter
@Setter
public class EstadoCiudad {
    private Integer codigoestado;
    private String estado;

    public EstadoCiudad() {
    }



    public void inicializarestadociudad(Ciudad ciudadjugador) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL inicializar_estado_ciudad(?,?,?,?)");
        procedimiento.setString("nickjugador", ciudadjugador.getJugador().getNick());
        procedimiento.setString("nombreciudad", ciudadjugador.getNombre());

        procedimiento.registerOutParameter("codigoestado", Types.INTEGER);
        procedimiento.registerOutParameter("nombreestado", Types.VARCHAR);

        procedimiento.execute();

        this.codigoestado = procedimiento.getInt("codigoestado");
        this.estado = procedimiento.getString("nombreestado");

    }


}
