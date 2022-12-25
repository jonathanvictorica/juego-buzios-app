/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.ciudad.Ciudad;
import lombok.*;

import java.sql.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoBarcoActual {
    protected Integer codigomov;
    protected Ciudad ciudadsalida;
    protected Ciudad ciudaddestino;
    protected Date fechasalida;
    protected Date fechallegada;
    protected Time horasalida;
    protected Time horallegada;
    protected BarcoMovimiento barcomovimiento;
    protected Integer tiempo;
    private Carga carga;

    public MovimientoBarcoActual(Ciudad ciudadsalida, Ciudad ciudaddestino) {
        this.ciudadsalida = ciudadsalida;
        this.ciudaddestino = ciudaddestino;
    }




    public void calculartiempollegada() throws SQLException {

        this.tiempo = 10;
    }


    public void almacenarmovimientobarco() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL almacenar_movimiento(?,?,?,?,?,?,?,?)");


        procedimiento.setString("nickjugadorsalida", this.ciudadsalida.getJugador().getNick());
        procedimiento.setString("ciudadsalida", this.ciudadsalida.getNombre());
        procedimiento.setString("nickjugadorllegada", this.ciudaddestino.getJugador().getNick());
        procedimiento.setString("ciudadllegada", this.ciudaddestino.getNombre());
        procedimiento.setInt("tiempotarda", this.tiempo);
        procedimiento.registerOutParameter("fechallegada", Types.DATE);
        procedimiento.registerOutParameter("horallegada", Types.TIME);
        procedimiento.registerOutParameter("codigomovimiento", Types.INTEGER);


        procedimiento.execute();


        this.fechallegada = procedimiento.getDate("fechallegada");
        this.horallegada = procedimiento.getTime("horallegada");
        this.codigomov = procedimiento.getInt("codigomovimiento");

    }
}
